package com.kurdistan.LogConsumer.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kafka/consumer")
public class ConsumerController {

    @Autowired
    private KafkaMessageListener kafkaMessageListener;

    @GetMapping
    public List<String> logTest() {
        return kafkaMessageListener.getLogMessages();
    }
}
