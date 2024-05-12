/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class LoanSummaryCalculationResponse {
         
    private  int responseCode  = 400;
    private  String responseMessage = ""; 
    
    private  String  totalAmountPayable = ""; 
    private  String  monthlyAmountPayable = ""; 
    private  String  totalInterestAmountPayable = ""; 
    
    
    NullableFees[]    fees =  new NullableFees[2];
    
    
    public int  getResponseCode(){
        return  responseCode;
    }
    
    public String  getResponseMessage(){
        return  responseMessage;
    }
    
    public  NullableFees[]  getFees(){
        return  fees;
    }
    
    
    public String  getTotalAmountPayable(){
        return  totalAmountPayable;
    }
    
    public String   getMonthlyAmountPayable(){
        return  monthlyAmountPayable;
    }
    
    public String  getTotalInterestAmountPayable(){
        return  totalInterestAmountPayable;
    }
    
    
    
    
    public void  setResponseCode(int  inResponseCode){
       responseCode = inResponseCode;
    }
    
    public void  setResponseMessage(String  inResponseMessage){
          responseMessage = inResponseMessage;
    }
     
    
    public  void  getFees(NullableFees[]   inFees){
         fees = inFees;
    }
    
    
    public void  setTotalAmountPayable(String  inTotalAmountPayable){
       totalAmountPayable = inTotalAmountPayable;
    }
    
    public void  setMonthlyAmountPayable(String  inMonthlyAmountPayable){
       monthlyAmountPayable = inMonthlyAmountPayable;
    }
    
    public void  setTotalInterestAmountPayable(String  inTotalInterestAmountPayable){
       totalInterestAmountPayable = inTotalInterestAmountPayable;
    }
    
    
    private  final  String  convertToJSONString(){
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
     
    
    
     public   final  LoanSummaryCalculationResponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanSummaryCalculationResponse   loanSummaryCalculationResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanSummaryCalculationResponse = objectMapper.readValue(inObjectJSON, LoanSummaryCalculationResponse.class);
             //  this.log(con, inObjectJSON, true);
            }catch(Exception ex){
            //  this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanSummaryCalculationResponse;
    }
     
    
    public  static  LoanSummaryCalculationResponse  readFromJSON(String  inObjectJSON){ 
        LoanSummaryCalculationResponse  loanSummaryCalculationResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanSummaryCalculationResponse = objectMapper.readValue(inObjectJSON, LoanSummaryCalculationResponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanSummaryCalculationResponse;
    }
      
    
}
