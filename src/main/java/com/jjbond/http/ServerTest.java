package com.jjbond.http;

import io.vertx.core.Vertx;
import sun.security.provider.certpath.Vertex;

/**
 * Created by ccelloeurdy on 2017/1/23.
 */
public class ServerTest {

    public static void main(String args[]){
        String url = "localhost:8080";
        Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end("Hello World!")).listen(8080);
    }

}
