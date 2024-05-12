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
public class MerchFetchMyBilkDisbursementTrxn  extends  MerchantRequestBase  {
     
    private  int  pageSize = 30;
    private  int  page = 0;
    private  String  batchId = "_";
    private  String  trxnReference = "_";
    private  String  customerReference = "_";
    private  String  trxnAmount = "_";
     
    
    
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
     
     
     public   final  MerchFetchMyBilkDisbursementTrxn  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        MerchFetchMyBilkDisbursementTrxn   merchFetchMyBilkDisburseTrxn  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchFetchMyBilkDisburseTrxn = objectMapper.readValue(inObjectJSON, MerchFetchMyBilkDisbursementTrxn.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchFetchMyBilkDisburseTrxn;
    }
     
     
    public  static  MerchFetchMyBilkDisbursementTrxn  readFromJSON(String  inObjectJSON){ 
        MerchFetchMyBilkDisbursementTrxn  merchFetchMyBilkDisbursementTrxn  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchFetchMyBilkDisbursementTrxn = objectMapper.readValue(inObjectJSON, MerchFetchMyBilkDisbursementTrxn.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchFetchMyBilkDisbursementTrxn;
    }
      
  
     
    
    public  int  getPageSize(){
        return  pageSize;
    }
    
    public  int  getPage(){
        return  page;
    }
    
    public  String  getBatchId(){
        return  batchId;
    }
    
    public  String  getTrxnReference(){
        return  trxnReference;
    }
    
    public  String  getCustomerReference(){
        return  customerReference;
    }
     
    public  String  getTrxnAmount(){
        return  trxnAmount;
    }
    
    
    
    
    
    public  void  setPageSize(int  inPageSize){
           pageSize = inPageSize;
    }
    
    public  void  setPage(int  inPage){
           page = inPage;
    }
    
    public  void  setBatchId(String  inBatchId){
           batchId = inBatchId;
    }
    
    public  void  setTrxnReference(String  inTrxnReference){
           trxnReference = inTrxnReference;
    }
    
    public  void  setCustomerReference(String  inCustomerReference){
           customerReference = inCustomerReference;
    }
     
    public  void  setTrxnAmount(String  inTrxnAmount){
           trxnAmount =  inTrxnAmount;
    }
    
    
    
}
