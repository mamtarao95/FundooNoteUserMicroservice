package com.bridgelabz.microservice.fundoonote.user.rabbitmq;

import com.bridgelabz.microservice.fundoonote.user.models.EmailDTO;

public interface Consumer {
	
	public void recievedMessage(EmailDTO emailDTO) throws Exception ;
}
