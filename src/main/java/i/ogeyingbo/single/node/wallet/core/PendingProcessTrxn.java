/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.core;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PendingProcessTrxn  {
    
      
    protected  long  id  = -1;
    protected  String  initCompanyId =  "";
    protected  String  partnerCode =  "";
    protected  String  applicationCode =  "";
    protected  String  processorNodeName =  "";
    protected  String  processorNodeIP =  "";
    protected  String  trxnRequestId =  "";   //--
    protected  String  trxnReference =  "";
    protected  long    bearerTokenHash  = -1;
    protected  String  processorReference =  "";
    protected  long  processorAuthKeyHash =  -1;
    protected  String  trxnTypeId =  "";
    protected  long    logSessionId  = -1;
    protected  String  trxnEvent =  "";
    protected  String  trxnType =  ""; 
    protected  String  trxnMode =  "";
    protected  String  debitCurrencyName =  "";
    protected  String  debitCurrencyCode =  "";
    protected  String  debitCurrencySymbol =  "";
    protected  String  trxnStartDate =  "";
    protected  String  trxnStartTime =  "";
    protected  String  trxnEndDate =  "";    
    protected  String  trxnEndTime =  "";
    
    protected  String  senderSchemeCode =  "";
    protected  String  senderProfileTypeCode =  "";
    protected  String  senderCustomerReference =  "";
    protected  String  senderName =  "";
    protected  String  senderWallet =  "";
    
    protected  long    currencyExchangeLogRefId  = -1;
    protected  BigDecimal  currencyExchangeRate =  new BigDecimal(0.00); 
    
    protected  String  recieverSchemeCode =  "";
    protected  String  recieverProfileTypeCode =  "";
    protected  String  recieverCustomerReference =  "";
    protected  String  recieverName =  "";
    protected  String  recieverBankCode =  "";    
    protected  String  recieverAccount =  "";
    protected  String  recieverBank =  ""; 
    protected  int     trxnProcessCode =  -1;
    protected  String  trxnStatusCode =  "";
    protected  String  trxnStatus =  "";
    
    protected  BigDecimal  totalTrxnAmount =  new BigDecimal(0.00);
    protected  BigDecimal  trxnValueAmount =  new BigDecimal(0.00);
    protected  BigDecimal  totalTrxnFeeAmount =  new BigDecimal(0.00);
    
    protected  String  creditCurrencyName =  "";
    protected  String  creditCurrencyCode =  "";
    protected  String  creditCurrencySymbol =  ""; 
        
    protected  BigDecimal  bonusCreditAmount =  new BigDecimal(0.00);
    protected  BigDecimal  bonusDebitAmount =  new BigDecimal(0.00);
    protected  BigDecimal  availBalanceBeforeTrxn =  new BigDecimal(0.00);
    protected  BigDecimal  availBalanceAfterTrxn =  new BigDecimal(0.00);
    protected  BigDecimal  bookBalanceBeforeTrxn =  new BigDecimal(0.00);
    protected  BigDecimal  bookBalanceAfterTrxn =  new BigDecimal(0.00);
        
    protected  long    authUserId =  -1;
    protected  long  authFactor1KeyHash =  -1;
    protected  long  authFactor2KeyHash =  -1;
    protected  String  purchaseTokenEncrypt =  "";
    protected  String  serviceProvider =  "";
    protected  String  serviceCustomerId =  "";
    protected  long  purchaseTokenHash =  -1;    
    protected  String  productProviderCustomerName =  "";
    protected  String  productProviderCustomerAddress =  "";    
    protected  String  narration =  "";
    protected  String  trxnDetail =  "";
    protected  String  trxnComment =  "";
    
    
    protected  boolean  isFinalized = false;
    protected  int    updateCheck =  0;  
    
    private  boolean  isProcessed= false;
    private  boolean  isSelected = false;
    private  boolean  isDebitWalletInMemory = false;
    private  boolean  isCreditAccountInMemory = false;
    
      
    
     
    public  PendingProcessTrxn(long inId, String inInitCompanyId,  String inPartnerCode,  String  inAppCode, 
                           String inProcessorNodeName,    String inProcessorNodeIP, String inTrxnRequestId, 
                        String inProcessorRef,  String inTrxnReference,  long inBearerTokenHash,  long inProcessorAuthKeyHash,  
                          String inTrxnTypeId, long inLogSessionId,   String inTrxnEvent, String inTrxnType,
                        String inTrxnMode, String inDebitCurrencyName, String inDebitCurrencyCode,  String  inDebitCurrencySymbol,
                        String inTrxnStartDate,  String inTrxnStartTime,   String inTrxnEndDate, String inTrxnEndTime,
                        String inSenderSchemeCode, String inSenderProfileTypeCode, String inSenderCustomerRef,
                        String inSenderName, String inSenderWallet,  long  inCurrencyExchangeLogRefId,  BigDecimal  inCurrencyExchangeRate,
                        String inRecieverSchemeCode, String inRecieverProfileTypeCode, String inRecieverCustomerRef,
                        String inRecieverName, String inRecieverBankCode,
                        String inRecieverAccount, String inRecieverBank, int inTrxnProcessCode, String inTrxnStatusCode,
                        String inTrxnStatus,  BigDecimal  inTotalTrxnAmount, BigDecimal  inTrxnValueAmount,
                        BigDecimal  inTotalTrxnFeeAmount, String inCreditCurrencyName, String inCreditCurrencyCode, 
                         String  inCreditCurrencySymbol,  BigDecimal  inBonusCreditAmount, BigDecimal  inBonusDebitAmount,
                        BigDecimal  inAvailBalanceBeforeTrxn, BigDecimal  inAvailBalanceAfterTrxn, BigDecimal  inBookBalanceBeforeTrxn, 
                        BigDecimal  inBookBalanceAfterTrxn, long  inAuthUserId, long  inAuthFactor1KeyHash,
                        long  inAuthFactor2KeyHash, String  inPurchaseTokenEncrypt, String  inServiceProvider,
                        String  inServiceCustomerId, long  inPurchaseTokenHash, String  inProductProviderCustomerName,
                         String  inProductProviderCustomerAddress,    String  inTrxnDetail, String  inNarration,  String  inTrxnComment){
        id = inId;
        initCompanyId = inInitCompanyId;
        partnerCode   = inPartnerCode;
        applicationCode  = inAppCode; 
        processorNodeName = inProcessorNodeName;
        processorNodeIP = inProcessorNodeIP;  
        trxnRequestId =  inTrxnRequestId;
        trxnReference = inTrxnReference;
        bearerTokenHash  = inBearerTokenHash;
        processorReference = inProcessorRef;
        processorAuthKeyHash = inProcessorAuthKeyHash;
        trxnTypeId = inTrxnTypeId;
        logSessionId = inLogSessionId;
        trxnEvent  = inTrxnEvent;
        trxnType = inTrxnType;
        trxnMode = inTrxnMode;
        debitCurrencyName =  inDebitCurrencyName;
        debitCurrencyCode = inDebitCurrencyCode;
        debitCurrencySymbol = inDebitCurrencySymbol;
        trxnStartDate = inTrxnStartDate;
        trxnStartTime = inTrxnStartTime;
        trxnEndDate  =  inTrxnEndDate;        
        trxnEndTime  =  inTrxnEndTime;
        senderSchemeCode = inSenderSchemeCode;
        senderProfileTypeCode =  inSenderProfileTypeCode;
        senderCustomerReference = inSenderCustomerRef; 
        senderName = inSenderName;
        senderWallet =  inSenderWallet;
        currencyExchangeLogRefId =  inCurrencyExchangeLogRefId;
        currencyExchangeRate =  inCurrencyExchangeRate;
        recieverSchemeCode = inRecieverSchemeCode;
        recieverProfileTypeCode =  inRecieverProfileTypeCode;
        recieverCustomerReference = inRecieverCustomerRef; 
        recieverName = inRecieverName;
        recieverBankCode =  inRecieverBankCode;
        recieverAccount  =  inRecieverAccount;
        recieverBank  =  inRecieverBank;
        trxnProcessCode  =  inTrxnProcessCode;
        trxnStatusCode = inTrxnStatusCode;
        trxnStatus  =  inTrxnStatus;
        totalTrxnAmount  = inTotalTrxnAmount;
        trxnValueAmount  = inTrxnValueAmount;
        totalTrxnFeeAmount = inTotalTrxnFeeAmount;
        creditCurrencyName =  inCreditCurrencyName;
        creditCurrencyCode = inCreditCurrencyCode;
        creditCurrencySymbol = inCreditCurrencySymbol;
        bonusCreditAmount =  inBonusCreditAmount;
        bonusDebitAmount =  inBonusDebitAmount;
        availBalanceBeforeTrxn  = inAvailBalanceBeforeTrxn;
        availBalanceAfterTrxn =  inAvailBalanceAfterTrxn;
        bookBalanceBeforeTrxn  = inBookBalanceBeforeTrxn;
        bookBalanceAfterTrxn  = inBookBalanceAfterTrxn;
        authUserId = inAuthUserId;
        authFactor1KeyHash = inAuthFactor1KeyHash;
        authFactor2KeyHash = inAuthFactor2KeyHash;
        purchaseTokenEncrypt = inPurchaseTokenEncrypt;
        serviceProvider = inServiceProvider;
        serviceCustomerId = inServiceCustomerId;
        purchaseTokenHash = inPurchaseTokenHash;
        productProviderCustomerName = inProductProviderCustomerName;
        productProviderCustomerAddress = inProductProviderCustomerAddress;
        narration = inNarration;
        trxnDetail  =  inTrxnDetail;
        trxnComment  =  inTrxnComment;
    }
    
    
     
    public  final void  setDebitWalletInMemory(){
        isDebitWalletInMemory = true;
    }
    
    
     
    public final void  setCreditAccountInMemory(){
        isCreditAccountInMemory = true;
    }
    
     
    public  void  setTotalTrxnAmount(BigDecimal  inTotalTrxnAmount){
        totalTrxnAmount =  inTotalTrxnAmount;
    }
    
    public  void  setTotalTrxnFeeAmount(BigDecimal  inTotalTrxnFeeAmount){
        totalTrxnFeeAmount =  inTotalTrxnFeeAmount;
    }
    
    
    public  BigDecimal   getTotalTrxnAmount(){
        return  totalTrxnAmount;
    }
    
    public  BigDecimal   getTrxnValueAmount(){
       return  trxnValueAmount; 
    }
    
    public  BigDecimal   getTotalTrxnFeeAmount(){
        return   totalTrxnFeeAmount;
    }
     
  
     public  BigDecimal   getAvailableBalBeforeTrxn(){
       return  availBalanceBeforeTrxn;
    }
    
    public  BigDecimal   getAvailableBalAfterTrxn(){
        return   availBalanceAfterTrxn;
    }
    
    
    public  long  getAuthUserId(){
        return  authUserId;
    }
    
    
    public  long  getAuthFactor1KeyHash(){
        return  authFactor1KeyHash;
    }
    
    public  long  getAuthFactor2KeyHash(){
        return  authFactor2KeyHash;
    }
    
    public  boolean  isFinalized(){
        return  isFinalized;
    }
    
    public  int  getUpdateCHeck(){
        return updateCheck;
    }
    
    
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
     
     
    
    public  static  Transaction  readFromJSON(String  inObjectJSON){ 
        Transaction  transaction  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              transaction = objectMapper.readValue(inObjectJSON, Transaction.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  transaction;
    }
      
    
   
    
    
    
    
    public    boolean   logPendingProcessTrxn(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
           
         StringBuilder  INSERT_TRANSACTION_SQL =  new StringBuilder(200);
            INSERT_TRANSACTION_SQL.append("INSERT  INTO  pending_process_trxn  (init_company_id, partner_code,   ");
            INSERT_TRANSACTION_SQL.append(" application_code,  processor_node_name, processor_node_ip, trxn_request_id, ");
            INSERT_TRANSACTION_SQL.append(" trxn_reference, bearer_token_hash, processor_reference, processor_auth_key_hash, ");
            INSERT_TRANSACTION_SQL.append(" trxn_type_id,  log_session_id,  trxn_event, trxn_type, trxn_mode, ");
            INSERT_TRANSACTION_SQL.append(" debit_currency_name,  debit_currency_code, debit_currency_symbol,  ");
            INSERT_TRANSACTION_SQL.append("  trxn_start_date, trxn_start_time,  trxn_end_date, trxn_end_time, ");
            INSERT_TRANSACTION_SQL.append("  sender_scheme_code, sender_profile_type_code,  sender_customer_reference, ");
            INSERT_TRANSACTION_SQL.append("  sender_name, sender_wallet, currency_exchange_log_reference_id,  ");
            INSERT_TRANSACTION_SQL.append("  currency_exchange_rate, reciever_scheme_code,  reciever_profile_type_code, ");
            INSERT_TRANSACTION_SQL.append("  reciever_customer_reference, reciever_name, reciever_bank_code,  reciever_account, ");
            INSERT_TRANSACTION_SQL.append(" reciever_bank, total_trxn_amount,   trxn_value_amount,  total_trxn_fee_amount, ");
            INSERT_TRANSACTION_SQL.append(" credit_currency_name,  credit_currency_code, credit_currency_symbol, ");
            INSERT_TRANSACTION_SQL.append(" trxn_process_code, trxn_status_code, ");
            INSERT_TRANSACTION_SQL.append(" trxn_status,  bonus_credit_amount, bonus_debit_amount, avail_bal_before_trxn, ");
            INSERT_TRANSACTION_SQL.append(" avail_bal_after_trxn,  book_bal_before_trxn, book_bal_after_trxn, auth_user_id, ");
            INSERT_TRANSACTION_SQL.append(" auth_factor_1_key_hash,  auth_factor_2_key_hash, service_provider, service_customer_id, ");
            INSERT_TRANSACTION_SQL.append(" purchase_token_encrypt,  purchase_token_hash, product_provider_customer_name, ");
            INSERT_TRANSACTION_SQL.append(" product_provider_customer_address, debit_wallet_in_memory, credit_accnt_in_memory,  ");
            INSERT_TRANSACTION_SQL.append("  trxn_detail, narration,  trxn_comment)  VALUES  (?,?,?,?,?,?,?,?,?,?,?, "); 
            INSERT_TRANSACTION_SQL.append("  CURRENT_DATE, CURRENT_TIME,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  "); 
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_TRANSACTION_SQL.toString()));
                                                 
                        ps.setString(1,  initCompanyId);
                        ps.setString(2, partnerCode);
                        ps.setString(3, applicationCode);
                        ps.setString(4, processorNodeName); 
                        ps.setString(5, processorNodeIP); 
                        ps.setString(6, trxnRequestId);
                        ps.setString(7, trxnReference);
                        ps.setLong(8, bearerTokenHash);
                        ps.setString(9, processorReference); 
                        ps.setLong(10, processorAuthKeyHash); 
                        ps.setString(11, trxnEvent); 
                        ps.setString(12, trxnType); 
                        ps.setString(13, trxnMode);  
                         ps.setString(14, debitCurrencyName);
                        ps.setString(15, debitCurrencyCode);
                        ps.setString(16, debitCurrencySymbol);   
                        
                        ps.setString(17, senderSchemeCode);
                        ps.setString(18, senderProfileTypeCode);
                        ps.setString(19, senderCustomerReference);
                        ps.setString(20, senderName);
                        ps.setString(21, senderWallet);
                        
                        ps.setLong(22, currencyExchangeLogRefId);
                        ps.setBigDecimal(23, currencyExchangeRate);
                        ps.setString(24, recieverSchemeCode);
                        ps.setString(25, recieverProfileTypeCode);
                        ps.setString(26, recieverCustomerReference);
                        
                        ps.setString(27, recieverName); 
                        ps.setString(28, recieverBankCode); 
                        ps.setString(29, recieverAccount); 
                        ps.setString(30, recieverBank); 
                        ps.setInt(31, trxnProcessCode); 
                        ps.setString(32, trxnStatusCode); 
                        ps.setString(33, trxnStatus); 
                        ps.setBigDecimal(34, totalTrxnAmount); 
                        ps.setBigDecimal(35, trxnValueAmount); 
                        ps.setBigDecimal(36, totalTrxnFeeAmount); 
                         ps.setString(37, creditCurrencyName);
                        ps.setString(38, creditCurrencyCode);
                        ps.setString(39, creditCurrencySymbol); 
                        ps.setBigDecimal(40, bonusCreditAmount); 
                        ps.setBigDecimal(41, bonusDebitAmount); 
                        ps.setBigDecimal(42, availBalanceBeforeTrxn); 
                        ps.setBigDecimal(43, availBalanceAfterTrxn); 
                        ps.setBigDecimal(44, bookBalanceBeforeTrxn); 
                        ps.setBigDecimal(29, bookBalanceAfterTrxn); 
                        ps.setLong(45, authUserId);
                        ps.setLong(46, authFactor1KeyHash); 
                        ps.setLong(47, authFactor2KeyHash); 
                        ps.setString(48, purchaseTokenEncrypt); 
                        ps.setString(49, serviceProvider); 
                        ps.setString(50, serviceCustomerId); 
                        ps.setLong(51, purchaseTokenHash); 
                        ps.setString(52, productProviderCustomerName); 
                        ps.setString(53, productProviderCustomerAddress); 
                        ps.setString(54, trxnDetail); 
                        ps.setString(54, narration); 
                        ps.setString(54, trxnComment); 

                        isRecordInserted  =  (ps.executeUpdate() == 1);    
                                           
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_TRANSACTION_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }
      
        
    
       
       
    
}
