package com.kafkademo.controller.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkademo.model.User;

@Service
public class Producer {
	
	@Autowired
	@Qualifier("userKafkaTemplate")
	private KafkaTemplate<String, User> userKafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String TOPIC = "tipickafka1"; 
	private static final String TOPIC_M = "tipickafka"; 
	
	public void SendMessage(String messaje) {
		
		kafkaTemplate.send(TOPIC_M, messaje);
		
	}
	
	public void SendUser(String name) {
		
		userKafkaTemplate.send(TOPIC, new User(name, "Ospino"));
		
	}
}
