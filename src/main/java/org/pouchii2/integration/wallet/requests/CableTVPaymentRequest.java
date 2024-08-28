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
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CableTVPaymentRequest   extends  PouchiiRequestBase  {
             
    @Positive(message = "Wallet ID must be a positive number")    
    @Digits(integer = 8, fraction = 0, message = "Wallet ID must consist of digit value only")
    private  long  walletId = -1;
    
   //  @Size(min=11,  max=11, message="Customer ID must be Eleven (11) digits")
    @NotBlank(message = "Customer ID cannot be null or empty") @Pattern(regexp="[0-9]")   
    private  String  customerId = "09159187488";
     
    @NotBlank(message = "Biller name cannot be null or empty")
    private  String  billerName = "Integrator";
    
    @NotBlank(message = "Biller code cannot be null or empty")
    private  String  billerCode = "-";
    
    @Positive(message = "Biller ID must be a positive number")    
    @Digits(integer = 3, fraction = 0, message = "Biller ID must consist of digit value only")
    private  long     billerId = 16;
    
    @Positive(message = "Payment amount must be a positive number")    
    @Digits(integer = 8, fraction = 2, message = "Payment amount must consist of digit value only")
    private  BigDecimal  paymentAmount = new BigDecimal(0.00); 
    
    private  boolean  paymentWithBonus = false;
    private  BigDecimal  payWithBonusAmount = new BigDecimal(0.00);
     
    @NotBlank(message = "Currency cannot be null or empty")
    @Size(min=3,  max=3, message="Currency must be three (3) letter code")
    private  String  currency = "NGN";
    
    @NotBlank(message = "Transaction PIN cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Transaction PIN must be four (4) digits")
    private  String  trxnPin = "1234"; 
    private  boolean  saveBeneficiary = true;
    private  String  saveBeneficiaryName = "";
    
    @NotBlank(message = "Transaction reference cannot be null or empty")
    private  String  trxnReference = "";
    
    @NotBlank(message = "Payment code cannot be null or empty")
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
