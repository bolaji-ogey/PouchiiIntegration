/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import i.ogeyingbo.single.node.wallet.merchant.requests.ForgotMerchTrxnPin;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class LoanRepaymentNotificationReq extends  RequestBase {
    
    private  String  loanRequestReference = "";
    private  String  paymentReference = "";
    
    private  int     repaymentCount  =  0;
    private  String  repaymentCurrency = "NGN";
    private  BigDecimal  repaymentAmount = new BigDecimal(0.00);
    private  BigDecimal   repaymentAmountFee = new BigDecimal(0.00);
    
    private  String  loanRepaymentDate = "";
    private  int     loanRepaymentStatusCode  = 201;
    private  String  loanRepaymentStatus = "Successful"; 
    
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
     
     
     public   final  LoanRepaymentNotificationReq  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanRepaymentNotificationReq   loanRepaymentNotificationReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanRepaymentNotificationReq = objectMapper.readValue(inObjectJSON, LoanRepaymentNotificationReq.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanRepaymentNotificationReq;
    }
     
     
     
    public  static  LoanRepaymentNotificationReq  readFromJSON(String  inObjectJSON){ 
        LoanRepaymentNotificationReq  loanRepaymentNotificationReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanRepaymentNotificationReq = objectMapper.readValue(inObjectJSON, LoanRepaymentNotificationReq.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanRepaymentNotificationReq;
    }
      
      
   
  
    
    public  String  getLoanRequestReference(){
        return  loanRequestReference;
    }
    
    public  String  getPaymentReference(){
        return  paymentReference;
    }
    
    public  int  getRepaymentCount(){
        return  repaymentCount;
    }
    
    public  String  getRepaymentCurrency(){
        return  repaymentCurrency;
    }
    
    public  BigDecimal  getRepaymentAmount(){
        return  repaymentAmount;
    }
    
    public  BigDecimal  getRepaymentAmountFee(){
        return  repaymentAmountFee;
    }
    
    
    public  String  getLoanRepaymentDate(){
        return  loanRepaymentDate;
    }
    
    public  int  getLoanRepaymentStatusCode(){
        return  loanRepaymentStatusCode;
    }
    
    public  String  getLoanRepaymentStatus(){
        return  loanRepaymentStatus;
    }
    
     
    
}
