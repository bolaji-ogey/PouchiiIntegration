/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.requests;

 
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
public class MerchantPaymentInstruction  extends  PouchiiMerchRequestBase {
    
    private  String  customerReference = "-";                                                                                                                                                 
    private  String  beneficiaryAccountName = "-";
    private  String  beneficiaryAccountNumber = "_";
    private  String  beneficiaryBankCode = "_";
    private  String  narration = "-";
    private  String  trxnRequestReference = "_";
    
    private  String  creditCurrency = "NGN"; 
    private  String  trxnAmount = "0.00";
     
   
     
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
     
     
     public   final  MerchantPaymentInstruction  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        MerchantPaymentInstruction   merchPaymentInstruction  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchPaymentInstruction = objectMapper.readValue(inObjectJSON, MerchantPaymentInstruction.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchPaymentInstruction;
    }
     
     
    public  static  MerchantPaymentInstruction  readFromJSON(String  inObjectJSON){ 
        MerchantPaymentInstruction  merchantPaymentInstruction  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchantPaymentInstruction = objectMapper.readValue(inObjectJSON, MerchantPaymentInstruction.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchantPaymentInstruction;
    }
       
    
    
    public  void  setCustomerReference(String  inCustomerReference){
          customerReference = inCustomerReference; 
    }
    
    
    public  void  setBeneficiaryAccountName(String  inBeneficiaryAccountName){
           beneficiaryAccountName = inBeneficiaryAccountName;
    }
    
    public  void  setBeneficiaryAccountNumber(String  inBeneficiaryAccountNumber){
          beneficiaryAccountNumber = inBeneficiaryAccountNumber; 
    }
     
    public  void  setBeneficiaryBankCode(String  inBeneficiaryBankCode){
           beneficiaryBankCode = inBeneficiaryBankCode;
    }
    
    public  void  setNarration(String  inNarration){
           narration = inNarration;
    }
    
    public  void  setTrxnRequestReference(String  inTrxnRequestReference){
           trxnRequestReference = inTrxnRequestReference;
    }
    
    
     
    public  void  setTrxnAmount(String  inTrxnAmount){
           trxnAmount = inTrxnAmount;
    }
    
    
    
    
    
    
    
    
     public  String  getCustomerReference(){
       return  customerReference; 
    }
    
    
    public  String  getBeneficiaryAccountName(){
        return  beneficiaryAccountName;
    }
    
    public  String  getBeneficiaryAccountNumber(){
       return  beneficiaryAccountNumber; 
    }
     
    public  String  getBeneficiaryBankCode(){
        return  beneficiaryBankCode;
    }
    
    public  String  getNarration(){
        return  narration;
    }
    
    public  String  getTrxnRequestReference(){
        return  trxnRequestReference;
    }
    
    
    
    public  String  getTrxnAmount(){
        return  trxnAmount;
    }
    
    
}
