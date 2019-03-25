package com.fuckaowin.kafka;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
public class Consumer implements Runnable {
//    首先建立一个处理消息的类Consumer
    private KafkaStream stream;
    private int threadNumber;
 
    public Consumer(KafkaStream a_stream, int a_threadNumber) {
        threadNumber = a_threadNumber;
        stream = a_stream;
    }
 
    public void run() {
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext())
            System.out.println("Thread " + threadNumber + ": " + new String(it.next().message()));
        System.out.println("Shutting down Thread: " + threadNumber);
    }
}