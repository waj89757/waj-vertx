package com.jjbond.web;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import org.junit.Test;

/**
 * Created by ccelloeurdy on 2017/2/1.
 */
public class WebServer {

    public static void main(String args[]){

        Router router = Router.router(Vertx.vertx());

/*        router.route("/some/path/").handler(routingContext -> {
            routingContext.response().putHeader("content-type", "text/html").end("Hello World!");
        });*/

        router.route("/some/path/").handler(routingContext -> {

            HttpServerResponse response = routingContext.response();
            // enable chunked responses because we will be adding data as
            // we execute over other handlers. This is only required once and
            // only if several handlers do output.
            response.setChunked(true);

            response.write("route1\n");

            // Call the next matching route after a 5 second delay
            routingContext.vertx().setTimer(5000, tid -> routingContext.next());
        });

        Vertx.vertx().createHttpServer().requestHandler(router::accept).listen(8080);
    }

    @Test
    public void test1(){
        Router router = Router.router(Vertx.vertx());

        router.route("/some/path/").handler(routingContext -> {

            HttpServerResponse response = routingContext.response();
            // enable chunked responses because we will be adding data as
            // we execute over other handlers. This is only required once and
            // only if several handlers do output.
            //response.setChunked(true);

            response.write("route1\n");

            // Call the next matching route after a 5 second delay
            routingContext.vertx().setTimer(5000, tid -> routingContext.next());
        });

        Vertx.vertx().createHttpServer().requestHandler(router::accept).listen(8080);

    }



}
