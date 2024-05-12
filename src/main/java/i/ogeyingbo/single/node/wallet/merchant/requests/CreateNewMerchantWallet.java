/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.merchant.requests;
 
  
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CreateNewMerchantWallet   extends  MerchantRequestBase   {
         
    private  String  walletName = "-";
    private  boolean  createNubanAccount = true;
    private  String  currency = "NGN";
     
    
    
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
     
     
    public   final  CreateNewMerchantWallet  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CreateNewMerchantWallet   createNewMerchantWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createNewMerchantWallet = objectMapper.readValue(inObjectJSON, CreateNewMerchantWallet.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createNewMerchantWallet;
    }
     
     
     
    public  static  CreateNewMerchantWallet  readFromJSON(String  inObjectJSON){ 
        CreateNewMerchantWallet  createNewMerchantWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createNewMerchantWallet = objectMapper.readValue(inObjectJSON, CreateNewMerchantWallet.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createNewMerchantWallet;
    }
      
    
    
     public  void  setWalletName(String  inWalletName){
            walletName = inWalletName;
    }
    
    
    public  void  setCreateNubanAccount(boolean  inCreateNubanAccount){
            createNubanAccount = inCreateNubanAccount;
    }
    
    
    public  void  setCurrency(String  inCurrency){
            currency = inCurrency;
    }
    
    
    
    
    
    public  String  getWalletName(){
        return   walletName;
    }
    
    
    public  boolean  getCreateNubanAccount(){
        return   createNubanAccount;
    }
    
    
    public  String  getCurrency(){
        return   currency;
    }
    
    
    
    
    
    
    
    
}
