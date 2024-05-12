/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.callback.url;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CallBackResult {
    
    public  int  recordsInserted =  0;
    private  String  notificationEvent =  "";
    private  String  notificationType =  "";
    private  String  transactionStatus =  "";
    private  int  statusCode =  0;
    private  boolean  doLog = false;
    private  CallBackResultData    resultData =  null;    
    public  TransactionLog    logData =  null;
  //  CustomPool    custPool  =   CustomPool.getInstance();
    
    public  CallBackResult(CustomPool    inCustPool,   JSONObject  inResult){
          CustomPool    custPoolz  = inCustPool;
        try{
            
            notificationEvent =  inResult.getString("notificationEvent");
            notificationType  =  inResult.getString("notificationType");
            transactionStatus  =  inResult.getString("transactionStatus");
            statusCode = inResult.getInt("statusCode");
            resultData = new CallBackResultData(inResult.getJSONObject("data"));
            logData = new TransactionLog(inResult.getJSONObject("data")); 
           
            logData.setStatusCode(statusCode);
            transactionStatus  =  inResult.getString("transactionStatus");
            
            try{
                if(inResult.getBoolean("doLog") != false){
                    doLog  =  inResult.getBoolean("doLog");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            
            if(doLog == true){
                    try{
                        String     identKey    =    (String)CustomPool.getIdentityKey();
                        System.out.println("Identity key is "+identKey);
                         Connection  cron   =  custPoolz.getPoolConnection(identKey);

                        int  isRecordInserted =  recordsInserted = logData.recordTransactionLog(cron);

                        logData.setTransactionValueAmount(new BigDecimal(500));
                        int   res = logData.getTransactionValueAmount().compareTo(new BigDecimal(200));
                        System.out.println("----------- res ----------------> "+res);
                        if(logData.getTransactionValueAmount().compareTo(new BigDecimal(200)) > 0){
                               logData.updateWalletBalance(cron);
                               System.out.println("----------- Trxn Value is greater than 200 ---------------- ");
                        }else if(logData.getTransactionValueAmount().compareTo(new BigDecimal(200)) == 0){
                              // logData.updateWalletBalance(cron);
                               System.out.println("----------- Trxn Value is equal to 200 ---------------- ");
                        }else if(logData.getTransactionValueAmount().compareTo(new BigDecimal(200)) < 0){
                              // logData.updateWalletBalance(cron);
                               System.out.println("----------- Trxn Value is less than 200 ---------------- ");
                        }

                        logData.updateTrxnHistory(cron, logData.getTrxnHistoryColumnRef(cron));
                        logData.updateWalletBalanceHistory(cron, logData.getWalletBalHistoryColumnRef(cron));

                       if(cron != null){
                           System.out.println("Connection: "+cron.toString()+"    acquired....");
                           custPoolz.closePoolConnection(identKey);

                           if(isRecordInserted > 0){
                               System.out.println(String.format("%d  records inserted ", isRecordInserted));
                           }
                       }else{

                           System.out.println("Error acquiring connection. Connection cannot be  acquired");
                       }

                    }catch(Exception ei){
                        ei.printStackTrace();
                    }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
 
    
    
    
    
      public  CallBackResult(JSONObject  inResult, boolean  noLog){
        try{
            notificationEvent =  inResult.getString("notificationEvent");
            notificationType  =  inResult.getString("notificationType");
            transactionStatus  =  inResult.getString("transactionStatus");
            statusCode = inResult.getInt("statusCode");
            resultData = new CallBackResultData(inResult.getJSONObject("data"));
            logData = new TransactionLog(inResult.getJSONObject("data")); 
           
            logData.setStatusCode(statusCode);
             
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
 
      
      
      
    
    public  void  logOut(){
        System.out.println("notificationEvent  --> "+notificationEvent);
        System.out.println("notificationType  --> "+notificationType);
        System.out.println("transactionStatus  --> "+transactionStatus);
        System.out.println("statusCode  --> "+statusCode);        
        resultData.logOut();
    }
  
    public  String  getNotificationEvent(){
        return  notificationEvent;
    }
    
    public  String  getNotificationType(){
        return  notificationType;
    }
    
    public  String  gettransactionStatus(){
        return  transactionStatus;
    }
    
    public  int  getStatusCode(){
        return  statusCode;
    }
    
    public  CallBackResultData  getResultData(){
        return  resultData;
    }
}
