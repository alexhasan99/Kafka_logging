package com.kurdistan.LogConsumer.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaMessageListener {
    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);
    List<String> logMessages = new ArrayList<>();

    @KafkaListener(topics = "test", groupId = "group1")
    public void  consume(String message){
        logger.info("Consumer consume the message {}", message);
        logMessages.add(message);
    }

    public List<String> getLogMessages() {
        return new ArrayList<>(logMessages);
    }
}
