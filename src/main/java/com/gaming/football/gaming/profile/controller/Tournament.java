package com.gaming.football.gaming.profile.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaming.football.gaming.profile.beans.Profile;
import com.gaming.football.gaming.profile.service.ProfileService;

@Controller
@RequestMapping("/profile")
public class Tournament {
	private static final String ACCOUNT_PAGE="profile";
	private static final int USER_ID=1;
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/setting")
	public String userProfile(Model model,HttpServletRequest request){
		Profile profile =profileService.profileDetails(USER_ID);
		model.addAttribute("profile",profile);
		request.getSession().setAttribute("profile", profile);
		return ACCOUNT_PAGE;
	}
	@PostMapping("/update/userName")
	public String update(Model model
			,@ModelAttribute("profile") Profile profile
			,HttpServletRequest request){
		Profile fromSession=populateFrmSession(profile,request);
		fromSession.setIdProfile(profile.getIdProfile());
		fromSession.setUserName(profile.getUserNameChange());
		setSession(request,profile);
		model.addAttribute("profile",profileService.update(profile));
		return ACCOUNT_PAGE;
	}
	@PostMapping("/update/altEmail")
	public String updateAltEmail(Model model
			,@ModelAttribute("profile") Profile profile
			,HttpServletRequest request){
		Profile fromSession=populateFrmSession(profile,request);
		fromSession.setAlternateEmail(profile.getAlternateEmail());
		setSession(request,profile);
		model.addAttribute("profile",profileService.update(profile));
		return ACCOUNT_PAGE;
	}
	@PostMapping("/update/password")
	public String updatePassword(Model model
			,@ModelAttribute("profile") Profile profile
			,HttpServletRequest request){
		Profile fromSession=populateFrmSession(profile,request);
		fromSession.setPassword(profile.getPassword());
		fromSession.setAlternatePassword(profile.getAlternatePassword());
		fromSession.setConfirmPassword(profile.getConfirmPassword());
		setSession(request,profile);
		model.addAttribute("profile",profileService.update(profile));
		return ACCOUNT_PAGE;
	}
	@PostMapping("/update/name")
	public String updateName(Model model
			,@ModelAttribute("profile") Profile profile
			,HttpServletRequest request){
		Profile fromSession=populateFrmSession(profile,request);
		fromSession.setFirstName(profile.getFirstName());
		fromSession.setLastName(profile.getLastName());
		setSession(request,profile);
		model.addAttribute("profile",profileService.update(profile));
		return ACCOUNT_PAGE;
	}
	private Profile populateFrmSession(Profile userObj,HttpServletRequest request){
		Profile profile=(Profile)request.getSession().getAttribute("profile");
		userObj.setPrimaryEmail(profile.getPrimaryEmail());
		userObj.setPassword(profile.getPassword());
		userObj.setUserName(profile.getUserName());
		userObj.setFirstName(profile.getFirstName());
		userObj.setLastName(profile.getLastName());
		userObj.setIdProfile(profile.getIdProfile());
		return userObj;
	}
	private void setSession(HttpServletRequest request,Profile profile){
		request.getSession().setAttribute("profile", profile);
	}
}
