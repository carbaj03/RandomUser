package com.acv.randomuser.data.local;


import com.acv.randomuser.data.JsonUtil;
import com.acv.randomuser.domain.error.LocalGatewayException;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.Range;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class LocalStorage {

    private JsonUtil jsonUtil;

    public LocalStorage(JsonUtil jsonUtil) {
        this.jsonUtil = jsonUtil;
    }

    public <T extends RealmObject> void persist(List<T> model) throws LocalGatewayException {
        Realm realm = null;
        try {
            realm = getInstance();
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(model);
            realm.commitTransaction();
        } catch (Exception ex) {
            if (realm != null && realm.isInTransaction()) {
                realm.cancelTransaction();
            }
            throw new LocalGatewayException();
        } finally {
            if (realm != null)
                realm.close();
        }
    }


    public <M, T extends RealmObject> List<M> deleteBy(Class<T> classRealm, Id id, Mapper<T, M> mapper) throws LocalGatewayException {
        Realm realm = null;
        try {
            realm = getInstance();
            T object = realm
                    .where(classRealm)
                    .equalTo("idmodel.name", id.getName())
                    .equalTo("idmodel.value", id.getValue())
                    .findFirst();
            if (object != null) {
                List<M> listM = new ArrayList<>();
                listM.add(mapper.map(object));

                realm.beginTransaction();
                object.deleteFromRealm();
                realm.commitTransaction();

                return listM;
            } else {
                return new ArrayList<>();
            }
        } catch (Exception ex) {
            throw new LocalGatewayException();
        } finally {
            if (realm != null)
                realm.close();
        }
    }

    public <T extends RealmObject> void deleteAll(Class<T> classRealm) throws LocalGatewayException {
        Realm realm = null;
        try {
            realm = getInstance();
            realm.beginTransaction();
            realm.delete(classRealm);
            realm.commitTransaction();

        } catch (Exception ex) {
            throw new LocalGatewayException();
        } finally {
            if (realm != null)
                realm.close();
        }
    }


    public <M, T extends RealmObject> M findById(Class<T> classRealm, Id id, Mapper<T, M> mapper) throws LocalGatewayException {
        Realm realm = null;
        try {
            realm = getInstance();
            T object = realm
                    .where(classRealm)
                    .equalTo("idmodel.name", id.getName())
                    .equalTo("idmodel.value", id.getValue())
                    .findFirst();

            if (object != null)
                return mapper.map(object);
            else
                return null;

        } catch (Exception ex) {
            throw new LocalGatewayException();
        } finally {
            if (realm != null)
                realm.close();
        }
    }

    public <M, T extends RealmObject> List<M> findAll(Class<T> classRealm, Mapper<T, M> mapper) throws LocalGatewayException {
        Realm realm = null;

        List<M> listM = new ArrayList<>();

        try {
            realm = getInstance();
            RealmResults<T> objects = realm
                    .where(classRealm)
                    .findAll();

            if (objects != null) {
                for (T objectT : objects) {
                    listM.add(mapper.map(objectT));
                }
                return listM;
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new LocalGatewayException();
        } finally {
            if (realm != null)
                realm.close();
        }
    }

    public <M, T extends RealmObject> List<M> findByRange(Class<T> classRealm, Mapper<T, M> mapper, Range range) throws LocalGatewayException {
        Realm realm = null;
        int end = range.getEnd();
        int init = range.getInit();

        List<M> listM = new ArrayList<>();
        try {
            realm = getInstance();
            RealmResults<T> objects = realm
                    .where(classRealm)
                    .findAll();
            if (range.isMinorThanInit(objects.size())) {
                return listM;
            }
            if (range.isMinorThanEnd(objects.size())) {
                end = objects.size();
            }
            List<T> ts = objects.subList(init, end);

            if (ts != null) {
                for (T objectT : ts) {
                    listM.add(mapper.map(objectT));
                }
                return listM;
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new LocalGatewayException();
        } finally {
            if (realm != null)
                realm.close();
        }
    }

    private Realm getInstance() {
        return Realm.getDefaultInstance();
    }
}
