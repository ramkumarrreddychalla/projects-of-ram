package com.davelcorp.application.controller;

import com.davelcorp.application.model.Profile;
import com.davelcorp.application.service.BranchService;
import com.davelcorp.application.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ProfileRestController {
 
    @Autowired
    BranchService branchService;  //Service which will do all data retrieval/manipulation work

    @Autowired
    ProfileService profileService;
 
    
    //-------------------Retrieve All Profiles--------------------------------------------------------
     
    @RequestMapping(value = "/profile/", method = RequestMethod.GET)
    public ResponseEntity<List<Profile>> listAllProfiles() {
        List<Profile> Profiles = profileService.findAllProfiles();
        if(Profiles.isEmpty()){
            return new ResponseEntity<List<Profile>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Profile>>(Profiles, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Profile--------------------------------------------------------
     
    @RequestMapping(value = "/Profile/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profile> getProfile(@PathVariable("id") long id) {
        System.out.println("Fetching Profile with id " + id);
        Profile Profile = profileService.findByProfileId(id);
        if (Profile == null) {
            System.out.println("Profile with id " + id + " not found");
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Profile>(Profile, HttpStatus.OK);
    }



    //-------------------Create a Profile--------------------------------------------------------

    @RequestMapping(value = "/Profile/", method = RequestMethod.POST)
    public ResponseEntity<Void> createProfile(@RequestBody Profile Profile,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Profile " + Profile.getProfilename());

        if (profileService.isProfileExist(Profile)) {
            System.out.println("A Profile with name " + Profile.getProfilename() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        profileService.saveProfile(Profile);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Profile/{id}").buildAndExpand(Profile.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    //------------------- Update a Profile --------------------------------------------------------

    @RequestMapping(value = "/Profile/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Profile> updateProfile(@PathVariable("id") long id, @RequestBody Profile Profile) {
        System.out.println("Updating Profile " + id);

        Profile currentProfile = profileService.findByProfileId(id);

        if (currentProfile==null) {
            System.out.println("Profile with id " + id + " not found");
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }

        currentProfile.setProfilename(Profile.getProfilename());
        currentProfile.setAddress(Profile.getAddress());
        currentProfile.setEmail(Profile.getEmail());

        profileService.updateProfile(currentProfile);
        return new ResponseEntity<Profile>(currentProfile, HttpStatus.OK);
    }



    //------------------- Delete a Profile --------------------------------------------------------

    @RequestMapping(value = "/Profile/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Profile> deleteProfile(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Profile with id " + id);

        Profile Profile = profileService.findByProfileId(id);
        if (Profile == null) {
            System.out.println("Unable to delete. Profile with id " + id + " not found");
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }

        profileService.deleteProfileById(id);
        return new ResponseEntity<Profile>(HttpStatus.NO_CONTENT);
    }



    //------------------- Delete All Profiles --------------------------------------------------------

    @RequestMapping(value = "/Profile/", method = RequestMethod.DELETE)
    public ResponseEntity<Profile> deleteAllProfiles() {
        System.out.println("Deleting All Profiles");
 
        profileService.deleteAllProfiles();
        return new ResponseEntity<Profile>(HttpStatus.NO_CONTENT);
    }
 
}