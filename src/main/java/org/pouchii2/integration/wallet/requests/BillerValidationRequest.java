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
public class BillerValidationRequest    extends  PouchiiRequestBase  {
     
    private  int     billerId = 15; 
    private  int     productId = 15; 
    private  String  serviceType = "ibadan_electric_prepaid"; 
    private  String  serviceCategory = "POWER"; 
    private  String  customerId = "23100153404"; 
    
       
    
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
     
     
    
    public   final  BillerValidationRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        BillerValidationRequest   billerValidationRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              billerValidationRequest = objectMapper.readValue(inObjectJSON, BillerValidationRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  billerValidationRequest;
    }
     
     
     
    
    public  static  BillerValidationRequest  readFromJSON(String  inObjectJSON){ 
        BillerValidationRequest  billerValidationRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              billerValidationRequest = objectMapper.readValue(inObjectJSON, BillerValidationRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  billerValidationRequest;
    }
      
 
      
    public  int  getBillerId(){
       return  billerId; 
    }
    
    public  int  getProductId(){
        return  productId;
    }
    
    public  String  getServiceType(){
        return  serviceType;
    }
    
    public  String  getServiceCategory(){
        return  serviceCategory;
    }
    
    public  String  getCustomerId(){
        return  customerId;
    }
    
    
    
    
    
    public  void  setBillerId(int  inBillerId){
          billerId = inBillerId; 
    }
    
    public  void  setProductId(int  inProductId){
           productId = inProductId;
    }
    
    public  void  setServiceType(String  inServiceType){
           serviceType = inServiceType;
    }
    
    public  void  setServiceCategory(String  inServiceCategory){
           serviceCategory = inServiceCategory;
    }
    
    public  void  setCustomerId(String  inCustomerId){
           customerId = inCustomerId;
    }
    
    
    
    
    
}
