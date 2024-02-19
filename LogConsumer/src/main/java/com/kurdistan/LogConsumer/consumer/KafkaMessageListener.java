package com.kurdistan.LogConsumer.consumer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaMessageListener {

    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    private List<String> logMessages = new ArrayList<>();
    private ConcurrentMessageListenerContainer<String, String> container;

    @Autowired
    private ConcurrentKafkaListenerContainerFactory<String, String> factory;

    public void startListeningToTopic(String topicName) {
        // Stop the current listener container if it is running
        if (container != null && container.isRunning()) {
            container.stop();
        }

        // Create a new instance of the container
        container = factory.createContainer(topicName);
        container.setupMessageListener((MessageListener<String, String>) message -> {
            logger.info("Consumer consume the message {}", message.value());
            logMessages.add(message.value());
        });

        // Start the container to begin listening to the topic
        container.start();
    }

    public List<String> getLogMessages() {
        return new ArrayList<>(logMessages);
    }
}

