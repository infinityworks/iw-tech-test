package infinityworks.com.iwtechtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FSAAuthorityList {

    @JsonProperty("authorities")
    private List<FSAAuthority> fsaAuthorityList;

    public FSAAuthorityList() {
        //blank required for jackson
    }

    public FSAAuthorityList(List<FSAAuthority> fsaAuthorityList) {
        this.fsaAuthorityList = fsaAuthorityList;
    }

    public List<FSAAuthority> getFsaAuthorityList() {
        return fsaAuthorityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FSAAuthorityList that = (FSAAuthorityList) o;

        return fsaAuthorityList != null ? fsaAuthorityList.equals(that.fsaAuthorityList) : that.fsaAuthorityList == null;
    }

    @Override
    public int hashCode() {
        return fsaAuthorityList != null ? fsaAuthorityList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FSAAuthorityList{" +
                "fsaAuthorityList=" + fsaAuthorityList +
                '}';
    }
}
