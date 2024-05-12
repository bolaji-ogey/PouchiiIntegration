/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ViewMyWalletQRCode    extends  PouchiiRequestBase  {
     
    private  String  walletNumber = "-";
    
    private  String   url  = "/walletservice/rest/api/view/wallet/grcode/{WALLET_NUMBER}";
    
    public  String  getUrl(){
        return url;
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
    
    
    
    public   final  ViewMyWalletQRCode  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ViewMyWalletQRCode  viewMyWalletQRCode  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              viewMyWalletQRCode = objectMapper.readValue(inObjectJSON, ViewMyWalletQRCode.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  viewMyWalletQRCode;
    }
     
     
    
    public  static  ViewMyWalletQRCode  readFromJSON(String  inObjectJSON){ 
        ViewMyWalletQRCode  viewMyWalletQRCode  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              viewMyWalletQRCode = objectMapper.readValue(inObjectJSON, ViewMyWalletQRCode.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  viewMyWalletQRCode;
    }
      
    
     
   
    public String  getWalletNumber(){
        return   walletNumber;
    }
    
    
    public void  setWalletNumber(String   inWalletNumber){
         walletNumber = inWalletNumber;
         url = url.replace("{WALLET_NUMBER}", walletNumber);
    }
    
    
}
