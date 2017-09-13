package com.example.demo.test;

/**
 * Created by jiaozhiguang on 2017/8/29.
 */
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MyConsumer {
    public static void main(String[] args) {
        String topic = "lxw1234.com";
        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(createConsumerConfig());
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream =  consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while(it.hasNext())
            System.out.println("consume: " + new String(it.next().message()));
    }

    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        props.put("group.id","group1");
//        props.put("zookeeper.connect","zk1:2181,zk2:2181,zk3:2181");
        props.put("zookeeper.connect","127.0.0.1:2181");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        return new ConsumerConfig(props);
    }
}
