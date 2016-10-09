package com.davelcorp.application.model;

/**
 * Created by ramma on 0004,10/4/2016.
 */
public class Branch {

    private long id;
    private String alias;
    private String host;
    private String status;
    private String desc;

    public Branch(long id, String alias, String host, String status, String desc) {
        this.id = id;
        this.alias = alias;
        this.host = host;
        this.status = status;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;

        Branch branch = (Branch) o;

        if (getAlias() != null ? !getAlias().equals(branch.getAlias()) : branch.getAlias() != null) return false;
        if (getHost() != null ? !getHost().equals(branch.getHost()) : branch.getHost() != null) return false;
        if (getStatus() != null ? !getStatus().equals(branch.getStatus()) : branch.getStatus() != null) return false;
        return getDesc() != null ? getDesc().equals(branch.getDesc()) : branch.getDesc() == null;

    }

    @Override
    public int hashCode() {
        int result = getAlias() != null ? getAlias().hashCode() : 0;
        result = 31 * result + (getHost() != null ? getHost().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getDesc() != null ? getDesc().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "alias='" + alias + '\'' +
                ", host='" + host + '\'' +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
