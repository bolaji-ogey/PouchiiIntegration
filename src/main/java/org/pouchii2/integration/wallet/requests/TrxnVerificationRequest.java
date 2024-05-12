/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class TrxnVerificationRequest extends PouchiiRequestBase {
    
    
    public  String  processorReference = "-";
    public  String  trxnReference  = "-";
    
    
    private   String  url =  "/transactionservice/rest/api/payment/trans/verification/{TRANSACTION_REF}";
    
    
    public  String  getUrl(){
        return  url;
    }
    
    public  final  JSONObject  convertToJSON(){
        JSONObject  returnedJson =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
             objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
           returnedJson =  new JSONObject(objectMapper.writeValueAsString(this));
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJson;
    }
    
    
    public  final  String  convertToJSONString(){
        String  returnedJsonString =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            returnedJsonString  =   objectMapper.writeValueAsString(this);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJsonString;
    }
    
    
    
    public   final  TrxnVerificationRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        TrxnVerificationRequest  trxnVerificationRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              trxnVerificationRequest = objectMapper.readValue(inObjectJSON, TrxnVerificationRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  trxnVerificationRequest;
    }
     
     
    
    public  static  TrxnVerificationRequest  readFromJSON(String  inObjectJSON){ 
        TrxnVerificationRequest  trxnVerificationRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              trxnVerificationRequest = objectMapper.readValue(inObjectJSON, TrxnVerificationRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  trxnVerificationRequest;
    }
      
    
    public  String  getProcessorReference(){
        return  processorReference;
    }
    
    
    public String  getTrxnReference(){
        return  trxnReference;
    }
    
    
    
    
     
    public  void  setProcessorReference(String  inProcessorReference){
           processorReference = inProcessorReference;
    }
    
    
    public void  setTrxnReference(String  inTrxnReference){
           trxnReference = inTrxnReference;
    }
    
    
}
