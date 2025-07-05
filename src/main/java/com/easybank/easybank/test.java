package com.easybank.easybank;

public class test {
    private int count = 0;
    public synchronized void increaseCount(){
        this.count ++;
    }
    public int getCount(){
        return this.count;
    }
    public static void main(String[] args) throws InterruptedException {
        test instance = new test();
        Thread t1 = new Thread(()->{
            for (int i = 0; i< 100000;i++){
                instance.increaseCount();
                System.out.println("this is thread1 :" + instance.getCount());
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i< 100000;i++){
                instance.increaseCount();
                System.out.println("this is thread2 :" + instance.getCount());
            }
        });
        t1.start();
        t2.start();
        t1.wait();
        t1.join();
        t2.join();
        System.out.println("final count: "+instance.getCount());
    }
}
