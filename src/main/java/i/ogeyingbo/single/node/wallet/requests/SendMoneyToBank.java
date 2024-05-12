/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.requests;

  
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class SendMoneyToBank  extends   RequestBase {
          
    private  BigDecimal  trxnAmount = new BigDecimal(0.00);
    private  String  narration = "-";
    private  String  currency = "-";
    private  String  sourceAccount = "-";
    private  String  sourceAccountType = "-";
    private  boolean  saveBeneficiary = true;
     
    private  String  beneficiaryAccount = "-";
    private  String  beneficiaryAccountName = "-";
    private  String  beneficiaryBankCode = "-";  // Bankcode or Wallet
    private  String  beneficiaryAccountType = "Bank";  
  
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
    
    public  void  setSourceAccountType(String  inSourceAccountType){
           sourceAccountType = inSourceAccountType;
    }
    
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
    
    public  void  setBeneficiaryAccountType(String  inBeneficiaryAccountType){
           beneficiaryAccountType = inBeneficiaryAccountType;
    }
    
    
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
