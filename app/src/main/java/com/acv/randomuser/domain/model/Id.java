package com.acv.randomuser.domain.model;

import java.io.Serializable;

public class Id  implements Serializable {
    private String name;
    private String value;

    public Id(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Id id = (Id) o;

        if (name != null ? !name.equals(id.name) : id.name != null) return false;
        return value != null ? value.equals(id.value) : id.value == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
