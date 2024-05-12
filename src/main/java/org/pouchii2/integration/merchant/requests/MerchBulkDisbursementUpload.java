/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class MerchBulkDisbursementUpload  extends  PouchiiMerchRequestBase {
      
    private  String  batchId = "-";
    private  boolean  appendToPrevious = false;
    private  String  sourceAccount = "-"; 
    private  String  debitCurrency = "NGN";
    private  BigDecimal  totalDebitAmount = new BigDecimal(0.00); 
    private  String  totalDebitTrxnAmount = "0.00"; 
    
    
    private  ArrayList<MerchantPaymentInstruction>   merchantPaymentInstructions = new ArrayList<MerchantPaymentInstruction>();
    
     
    
    
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
     
     
    
     public   final  MerchBulkDisbursementUpload  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        MerchBulkDisbursementUpload   merchBulkDisbursementUpload  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchBulkDisbursementUpload = objectMapper.readValue(inObjectJSON, MerchBulkDisbursementUpload.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchBulkDisbursementUpload;
    }
     
     
    
    public  static  MerchBulkDisbursementUpload  readFromJSON(String  inObjectJSON){ 
        MerchBulkDisbursementUpload  merchBulkDisbursementUpload  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchBulkDisbursementUpload = objectMapper.readValue(inObjectJSON, MerchBulkDisbursementUpload.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchBulkDisbursementUpload;
    }
      
    
    
    public  String  getBatchId(){
        return  batchId;
    }
    
    public  boolean  getAppendToPrevious(){
        return  appendToPrevious;
    }
    
    public  String  getSourceAccount(){
        return  sourceAccount;
    }
    
    public  String  getDebitCurrency(){
        return  debitCurrency;
    }
    
   
    public  BigDecimal  getTotalDebitAmount(){
        return  totalDebitAmount;
    }    
    
    public  String  getTotalDebitTrxnAmount(){
        return  totalDebitTrxnAmount;
    }
     
    public  ArrayList<MerchantPaymentInstruction>  getMerchantPaymentInstructions(){
        return  merchantPaymentInstructions;
    }
    
    
    
    
    
    
    
    
     public  void  setBatchId(String  inBatchId){
           batchId = inBatchId;
    }
    
    public  void  setAppendToPrevious(boolean  inAppendToPrevious){
           appendToPrevious = inAppendToPrevious;
    }
    
    public  void  setSourceAccount(String  inSourceAccount){
           sourceAccount = inSourceAccount;
    }
    
    public  void  setDebitCurrency(String  inDebitCurrency){
           debitCurrency = inDebitCurrency;
    }
    
   
    public  void  setTotalDebitAmount(BigDecimal  inTotalDebitAmount){
           totalDebitAmount = inTotalDebitAmount;
    }    
    
    public  void  setTotalDebitTrxnAmount(String  inTotalDebitTrxnAmount){
           totalDebitTrxnAmount = inTotalDebitTrxnAmount;
    }
     
    public  void  setMerchantPaymentInstructions(ArrayList<MerchantPaymentInstruction>  inMerchantPaymentInstructions){
           merchantPaymentInstructions = inMerchantPaymentInstructions;
    }
    
    
}
