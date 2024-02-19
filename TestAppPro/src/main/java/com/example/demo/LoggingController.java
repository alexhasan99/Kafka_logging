package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @GetMapping("/log")
    public String logMessage() {
        logger.info("Testmeddelande skickat till Kafka");
        return "Loggmeddelande skickat";
    }
}
