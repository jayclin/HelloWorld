package com.example.helloworld;

import java.util.concurrent.Callable;

public class Callablethread implements Callable {
    @Override
    public String call() throws Exception {
        doSomeThing();
        return "需要返回的值";
    }

    private void doSomeThing() {
        System.out.println("我是线程中的方法");
    }
}
