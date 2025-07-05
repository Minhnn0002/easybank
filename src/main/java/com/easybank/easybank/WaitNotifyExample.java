package com.easybank.easybank;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyExample {

    private final List<Integer> buffer = new ArrayList<>();
    private final int LIMIT = 5;

    public static void main(String[] args) {
        WaitNotifyExample example = new WaitNotifyExample();
        example.doWork();
    }

    public void doWork() {
        Thread producer = new Thread(this::produce);
        Thread consumer = new Thread(this::consume);

        producer.start();
        consumer.start();
    }

    public void produce() {
        int value = 0;
        while (true) {
            synchronized (buffer) {
                while (buffer.size() == LIMIT) {
                    try {
                        System.out.println("Producer waiting...");
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer.add(value);
                System.out.println("Produced: " + value++);
                buffer.notify(); // đánh thức consumer
                try {
                    Thread.sleep(500); // để dễ quan sát
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        System.out.println("Consumer waiting...");
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int value = buffer.remove(0);
                System.out.println("Consumed: " + value);
                buffer.notify(); // đánh thức producer
                try {
                    Thread.sleep(1000); // để dễ quan sát
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

