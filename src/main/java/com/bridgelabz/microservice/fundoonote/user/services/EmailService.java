package com.bridgelabz.microservice.fundoonote.user.services;

import com.bridgelabz.microservice.fundoonote.user.models.EmailDTO;

public interface EmailService {
	void sendActivationEmail(EmailDTO emailDTO) throws Exception ;
}
