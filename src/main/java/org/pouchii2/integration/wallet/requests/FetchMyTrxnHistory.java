/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class FetchMyTrxnHistory    extends  PouchiiRequestBase  {
         
    private  int  page = 0; 
    private  int  lastRecord = 0; 
    private  int  pageSize = 30; 
    private  Long[]  walletIds =  null; 
    private final String[]  trxnStatus =  {"Successful","Pending","Failed"}; 
    
    private final   String[]  trxnEvent = {"SendMoney","Deposit","RequestMoney", "AirtimeTopup","EPinPurchase","DataSubscription",
     "PayRRR","PayElectricity","CableTV","InternetSubscription","BillsPayment","Reversal","Referral","Disbursement"};  
    private final String[]  trxnType = {"Debit","Credit"}; 
    private  final String[]  trxnMode = {"WalletToWallet","BankToWallet","WalletToBank", "BonusWallet", "Ussd", "Card"}; 
    
    private  String  trxnStartDate = "2023-03-07";
    private  String  trxnEndDate = "2024-05-05";
    private  String  narration = "-";  
    
    
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
     
    
    public   final  FetchMyTrxnHistory  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        FetchMyTrxnHistory  fetchMyTrxnHistory  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              fetchMyTrxnHistory = objectMapper.readValue(inObjectJSON, FetchMyTrxnHistory.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  fetchMyTrxnHistory;
    }
     
    
    
    public  static  FetchMyTrxnHistory  readFromJSON(String  inObjectJSON){ 
        FetchMyTrxnHistory  fetchMyTrxnHistory  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              fetchMyTrxnHistory = objectMapper.readValue(inObjectJSON, FetchMyTrxnHistory.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  fetchMyTrxnHistory;
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
    
    public  Long[]  getWalletIds(){
        return  walletIds;
    }
    
    public  String[]  getTrxnStatus(){
        return  trxnStatus;
    }
     
    
    public  String[]  getTrxnEvent(){
        return  trxnEvent;
    }
    
    
    public  String[]  getTrxnType(){
        return  trxnType;
    }
    
    public  String[]  getTrxnMode(){
        return  trxnMode;
    }
    
      
    public  String  getTrxnStartDate(){
        return  trxnStartDate;
    }
    
     public  String  getTrxnEndDate(){
        return  trxnEndDate;
    }
     
    public  String  getNarration(){
        return  narration;
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
    
    public  void  setWalletIds(Long[]  inWalletIds){
           walletIds = inWalletIds;
    }
    
    
    /***
    public  void  setTrxnStatus(String[]  inTrxnStatus){
           trxnStatus = inTrxnStatus;
    }
     
    
    public  void  setTrxnEvent(String[]  inTrxnEvent){
           trxnEvent = inTrxnEvent;
    }
    
    
    public  void    setTrxnType(String[]  inTrxnType){
           trxnType = inTrxnType;
    }
    
    public  void  setTrxnMode(String[]  inTrxnMode){
           trxnMode = inTrxnMode;
    }
    ***/
      
    public  void  setTrxnStartDate(String  inTrxnStartDate){
           trxnStartDate = inTrxnStartDate;
    }
    
     public  void  setTrxnEndDate(String  inTrxnEndDate){
           trxnEndDate = inTrxnEndDate;
    }
     
    public  void  setNarration(String  inNarration){
           narration = inNarration;
    }
    
    
    
    
    
}
