package com.fuckaowin.kafka;
import java.util.Properties; 

import kafka.javaapi.producer.Producer; 
import kafka.producer.KeyedMessage; 
import kafka.producer.ProducerConfig; 
   
public class MyProducer {   
     
        public static void main(String[] args) {   
        	//集成自Hashtable，键值对存储数据<String,String>
            Properties props = new Properties();
          //此处配置的是kafka的端口
            props.setProperty("metadata.broker.list","localhost:9092");   
          //配置value的序列化类
            props.setProperty("serializer.class","kafka.serializer.StringEncoder");
            /*
             0：这意味着生产者producer不等待来自broker同步完成的确认继续发送下一条（批）消息。此选项提供最低的延迟但最弱的耐久性保证（当服务器发生故障时某些数据会丢失，如leader已死，但producer并不知情，发出去的信息broker就收不到）。
			1：这意味着producer在leader已成功收到的数据并得到确认后发送下一条message。此选项提供了更好的耐久性为客户等待服务器确认请求成功（被写入死亡leader但尚未复制将失去了唯一的消息）。
			-1：这意味着producer在follower副本确认接收到数据后才算一次发送完成。此选项提供最好的耐久性，我们保证没有信息将丢失，只要至少一个同步副本保持存活。
             */
            props.put("request.required.acks","1");   
            ProducerConfig config = new ProducerConfig(props);   
            //创建生产这对象
            Producer<String, String> producer = new Producer<String, String>(config);
            //生成消息
            KeyedMessage<String, String> data = new KeyedMessage<String, String>("mykafka","test-kafka");
            try {   
                int i =1; 
                while(i < 100){    
                    //发送消息
                    producer.send(data);   
                } 
            } catch (Exception e) {   
                e.printStackTrace();   
            }   
            producer.close();   
        }   
}