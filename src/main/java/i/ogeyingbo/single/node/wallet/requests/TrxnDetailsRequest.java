/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.requests;

  
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class TrxnDetailsRequest  extends  RequestBase {
    
    public  String  processorReference = "-";
    public  String  trxnReference  = "-";
    
    
    private    String  url =  "/transactionservice/rest/api/payment/trans/details/{TRANSACTION_REF}";
    
    
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
    
    
    
    public   final  TrxnDetailsRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        TrxnDetailsRequest  trxnDetailsRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              trxnDetailsRequest = objectMapper.readValue(inObjectJSON, TrxnDetailsRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  trxnDetailsRequest;
    }
     
     
    
    public  static  TrxnDetailsRequest  readFromJSON(String  inObjectJSON){ 
        TrxnDetailsRequest  trxnDetailsRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              trxnDetailsRequest = objectMapper.readValue(inObjectJSON, TrxnDetailsRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  trxnDetailsRequest;
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
