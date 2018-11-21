package com.gaming.football.gaming.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Home {
	private static final String ACCOUNT_PAGE="index";
	public String showHome(){
		return ACCOUNT_PAGE;
	}

}
