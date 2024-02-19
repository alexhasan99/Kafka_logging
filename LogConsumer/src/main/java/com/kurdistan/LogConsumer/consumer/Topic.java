package com.kurdistan.LogConsumer.consumer;


import lombok.Getter;

@Getter
public class Topic {
    private final String name;

     private final int partitions;

    private final short replicationFactor;

    public Topic(String name, int partitions, short replicationFactor) {
        this.name = name;
        this.partitions = partitions;
        this.replicationFactor = replicationFactor;
    }
}
