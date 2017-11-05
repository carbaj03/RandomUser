package com.acv.randomuser.data.local;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DataBaseHelper {

    private static final String NAME_DB = "randomuser.realm";
    private static final int SCHEMA_VERSION = 1;
    private RealmConfiguration realmConfiguration;

    public static DataBaseHelper createInstance(Context context) {
        return new DataBaseHelper(context);
    }

    private DataBaseHelper(Context context) {
        Realm.init(context);
    }

    public DataBaseHelper initalize() {
        buildRealmConfiguration();
        Realm.setDefaultConfiguration(realmConfiguration);
        return this;
    }

    private DataBaseHelper buildRealmConfiguration() {
        realmConfiguration = new RealmConfiguration.Builder()
                .name(NAME_DB)
                .schemaVersion(SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        return this;
    }

}