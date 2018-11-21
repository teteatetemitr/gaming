package com.gaming.football.gaming.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaming.football.gaming.profile.beans.Profile;
import com.gaming.football.gaming.profile.repository.ProfileRepository;

@Service
public class ProfileService {
	@Autowired
	ProfileRepository profileRepository;
	
	public Profile profileDetails(int userId){
		return profileRepository.findByUserId(userId);
	}
	
	public Profile update(Profile profile){
		return profileRepository.save(profile);
	}
	

}
