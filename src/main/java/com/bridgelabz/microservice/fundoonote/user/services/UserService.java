package com.bridgelabz.microservice.fundoonote.user.services;


import javax.security.auth.login.LoginException;

import com.bridgelabz.microservice.fundoonote.user.exceptions.EmailIdNotFoundException;
import com.bridgelabz.microservice.fundoonote.user.exceptions.IncorrectPasswordException;
import com.bridgelabz.microservice.fundoonote.user.exceptions.TokenExpiresException;
import com.bridgelabz.microservice.fundoonote.user.exceptions.UserNotActivatedException;
import com.bridgelabz.microservice.fundoonote.user.exceptions.UserNotFoundException;
import com.bridgelabz.microservice.fundoonote.user.exceptions.UserNotUniqueException;
import com.bridgelabz.microservice.fundoonote.user.models.LoginDTO;
import com.bridgelabz.microservice.fundoonote.user.models.RegistrationDTO;
import com.bridgelabz.microservice.fundoonote.user.models.SetPasswordDTO;



public interface UserService {
	public void registerUser(RegistrationDTO registrationDTO) throws  IncorrectPasswordException, UserNotUniqueException;

	public String loginUser(LoginDTO loginDTO) throws LoginException, UserNotFoundException, IncorrectPasswordException, UserNotActivatedException;

	public void activateAccount(String token) throws  TokenExpiresException, UserNotFoundException;

	public void forgotPassword(String email) throws EmailIdNotFoundException ;

	void resetPassword(SetPasswordDTO setPasswordDTO, String token) throws UserNotFoundException;

}
