/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.merchant.requests.backup;
 
  
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
public class MerchantFundTransfer    extends  MerchantRequestBase  {
         
    private  BigDecimal  trxnAmount =  new BigDecimal(0.00); 
    private  String  narration = "-";
    private  String  trxnReference = "-";
    private  String  debitCurrency = "NGN";
    private  String  sourceAccount = "-";
    private  final String  sourceAccountType = "Wallet";
    private  boolean  saveBeneficiary = true;
    private  String  creditCurrency = "NGN";
    private  String  beneficiaryAccount = "-";
    private  String  beneficiaryBankName = "-";
    private  String  beneficiaryBankCode = "-";
    private  String  beneficiaryAccountType = "Wallet";
    private  String  trxnPin = "-";
    private  boolean  chargeMyBonusWallet = false;
    private  BigDecimal  amountChargedFromBonusWallet =  new BigDecimal(0.00); 
     
    
    
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
     
     
     public   final  MerchantFundTransfer  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        MerchantFundTransfer   merchantFundTransfer  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchantFundTransfer = objectMapper.readValue(inObjectJSON, MerchantFundTransfer.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchantFundTransfer;
    }
     
     
    public  static final MerchantFundTransfer  readFromJSON(String  inObjectJSON){ 
        MerchantFundTransfer  merchantFundTransfer  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchantFundTransfer = objectMapper.readValue(inObjectJSON, MerchantFundTransfer.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchantFundTransfer;
    }
      
    
    
    
    
    
    
    public  void  setTrxnAmount(BigDecimal  inTrxnAmount){
           trxnAmount = inTrxnAmount;
    }
    
    
    public  void  setNarration(String  inNarration){
           narration = inNarration;
    }
    
    
    public  void  setTrxnReference(String  inTrxnReference){
           trxnReference = inTrxnReference;
    }
    
    
    public  void  setDebitCurrency(String  inDebitCurrency){
           debitCurrency = inDebitCurrency;
    }
    
    
    public  void  setSourceAccount(String  inSourceAccount){
           sourceAccount = inSourceAccount;
    }
    
     
    
    public  void  setSaveBeneficiary(boolean  inSaveBeneficiary){
           saveBeneficiary = inSaveBeneficiary;
    }
    
      
    public  void  setCreditCurrency(String  inCreditCurrency){
           creditCurrency = inCreditCurrency;
    }
    
    public  void  setBeneficiaryAccount(String  inBeneficiaryAccount){
           beneficiaryAccount = inBeneficiaryAccount                                       ;
    }
    
    public  void  setBeneficiaryBankName(String  inBeneficiaryBankName){
           beneficiaryBankName =  inBeneficiaryBankName;
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
    
    
    
    
    
    
  
    
    
    public  BigDecimal  getTrxnAmount(){
        return  trxnAmount;
    }
    
    
    public  String  getNarration(){
        return  narration;
    }
    
    
    public  String  getTrxnReference(){
        return  trxnReference;
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
    
    public  boolean  getSaveBeneficiary(){
        return  saveBeneficiary;
    }
    
      
    public  String  getCreditCurrency(){
        return  creditCurrency;
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
    
    
    public  String  getTrxnPin(){
        return  trxnPin;
    }
    
    
    public  boolean  getChargeMyBonusWallet(){
        return  chargeMyBonusWallet;
    }
    
    public  BigDecimal  getAmountChargedFromBonusWallet(){
        return  amountChargedFromBonusWallet;
    }
    
    
    
    
}
