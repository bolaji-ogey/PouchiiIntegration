/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.requests;

  
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AcceptOrRejectRequestMoney    extends  RequestBase  {
      
    private  long  requestMoneyId = -1; 
    private  boolean  requestMoneyStatus = true; 
    private  boolean  cancelRequest = false; 
    
    @NotBlank(message = "Reason cannot be null or empty")
    private  String  reason = "-";
    
    @NotBlank(message = "Transaction PIN cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Transaction PIN must be four (4) digits")
    private  String  trxnPin = "-";  
    
       
    
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
     
     
     public   final  AcceptOrRejectRequestMoney  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        AcceptOrRejectRequestMoney   acceptOrRejectRequestMoney  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              acceptOrRejectRequestMoney = objectMapper.readValue(inObjectJSON, AcceptOrRejectRequestMoney.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  acceptOrRejectRequestMoney;
    }
     
     
     
    public  static  AcceptOrRejectRequestMoney  readFromJSON(String  inObjectJSON){ 
        AcceptOrRejectRequestMoney  acceptOrRejectRequestMoney  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              acceptOrRejectRequestMoney = objectMapper.readValue(inObjectJSON, AcceptOrRejectRequestMoney.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  acceptOrRejectRequestMoney;
    }
      
    
     
  
    
    public  long  getRequestMoneyId(){
        return  requestMoneyId;
    }
    
    public  boolean  getRequestMoneyStatus(){
        return  requestMoneyStatus;
    }
    
    public  boolean  getCancelRequest(){
        return  cancelRequest;
    }
    
    public  String  getReason(){
        return  reason;
    }
    
    public  String  getTrxnPin(){
        return  trxnPin;
    }
    
    
    
    
    
    public  void  setRequestMoneyId(long  inRequestMoneyId){
           requestMoneyId = inRequestMoneyId;
    }
    
    public  void  setRequestMoneyStatus(boolean  inRequestMoneyStatus){
           requestMoneyStatus = inRequestMoneyStatus;
    }
    
    public  void  setCancelRequest(boolean  inCancelRequest){
           cancelRequest = inCancelRequest;
    }
    
    public  void  setReason(String  inReason){
           reason = inReason;
    }
    
    public  void  setTrxnPin(String  inTrxnPin){
           trxnPin = inTrxnPin;
    }
    
    
    
}
