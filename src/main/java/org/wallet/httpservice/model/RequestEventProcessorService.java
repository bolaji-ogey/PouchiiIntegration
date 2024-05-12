/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.wallet.httpservice.model;
 
import org.pouchii2.callback.url.*;
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
public class RequestEventProcessorService extends AbstractVerticle {
     
  private static final CustomPool    custPool  =     CustomPool.getInstance(); 
   
  
    
    
 @Override
  public void start() throws Exception {  
       vertx.eventBus().consumer("req.event.proc.bus",this::onTrxnDecryptReqstRecieved); 
        System.out.println("RequestEventProcessorService   Started . . ..");
  }
  
  
//  onMessage() will be called when a message is received.
  private   void  onTrxnDecryptReqstRecieved(Message  tMessage) {
        //  JSONObject message = (JSONObject) tMessage.body(); 
         String message = (String) tMessage.body();  
         System.out.println("Message Received: --> \n " + message.toString());
        //  logDecryptedTrxnRequest(message);
         JSONObject  respJson =   new JSONObject(); 
         respJson.put("responseMessage", "Yes I got it");
        // tMessage.reply("RESPONSE");
        //  tMessage.reply(respJson.toString());
        
        tMessage.reply( doProcess(new JSONObject(message)));
  }
  
   
  
  private  String  doProcess(JSONObject  reqData){
     
      JSONObject  respData  =  new JSONObject();
      
        if(reqData != null){
             CallBackResult    callBackResult  =  new  CallBackResult(custPool, reqData);
            //  callBackResult  =  new  CallBackResult(reqData, false);
             TransactionLog  trxnLog  = new TransactionLog(reqData.getJSONObject("data"));
           
            //  trxnLog = getRecordFromLog(callBackResult);
               
                respData.put("responseCode", trxnLog.getProcessorRespCode().trim());

                respData.put("responseStatus", trxnLog.getTransStatusCode());
                respData.put("transactionRef", trxnLog.getTransRef().trim());
                respData.put("processorRespRef", trxnLog.getProcessorRespRef().trim());
                respData.put("responseMessage", trxnLog.getTransStatus().trim());
                respData.put("customerReference", trxnLog.getCustomerReference().trim());
                respData.put("beneficiaryCustomerId", trxnLog.getBeneficiaryCustomerId().trim());
            
           }else{
               respData.put("responseStatus", 400);
                respData.put("transactionRef", "unknown");
                respData.put("processorRespRef", "99");
                respData.put("responseMessage", "fail");
            
          }
           
        
            return  respData.toString();
        // req.response().setStatusCode(200).setStatusMessage("OK").send(respData.toString());
         
  }
    
  


public  TransactionLog   getRecordFromLog(CallBackResult    callBackResult){
    TransactionLog   trxnLogi =  new  TransactionLog();
    
       if(callBackResult.recordsInserted >  0){        
                try{
                          String     identKey    =    (String)CustomPool.getIdentityKey();
                          System.out.println("Identity key is "+identKey);
                           Connection  cron   =  custPool.getPoolConnection(identKey);

                          trxnLogi.getTransactionLog(cron);
                          trxnLogi.logOut();

                          if(cron != null){
                              System.out.println("Connection: "+cron.toString()+"    acquired....");
                              custPool.closePoolConnection(identKey); 
                          }else{

                              System.out.println("Error acquiring connection. Connection cannot be  acquired");
                          }

                       }catch(Exception ei){
                           ei.printStackTrace();
                       }
           }
     return  trxnLogi;        
}  



}
