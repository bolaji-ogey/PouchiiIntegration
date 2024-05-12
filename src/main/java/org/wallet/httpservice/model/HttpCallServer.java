/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.wallet.httpservice.model;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
import org.pouchii2.callback.url.*;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Launcher;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.net.SocketAddress;
import java.sql.Connection;
import org.json.JSONObject; 

/*
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class HttpCallServer extends AbstractVerticle {
    
 //    CustomPool    custPool  =    CustomPool.getInstance();
     TransactionLog   trxnLog  = new TransactionLog();
     boolean isOk =  false;
     String   respJSON =  "";

  public static void main(String[] args) {
      Vertx    vertx = Vertx.vertx();
       
       DeploymentOptions  deployOptions =  new  DeploymentOptions();
      deployOptions.setInstances(5);
       deployOptions.setWorker(true);
    
       vertx.deployVerticle(new RequestEventProcessorService());
        vertx.deployVerticle(new HttpCallServer());
        vertx.eventBus().registerDefaultCodec(JSONObject.class,
                new GenericCodec<JSONObject>(JSONObject.class));
  }

  
  
  
  @Override
  public void start() throws Exception {

      
    vertx.createHttpServer().requestHandler(req -> {
          
      req.bodyHandler(buff -> {
      //  System.out.println("Receiving user " + buff.toJsonObject().encodePrettily() + " from client ");
        JSONObject  reqData  =  null; 
         respJSON = "";
        try{
             String  reqInData =  buff.toJsonObject().encodePrettily();
             reqData  =  new JSONObject(buff.toJsonObject().encodePrettily());
            // vertx.eventBus().send("req.event.proc.bus", reqInData);
       
              
                   vertx.eventBus().request("req.event.proc.bus", reqInData, reply -> {
                     if (reply.succeeded()) {
                            isOk = true;
                             System.out.println("Reply successfull"); 
                             respJSON = reply.result().body().toString();
                              System.out.println("reply.result().body().toString()  --> "+reply.result().body().toString()); 
                             // context.get(new JSONObject(reply.result().body())); v  
                            req.response().setStatusCode(200).setStatusMessage("OK").end(respJSON);
                        } else {
                           System.out.println("No reply");
                           JSONObject  respData  =  new JSONObject();
                            respData.put("responseStatus", 400);
                            respData.put("transactionRef", "unknown");
                            respData.put("processorRespRef", "99");
                            respData.put("responseMessage", "fail");
                           respJSON = respData.toString();
                           req.response().setStatusCode(201).setStatusMessage("FAILED").end(respJSON);
                       }
                    });
                   
        }catch(Exception ex){
            ex.printStackTrace();
        }
          
         SocketAddress   reqSockAddr =  req.remoteAddress();
        
            String  reqIPAddress =  reqSockAddr.host();
            int    reqIPPort =  reqSockAddr.port();
            
            System.out.println("reqIPAddress  >>> "+reqIPAddress);
            System.out.println("reqIPPort  >>>>  "+reqIPPort);
             
          // req.response().setStatusCode(200).setStatusMessage("OK").end(respJSON);
           // req.response().setStatusCode(200).setStatusMessage("OK").send(respJSON);
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
