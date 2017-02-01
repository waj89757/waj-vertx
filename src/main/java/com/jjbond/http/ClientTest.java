package com.jjbond.http;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import org.junit.Test;

/**
 * Created by ccelloeurdy on 2017/1/23.
 */
public class ClientTest {

    String url = "localhost:8080";

    @Test
    public void test1(){
        HttpClient httpClient = Vertx.vertx().createHttpClient();
        httpClient.getNow(8080,"localhost","/",resp ->{
            System.out.println("Got respnose " + resp.statusCode());
            resp.bodyHandler(body -> System.out.println("Got data " + body.toString("ISO-8859-1")));
            resp.handler(responseBody -> {
                System.out.println("response : " + responseBody.toString());
            });
        });
        while (true){

        }

    }

}
