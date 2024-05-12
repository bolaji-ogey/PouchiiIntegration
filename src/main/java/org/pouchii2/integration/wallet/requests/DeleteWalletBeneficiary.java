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
public class DeleteWalletBeneficiary    extends  PouchiiRequestBase   {
      
    private  int[]  beneficiaryList = null; 
     
    
    
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
     
    
    
     public   final  DeleteWalletBeneficiary  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        DeleteWalletBeneficiary   deleteWalletBeneficiary  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              deleteWalletBeneficiary = objectMapper.readValue(inObjectJSON, DeleteWalletBeneficiary.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  deleteWalletBeneficiary;
    }
     
     
    
    public  static  DeleteWalletBeneficiary  readFromJSON(String  inObjectJSON){ 
        DeleteWalletBeneficiary  deleteWalletBeneficiary  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              deleteWalletBeneficiary = objectMapper.readValue(inObjectJSON, DeleteWalletBeneficiary.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  deleteWalletBeneficiary;
    }
      
     
    
    
    public  int[]  getBeneficiaryList(){
        return  beneficiaryList;
    }
    
    
    public  void  setBeneficiaryList(int[]  inBeneficiaryList){
           beneficiaryList = inBeneficiaryList;
    }
    
    
    
    
}

