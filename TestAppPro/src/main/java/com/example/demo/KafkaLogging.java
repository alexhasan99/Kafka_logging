package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaLogging {
    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);
    static CustomLookup lookup = new CustomLookup();
    static public void logger (String type, String message){
        switch (type){
            case "info" ->logger.info("Container_ID: " +lookup.lookup("container.name") +" massage: " + message);
            case "error" -> logger.error("Container_ID: " +lookup.lookup("container.name") +" massage: " + message);
            case "debug" -> logger.debug("Container_ID: " +lookup.lookup("container.name") +" massage: " + message);
        }
    }
}
