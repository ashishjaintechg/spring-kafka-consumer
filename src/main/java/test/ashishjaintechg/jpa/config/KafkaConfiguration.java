package test.ashishjaintechg.jpa.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import test.ashishjaintechg.jpa.User;

@Configuration
@EnableKafka
public class KafkaConfiguration {

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map <String,Object> configMap = new HashMap<>();
		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "java-1");
		return new DefaultKafkaConsumerFactory<>(configMap);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
//	@Bean
//	public ConsumerFactory<String, User> userConsumerFactoryJson() {
//		Map <String,Object> configMap = new HashMap<>();
//		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//		configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "java-2");
//		return new DefaultKafkaConsumerFactory<>(configMap, new StringDeserializer(), new JsonDeserializer<>(User.class));
//	}
//	
//	@Bean
//	public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerContainerFactory() {
//		ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<String, User>();
//		factory.setConsumerFactory(userConsumerFactoryJson());
//		return factory;
//	}

	
}
