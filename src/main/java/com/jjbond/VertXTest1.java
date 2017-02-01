package com.jjbond;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.junit.Test;

/**
 * Created by ccelloeurdy on 2017/1/24.
 */
public class VertXTest1 {

    @Test
    public void test1(){
        Vertx.vertx().setTimer(1,h->{
            System.out.println("hello world!");
        });
        while (true){

        }
    }

    @Test
    public void test2(){
        Vertx.vertx(new VertxOptions().setWorkerPoolSize(20));
    }


}
