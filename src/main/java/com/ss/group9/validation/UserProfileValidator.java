package com.ss.group9.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ss.group9.model.UserProfile;

@Component
public class UserProfileValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserProfile userProfile = (UserProfile) object;
		validatePassword(userProfile.getPassword(), errors);
		
	}

	private void validatePassword(String password, Errors errors) {
		if (!StringUtils.isEmpty(password)) {
			if (password.length() < 8) {
				errors.rejectValue("password", "Min");
			} else if (password.length() > 15) {
				errors.rejectValue("password", "Max");
			}
		}
		
	}

}
