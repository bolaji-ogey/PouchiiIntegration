/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.requests;

 
import org.pouchii2.integration.wallet.requests.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.math.BigDecimal;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BalanceEnquiryByCustReference_1    extends  PouchiiRequestBase {
      
    private  String  currency = "-";
     
    
    
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
     
     
     public   final  BalanceEnquiryByCustReference_1  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        BalanceEnquiryByCustReference_1   balanceEnquiryByCustReference  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              balanceEnquiryByCustReference = objectMapper.readValue(inObjectJSON, BalanceEnquiryByCustReference_1.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  balanceEnquiryByCustReference;
    }
     
     
     
    public  static  BalanceEnquiryByCustReference_1  readFromJSON(String  inObjectJSON){ 
        BalanceEnquiryByCustReference_1  balanceEnquiryByCustReference  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              balanceEnquiryByCustReference = objectMapper.readValue(inObjectJSON, BalanceEnquiryByCustReference_1.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  balanceEnquiryByCustReference;
    }
      
    
     
    
      
    public  String  getCurrrency(){
       return  currency; 
    }
    
     
    
    
    public  void  setCurrrency(String   inCurrency){
          currency = inCurrency; 
    }
    
    
    
    
}
