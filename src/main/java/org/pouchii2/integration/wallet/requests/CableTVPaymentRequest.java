/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
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
public class CableTVPaymentRequest   extends  PouchiiRequestBase  {
             
    private  long  walletId = -1;
    private  String  customerId = "09159187488";
    private  String  billerName = "Integrator";
    private  String  billerCode = "-";
    private  long     billerId = 16;
    private  BigDecimal  paymentAmount = new BigDecimal(0.00); 
    
    private  boolean  paymentWithBonus = false;
     private  BigDecimal  payWithBonusAmount = new BigDecimal(0.00); 
    private  String  currency = "NGN";
    private  String  trxnPin = "1234"; 
    private  boolean  saveBeneficiary = true;
    private  String  saveBeneficiaryName = "";
    private  String  trxnReference = "";
    
    private  String  paymentCode = "";
    
     
            
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
     
     
     public   final  CableTVPaymentRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CableTVPaymentRequest   cableTVPaymentRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              cableTVPaymentRequest = objectMapper.readValue(inObjectJSON, CableTVPaymentRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  cableTVPaymentRequest;
    }
     
     
     
     
    public  static  CableTVPaymentRequest  readFromJSON(String  inObjectJSON){ 
        CableTVPaymentRequest  cableTVPaymentRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              cableTVPaymentRequest = objectMapper.readValue(inObjectJSON, CableTVPaymentRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  cableTVPaymentRequest;
    }
      
   
    
    
    
    public  long  getWalletId(){
        return  walletId;
    }
    
    public  String  getCustomerId(){
        return  customerId;
    }
    
    public  String  getBillerName(){
        return  billerName;
    }
    
    public  String  getBillerCode(){
        return  billerCode;
    }
    
    public  long  getBillerId(){
        return  billerId;
    }
    
    public  BigDecimal  getPaymentAmount(){
        return  paymentAmount;
    }
    
    public  boolean  getPaymentWithBonus(){
        return  paymentWithBonus;
    }
    
    public  BigDecimal  getPayWithBonusAmount(){
        return  payWithBonusAmount;
    }
   
    public  String  getCurrency(){
        return  currency;
    }
    
    public  String  getTrxnPin(){
        return  trxnPin;
    }
    
    public  boolean  getSaveBeneficiary(){
        return  saveBeneficiary;
    }
    
    public  String  getSaveBeneficiaryName(){
        return  saveBeneficiaryName;
    }
    
    public  String  getTrxnReference(){
        return  trxnReference;
    }
    
    
    public  String  getPaymentCode(){
        return  paymentCode;
    }
    
    
    
    
    
    
    
    
     
    public  void  setWalletId(long  inWalletId){
           walletId = inWalletId;
    }
    
    public  void  setCustomerId(String  inCustomerId){
           customerId = inCustomerId;
    }
    
    public  void  setBillerName(String  inBillerName){
           billerName = inBillerName;
    }
    
    public  void  setBillerCode(String  inBillerCode){
           billerCode = inBillerCode;
    }
    
    public  void  setBillerId(long  inBillerId){
           billerId = inBillerId;
    }
    
    public  void  setPaymentAmount(BigDecimal  inPaymentAmount){
           paymentAmount = inPaymentAmount;
    }
    
    public  void  setPaymentWithBonus(boolean  inPaymentWithBonus){
           paymentWithBonus = inPaymentWithBonus;
    }
    
    public  void  setPayWithBonusAmount(BigDecimal  inPayWithBonusAmount){
           payWithBonusAmount = inPayWithBonusAmount;
    }
   
    public  void  setCurrency(String  inCurrency){
           currency = inCurrency;
    }
    
    public  void  setTrxnPin(String  inTrxnPin){
           trxnPin = inTrxnPin;
    }
    
    public  void  setSaveBeneficiary(boolean  inSaveBeneficiary){
           saveBeneficiary = inSaveBeneficiary;
    }
    
    public  void  setSaveBeneficiaryName(String  inSaveBeneficiaryName){
           saveBeneficiaryName = inSaveBeneficiaryName;
    }
    
    public  void  setTrxnReference(String  inTrxnReference){
           trxnReference = inTrxnReference;
    }
    
    
    public  void  setPaymentCode(String  inPaymentCode){
           paymentCode = inPaymentCode;
    }
    
    
    
}
