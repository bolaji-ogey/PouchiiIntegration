/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vertx.eventbus.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
class SenderVerticle extends AbstractVerticle {
    
    public  static  void main(String[] args){
         Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new ReceiverVerticle());
        vertx.deployVerticle(new SenderVerticle());
        vertx.eventBus().registerDefaultCodec(BigSerializedObject.class,
                new BigSerializedObjectCodec());
    }
   
    
    
    @Override
    public void start() {
       BigSerializedObject  bigSerializedObject  =  new BigSerializedObject();
       System.out.println("SENDING --> "+bigSerializedObject.toString());
        vertx.eventBus().send("address", bigSerializedObject);
    }
}
