/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monicenta.lenders.api;
 
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
public class LenderLoanAppNotifyProc extends AbstractVerticle {
     
 
    
    
 @Override
  public void start() throws Exception {  
       vertx.eventBus().consumer("lender.api.proc.bus",this::onTrxnDecryptReqstRecieved); 
        System.out.println("LenderLoanAppNotifyProc   Started . . ..");
  }
  
  
//  onMessage() will be called when a message is received.
  private   void  onTrxnDecryptReqstRecieved(Message  tMessage) {
        //  JSONObject message = (JSONObject) tMessage.body(); 
         String message = (String) tMessage.body();  
         System.out.println("Message Received: --> \n " + message.toString());
        //  logDecryptedTrxnRequest(message); 
        // tMessage.reply("RESPONSE");
        //  tMessage.reply(respJson.toString());
        
        tMessage.reply( doProcess(new JSONObject(message)));
        
  }
  
   
  
  private  String  doProcess(JSONObject  reqData){
      
      LoanApplicationNotifyReq  loanApplicationNotifyReq =  null;
     
      JSONObject  respData  =  new JSONObject();
      
        if(reqData != null){
            
              loanApplicationNotifyReq  =   LoanApplicationNotifyReq.readFromJSON(reqData.toString());
             
              System.out.println(loanApplicationNotifyReq.getTenureRate());
             System.out.println(loanApplicationNotifyReq.toString());
          }
           
        return   loanApplicationNotifyReq.toString();
     //return  respData.toString();
      // req.response().setStatusCode(200).setStatusMessage("OK").send(respData.toString());
         
  }
    
  

   
  
  
   
}
