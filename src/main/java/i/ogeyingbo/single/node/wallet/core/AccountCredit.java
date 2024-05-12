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
public class AccountCredit {
           
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
    protected  String  trxnStartDate =  "";
    protected  String  trxnStartTime =  "";
    protected  String  trxnEndDate =  "";    
    protected  String  trxnEndTime =  ""; 
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
    
    protected  BigDecimal  creditAmount =  new BigDecimal(0.00); 
    
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
    
     
    
       
    
    public  AccountCredit(long inId, String inInitCompanyId,  String inPartnerCode,  String  inAppCode, 
                          String inTrxnReference,     String inProcessorNodeName,    String inProcessorNodeIP,
                          String  inTrxnRequestId,   String inProcessorRef, long inProcessorAuthKeyHash,  
                         String  inTrxnTypeId,  long  inLogSessionId,  String inTrxnEvent,  String inTrxnType,
                        String inTrxnMode, String inCreditCurrencyName, String inCreditCurrencyCode,  String  inCreditCurrencySymbol,
                        String inTrxnStartDate,  String inTrxnStartTime,   String inTrxnEndDate, String inTrxnEndTime,
                        long  inCurrencyExchangeLogRefId, BigDecimal   inCurrencyExchangeRate,
                        String inRecieverSchemeCode, String inRecieverProfileTypeCode,   String inRecieverCustomerRef,
                        String inRecieverName, String inRecieverAccount,   String inRecieverBankCode, String inRecieverAccountName, 
                        String inRecieverBank, int inTrxnProcessCode, String inTrxnStatusCode,
                        String inTrxnStatus,  BigDecimal  inCreditAmount,    BigDecimal  inAvailBalanceBeforeTrxn, 
                        BigDecimal  inAvailBalanceAfterTrxn,    long  inAuthUserId, long  inAuthFactor1KeyHash,
                        long  inAuthFactor2KeyHash, String  inPurchaseTokenEncrypt, String  inServiceProvider,
                        String  inServiceCustomerId, long  inPurchaseTokenHash, String  inProductProviderCustomerName,
                         String  inProductProviderCustomerAddress,     String  inTrxnDetail, String  inNarration,  String  inTrxnComment){
        id = inId;
        initCompanyId = inInitCompanyId;
        partnerCode   = inPartnerCode;
        applicationCode  = inAppCode;
        processorNodeName = inProcessorNodeName;
        processorNodeIP = inProcessorNodeIP;
        trxnRequestId = inTrxnRequestId;
        trxnReference = inTrxnReference;
        processorReference = inProcessorRef;                                       
        processorAuthKeyHash = inProcessorAuthKeyHash;   
        trxnTypeId = inTrxnTypeId;
        logSessionId = inLogSessionId;
        trxnEvent  = inTrxnEvent;
        trxnType = inTrxnType;
        trxnMode = inTrxnMode;
        creditCurrencyName =  inCreditCurrencyName;
        creditCurrencyCode = inCreditCurrencyCode;
        creditCurrencySymbol = inCreditCurrencySymbol;
        trxnStartDate = inTrxnStartDate;
        trxnStartTime = inTrxnStartTime;
        trxnEndDate  =  inTrxnEndDate;        
        trxnEndTime  =  inTrxnEndTime;
        currencyExchangeLogRefId  = inCurrencyExchangeLogRefId;
        currencyExchangeRate  =  inCurrencyExchangeRate;
        recieverSchemeCode = inRecieverSchemeCode;
        recieverProfileTypeCode = inRecieverProfileTypeCode;
        recieverCustomerReference = inRecieverCustomerRef;
        recieverName = inRecieverName;
        recieverAccount =  inRecieverAccount; 
        recieverBankCode =  inRecieverBankCode; 
        recieverBank  =  inRecieverBank;
        trxnProcessCode  =  inTrxnProcessCode;
        trxnStatusCode = inTrxnStatusCode;
        trxnStatus  =  inTrxnStatus;
        creditAmount  = inCreditAmount; 
        availBalanceBeforeTrxn  = inAvailBalanceBeforeTrxn;
        availBalanceAfterTrxn =  inAvailBalanceAfterTrxn; 
        authUserId = inAuthUserId;
        authFactor1KeyHash = inAuthFactor1KeyHash;
        authFactor2KeyHash = inAuthFactor2KeyHash;
        purchaseTokenEncrypt = inPurchaseTokenEncrypt;
        serviceProvider = inServiceProvider;
        serviceCustomerId = inServiceCustomerId;
        purchaseTokenHash = inPurchaseTokenHash;
        productProviderCustomerName = inProductProviderCustomerName;
        productProviderCustomerAddress = inProductProviderCustomerAddress;
        trxnDetail = inTrxnDetail;
        narration = inNarration;        
        trxnComment  = inTrxnComment;            
    }
    
    
     
   public  BigDecimal   getCreditAmount(){
        return  creditAmount;
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
     
     
    
    public  static  AccountCredit  readFromJSON(String  inObjectJSON){ 
        AccountCredit  accountCredit  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              accountCredit = objectMapper.readValue(inObjectJSON, AccountCredit.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  accountCredit;
    }
      
    
    
    public    boolean   logAccountCredit(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
           
         StringBuilder  INSERT_TRANSACTION_SQL =  new StringBuilder(200);
            INSERT_TRANSACTION_SQL.append("INSERT  INTO  transaction_history  (init_company_id, partner_code, application_code,  ");
            INSERT_TRANSACTION_SQL.append("   processor_node_name, processor_node_ip, trxn_reference,  processor_reference, ");
            INSERT_TRANSACTION_SQL.append("  processor_auth_key_hash, trxn_event, trxn_type, trxn_mode, ");
            INSERT_TRANSACTION_SQL.append(" currency_name,  currency_code, currency_symbol, trxn_start_date, trxn_start_time,  ");
            INSERT_TRANSACTION_SQL.append("  trxn_end_date, trxn_end_time,  sender_name, sender_wallet, reciever_name, ");
            INSERT_TRANSACTION_SQL.append(" reciever_bank_code,  reciever_account, reciever_bank, total_trxn_amount, ");
            INSERT_TRANSACTION_SQL.append(" trxn_value_amount,  total_trxn_fee_amount, trxn_process_code, trxn_status_code, ");
            INSERT_TRANSACTION_SQL.append(" trxn_status,  bonus_credit_amount, bonus_debit_amount, avail_bal_before_trxn, ");
            INSERT_TRANSACTION_SQL.append(" avail_bal_after_trxn,  book_bal_before_trxn, book_bal_after_trxn, auth_user_id, ");
            INSERT_TRANSACTION_SQL.append(" auth_factor_1_key_hash,  auth_factor_2_key_hash, service_provider, service_customer_id, ");
            INSERT_TRANSACTION_SQL.append(" purchase_token_encrypt,  purchase_token_hash, product_provider_customer_name, ");
            INSERT_TRANSACTION_SQL.append(" product_provider_customer_address, narration)  VALUES  (?,?,?,?,?,?,?,?,?,?,?, "); 
            INSERT_TRANSACTION_SQL.append("  CURRENT_DATE, CURRENT_TIME,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");  
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_TRANSACTION_SQL.toString()));
                        
                        ps.setString(1, initCompanyId);
                        ps.setString(2, partnerCode);
                        ps.setString(3, applicationCode);
                        ps.setString(5, processorNodeName); 
                        ps.setString(5, processorNodeIP); 
                        ps.setString(4, trxnRequestId);
                        ps.setString(4, trxnReference);
                        ps.setString(5, processorReference); 
                        ps.setLong(5, processorAuthKeyHash); 
                        ps.setString(6, trxnTypeId); 
                        ps.setLong(7, logSessionId);
                        ps.setString(6, trxnEvent); 
                        ps.setString(7, trxnType); 
                        ps.setString(8, trxnMode);  
                        ps.setString(9, creditCurrencyName);
                        ps.setString(10, creditCurrencyCode);
                        ps.setString(11, creditCurrencySymbol);   
                         ps.setLong(11, currencyExchangeLogRefId);
                         ps.setBigDecimal(11, currencyExchangeRate);
                        ps.setString(12, recieverName);
                        ps.setString(13, recieverAccount); 
                        ps.setString(15, recieverBankCode);  
                        ps.setString(17, recieverBank); 
                        ps.setInt(18, trxnProcessCode); 
                        ps.setString(19, trxnStatusCode); 
                        ps.setString(20, trxnStatus); 
                            ps.setBigDecimal(21, creditAmount);  
                        ps.setBigDecimal(26, availBalanceBeforeTrxn); 
                        ps.setBigDecimal(27, availBalanceAfterTrxn);  
                        ps.setLong(30, authUserId);
                        ps.setLong(31, authFactor1KeyHash); 
                        ps.setLong(32, authFactor2KeyHash); 
                        ps.setString(33, purchaseTokenEncrypt); 
                        ps.setString(34, serviceProvider); 
                        ps.setString(35, serviceCustomerId); 
                        ps.setLong(36, purchaseTokenHash); 
                        ps.setString(37, productProviderCustomerName); 
                        ps.setString(38, productProviderCustomerAddress); 
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
      
       
    
            
       public   boolean    retrieveAccountCredit(Connection  cron){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           int  recordCount   = 0;
           boolean  recordFound  = false;
           try {                  
               
               sbQuery.append("  SELECT  id, init_company_id, partner_code, application_code,   "); 
               sbQuery.append("    processor_node_name, processor_node_ip,  trxn_reference,  processor_reference,  "); 
               sbQuery.append("    trxn_event, trxn_type, trxn_mode, credit_currency_name,  credit_currency_code,  ");
                sbQuery.append("  credit_currency_symbol,  currency_exchange_log_ref_id,  currency_exchange_rate,   trxn_start_date,  "); 
               sbQuery.append("  trxn_start_time, trxn_end_date, trxn_end_time, reciever_scheme_code,  reciever_profile_type_code,   ");   
               sbQuery.append("   reciever_customer_reference,   reciever_name,  ");
               sbQuery.append("  reciever_bank_code,  reciever_account, reciever_bank, credit_amount,    ");
               sbQuery.append("    trxn_process_code, trxn_status_code, trxn_status,  bonus_credit_amount,  ");
               sbQuery.append("  bonus_debit_amount, avail_bal_before_trxn,  avail_bal_after_trxn,  book_bal_before_trxn, ");
               sbQuery.append("  book_bal_after_trxn, auth_user_id, auth_factor_1_key_hash,  auth_factor_2_key_hash,  service_provider,  ");
               sbQuery.append("  service_customer_id,  purchase_token_encrypt,  purchase_token_hash,  product_provider_customer_name, ");
               sbQuery.append("  product_provider_customer_address,  trxn_detail,  narration, trxn_comment ");
               
               sbQuery.append("   FROM  transaction_history  WHERE   (init_company_id  =  '%s')  "); 
               sbQuery.append("   AND   (processor_reference = '%s')  AND   (sender_wallet =  '%s') "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), initCompanyId, processorReference, recieverAccount));
                
                // Parameters start with 1
                while (rsx.next()) {   
                   
                    this.id = rsx.getLong("id");
                    this.initCompanyId  =  rsx.getString("init_company_id");
                    this.partnerCode =  rsx.getString("partner_code");
                    this.applicationCode =  rsx.getString("application_code");
                    this.processorNodeName =  rsx.getString("processor_node_name");
                    this.processorNodeIP =  rsx.getString("processor_node_ip");
                    
                    this.trxnRequestId =  rsx.getString("trxn_request_id");
                    this.trxnReference =  rsx.getString("trxn_reference");
                    this.processorReference =  rsx.getString("processor_reference");
                    this.processorAuthKeyHash =  rsx.getLong("processor_auth_key_hash");
                    this.trxnTypeId = rsx.getString("trxn_type_id");                 
                    this.logSessionId =  rsx.getLong("log_session_id");
                    
                    this.trxnEvent = rsx.getString("trxn_event");                 
                    this.trxnType =  rsx.getString("trxn_type");
                    this.trxnMode =  rsx.getString("trxn_mode");
                    this.creditCurrencyName =  rsx.getString("credit_currency_name");
                    this.creditCurrencyCode = rsx.getString("credit_currency_code");                 
                    this.creditCurrencySymbol =  rsx.getString("credit_currency_symbol");
                    this.currencyExchangeLogRefId = rsx.getLong("currency_exchange_log_ref_id");
                    this.currencyExchangeRate  =  rsx.getBigDecimal("currency_exchange_rate");
                    this.trxnStartDate =  rsx.getString("trxn_start_date");
                    this.trxnStartTime =  rsx.getString("trxn_start_time");
                    this.trxnEndDate =  rsx.getString("trxn_end_date");
                    this.trxnEndTime =  rsx.getString("trxn_end_time");
                                     
                    this.recieverName =  rsx.getString("reciever_name");
                    this.recieverBankCode =  rsx.getString("reciever_bank_code");
                    this.recieverAccount = rsx.getString("reciever_account");                 
                    this.recieverBank =  rsx.getString("reciever_bank");
                    this.creditAmount =  rsx.getBigDecimal("credit_amount"); 
                    this.trxnProcessCode =  rsx.getInt("trxn_process_code");
                    this.trxnStatusCode = rsx.getString("trxn_status_code");                 
                    this.trxnStatus =  rsx.getString("trxn_status");             
                    this.availBalanceBeforeTrxn =  rsx.getBigDecimal("avail_bal_before_trxn");
                    this.availBalanceAfterTrxn =  rsx.getBigDecimal("avail_bal_after_trxn"); 
                    
                    this.authUserId =  rsx.getLong("auth_user_id");
                    this.authFactor1KeyHash =  rsx.getLong("auth_factor_1_key_hash");
                    this.authFactor2KeyHash =  rsx.getLong("auth_factor_2_key_hash");
                    this.serviceProvider =  rsx.getString("service_provider");
                    this.serviceCustomerId =  rsx.getString("service_customer_id");
                    this.purchaseTokenEncrypt =  rsx.getString("purchase_token_encrypt");
                    this.purchaseTokenHash =  rsx.getLong("purchase_token_hash");
                    this.productProviderCustomerName =  rsx.getString("product_provider_customer_name");
                    this.productProviderCustomerAddress =  rsx.getString("product_provider_customer_address");
                    this.trxnDetail =  rsx.getString("trxn_detail");
                    this.narration =  rsx.getString("narration");
                   this.trxnComment =  rsx.getString("trxn_comment"); 
                                        
                    recordCount  = recordCount + 1;                 
                } 
                
                if(recordCount == 1){
                    recordFound = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null;
                    cron.close();
                    cron = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
     return  recordFound;
  } 
    
       
       
       
}
