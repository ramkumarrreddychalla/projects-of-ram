package com.davelcorp.application.model;

import java.util.List;

public class Profile {

	private String companyName;

	private long id;

	private String profilename;

	private String address;

	private String email;

	private String host;

	private String status;

	private List<Branch> branches;

	private String ein;

	private int numLicenses;

	private List<ProfileType> profileTypes;



	public Profile(){
		id=0;
	}

	public Profile(String companyName, long id,
				   String profilename,
				   String address, String email,
				   String host, String status,
				   String ein) {
		this.companyName = companyName;
		this.id = id;
		this.profilename = profilename;
		this.address = address;
		this.email = email;
		this.host = host;
		this.status = status;
		this.ein = ein;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfilename() { return profilename;}

	public void setProfilename(String profilename) { this.profilename = profilename; }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public String getEin() {
		return ein;
	}
	public int getNumLicenses() {
		return numLicenses;
	}
	public void setNumLicenses(int numLicenses) {
		this.numLicenses = numLicenses;
	}

	public List<ProfileType> getProfileTypes() {
		return profileTypes;
	}

	public void setProfileTypes(List<ProfileType> profileTypes) {
		this.profileTypes = profileTypes;
	}

	@Override
	public String toString() {
		return "Profile{" +
				"companyName='" + companyName + '\'' +
				", id=" + id +
				", profilename='" + profilename + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				", host='" + host + '\'' +
				", status='" + status + '\'' +
				", branches=" + branches +
				", ein='" + ein + '\'' +
				", numLicenses=" + numLicenses +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Profile)) return false;

		Profile profile = (Profile) o;

		if (getId() != profile.getId()) return false;
		if (getCompanyName() != null ? !getCompanyName().equals(profile.getCompanyName()) : profile.getCompanyName() != null)
			return false;
		if (getProfilename() != null ? !getProfilename().equals(profile.getProfilename()) : profile.getProfilename() != null)
			return false;
		if (getAddress() != null ? !getAddress().equals(profile.getAddress()) : profile.getAddress() != null)
			return false;
		if (getEmail() != null ? !getEmail().equals(profile.getEmail()) : profile.getEmail() != null) return false;
		if (getHost() != null ? !getHost().equals(profile.getHost()) : profile.getHost() != null) return false;
		if (getStatus() != null ? !getStatus().equals(profile.getStatus()) : profile.getStatus() != null) return false;
		if (getBranches() != null ? !getBranches().equals(profile.getBranches()) : profile.getBranches() != null)
			return false;
		return getEin() != null ? getEin().equals(profile.getEin()) : profile.getEin() == null;

	}

	@Override
	public int hashCode() {
		int result = getCompanyName() != null ? getCompanyName().hashCode() : 0;
		result = 31 * result + (int) (getId() ^ (getId() >>> 32));
		result = 31 * result + (getProfilename() != null ? getProfilename().hashCode() : 0);
		result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		result = 31 * result + (getHost() != null ? getHost().hashCode() : 0);
		result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
		result = 31 * result + (getBranches() != null ? getBranches().hashCode() : 0);
		result = 31 * result + (getEin() != null ? getEin().hashCode() : 0);
		return result;
	}

	public void setEin(String ein) {
		this.ein = ein;
	}

}
