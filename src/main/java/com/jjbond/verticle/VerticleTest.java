package com.jjbond.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * Created by ccelloeurdy on 2017/2/2.
 * 创建一个verticle对象
 */
public class VerticleTest extends AbstractVerticle {


    public static void main(String args[]){
        Vertx vertx = Vertx.vertx();
        //启动一个verticle
        vertx.deployVerticle(VerticleTest.class.getName());
    }


    @Override
    /**
     * 同步方式 底层使用worker线程池
     */
    public void start() throws Exception {
        vertx.executeBlocking(future -> {

            System.out.println("hello world !");
            future.complete();
        },r -> {});

        vertx.executeBlocking(future -> {
            System.out.println("nihao !");
        },r->{});

    }
}
