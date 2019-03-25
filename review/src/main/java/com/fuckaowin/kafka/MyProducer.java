package com.fuckaowin.kafka;
import java.util.Properties; 

import kafka.javaapi.producer.Producer; 
import kafka.producer.KeyedMessage; 
import kafka.producer.ProducerConfig; 
   
public class MyProducer {   
     
        public static void main(String[] args) {   
        	//������Hashtable����ֵ�Դ洢����<String,String>
            Properties props = new Properties();
          //�˴����õ���kafka�Ķ˿�
            props.setProperty("metadata.broker.list","localhost:9092");   
          //����value�����л���
            props.setProperty("serializer.class","kafka.serializer.StringEncoder");
            /*
             0������ζ��������producer���ȴ�����brokerͬ����ɵ�ȷ�ϼ���������һ����������Ϣ����ѡ���ṩ��͵��ӳٵ��������;��Ա�֤������������������ʱĳЩ���ݻᶪʧ����leader��������producer����֪�飬����ȥ����Ϣbroker���ղ�������
			1������ζ��producer��leader�ѳɹ��յ������ݲ��õ�ȷ�Ϻ�����һ��message����ѡ���ṩ�˸��õ��;���Ϊ�ͻ��ȴ�������ȷ������ɹ�����д������leader����δ���ƽ�ʧȥ��Ψһ����Ϣ����
			-1������ζ��producer��follower����ȷ�Ͻ��յ����ݺ����һ�η�����ɡ���ѡ���ṩ��õ��;��ԣ����Ǳ�֤û����Ϣ����ʧ��ֻҪ����һ��ͬ���������ִ�
             */
            props.put("request.required.acks","1");   
            ProducerConfig config = new ProducerConfig(props);   
            //�������������
            Producer<String, String> producer = new Producer<String, String>(config);
            //������Ϣ
            KeyedMessage<String, String> data = new KeyedMessage<String, String>("mykafka","test-kafka");
            try {   
                int i =1; 
                while(i < 100){    
                    //������Ϣ
                    producer.send(data);   
                } 
            } catch (Exception e) {   
                e.printStackTrace();   
            }   
            producer.close();   
        }   
}