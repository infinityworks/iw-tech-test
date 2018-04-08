package com.infinityworks.techtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FSAAuthority {

    @JsonProperty("LocalAuthorityId")
    private Integer id;

    @JsonProperty("Name")
    private String name;

    public FSAAuthority() {
        //blank required for jackson
    }

    public FSAAuthority(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FSAAuthority that = (FSAAuthority) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FSAAuthority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
