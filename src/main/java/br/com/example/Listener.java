package br.com.example;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {

	@Value("${topic.clientId}")
	private String clientId;

//	@KafkaListener(id = "${topic.clientId}", topicPartitions = {
//			@TopicPartition(topic = "${topic.name}", partitions = { "${topic.partition}" }) }, concurrency = "5")
	@KafkaListener(topics = { "${topic.name}" })
	public void listenPartition0(ConsumerRecord<?, ?> record) {
		System.out.println("Listener " + clientId + ", Thread ID: " + Thread.currentThread().getId());
		System.out.println("Received: " + record);
	}
}
