/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.integration.newpartner.setup.requests;
 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class InitializePartnerWallet extends  AdminRequestBase {
    
    private  final  String  schemeId  = "d2423272-dc1b-4c7b-b774-6fac86e8085d";
    private  final  String  currency  = "NGN";
    private       long  partnerId = 60;
    private  final  long  applicationId = 1;
    
    
    public  InitializePartnerWallet(){
        setRequestChannelId("123456770"); 
    }
      
      
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
     
    
    
     public   final  InitializePartnerWallet  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        InitializePartnerWallet   initializePartnerWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              initializePartnerWallet = objectMapper.readValue(inObjectJSON, InitializePartnerWallet.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  initializePartnerWallet;
    }
     
    
    public  static  InitializePartnerWallet  readFromJSON(String  inObjectJSON){ 
        InitializePartnerWallet  initializePartnerWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              initializePartnerWallet = objectMapper.readValue(inObjectJSON, InitializePartnerWallet.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  initializePartnerWallet;
    }
      
  
    
    
    
    public String  getSchemeId(){
        return  schemeId;
    }
    
    public String  getCurrency(){
        return  currency;
    }
    
    public long  getPartnerId(){
        return  partnerId;
    }
    
    public long  getAapplicationId(){
        return  applicationId;
    }
     
    
    
    
    public void  setPartnerId(long  inPartnerId){
           partnerId = inPartnerId;
    }
}
