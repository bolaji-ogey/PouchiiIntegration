/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class WalletKYCListRequest extends RequestBase {
    
    
    
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
    
    
    
    public   final  WalletKYCListRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        WalletKYCListRequest  walletKYCListRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              walletKYCListRequest = objectMapper.readValue(inObjectJSON, WalletKYCListRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  walletKYCListRequest;
    }
     
     
    
    public  static  WalletKYCListRequest  readFromJSON(String  inObjectJSON){ 
        WalletKYCListRequest  walletKYCListRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              walletKYCListRequest = objectMapper.readValue(inObjectJSON, WalletKYCListRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  walletKYCListRequest;
    }
      
    
}
