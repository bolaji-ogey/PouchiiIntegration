/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import io.vertx.core.AbstractVerticle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class EmptyVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(EmptyVerticle.class);
    
    @Override
    public void start() {
      logger.info("Start");
    }
    
    
    @Override
    public void stop() {
      logger.info("Stop");
    }


}
