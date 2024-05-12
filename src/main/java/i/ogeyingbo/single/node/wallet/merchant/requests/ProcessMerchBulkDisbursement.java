/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.merchant.requests;

  
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ProcessMerchBulkDisbursement   extends  MerchantRequestBase  {
     
    private  String  batchId = "-";
    private  String  paymentProcessAction = "Cancel"; // Cancel or Process
    private  String  trxnPin = "8888"; 
   
    
    
    
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
     
    
    
     public   final  ProcessMerchBulkDisbursement  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ProcessMerchBulkDisbursement   processMerchBulkDisbursement  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              processMerchBulkDisbursement = objectMapper.readValue(inObjectJSON, ProcessMerchBulkDisbursement.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  processMerchBulkDisbursement;
    }
     
     
     
    
    public  static  ProcessMerchBulkDisbursement  readFromJSON(String  inObjectJSON){ 
        ProcessMerchBulkDisbursement  processMerchBulkDisbursement  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              processMerchBulkDisbursement = objectMapper.readValue(inObjectJSON, ProcessMerchBulkDisbursement.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  processMerchBulkDisbursement;
    }
      
    
    
     
    
    public  String  getBatchId(){
        return  batchId;
    }
    
    public  String  getPaymentProcessAction(){
        return  paymentProcessAction;
    }
    
    public  String  getTrxnPin(){
        return  trxnPin;
    }

    
    
    
     public  void  setBatchId(String  inBatchId){
           batchId = inBatchId;
    }
    
    public  void  setPaymentProcessAction(String  inPaymentProcessAction){
           paymentProcessAction = inPaymentProcessAction;
    }
    
    public  void  setTrxnPin(String  inTrxnPin){
           trxnPin = inTrxnPin;
    }
    
    
}
