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
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class UpgradeToKYCLevel3 extends  RequestBase  {
    
    @NotBlank(message = "Document type cannot be null or empty")    
    private  String  kycDocumentType = "Electricity_Bill"; 
    
    @NotBlank(message = "Document number cannot be null or empty") @Pattern(regexp="[0-9]")
    private  String  documentNumber = "09087654";
    
    @NotBlank(message = "Document file cannot be null or empty")
    private  String  documentFile = "https://localhost:8080/nin/leke.png";
    
    @NotBlank(message = "Document content type cannot be null or empty")
    private  String  documentContentType = "image/jpg"; 

    @NotBlank(message = "Document issue date cannot be null or empty") @Pattern(regexp="[-0-9]")    
    private  String  issuedDate = "2021-03-14"; 
    
     
    
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
     
     
    
    public  static  UpgradeToKYCLevel3  readFromJSON(String  inObjectJSON){ 
        UpgradeToKYCLevel3  upgradeToKYCLevel3  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              upgradeToKYCLevel3 = objectMapper.readValue(inObjectJSON, UpgradeToKYCLevel3.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  upgradeToKYCLevel3;
    }
      
    
     
    
      
     
    public  String  getKycDocumentType(){
        return  kycDocumentType;
    }
    
    
    public  String  getDocumentNumber(){
        return  documentNumber;
    }
    
    public  String  getDocumentFile(){
        return  documentFile;
    }
    
    public  String  getDocumentContentType(){
        return  documentContentType;
    }
    
    public  String  getIssuedDate(){
       return  issuedDate; 
    }
    
    
    
    
    
    
    public  void  setKycDocumentType(String  inKycDocumentType){
           kycDocumentType = inKycDocumentType;
    }
    
    
    public  void  setDocumentNumber(String  inDocumentNumber){
           documentNumber = inDocumentNumber;
    }
    
    public  void  setDocumentFile(String  inDocumentFile){
           documentFile = inDocumentFile;
    }
    
    public  void  setDocumentContentType(String  inDocumentContentType){
           documentContentType = inDocumentContentType;
    }
    
    public  void  setIssuedDate(String  inIssuedDate){
          issuedDate = inIssuedDate; 
    }
    
    
    
    
}
