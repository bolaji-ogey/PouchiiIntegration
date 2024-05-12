/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vertx.eventbus.example;

import io.vertx.core.AbstractVerticle;
import static io.vertx.core.Vertx.vertx;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
class ReceiverVerticle extends AbstractVerticle {
    
    @Override
    public void start() {
        vertx.eventBus().consumer("address", (message) -> {
            System.out.println("RECEIVED MSG --> "+message.body().toString());
        });
    }
}
