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
public class MerchantPaymentDisbursement   extends  MerchantRequestBase {
           
    private  BigDecimal  disbursementAmount =  new BigDecimal(0.00); 
    private  String  debitCurrency = "NGN";
    private  String  sourceAccount = "-";
    private final  String  sourceAccountType = "Wallet";
    private  String  trxnReference = "-"; 
    private  String  trxnPin = "-"; 
    private  String  beneficiaryAccount = "-";
    private  String  beneficiaryBankName = "-";
    private  String  beneficiaryBankCode = "-";
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
