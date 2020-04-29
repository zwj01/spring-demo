package com.sofg.utils;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

public class KafkaUtil {
    public static Properties properties = new Properties();

    private static void setProperties() {
        try {
            properties.load(KafkaUtil.class.getResourceAsStream("/kafka.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMsg(String topic,String jsonString){
        setProperties();
        Producer<String, String> producer = null;
        producer = new KafkaProducer<String, String>(properties);
        System.out.println("发送消息到kafka");
        producer.send(new ProducerRecord<>(topic,jsonString));
        System.out.println("消息发送结束");
    }
}
