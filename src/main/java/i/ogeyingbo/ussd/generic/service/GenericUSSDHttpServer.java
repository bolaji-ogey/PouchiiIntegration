/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  i.ogeyingbo.ussd.generic.service;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
 
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Launcher;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.net.SocketAddress;
import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject; 

/*
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class GenericUSSDHttpServer extends AbstractVerticle {
   
   // USSDServiceConfig   availableServices = USSDServiceConfig.getInstance();
    boolean isOk =  false;
     String   respJSON =  "";

  public static void main(String[] args) {
      Vertx    vertx = Vertx.vertx();
       
       DeploymentOptions  deployOptions =  new  DeploymentOptions();
      deployOptions.setInstances(5);
       deployOptions.setWorker(true);
    
       vertx.deployVerticle(new GenericUSSDEngine());
        vertx.deployVerticle(new GenericUSSDHttpServer());
      //  vertx.eventBus().registerDefaultCodec(JSONObject.class,
       //         new GenericCodec<JSONObject>(JSONObject.class));
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
       
              
                   vertx.eventBus().request("i.ogeyingbo.ussd.service.bus", reqInData, reply -> {
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
              
      });

    }).listen(8080, listenResult -> {
      if (listenResult.failed()) {
        System.out.println("Could not start GenericUSSDHttpServer server");
        listenResult.cause().printStackTrace();
      } else {
        System.out.println("Server started");
      }
    });
  }
  
  
}
