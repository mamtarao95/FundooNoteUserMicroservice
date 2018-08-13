package com.bridgelabz.microservice.fundoonote.user.rabbitmq;

import com.bridgelabz.microservice.fundoonote.user.models.EmailDTO;

public interface Producer {
	
	public void produceMessage(EmailDTO emailDTO);

}
