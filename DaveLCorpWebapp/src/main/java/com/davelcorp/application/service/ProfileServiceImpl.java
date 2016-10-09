package com.davelcorp.application.service;

import com.davelcorp.application.model.Branch;
import com.davelcorp.application.model.Profile;
import com.davelcorp.application.model.ProfileType;
import com.davelcorp.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Profile> profiles;
	private static Profile profile;

	@Autowired
	BranchService branchService;
	
	//static{
        //profiles= populateDummyProfiles();
	//}

	public List<Profile> findAllProfiles() {
		return populateDummyProfiles();
	}
	
	public Profile findByProfileId(long id) {
		for(Profile Profile : profiles){
			if(Profile.getId() == id){
				return Profile;
			}
		}
		return null;
	}
	
	public Profile findByProfileName(String name) {
		for(Profile profile : profiles){
			if(profile.getProfilename().equalsIgnoreCase(name)){
				return profile;
			}
		}
		return null;
	}
	
	public void saveProfile(Profile profile) {
		profile.setId(counter.incrementAndGet());
		profiles.add(profile);
	}

	public void updateProfile(Profile Profile) {
		int index = profiles.indexOf(Profile);
		profiles.set(index, Profile);
	}

	public void deleteProfileById(long id) {
		
		for (Iterator<Profile> iterator = profiles.iterator(); iterator.hasNext(); ) {
		    Profile profile = iterator.next();
		    if (profile.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isProfileExist(Profile profile) {
		return findByProfileName(profile.getProfilename())!=null;
	}
	
	public void deleteAllProfiles(){
		profiles.clear();
	}

	private List<Profile> populateDummyProfiles(){
		List<Profile> profiles = new ArrayList<Profile>();
		Profile profile = new Profile("XYZ Compnay Inc",counter.incrementAndGet(),"Sam", "NY", "sam@abc.com","10.10.10.10","OK", "");
        profile.setBranches(branchService.findAllBranches());
        profile.setProfileTypes(retrieveProfileTypes());
        //profile.setBranches(branchService.populateDummyBranches());
        profiles.add(profile);
		/*
			profiles.add(new Profile(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com","OK").setb);
			profiles.add(new Profile(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com","Good"));
			profiles.add(new Profile(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com","Excellent"));
		*/
		return profiles;
	}

    private Profile populateDummyProfile(){
        //List<Profile> profiles = new ArrayList<Profile>();
        Profile profile = new Profile("XYZ Company Inc", counter.incrementAndGet(),"Sam", "NY", "sam@abc.com","10.10.10.10","OK", "EINUNIQUE");
        profile.setBranches(branchService.findAllBranches());
		profile.setNumLicenses(10);
		profile.setEin("EIN NUMBER");
		profile.setProfileTypes(retrieveProfileTypes());
		/*
			profiles.add(new Profile(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com","OK").setb);
			profiles.add(new Profile(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com","Good"));
			profiles.add(new Profile(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com","Excellent"));
		*/
        return profile;
    }

    private List<ProfileType> retrieveProfileTypes(){

		return Arrays.asList(new ProfileType("1","Type1", "01/01/2019"),
							 new ProfileType("2","Type1", "01/01/2019"),
							 new ProfileType("3","Type1", "01/01/2019"));
    }

}
