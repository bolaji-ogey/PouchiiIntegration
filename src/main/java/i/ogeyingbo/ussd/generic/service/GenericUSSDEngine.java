/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package   i.ogeyingbo.ussd.generic.service;
 

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message; 
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.net.SocketAddress;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class GenericUSSDEngine extends AbstractVerticle {
 
   USSDServiceConfig   availableServices = USSDServiceConfig.getInstance();
  private static final CustomPool    custPool  =     CustomPool.getInstance(); 
   
  
    
    
 @Override
  public void start() throws Exception {  
       vertx.eventBus().consumer("i.ogeyingbo.ussd.service.bus",this::onUSSDTextRecieved); 
       System.out.println("GenericUSSDEngine   Started . . ..");
  }
  
  
//  onMessage() will be called when a message is received.
  private   void  onUSSDTextRecieved(Message  tMessage) {
        
         String  response =  "";
         String message = (String) tMessage.body();  
         System.out.println("Message Received: --> \n " + message);
       
         String[]   inTextData   =  message.split(",");
         UserUSSDReqProcessor  userUSSDReqProcessor
                 =  new UserUSSDReqProcessor(inTextData[0],  inTextData[1]);
         
         try{
                String     identKey    =    (String)CustomPool.getIdentityKey();
                System.out.println("Identity key is "+identKey);
                 Connection  cron   =  custPool.getPoolConnection(identKey);
  
                if(cron != null){
                    response =  userUSSDReqProcessor.doProcess(cron, availableServices, inTextData[0],  inTextData[1]);
                    System.out.println("Connection: "+cron.toString()+"    acquired....");
                    custPool.closePoolConnection(identKey); 
                }else{
                    System.out.println("Error acquiring connection. Connection cannot be  acquired");
                }

             }catch(Exception ei){
                 ei.printStackTrace();
             }
         
        tMessage.reply( response);
  }
  
   
  
  
       

}
