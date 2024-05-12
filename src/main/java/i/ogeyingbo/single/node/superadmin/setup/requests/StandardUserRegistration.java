/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.superadmin.setup.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class StandardUserRegistration extends  AdminRequestBase {
    
    private  String  firstName = "";
    private  String  lastName = "";
    private  String  middleName = "";
    private  String  emailAddress = "";
    private  String  verificationEvent = "";
    private  String  mobileNumber = "";
    private  String  customIdentifier = "";
    private  String  password = "";
    private  Long[]  assignedRoles = new Long[1];
    private  boolean  enabledTwoFa = false;
    private  boolean  verified = true;
     
     
     
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
     
    
    
     public   final  StandardUserRegistration  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        StandardUserRegistration   standardUserRegistration  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              standardUserRegistration = objectMapper.readValue(inObjectJSON, StandardUserRegistration.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  standardUserRegistration;
    }
     
    
    public  static  StandardUserRegistration  readFromJSON(String  inObjectJSON){ 
        StandardUserRegistration  standardUserRegistration  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              standardUserRegistration = objectMapper.readValue(inObjectJSON, StandardUserRegistration.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  standardUserRegistration;
    }
      
  
    
    
    public  String  getFirstName(){
        return  firstName;
    }
    
    public  String  getLastName(){
        return  lastName;
    }
    
    public  String  getMiddleName(){
        return  middleName;
    }
    
    public  String  getEmailAddress(){
        return  emailAddress;
    }
    
     
    
    public  String  getVerificationEvent(){
        return  verificationEvent;
    }
    
    
    public  String  getMobileNumber(){
        return  mobileNumber;
    }
    
    
    public  String  getCustomIdentifier(){
        return  customIdentifier;
    }
    
    public  String  getPassword(){
        return  password;
    }
    
    public  Long[]  getAssignedRoles(){
        return  assignedRoles;
    }
    
    public  boolean  getEnabledTwoFa(){
        return  enabledTwoFa;
    }
    
    public  boolean  getVerified(){
        return  verified;
    }
     
                     
    
    public  void setFirstName(String  inFirstName){
        firstName  = inFirstName;
    }
    
    public  void setLastName(String  inLastName){
        lastName  = inLastName;
    }
    
    public  void setMiddleName(String  inMiddleName){
        middleName  = inMiddleName;
    }
    
    public  void setEmailAddress(String  inEmailAddress){
        emailAddress  = inEmailAddress;
    }
    
    public  void setVerificationEvent(String  inVerificationEvent){
        verificationEvent  = inVerificationEvent;
    }
    
    public  void setMobileNumber(String  inMobileNumber){
        mobileNumber  = inMobileNumber;
    }
    
    public  void setCustomIdentifier(String  inCustomIdentifier){
        customIdentifier  = inCustomIdentifier;
    }
    
    public  void  setPassword(String  inPassword){
        password  = inPassword;
    }
              
  
    public  void  setAssignedRoles(long  inAssignedRole){
        assignedRoles[0]  = inAssignedRole;
    }
  
    
}
