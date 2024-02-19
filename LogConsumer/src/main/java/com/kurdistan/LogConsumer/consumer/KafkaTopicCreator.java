package com.kurdistan.LogConsumer.consumer;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Properties;

public class KafkaTopicCreator {

    public static void createTopic(final String topicName, final int partitions, final short replicationFactor) {
        Properties config = new Properties();
        // Ange Kafka-serverns adress här
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "10.98.189.161:9092");

        try (AdminClient adminClient = AdminClient.create(config)) {
            NewTopic newTopic = new NewTopic(topicName, partitions, replicationFactor);
            KafkaFuture<Void> future = adminClient.createTopics(Collections.singleton(newTopic)).all();
            future.get(); // Vänta på att framtiden slutförs
            System.out.println("Topic " + topicName + " created successfully");
        } catch (Exception e) {
            System.out.println("Failed to create topic " + topicName);
            e.printStackTrace();
        }
    }
}
