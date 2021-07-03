package test.ashishjaintechg.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringKafkaConsumerApplication {

	List<String> messages = new ArrayList<String>();
	User userDate =null;
	
	
	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg() {
		return messages;
	}
	
	
	
	@KafkaListener(groupId = "java-1", topics="test", containerFactory ="kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		messages.add(data);
		return messages;
		
	}
	

	
	
//	@GetMapping("/consumeJsonMessage")
//	public User consumeMsgJson() {
//		return userDate;
//	}
//	
//	
//	
//	@KafkaListener(groupId = "java-2", topics="test", containerFactory ="userKafkaListenerContainerFactory")
//	public User getMsgFromTopicJson(User userData) {
//		userDate = userData;
//		return userDate;
//		
//	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaConsumerApplication.class, args);
	}

}
