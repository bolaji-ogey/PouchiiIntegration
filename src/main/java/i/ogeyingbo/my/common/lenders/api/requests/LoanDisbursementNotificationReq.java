/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class LoanDisbursementNotificationReq extends  RequestBase {
    
    private  String  loanRequestReference = "";
    private  String  disbursementPaymentReference = "";
    
    private  String     disbursementCurrency = "NGN";
    private  BigDecimal  disbursementAmount = new BigDecimal(0.00);
    private  BigDecimal  disbursementFeeAmount = new BigDecimal(0.00);
    
    private  String  disbursementDate = "";
    private  int     disbursementStatusCode  = 201;
    private  String  disbursementStatus = ""; 
    
    ArrayList<TrxnFee>    transFees  =  new  ArrayList<>();
    
    
    
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
     
     
     public   final  LoanDisbursementNotificationReq  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanDisbursementNotificationReq   loanDisbursementNotificationReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanDisbursementNotificationReq = objectMapper.readValue(inObjectJSON, LoanDisbursementNotificationReq.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanDisbursementNotificationReq;
    }
     
     
     
    public  static  LoanDisbursementNotificationReq  readFromJSON(String  inObjectJSON){ 
        LoanDisbursementNotificationReq  loanDisbursementNotificationReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanDisbursementNotificationReq = objectMapper.readValue(inObjectJSON, LoanDisbursementNotificationReq.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanDisbursementNotificationReq;
    }
      
    
    
    
  
    
    public  String  getLoanRequestReference(){
        return  loanRequestReference;
    }
    
    public  String  getDisbursementPaymentReference(){
        return  disbursementPaymentReference;
    }
    
    
    
    public  String  getDisbursementCurrency(){
        return   disbursementCurrency;
    }
    
    public  BigDecimal  getDisbursementAmount(){
        return  disbursementAmount;
    }
    
    public  BigDecimal  getDisbursementFeeAmount(){
        return  disbursementFeeAmount;
    }
    
    
    public  String  getDisbursementDate(){
        return  disbursementDate;
    }
    
    public  int  getDisbursementStatusCode(){
        return  disbursementStatusCode;
    }
    
    public  String  getDisbursementStatus(){
        return  disbursementStatus;
    }
    
    
    
}
