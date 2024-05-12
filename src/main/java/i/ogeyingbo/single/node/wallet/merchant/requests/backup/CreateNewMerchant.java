/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.merchant.requests.backup;

  
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CreateNewMerchant  extends  MerchantRequestBase  {
         
    private  String  partnerName = "-";
    private  String  partnerCode = "-";
    private  String  gender = "-";
    private  String  businessName = "-";
    private  String  businessShortName = "-";
    private  String  rcNumber = "-";
    private  String  businessType = "-";
    private  String  businessDescription = "-";
    private  String  address = "-";
    private  String  firstName = "-";
    private  String  lastName = "-";
    private  String  bvn = "-";
    
    private  String  dateOfBirth = "1993-10-22";
    private  int  state =  1;
    private  int  country =  1;
    private  String  emailAddress = "-";
    private  String  contactPhoneNumber = "-";
    private  String  avatar = "-";
    private  boolean  verified =  true;
    private  boolean  generateMerchantSecurity = true;
    private  boolean  enabledTwoFA = false;
    
       
    
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
     
     
     public   final  CreateNewMerchant  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CreateNewMerchant   createNewMerchant  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createNewMerchant = objectMapper.readValue(inObjectJSON, CreateNewMerchant.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createNewMerchant;
    }
     
     
    public  static  CreateNewMerchant  readFromJSON(String  inObjectJSON){ 
        CreateNewMerchant  createNewMerchant  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createNewMerchant = objectMapper.readValue(inObjectJSON, CreateNewMerchant.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createNewMerchant;
    }
      
    
   
    
        
    public  String  getPartnerName(){
        return  partnerName;
    }
    
    
    public  String  getPartnerCode(){
        return partnerCode;
    }
    
     
    public  String  getGender(){
        return gender;
    }
    
    public  String  getBusinessName(){
        return businessName;
    }
    
    public  String  getBusinessShortName(){
        return businessShortName;
    }
    
    public  String  getRcNumber(){
        return rcNumber;
    }
    
    public  String  getBusinessType(){
        return  businessType;
    }
    
    public  String  getBusinessDescription(){
        return  businessDescription;
    }
    
    public  String  getFirstName(){
        return firstName;
    }
    
    public  String  getLastName(){
        return lastName;
    }
    
    public  String  getDateOfBirth(){
        return dateOfBirth;
    }
    
    public  String  getAddress(){
        return address;
    }
    
    public  int  getState(){
        return state;
    }
    
    public  int  getCountry(){
        return country;
    }
    
    public  String  getBvn(){
        return  bvn;
    }
    
    public  String  getEmailAddress(){
        return emailAddress;
    }
    
    public  String  getContactPhoneNumber(){
        return contactPhoneNumber;
    }
    
    public  String  getAvatar(){
        return avatar;
    }
    
    public  boolean  getVerified(){
        return verified;
    }
    
     
    public  boolean  getGenerateMerchantSecurity(){
        return generateMerchantSecurity;
    }
    
    public  boolean  getEnabledTwoFA(){
        return enabledTwoFA;
    }
    
      
    
    
     public  void  setPartnerName(String  inPartnerName){
         partnerName = inPartnerName;
    }
    
    
    public  void  setPartnerCode(String  inPartnerCode){
         partnerCode = inPartnerCode;
    }
    
    public  void  setGender(String  inGender){
          gender = inGender;
    }
    
    public  void  setBusinessName(String  inBusinessName){
          businessName = inBusinessName;
    }
    
    public  void  setBusinessShortName(String  inBusinessShortName){
          businessShortName = inBusinessShortName;
    }
    
    public  void  setRcNumber(String  inRcNumber){
          rcNumber = inRcNumber;
    }
    
    public  void  setBusinessType(String  inBusinessType){
           businessType = inBusinessType;
    }
    
    public  void  setBusinessDescription(String  inBusinessDescription){
           businessDescription = inBusinessDescription;
    }
    
    public  void  setFirstName(String  inFirstName){
          firstName = inFirstName;
    }
    
    public  void  setLastName(String  inLastName){
          lastName = inLastName;
    }
    
    public  void  setDateOfBirth(String  inDateOfBirth){
          dateOfBirth = inDateOfBirth;
    }
    
    public  void  setAddress(String  inAddress){
          address = inAddress;
    }
    
    public  void  setState(int  inState){
          state = inState;
    }
    
    public  void  setCountry(int  inCountry){
          country = inCountry;
    }
    
    
    public  void  setBvn(String  inBvn){
          bvn = inBvn;
    }
    
    public  void  setEmailAddress(String  inEmailAddress){
          emailAddress = inEmailAddress;
    }
    
    public  void  setContactPhoneNumber(String  inContactPhoneNumber){
          contactPhoneNumber = inContactPhoneNumber;
    }
    
    public  void  setAvatar(String  inAvatar){
          avatar = inAvatar;
    }
    
    public  void  setVerified(boolean  inVerified){
          verified = inVerified;
    }
    
     
    public  void  setGenerateMerchantSecurity(boolean  inGenerateMerchantSecurity){
          generateMerchantSecurity = inGenerateMerchantSecurity;
    }
    
    public  void  setEnabledTwoFA(boolean  inEnabledTwoFA){
          enabledTwoFA = inEnabledTwoFA;
    }
    
    
}
