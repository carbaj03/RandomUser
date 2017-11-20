package com.acv.randomuser.domain.usecase.main;

import com.acv.randomuser.domain.model.Id;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alejandro on 20/11/17.
 */

public class DiscartedIds {
    private Set<Id> discartedIds;

    public DiscartedIds() {
        discartedIds = new HashSet<>();
    }

    public DiscartedIds(Collection e){
        this.discartedIds = (Set<Id>) e;
    }

    public DiscartedIds addAll(Set<Id> ids){
        discartedIds.addAll(ids);
        return new DiscartedIds(discartedIds);
    }

    public boolean contains(Id id) {
        return discartedIds.contains(id);
    }


}
