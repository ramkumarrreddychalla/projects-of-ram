package com.davelcorp.application.service;

import com.davelcorp.application.model.Branch;
import com.davelcorp.application.model.Profile;
import com.davelcorp.application.model.User;

import java.util.List;


public interface ProfileService {

	Profile findByProfileId(long id);

	Profile findByProfileName(String name);
	
	void saveProfile(Profile user);
	
	void updateProfile(Profile user);
	
	void deleteProfileById(long id);

	List<Profile> findAllProfiles();
	
	void deleteAllProfiles();
	
	public boolean isProfileExist(Profile profile);

}
