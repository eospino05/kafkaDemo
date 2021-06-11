package com.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkademo.controller.producer.Producer;

@RestController
@RequestMapping("user")
public class UserRestController {

	@Autowired
	private Producer producer;

	@GetMapping("/sendMenssage/{message}")
	public ResponseEntity<String> sendMenssage(@PathVariable("message") String message) {
		
		producer.SendMessage(message);
		
		return new ResponseEntity<String>("Mensaje enviado", HttpStatus.OK);
	}
	
	@GetMapping("/crear/{name}")
	public ResponseEntity<String> crear(@PathVariable("name") String name) {
		
		producer.SendUser(name);
		
		return new ResponseEntity<String>("Operacion exitosa", HttpStatus.OK);
	}
}
