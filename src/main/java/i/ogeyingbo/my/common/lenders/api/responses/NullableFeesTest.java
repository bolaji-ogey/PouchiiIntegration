/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.sql.Connection;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class NullableFeesTest {
    
    
     private  String  feeName = "";
    private  String  feeType = "";
    private  String  feeOperator = null;
    private  String  feeAmount = null;
    
    
    public  String  getFeeName(){
        return   feeName;
    }
    
    public  String  getFeeType(){
        return   feeType;
    }
    
    public  String  getFeeOperator(){
        return   feeOperator;
    }
    
    public  String  getFeeAmount(){
        return   feeAmount;
    }
    
    
    
    
     public  void  setFeeName(String   inFeeName){
        feeName = inFeeName;
    }
    
    public  void  setFeeType(String  inFeeType){
        feeType = inFeeType;
    }
    
 
     public  void   setFeeOperator(String   inFeeOperator){
        feeOperator =  inFeeOperator;
    }
    
    public  void  setFeeAmount(String  inFeeAmount){
        feeAmount =   inFeeAmount;
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
     
    
    
    
    public  static  void main(String[] args){
        NullableFeesTest    nullableFeeTest  = new  NullableFeesTest();
        
          nullableFeeTest.setFeeName("Da Fees");
          nullableFeeTest.setFeeType("Da Fee Type");
          
          nullableFeeTest.setFeeOperator("&##hdsaf");
          nullableFeeTest.setFeeAmount("24.00");
      
        NullableFees   nullableFees  =  NullableFees.readFromJSON(nullableFeeTest.convertToJSONString());
        System.out.println("Fee Name = "+nullableFees.getFeeName());
        System.out.println("Fee Type = "+nullableFees.getFeeType());
        System.out.println("");
        System.out.println("Fee Amount = "+nullableFees.getFeeAmount());
        System.out.println("Fee Operator = "+nullableFees.getFeeOperator());
    }
    
}
