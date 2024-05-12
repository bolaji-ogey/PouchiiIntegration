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
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class SendMoneyToWallet  extends   RequestBase  {
           
    private  BigDecimal  trxnAmount = new BigDecimal(0.00);
    private  String  narration ="-";
    private  String  currency = "-";
    private  String  sourceAccount = "-";
    private  String  sourceAccountType = "-";
    private  boolean  saveBeneficiary = true;
     
    private  String  beneficiaryAccount = "-";
    private  String  beneficiaryAccountName = "-";
    private  String  beneficiaryBankCode = "-";  // Bankcode or Wallet
    private  String  beneficiaryAccountType = "Wallet";  
  
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
    
    
    
    
    
    
    public  static  void  main(String[]  args){
         SendMoneyToWallet  sendMoneyToWallet  = new  SendMoneyToWallet();
         System.out.println(sendMoneyToWallet.convertToJSONString());
        
      //  String inputJson = "{\"requestId\":\"H-9371411\",\"requestChannelId\":\"TEST-MERCHANT\",\"requestChannel\":\"API\",\"requestChannelType\":\"Integrator\",\"requestApplicationCode\":\"-\",\"requestApplicationModule\":\"INTEGRATOR\",\"requestPartnerCode\":\"-\",\"customerReference\":\"-\",\"trxnAmount\":0,\"narration\":\"-\",\"currency\":\"NGN\",\"sourceAccount\":\"-\",\"sourceAccountType\":\"-\",\"saveBeneficiary\":true,\"beneficiaryAccount\":\"-\",\"beneficiaryAccountName\":\"-\",\"beneficiaryBankCode\":\"Wallet\",\"beneficiaryAccountType\":\"Wallet\",\"trxnPin\":\"1234\",\"chargeMyBonusWallet\":false,\"amountChargedFromBonusWallet\":0}";
      //  SendMoneyToWallet  sendMoneyToWallet  =  SendMoneyToWallet.readFromJSON(inputJson);
     //   System.out.println(sendMoneyToWallet.convertToJSONString());
    }
     
    
    
}


