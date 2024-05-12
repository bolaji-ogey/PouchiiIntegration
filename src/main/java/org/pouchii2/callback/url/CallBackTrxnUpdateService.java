/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.callback.url;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Launcher;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.net.SocketAddress;
import java.sql.Connection;
import org.json.JSONObject; 

/*
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class CallBackTrxnUpdateService extends AbstractVerticle {
     
  public static void main(String[] args) {
      Vertx    vertx = Vertx.vertx();
       
       DeploymentOptions  deployOptions =  new  DeploymentOptions();
      deployOptions.setInstances(5);
       deployOptions.setWorker(true);
    
     //  vertx.deployVerticle(new RequestEventProcessorService());
       vertx.deployVerticle(new  LenderLoanAppNotifyProc());
        vertx.deployVerticle(new CallBackTrxnUpdateService());
        vertx.eventBus().registerDefaultCodec(JSONObject.class,
                new GenericCodec<JSONObject>(JSONObject.class));
  }

  
  
  
  @Override
  public void start() throws Exception {

    vertx.createHttpServer().requestHandler(req -> {
         
      req.bodyHandler(buff -> {
      //  System.out.println("Receiving user " + buff.toJsonObject().encodePrettily() + " from client ");
        JSONObject  reqData  =  null;
        try{
             String  reqInData =  buff.toJsonObject().encodePrettily();
             reqData  =  new JSONObject(buff.toJsonObject().encodePrettily());
            // vertx.eventBus().send("req.event.proc.bus", reqInData);
            
            System.out.println("RECIEVING: "+reqData.toString());
              
             vertx.eventBus().request("lender.api.proc.bus", reqInData, reply -> {
               //    vertx.eventBus().request("req.event.proc.bus", reqInData, reply -> {
                     if (reply.succeeded()) {
                             System.out.println("Reply successfull");
                             context.get(new JSONObject(reply.result().body()));
                        } else {
                           System.out.println("No reply");
                       }
                    });
                   
        }catch(Exception ex){
            ex.printStackTrace();
        }
           req.response().setStatusCode(200).setStatusMessage("OK").send(reqData.toString());
      });

    }).listen(8080, listenResult -> {
      if (listenResult.failed()) {
        System.out.println("Could not start HTTP server");
        listenResult.cause().printStackTrace();
      } else {
        System.out.println("Server started");
      }
    });
  }
}
