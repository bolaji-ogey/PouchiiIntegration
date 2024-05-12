/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import io.vertx.core.AbstractVerticle; 
import io.vertx.core.Vertx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Deployer extends AbstractVerticle {

   private static final Logger logger = LoggerFactory.getLogger(Deployer.class);
     
     
    

        @Override
        public void start() {
            long delay = 1000;
            for (int i = 0; i < 50; i++) {
                vertx.setTimer(delay, id -> deploy());
                delay = delay + 1000;
            }
        }
        
        
        private void deploy() {
            vertx.deployVerticle(new EmptyVerticle(), ar -> {
            if (ar.succeeded()) {
               String id = ar.result();
               logger.info("Successfully deployed {}", id);
               vertx.setTimer(5000, tid -> undeployLater(id));
            } else {
              logger.error("Error while deploying", ar.cause());
            }
            });
        }
        
        
        
        private void undeployLater(String id) {
            vertx.undeploy(id, ar -> {
            if (ar.succeeded()) {
               logger.info("{} was undeployed", id);
            } else {
               logger.error("{} could not be undeployed", ar.cause()); 
            }
            });
        }
        
        
        
        
        
        public static void main(String[] args) {
           Vertx vertx = Vertx.vertx();
           vertx.deployVerticle(new Deployer());
        }
        
        
        
}
