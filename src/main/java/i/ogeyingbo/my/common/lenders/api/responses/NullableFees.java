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
public class NullableFees {
    
    private  String  feeName = "";
    private  String  feeType = "";
    private  BigDecimal  feeOperator = new BigDecimal(0.00);
    private  BigDecimal  feeAmount = new BigDecimal(0.00);
    
    
    public  String  getFeeName(){
        return   feeName;
    }
    
    public  String  getFeeType(){
        return   feeType;
    }
    
    public  BigDecimal  getFeeOperator(){
        return   feeOperator;
    }
    
    public  BigDecimal  getFeeAmount(){
        return   feeAmount;
    }
    
    
    
    
     public  void  setFeeName(String   inFeeName){
        feeName = inFeeName;
    }
    
    public  void  setFeeType(String  inFeeType){
        feeType = inFeeType;
    }
    
    public  void setFeeOperator(String  inFeeOperator){
        if(!StringUtils.isEmpty(inFeeOperator)){
           try{
               feeOperator = new BigDecimal(inFeeOperator.trim());
           }catch(Exception ex){
               feeOperator = new BigDecimal(100);
               ex.printStackTrace();
           }
        }else{
          feeOperator = new BigDecimal(100);
        }
    }
    
    
    
    public  void  setFeeAmount(String  inFeeAmount){
          if(!StringUtils.isEmpty(inFeeAmount)){
           try{
               feeAmount= new BigDecimal(inFeeAmount.trim());
           }catch(Exception ex){
               feeAmount = new BigDecimal(0.00);
               ex.printStackTrace();
           }
        }else{
          feeOperator = new BigDecimal(0.00);
        }
    }
    
    
    
    
    
    
  public   final  NullableFees  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        NullableFees   nullableFees  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              nullableFees = objectMapper.readValue(inObjectJSON, NullableFees.class);
             //  this.log(con, inObjectJSON, true);
            }catch(Exception ex){
            //  this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  nullableFees;
    }
     
    
    public  static  NullableFees  readFromJSON(String  inObjectJSON){ 
        NullableFees  nullableFees  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              nullableFees = objectMapper.readValue(inObjectJSON, NullableFees.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  nullableFees;
    }
      
    
}
