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
public class SendMoneyToBank  extends  PouchiiRequestBase {
          
    @Positive(message = "Trxn amount must be a positive number")    
    @Digits(integer = 8, fraction = 2, message = "Trxn amount must consist of digit value only")
    private  BigDecimal  trxnAmount = new BigDecimal(0.00);
    
    private  String  narration = "-";
    
    @NotBlank(message = "Currency cannot be null or empty")
    @Size(min=3,  max=3, message="Currency must be three (3) letter code")
    private  String  currency = "NGN";
    
    @NotBlank(message = "Source account cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Source account must be ten (10) digits")
    private  String  sourceAccount = "-";
    
    @NotBlank(message = "Source account type cannot be null or empty")
    private  final String  sourceAccountType = "Wallet";
    
    private  boolean  saveBeneficiary = true;
     
    @NotBlank(message = "Beneficiary account cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Beneficiary account must be ten (10) digits")
    private  String  beneficiaryAccount = "-";
    
    @NotBlank(message = "Beneficiary account name cannot be null or empty")
    private  String  beneficiaryAccountName = "-";
    
    @NotBlank(message = "Beneficiary bank code cannot be null or empty")   @Pattern(regexp="[0-9]")
    @Size(min=3,  max=5, message="Beneficiary bank code must be either three (3) or five (5) digits")
    private  String  beneficiaryBankCode = "-";  // Bankcode or Wallet
    
    @NotBlank(message = "Beneficiary account type cannot be null or empty")
    private final String  beneficiaryAccountType = "Bank";  
  
    @NotBlank(message = "Transaction PIN cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Transaction PIN must be four (4) digits")
    private  String  trxnPin = "1234";  
    
    private  boolean  chargeMyBonusWallet = false;  
    private  BigDecimal  amountChargedFromBonusWallet = new BigDecimal(0.00); 
     
    
    
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
     
     
    
    
   public   final  SendMoneyToBank  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        SendMoneyToBank   sendMoneyToBank  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              sendMoneyToBank = objectMapper.readValue(inObjectJSON, SendMoneyToBank.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  sendMoneyToBank;
    }
        
        
        
        
    
    public  static  SendMoneyToBank  readFromJSON(String  inObjectJSON){ 
        SendMoneyToBank  sendMoneyToBank  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              sendMoneyToBank = objectMapper.readValue(inObjectJSON, SendMoneyToBank.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  sendMoneyToBank;
    }
      
    
  
    
   
    
    public  BigDecimal  getTrxnAmount(){
       return  trxnAmount; 
    }
    
    
    public  String  getNarration(){
        return  narration;
    }
    
    public  String  getCurrrency(){
       return  currency; 
    }
    
    public  String  getSourceAccount(){
        return  sourceAccount;
    }
    
    public  String  getSourceAccountType(){
        return  sourceAccountType;
    }
    
    public  boolean  getSaveBeneficiary(){
        return  saveBeneficiary;
    }
     
  
    
    public  String  getBeneficiaryAccount(){
        return  beneficiaryAccount;
    }
    
    public  String  getBeneficiaryAccountName(){
        return  beneficiaryAccountName;
    }
    
    public  String  getBeneficiaryBankCode(){
        return  beneficiaryBankCode;
    }
    
    public  String  getBeneficiaryAccountType(){
        return  beneficiaryAccountType;
    }
    
    
    public  String  getTrxnPin(){
        return  trxnPin;
    }
    
    public  boolean  getChargeMyBonusWallet(){
        return  chargeMyBonusWallet;
    }
    
    public  BigDecimal  getAmountChargedFromBonusWallet(){
        return  amountChargedFromBonusWallet;
    }
    
     
    
    
    
    
     
    
    public  void  setTrxnAmount(BigDecimal  inTrxnAmount){
          trxnAmount = inTrxnAmount; 
    }
    
    
    public  void  setNarration(String  inNarration){
           narration = inNarration;
    }
    
    public  void  setCurrrency(String  inCurrrency){
          currency = inCurrrency; 
    }
    
    public  void  setSourceAccount(String  inSourceAccount){
           sourceAccount = inSourceAccount;
    }
    
    /***
    public  void  setSourceAccountType(String  inSourceAccountType){
           sourceAccountType = inSourceAccountType;
    }
    ****/
    
    public  void  setSaveBeneficiary(boolean  inSaveBeneficiary){
           saveBeneficiary = inSaveBeneficiary;
    }
      
    
    public  void  setBeneficiaryAccount(String  inBeneficiaryAccount){
           beneficiaryAccount = inBeneficiaryAccount;
    }
    
    public  void  setBeneficiaryAccountName(String  inBeneficiaryAccountName){
           beneficiaryAccountName = inBeneficiaryAccountName;
    }
    
    public  void  setBeneficiaryBankCode(String  inBeneficiaryBankCode){
           beneficiaryBankCode = inBeneficiaryBankCode;
    }
    
    /***
    public  void  setBeneficiaryAccountType(String  inBeneficiaryAccountType){
           beneficiaryAccountType = inBeneficiaryAccountType;
    }
    **/
    
    public  void  setTrxnPin(String  inTrxnPin){
           trxnPin = inTrxnPin;
    }
    
    public  void  setChargeMyBonusWallet(boolean  inChargeMyBonusWallet){
           chargeMyBonusWallet = inChargeMyBonusWallet;
    }
    
    public  void  setAmountChargedFromBonusWallet(BigDecimal  inAmountChargedFromBonusWallet){
           amountChargedFromBonusWallet = inAmountChargedFromBonusWallet;
    }
    
    
    
}
