/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class SomeVerticle   extends AbstractVerticle {

    @Override
    public void start(Promise<Void> promise) {
        vertx.createHttpServer()
        .requestHandler(req -> req.response().end("Ok"))
        .listen(8080, ar -> {
            if (ar.succeeded()) {
               promise.complete();
            } else {
               promise.fail(ar.cause());
            }
        });
    }
    
    
    
    
    
}
    
 