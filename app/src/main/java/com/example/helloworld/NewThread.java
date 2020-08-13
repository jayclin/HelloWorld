package com.example.helloworld;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread {
    public static void main(String[] args) {
        Callable<String> callable=new Callablethread();
        FutureTask<String> futureTask=new FutureTask<String>(callable);
        Thread thread=new Thread(futureTask);
        thread.start();
        doSomething();
        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void doSomething() {
        System.out.println("1233445");
    }
}
