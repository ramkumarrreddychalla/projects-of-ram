package com.davelcorp.application.model;

/**
 * Created by ramma on 0008,10/8/2016.
 */
public class ProfileType {

    private String profileId;

    private String profileType;

    private String dateOfExpiry;

    public ProfileType(String profileId, String profileType, String dateOfExpiry){
        this.profileId = profileId;
        this.profileType = profileType;
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileType)) return false;

        ProfileType that = (ProfileType) o;

        if (getProfileType() != null ? !getProfileType().equals(that.getProfileType()) : that.getProfileType() != null)
            return false;
        return getDateOfExpiry() != null ? getDateOfExpiry().equals(that.getDateOfExpiry()) : that.getDateOfExpiry() == null;

    }

    @Override
    public int hashCode() {
        int result = getProfileType() != null ? getProfileType().hashCode() : 0;
        result = 31 * result + (getDateOfExpiry() != null ? getDateOfExpiry().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProfileType{" +
                "profileType='" + profileType + '\'' +
                ", dateOfExpiry='" + dateOfExpiry + '\'' +
                '}';
    }
}
