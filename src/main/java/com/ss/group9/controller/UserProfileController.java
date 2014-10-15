package com.ss.group9.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ss.group9.model.UserProfile;
import com.ss.group9.validation.UserProfileValidator;

@Controller
public class UserProfileController {

	@Autowired
	private UserProfileValidator userProfileValidator;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String setUpRegistrationPage(Model model) {
		UserProfile userProfile = new UserProfile();
		model.addAttribute("userProfile", userProfile);
		System.out.println("in registration");
		return "registration";
 
	}
	
	@RequestMapping(value="/saveDetails", method = RequestMethod.POST)
	public String saveRegistrationDetails(@Valid @ModelAttribute("userProfile") UserProfile userProfile,
            BindingResult result, Model model) {
		System.out.println("in save details");
		userProfileValidator.validate(userProfile, result);
		if (result.hasErrors()) {
			System.out.println(result.getFieldErrorCount());
			model.addAttribute("userProfile", userProfile);
			return "registration";
		} else {
			model.addAttribute("userProfile", userProfile);
			return "registration";
		}
	}

	public UserProfileValidator getUserProfileValidator() {
		return userProfileValidator;
	}

	public void setUserProfileValidator(UserProfileValidator userProfileValidator) {
		this.userProfileValidator = userProfileValidator;
	}
	
}
