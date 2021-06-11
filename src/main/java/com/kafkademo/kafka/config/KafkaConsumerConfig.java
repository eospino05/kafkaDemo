package com.kafkademo.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.kafkademo.model.User;

//@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	
	
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");		
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String, String>(config);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> KafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, String>  factory = new ConcurrentKafkaListenerContainerFactory<String, String> ();
		
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	
	@Bean
	public ConsumerFactory<String, User> userConsumerFactory() {
		
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");		
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id2");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String, User>(config, new StringDeserializer(), new JsonDeserializer<>(User.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, User>  factory = new ConcurrentKafkaListenerContainerFactory<String, User> ();
		
		factory.setConsumerFactory(userConsumerFactory());
		//factory.setMessageConverter(new StringJsonMessageConverter());
		return factory;
	}
	

}
