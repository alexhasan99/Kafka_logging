package com.kurdistan.LogConsumer.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kafka/consumer")
public class ConsumerController {

    @Autowired
    private KafkaMessageListener kafkaMessageListener;

    @Autowired
    private  KafkaTopicDelete kafkaTopicDelete;


    @GetMapping("/listen/{name}")
    public ResponseEntity<String> startListening(@PathVariable String name) {
        kafkaMessageListener.startListeningToTopic(name);
        return ResponseEntity.ok("Listening to topic: " + name);
    }

    @GetMapping("/delete/{name}")
    public ResponseEntity<String> deleteTopic(@PathVariable String name) {
        kafkaTopicDelete.deleteTopic(name);
        return ResponseEntity.ok("Deleted topic: " + name);
    }

    @GetMapping("/logs")
    public List<String> getLogMessages() {
        return kafkaMessageListener.getLogMessages();
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic){
        KafkaTopicCreator.createTopic(topic.getName(), topic.getPartitions(), topic.getReplicationFactor());
        return topic;
    }
}
