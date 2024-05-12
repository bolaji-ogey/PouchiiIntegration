/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.merchant.requests.backup;
 
 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ReProcessMerchBulkDisbursement  extends  MerchantRequestBase {
     
    private  String  batchId = "-";
    private  String  debitCurrency = "-";
    private  String  trxnPin = "-";
    
    
     
    
    
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
     
     
     public   final  ReProcessMerchBulkDisbursement  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ReProcessMerchBulkDisbursement   reProcessMerchBulkDisbursement  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              reProcessMerchBulkDisbursement = objectMapper.readValue(inObjectJSON, ReProcessMerchBulkDisbursement.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  reProcessMerchBulkDisbursement;
    }
     
     
     
    public  static  ReProcessMerchBulkDisbursement  readFromJSON(String  inObjectJSON){ 
        ReProcessMerchBulkDisbursement  reProcessMerchBulkDisbursement  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              reProcessMerchBulkDisbursement = objectMapper.readValue(inObjectJSON, ReProcessMerchBulkDisbursement.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  reProcessMerchBulkDisbursement;
    }
      
 
    
    public  String  getBatchId(){
        return  batchId;
    }
    
    public  String  getDebitCurrency(){
        return  debitCurrency;
    }
    
    public  String  getTrxnPin(){
        return  trxnPin;
    }
    
    
    
    
    
    public  void  setBatchId(String  inBatchId){
           batchId = inBatchId;
    }
    
    public  void  setDebitCurrency(String  inDebitCurrency){
           debitCurrency = inDebitCurrency;
    }
    
    public  void  setTrxnPin(String  inTrxnPin){
           trxnPin = inTrxnPin;
    }
    
    
    
}
