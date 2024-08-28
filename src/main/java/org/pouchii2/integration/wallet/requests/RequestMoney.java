/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RequestMoney  extends  PouchiiRequestBase {
       
    @NotBlank(message = "Currency cannot be null or empty")
    @Size(min=3,  max=3, message="Currency must be three (3) letter code")
    private  String  currency = "-"; 
    
     @Positive(message = "Request amount must be a positive number")    
    @Digits(integer = 8, fraction = 2, message = "Request amount must consist of digit value only")
    private  BigDecimal  requestAmount = new BigDecimal(0.00); 
    
    @NotBlank(message = "Beneficiary wallet cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Beneficiary wallet must be ten (10) digits")
    private  String  beneficiaryWallet = "-"; 
    
    @NotBlank(message = "Source wallet number cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Source wallet number must be ten (10) digits")
    private  String  sourceWalletNumber = "-"; 
    
    @NotBlank(message = "Reason cannot be null or empty")
    private  String  reason = "Request Money"; 
   
     
    
    
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
     
     
     
    public   final  RequestMoney  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        RequestMoney   requestMoney  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              requestMoney = objectMapper.readValue(inObjectJSON, RequestMoney.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  requestMoney;
    }
     
     
     
    public  static  RequestMoney  readFromJSON(String  inObjectJSON){ 
        RequestMoney  requestMoney  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              requestMoney = objectMapper.readValue(inObjectJSON, RequestMoney.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  requestMoney;
    }
      
    
    
    
    public  String  getCurrency(){
        return  currency;
    }
    
    public  BigDecimal  getRequestAmount(){
        return  requestAmount;
    }
    
    public  String  getBeneficiaryWallet(){
        return  beneficiaryWallet;
    }
    
    public  String  getSourceWalletNumber(){
        return  sourceWalletNumber;
    }
     
    public  String  getReason(){
        return  reason;
    }
    
      
    
    
    
    
    
    public  void  setCurrency(String  inCurrency){
           currency = inCurrency;
    }
    
    public  void  setRequestAmount(BigDecimal  inRequestAmount){
           requestAmount = inRequestAmount;
    }
    
    public  void  setBeneficiaryWallet(String  inBeneficiaryWallet){
           beneficiaryWallet = inBeneficiaryWallet;
    }
    
    public  void  setSourceWalletNumber(String  inSourceWalletNumber){
           sourceWalletNumber = inSourceWalletNumber;
    }
     
    public  void  setReason(String  inReason){
           reason = inReason;
    }
    
    
    
}
