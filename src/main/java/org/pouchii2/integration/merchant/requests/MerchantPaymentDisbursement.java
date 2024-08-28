/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.requests;

 
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
public class MerchantPaymentDisbursement  extends  PouchiiMerchRequestBase {
           
    @Positive(message = "Trxn amount must be a positive number")    
    @Digits(integer = 8, fraction = 2, message = "Trxn amount must consist of digit value only")
    private  BigDecimal  disbursementAmount =  new BigDecimal(0.00); 
    
    @NotBlank(message = "Debit urrency cannot be null or empty")
    @Size(min=3,  max=3, message="Debit currency must be three (3) letter code")
    private  String  debitCurrency = "NGN";
    
    @NotBlank(message = "Source account cannot be null or empty")  @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Source account must be ten (10) digits")
    private  String  sourceAccount = "-";
    
    @NotBlank(message = "Source account type cannot be null or empty")
    private  final String  sourceAccountType = "Wallet";
    
    @NotBlank(message = "Transaction reference cannot be null or empty")
    private  String  trxnReference = "-"; 
    
    @NotBlank(message = "Transaction PIN cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Transaction PIN must be four (4) digits")
    private  String  trxnPin = "-"; 
    
    @NotBlank(message = "Beneficiary account cannot be null or empty")  @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Beneficiary account must be ten (10) digits")
    private  String  beneficiaryAccount = "-";
    
    @NotBlank(message = "Beneficiary bank name cannot be null or empty")
    private  String  beneficiaryBankName = "-";
    
    @NotBlank(message = "Beneficiary bank code cannot be null or empty")   @Pattern(regexp="[0-9]")
    @Size(min=3,  max=5, message="Beneficiary bank code must be either three (3) or five (5) digits")
    private  String  beneficiaryBankCode = "-";
    
    @NotBlank(message = "Beneficiary account type cannot be null or empty")
    private  String  beneficiaryAccountType = "Wallet"; 
    
    private  String  narration = "-"; 
    private  boolean  saveBeneficiary = false;      
    
    
    
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
     
     
     public   final  MerchantPaymentDisbursement  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        MerchantPaymentDisbursement   merchPaymentDisbursement  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchPaymentDisbursement = objectMapper.readValue(inObjectJSON, MerchantPaymentDisbursement.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchPaymentDisbursement;
    }
     
     
    public  static final MerchantPaymentDisbursement  readFromJSON(String  inObjectJSON){ 
        MerchantPaymentDisbursement  merchantPaymentDisbursement  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchantPaymentDisbursement = objectMapper.readValue(inObjectJSON, MerchantPaymentDisbursement.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchantPaymentDisbursement;
    }
      
    
    
                                
    public  void  setDisbursementAmount(BigDecimal  inDisbursementAmount){
           disbursementAmount = inDisbursementAmount;
    }
    
    public  void  setDebitCurrency(String  inDebitCurrency){
          debitCurrency = inDebitCurrency; 
    }
    
    public  void  setSourceAccount(String  inSourceAccount){
           sourceAccount = inSourceAccount;
    }
    
    
    
    public  void  setTrxnReference(String  inTrxnReference){
           trxnReference = inTrxnReference;
    }
    
    public  void  setTrxnPin(String  inTrxnPin){
           trxnPin = inTrxnPin;
    }
    
     public  void  setBeneficiaryAccount(String  inBeneficiaryAccount){
           beneficiaryAccount = inBeneficiaryAccount;
    }
    
    public  void  setBeneficiaryBankName(String  inBeneficiaryBankName){
           beneficiaryBankName = inBeneficiaryBankName;
    }
    
    public  void  setBeneficiaryBankCode(String  inBeneficiaryBankCode){
           beneficiaryBankCode = inBeneficiaryBankCode;
    }
    
    public  void  setBeneficiaryAccountType(String  inBeneficiaryAccountType){
           beneficiaryAccountType = inBeneficiaryAccountType;
    }
    
    
    public  void  setNarration(String  inNarration){
           narration = inNarration;
    }
    
     
    public  void  setSaveBeneficiary(boolean  inSaveBeneficiary){
           saveBeneficiary = inSaveBeneficiary;
    }
     
  
    
    
    
    
    public  BigDecimal  getDisbursementAmount(){
        return  disbursementAmount;
    }
    
    public  String  getDebitCurrency(){
       return  debitCurrency; 
    }
    
    public  String  getSourceAccount(){
        return  sourceAccount;
    }
    
    public  String  getSourceAccountType(){
        return  sourceAccountType;
    }
    
    public  String  getTrxnReference(){
        return  trxnReference;
    }
    
    public  String  getTrxnPin(){
        return  trxnPin;
    }
    
     public  String  getBeneficiaryAccount(){
        return  beneficiaryAccount;
    }
    
    public  String  getBeneficiaryBankName(){
        return  beneficiaryBankName;
    }
    
    public  String  getBeneficiaryBankCode(){
        return  beneficiaryBankCode;
    }
    
    public  String  getBeneficiaryAccountType(){
        return  beneficiaryAccountType;
    }
    
    
    public  String  getNarration(){
        return  narration;
    }
    
     
    public  boolean  getSaveBeneficiary(){
        return  saveBeneficiary;
    }
    
    
    
    
}
