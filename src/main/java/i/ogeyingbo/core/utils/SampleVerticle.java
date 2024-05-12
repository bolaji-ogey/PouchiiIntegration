/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class SampleVerticle  extends AbstractVerticle {
    
        private  static final Logger logger =   LoggerFactory.getLogger(SampleVerticle.class);
        
        
        @Override
        public void start() {
          logger.info("n = {}"+ config().getInteger("n", -1));
        }
                
        
        public static void main(String[] args) {
            Vertx vertx = Vertx.vertx();
            for (int n = 0; n < 4; n++) {
            JsonObject conf = new JsonObject().put("n", n);
            DeploymentOptions opts = new DeploymentOptions()
            .setConfig(conf)
            .setInstances(n);
            vertx.deployVerticle("chapter2.opts.SampleVerticle", opts);
           }
        }

    
}
