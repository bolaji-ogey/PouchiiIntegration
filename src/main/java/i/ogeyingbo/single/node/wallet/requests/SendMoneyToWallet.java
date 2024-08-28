/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.requests;

  
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
public class SendMoneyToWallet  extends   RequestBase  {
           
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
     
    @NotBlank(message = "Recipient account cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Beneficiary account must be ten (10) digits")
    private  String  recipientAccount = "-";
    
    @NotBlank(message = "Recipient account name cannot be null or empty")
    private  String  recipientAccountName = "-";
    
    @NotBlank(message = "Recipient bank code cannot be null or empty")  
    private  String  recipientBankCode = "-";  // Bankcode or Wallet
    
    @NotBlank(message = "Recipient account type cannot be null or empty")
    private final String  recipientAccountType = "Bank";  
  
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
     
     
    public   final  SendMoneyToWallet  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        SendMoneyToWallet  sendMoneyToWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              sendMoneyToWallet = objectMapper.readValue(inObjectJSON, SendMoneyToWallet.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  sendMoneyToWallet;
    }
    
    
    public  static  SendMoneyToWallet  readFromJSON(String  inObjectJSON){ 
        SendMoneyToWallet  sendMoneyToWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              sendMoneyToWallet = objectMapper.readValue(inObjectJSON, SendMoneyToWallet.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  sendMoneyToWallet;
    }
      
    
    
     
   
    
    public  BigDecimal  getTrxnAmount(){
       return  trxnAmount; 
    }
    
    
    public  String  getNarration(){
        return  narration;
    }
    
    public  String  getCurrency(){
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
     
  
    
    public  String  getRecipientAccount(){
        return  recipientAccount;
    }
    
    public  String  getRecipientAccountName(){
        return  recipientAccountName;
    }
    
    public  String  getRecipientBankCode(){
        return  recipientBankCode;
    }
    
    public  String  getRecipientAccountType(){
        return   recipientAccountType;
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
    ***/
    
    public  void  setSaveBeneficiary(boolean  inSaveBeneficiary){
           saveBeneficiary = inSaveBeneficiary;
    }
      
    
   public  void  setRecipientAccount(String  inRecipientAccount){
           recipientAccount = inRecipientAccount;
    }
    
    public  void  setRecipientAccountName(String  inRecipientAccountName){
           recipientAccountName = inRecipientAccountName;
    }
    
    public  void  setRecipientBankCode(String  inRecipientBankCode){
           recipientBankCode = inRecipientBankCode;
    }
    
    /***
    public  void  setRecipientAccountType(String  inRecipientAccountType){
           recipientAccountType = inRecipientAccountType;
    }
    ***/
    
    
    public  void  setTrxnPin(String  inTrxnPin){
           trxnPin = inTrxnPin;
    }
    
    public  void  setChargeMyBonusWallet(boolean  inChargeMyBonusWallet){
           chargeMyBonusWallet = inChargeMyBonusWallet;
    }
    
    public  void  setAmountChargedFromBonusWallet(BigDecimal  inAmountChargedFromBonusWallet){
           amountChargedFromBonusWallet = inAmountChargedFromBonusWallet;
    }
    
    
    
    
    
    
    public  static  void  main(String[]  args){
         SendMoneyToWallet  sendMoneyToWallet  = new  SendMoneyToWallet();
         System.out.println(sendMoneyToWallet.convertToJSONString());
        
      //  String inputJson = "{\"requestId\":\"H-9371411\",\"requestChannelId\":\"TEST-MERCHANT\",\"requestChannel\":\"API\",\"requestChannelType\":\"Integrator\",\"requestApplicationCode\":\"-\",\"requestApplicationModule\":\"INTEGRATOR\",\"requestPartnerCode\":\"-\",\"customerReference\":\"-\",\"trxnAmount\":0,\"narration\":\"-\",\"currency\":\"NGN\",\"sourceAccount\":\"-\",\"sourceAccountType\":\"-\",\"saveBeneficiary\":true,\"beneficiaryAccount\":\"-\",\"beneficiaryAccountName\":\"-\",\"beneficiaryBankCode\":\"Wallet\",\"beneficiaryAccountType\":\"Wallet\",\"trxnPin\":\"1234\",\"chargeMyBonusWallet\":false,\"amountChargedFromBonusWallet\":0}";
      //  SendMoneyToWallet  sendMoneyToWallet  =  SendMoneyToWallet.readFromJSON(inputJson);
     //   System.out.println(sendMoneyToWallet.convertToJSONString());
    }
     
    
    
}


