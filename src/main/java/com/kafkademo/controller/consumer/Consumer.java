package com.kafkademo.controller.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkademo.model.User;

@Service
public class Consumer {
	
	@KafkaListener(topics = {"tipickafka"}, groupId = "group_id")
	public void readMessage(String message) {
		System.out.println("Consummer message::::: " + message);
	}
	
	@KafkaListener(topics = {"tipickafka1"}, groupId = "group_id2", 
			containerFactory = "userKafkaListenerContainerFactory")	
	public void readMessageJson(User user) {
		System.out.println("Consummer user::::: " + user);
	}

}
