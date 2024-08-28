/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.requests;
 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.sql.Connection;
import javax.validation.constraints.Pattern;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ReleaseFundLockRequest  extends   RequestBase  {
    
    
    @NotBlank(message = "Lock transaction request cannot be null or empty")
    private  String  lockTransactionRequest  = "";
    
    @NotBlank(message = "Lock transaction amount cannot be null or empty")
    private  BigDecimal  lockTransactionAmount  =  new BigDecimal(0.00); 
    
     @NotBlank(message = "Request reference cannot be null or empty")
    private  String  requestReference  = "";
    
    @NotBlank(message = "Beneficiary  bank code cannot be null or empty")
    private  String  beneficiaryBankCode;
     
    @NotBlank(message = "Beneficiary account cannot be null or empty")
    private  String  beneficiaryAccount;
    
    @NotBlank(message = "Beneficiary account name cannot be null or empty")
    private  String  beneficiaryAccountName;
    
    
    private  String  narration;
    
    @NotBlank(message = "Currency cannot be null or empty")
    private  String  currency  = "NGN";
    
    @NotBlank(message = "Source account cannot be null or empty")
    private  String  sourceAccount;
    
    @NotBlank(message = "Source account type cannot be null or empty")
    private  String  sourceAccountType;
     
    
     
    
    
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
    
    
    
    public   final  ReleaseFundLockRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ReleaseFundLockRequest  releaseFundLockRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              releaseFundLockRequest = objectMapper.readValue(inObjectJSON, ReleaseFundLockRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  releaseFundLockRequest;
    }
     
     
    
    public  static  ReleaseFundLockRequest  readFromJSON(String  inObjectJSON){ 
        ReleaseFundLockRequest  releaseFundLockRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              releaseFundLockRequest = objectMapper.readValue(inObjectJSON, ReleaseFundLockRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  releaseFundLockRequest;
    }
      
    
    
    
          
    public  void  setLockTransactionRequest(String  inLockTransactionRequest){
        lockTransactionRequest  =  inLockTransactionRequest;
    }
    
    
    public  void  setRequestReference(String  inRequestReference){
        requestReference  =  inRequestReference;
    }
    
    public  void  setLockTransactionAmount(BigDecimal  inLockTransactionAmount){
        lockTransactionAmount  =  inLockTransactionAmount;
    }
    
     
    public  void  setBeneficiaryBankCode(String  inBeneficiaryBankCode){
      beneficiaryBankCode  =  inBeneficiaryBankCode;
    } 
    
    public  void  setBeneficiaryAccount(String  inBeneficiaryAccount){
        beneficiaryAccount  =  inBeneficiaryAccount;
    } 
    
    
    public  void  setBeneficiaryAccountName(String  inBeneficiaryAccountName){
        beneficiaryAccountName  =  inBeneficiaryAccountName;
    } 
    
    
    public  void  setNarration(String  inNarration){
        narration  =  inNarration;
    }
   
    
    public  void  setCurrency(String  inCurrency){
        currency  =  inCurrency;
    }
     
    
    public  void  setSourceAccount(String  inSourceAccount){
        sourceAccount  =  inSourceAccount;
    }
    
     
    public  void  setSourceAccountType(String  inSourceAccountType){
        sourceAccountType  =  inSourceAccountType;
    }
    
    
    
      
    
    
    
    
    
    
    public  String  getLockTransactionRequest(){
        return  lockTransactionRequest;
    }
    
    
     public  String  getRequestReference(){
        return  requestReference;
    }
    
    
    public  BigDecimal  getLockTransactionAmount(){
        return  lockTransactionAmount;
    }
    
     
    public  String  getBeneficiaryBankCode(){
         return  beneficiaryBankCode;
    } 
    
    public  String  getBeneficiaryAccount(){
         return  beneficiaryAccount;
    } 
    
    
    public  String  getBeneficiaryAccountName(){
         return  beneficiaryAccountName;
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
    
    
    
    
}
