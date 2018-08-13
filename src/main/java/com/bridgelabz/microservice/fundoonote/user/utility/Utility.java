package com.bridgelabz.microservice.fundoonote.user.utility;

import java.util.UUID;

import javax.security.auth.login.LoginException;

import com.bridgelabz.microservice.fundoonote.user.exceptions.IncorrectPasswordException;
import com.bridgelabz.microservice.fundoonote.user.exceptions.UserNotFoundException;
import com.bridgelabz.microservice.fundoonote.user.models.LoginDTO;
import com.bridgelabz.microservice.fundoonote.user.models.RegistrationDTO;
import com.bridgelabz.microservice.fundoonote.user.models.SetPasswordDTO;


public class Utility {

	private Utility() {
	}



	public static void validateUserInformation(RegistrationDTO registrationDTO) throws IncorrectPasswordException {

		if (registrationDTO.getEmail() == null || registrationDTO.getPassword() == null
				|| registrationDTO.getConfirmPassword() == null || registrationDTO.getFirstName() == null
				|| registrationDTO.getLastName() == null || registrationDTO.getMobileNumber() == null) {
			throw new IncorrectPasswordException("Fields cannot be null.All fields are mandatory.");
		}

		if (!validateEmail(registrationDTO.getEmail())) {
			throw new IncorrectPasswordException("Invalid Email-id");
		}
		if (!validatePassword(registrationDTO.getPassword()) || registrationDTO.getPassword() == "") {
			throw new IncorrectPasswordException(
					"(1)-Password must be must be atleast 8 characters long" + "(2)- Must have numbers and letters"
							+ "(3)- Must have at least a one special characters- “!,@,#,$,%,&,*,(,),+");
		}
		if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
			throw new IncorrectPasswordException("PASSWORD and CONFIRM PASSWORD fields are not matching!!");
		}
		if (registrationDTO.getMobileNumber().length() != 10 || registrationDTO.getMobileNumber() == "") {
			throw new IncorrectPasswordException("Mobile number should be 10 digits long");
		}

	}

	public static boolean validatePassword(String password) {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		return password.matches(pattern);
	}

	public static boolean validateEmail(String email) {
		String pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}";
		return email.matches(pattern);
	}


	public static void loginValidation(LoginDTO loginDTO) throws LoginException {
		if (loginDTO.getEmail() == null || loginDTO.getEmail() == "") {
			throw new LoginException("EmailID field cannot be empty");

		}
		if (loginDTO.getPassword() == null || loginDTO.getPassword() == "") {
			throw new LoginException("Password field cannot be empty");
		}
	}

	public static void resetPasswordValidation(SetPasswordDTO setPasswordDTO) throws UserNotFoundException {
		if (setPasswordDTO.getNewPassword() == null || setPasswordDTO.getNewPassword() == "") {
			throw new UserNotFoundException("New Password field cannot be empty");
		}
		if (setPasswordDTO.getConfirmPassword() == null || setPasswordDTO.getConfirmPassword() == "") {
			throw new UserNotFoundException("Confirm Password field cannot be empty");
		}
		if (!setPasswordDTO.getConfirmPassword().equals(setPasswordDTO.getNewPassword())) {
			throw new UserNotFoundException("New password and confirm password does not matches!!");
		}

	}
	
	public static String generateUUID() {
	       
        return UUID.randomUUID().toString();
      
    }
}
