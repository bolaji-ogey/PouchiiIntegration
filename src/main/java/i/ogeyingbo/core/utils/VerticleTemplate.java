/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import io.vertx.core.AbstractVerticle;  
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class VerticleTemplate  extends AbstractVerticle {
    
        private static final Logger logger = (java.util.logging.Logger) LoggerFactory.getLogger(VerticleTemplate.class);
       
        @Override
        public void start() {
          logger.info("Start");
        }
        
        @Override
        public void stop() {
          logger.info("Stop");
        }
         
    
    
}
