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
public class FetchReqMoneyNotifications    extends   RequestBase  {
      
    private  int  page = 0; 
    private  int  lastRecord = 0; 
    private  int  pageSize = 30; 
     
    
    
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
     
     
     
     public   final  FetchReqMoneyNotifications  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        FetchReqMoneyNotifications   fetchReqMoneyNotifications  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              fetchReqMoneyNotifications = objectMapper.readValue(inObjectJSON, FetchReqMoneyNotifications.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  fetchReqMoneyNotifications;
    }
     
     
    public  static  FetchReqMoneyNotifications  readFromJSON(String  inObjectJSON){ 
        FetchReqMoneyNotifications  fetchReqMoneyNotifications  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              fetchReqMoneyNotifications = objectMapper.readValue(inObjectJSON, FetchReqMoneyNotifications.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  fetchReqMoneyNotifications;
    }
      
    
     
        
    public  int  getPage(){
        return  page;
    }
    
    public  int  getLastRecord(){
        return  lastRecord;
    }
    
    public  int  getPageSize(){
        return  pageSize;
    } 
    
    
    
    
    public  void  setPage(int  inPage){
           page = inPage;
    }
    
    public  void  setLastRecord(int  inLastRecord){
           lastRecord = inLastRecord;
    }
    
    public  void  setPageSize(int  inPageSize){
           pageSize = inPageSize;
    }
    
    
    
    
}
