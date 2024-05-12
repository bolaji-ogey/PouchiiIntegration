/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.loan.services.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CreatePartnerProducts  extends  RequestBase  {
    
    private String   lenderCode  = "";
    private String   productName  = "";
    private String   description  = "";
    private String   shortName  = "";
    private boolean   status  = true;
     
     
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
     
     
     public   final  CreatePartnerProducts  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CreatePartnerProducts   createPartnerProducts  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createPartnerProducts = objectMapper.readValue(inObjectJSON, CreatePartnerProducts.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createPartnerProducts;
    }
     
     
    public  static  CreatePartnerProducts  readFromJSON(String  inObjectJSON){ 
        CreatePartnerProducts  createPartnerProducts  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createPartnerProducts = objectMapper.readValue(inObjectJSON, CreatePartnerProducts.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createPartnerProducts;
    }
     
    
    public  String  getLenderCode(){
        return  lenderCode;
    } 
    
    public  String  getProductName(){
        return  productName;
    }
    
    public  String  getDescription(){
        return  description;
    }
    
    public  String  getShortName(){
        return  shortName;
    }
    
    public  boolean  getStatus(){
        return  status;
    }
    
  
    
    
}
