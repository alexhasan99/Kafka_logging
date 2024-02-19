package com.kurdistan.LogConsumer.consumer;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaTopicDelete {
    public void deleteTopic(String topicName) {
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "10.98.189.161:9092");

        try (AdminClient admin = AdminClient.create(config)) {
            DeleteTopicsResult result = admin.deleteTopics(Collections.singletonList(topicName));
            result.all().get();
            System.out.println("Topic " + topicName + " deleted successfully.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Failed to delete topic " + topicName + ": " + e.getMessage());
            // Hantera fel här (t.ex. topic finns inte, åtkomst nekad, etc.)
        }
    }
}
