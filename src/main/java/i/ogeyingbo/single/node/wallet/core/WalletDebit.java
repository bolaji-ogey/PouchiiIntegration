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
public class WalletDebit {
    
       
      
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
    protected  String  senderBankCode =  "";
    protected  String  senderWalletName =  "";
    protected  String  senderBank =  "";
    
    protected  long    currencyExchangeLogRefId  = -1;
    protected  BigDecimal  currencyExchangeRate =  new BigDecimal(0.00); 
     
    protected  int     trxnProcessCode =  -1;
    protected  String  trxnStatusCode =  "";
    protected  String  trxnStatus =  "";
    
    protected  BigDecimal  debitAmount =  new BigDecimal(0.00);
    protected  BigDecimal  totalDebitAmount =  new BigDecimal(0.00);
    protected  BigDecimal  totalDebitFeeAmount =  new BigDecimal(0.00); 
        
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
    
     
    
       
    
    public  WalletDebit(long inId, String inInitCompanyId,  String inPartnerCode,  String  inAppCode, 
                          String inTrxnReference,     String inProcessorNodeName,    String inProcessorNodeIP,
                          String inTrxnRequestId, String inProcessorRef, long inProcessorAuthKeyHash,
                          String inTrxnTypeId, long inLogSessionId,  String inTrxnEvent, String inTrxnType,
                        String inTrxnMode, String inDebitCurrencyName, String inDebitCurrencyCode,  String  inDebitCurrencySymbol,
                        String inTrxnStartDate,  String inTrxnStartTime,   String inTrxnEndDate, String inTrxnEndTime,
                        String inSenderSchemeCode, String inSenderProfileTypeCode,   String inSenderCustomerRef,
                        String inSenderName, String inSenderWallet,   String inSenderBankCode, String inSenderWalletName, 
                        String inSenderBank, long  inCurrencyExchangeLogRefId, BigDecimal   inCurrencyExchangeRate,
                        int inTrxnProcessCode, String inTrxnStatusCode,
                        String inTrxnStatus,  BigDecimal  inDebitAmount, BigDecimal  inTotalDebitAmount,
                        BigDecimal  inTotalDebitFeeAmount,    BigDecimal  inAvailBalanceBeforeTrxn, 
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
        debitCurrencyName =  inDebitCurrencyName;
        debitCurrencyCode = inDebitCurrencyCode;
        debitCurrencySymbol = inDebitCurrencySymbol;
        trxnStartDate = inTrxnStartDate;
        trxnStartTime = inTrxnStartTime;
        trxnEndDate  =  inTrxnEndDate;        
        trxnEndTime  =  inTrxnEndTime;
        senderSchemeCode = inSenderSchemeCode;
        senderProfileTypeCode = inSenderProfileTypeCode;
        senderCustomerReference = inSenderCustomerRef;
        senderName = inSenderName;
        senderWallet =  inSenderWallet;  
        senderBankCode = inSenderBankCode;
        senderWalletName =  inSenderWalletName; 
        senderBank = inSenderBank; 
        currencyExchangeLogRefId  = inCurrencyExchangeLogRefId;
        currencyExchangeRate  =  inCurrencyExchangeRate;
        trxnProcessCode  =  inTrxnProcessCode;
        trxnStatusCode = inTrxnStatusCode;
        trxnStatus  =  inTrxnStatus;
        debitAmount  = inDebitAmount;
        totalDebitAmount  = inTotalDebitAmount;
        totalDebitFeeAmount = inTotalDebitFeeAmount; 
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
    
    
    public  BigDecimal   getDebitAmount(){
        return  debitAmount;
    }
    
    public  BigDecimal   getTotalDebitAmount(){
       return  totalDebitAmount; 
    }
    
    public  BigDecimal   getTotalDebitFeeAmount(){
        return   totalDebitFeeAmount;
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
     
     
    
    public  static  WalletDebit  readFromJSON(String  inObjectJSON){ 
        WalletDebit  walletDebit  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              walletDebit = objectMapper.readValue(inObjectJSON, WalletDebit.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  walletDebit;
    }
      
    
    
    public    boolean   logWalletDebit(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
           
         StringBuilder  INSERT_TRANSACTION_SQL =  new StringBuilder(200);
            INSERT_TRANSACTION_SQL.append("INSERT  INTO  transaction_history  (init_company_id, partner_code, application_code,  ");
            INSERT_TRANSACTION_SQL.append("   processor_node_name, processor_node_ip, trxn_reference,  processor_reference, ");
            INSERT_TRANSACTION_SQL.append("  processor_auth_key_hash, trxn_event, trxn_type, trxn_mode, ");
            INSERT_TRANSACTION_SQL.append(" currency_name,  currency_code, currency_symbol, trxn_start_date, trxn_start_time,  ");
            INSERT_TRANSACTION_SQL.append("  trxn_end_date, trxn_end_time,  sender_name, sender_wallet, sender_wallet_name, ");
            INSERT_TRANSACTION_SQL.append(" sender_bank_code,  sender_wallet_name, sender_bank, debit_amount, total_debit_amount, ");
            INSERT_TRANSACTION_SQL.append(" total_debit_fee_amount,   trxn_process_code, trxn_status_code, ");
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
                          ps.setLong(6, logSessionId); 
                        ps.setString(6, trxnEvent); 
                        ps.setString(7, trxnType); 
                        ps.setString(8, trxnMode);  
                        ps.setString(9, debitCurrencyName);
                        ps.setString(10, debitCurrencyCode);
                        ps.setString(11, debitCurrencySymbol);   
                        ps.setString(12, senderName);
                        ps.setString(13, senderWallet); 
                        ps.setString(15, senderBankCode); 
                        ps.setString(16, senderWalletName); 
                        ps.setString(17, senderBank); 
                        ps.setLong(6,  currencyExchangeLogRefId);
                        ps.setBigDecimal(17, currencyExchangeRate);
                        ps.setInt(18, trxnProcessCode); 
                        ps.setString(19, trxnStatusCode); 
                        ps.setString(20, trxnStatus); 
                        ps.setBigDecimal(21, debitAmount); 
                        ps.setBigDecimal(22, totalDebitAmount); 
                        ps.setBigDecimal(23, totalDebitFeeAmount);  
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
                        ps.setString(39, trxnDetail);
                        ps.setString(39, narration); 
                        ps.setString(39, trxnComment);

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
      
       
    
            
       public   boolean    retrieveWalletDebit(Connection  cron){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           int  recordCount   = 0;
           boolean  recordFound  = false;
           try {                  
               
               sbQuery.append("  SELECT  id, init_company_id, partner_code, application_code,   "); 
               sbQuery.append("    processor_node_name, processor_node_ip, trxn_request_id,  trxn_reference,  "); 
               sbQuery.append("    processor_reference,  processor_auth_key_hash,  trxn_type_id,  log_session_id, , ");
               sbQuery.append("    trxn_event, trxn_type, trxn_mode, debit_currency_name,  debit_currency_code, ");
              sbQuery.append("    debit_currency_symbol,  currency_exchange_log_ref_id, currency_exchange_rate, ");
               sbQuery.append("    trxn_start_date,   trxn_start_time,  trxn_end_date, "); 
               sbQuery.append("     trxn_end_time,  sender_scheme_code,  sender_profile_type_code,   ");   
               sbQuery.append("    sender_customer_reference,  sender_name, sender_wallet,   ");  
               sbQuery.append("  sender_bank_code,  sender_wallet_name, sender_bank, debit_amount,  total_debit_amount, ");
               sbQuery.append("  total_debit_fee_amount, trxn_process_code, trxn_status_code, trxn_status,   ");
               sbQuery.append("  bonus_credit_amount,  bonus_debit_amount, avail_bal_before_trxn,  avail_bal_after_trxn,   ");
               sbQuery.append("   auth_user_id, auth_factor_1_key_hash,  auth_factor_2_key_hash,  service_provider,  ");
               sbQuery.append("  service_customer_id,  purchase_token_encrypt,  purchase_token_hash,  product_provider_customer_name, ");
               sbQuery.append("  product_provider_customer_address,  trxn_detail,  narration, trxn_comment ");
               
               sbQuery.append("   FROM  transaction_history  WHERE   (init_company_id  =  '%s')  "); 
               sbQuery.append("   AND   (processor_reference = '%s')  AND   (sender_wallet =  '%s') "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), initCompanyId, processorReference, senderWallet));
                
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
                      this.logSessionId = rsx.getLong("log_session_id");
                    this.trxnEvent = rsx.getString("trxn_event");                 
                    this.trxnType =  rsx.getString("trxn_type");
                    this.trxnMode =  rsx.getString("trxn_mode");
                    this.debitCurrencyName =  rsx.getString("debit_currency_name");
                    this.debitCurrencyCode = rsx.getString("debit_currency_code");                 
                    this.debitCurrencySymbol =  rsx.getString("debit_currency_symbol");
                     this.currencyExchangeLogRefId = rsx.getLong("currency_exchange_log_ref_id");
                    this.currencyExchangeRate  =  rsx.getBigDecimal("currency_exchange_rate");
                    this.trxnStartDate =  rsx.getString("trxn_start_date");
                    this.trxnStartTime =  rsx.getString("trxn_start_time");
                    this.trxnEndDate =  rsx.getString("trxn_end_date");
                    this.trxnEndTime =  rsx.getString("trxn_end_time");
                    
                    this.senderName =  rsx.getString("sender_name");
                    this.senderWallet = rsx.getString("sender_wallet");        
                    this.senderBankCode =  rsx.getString("sender_bank_code");
                    this.senderWalletName = rsx.getString("sender_wallet_name");   
                    this.senderBank = rsx.getString("sender_bank");  
                    this.debitAmount =  rsx.getBigDecimal("debit_amount");
                    this.totalDebitAmount = rsx.getBigDecimal("total_debit_amount");                 
                    this.totalDebitFeeAmount =  rsx.getBigDecimal("total_debit_fee_amount");
                    this.trxnProcessCode =  rsx.getInt("trxn_process_code");
                    this.trxnStatusCode = rsx.getString("trxn_status_code");  
                    this.trxnStatus  = rsx.getString("trxn_status"); 
                    this.availBalanceBeforeTrxn =  rsx.getBigDecimal("avail_bal_before_trxn");
                    this.availBalanceAfterTrxn =  rsx.getBigDecimal("avail_bal_after_trxn"); 
                    
                    this.authUserId =  rsx.getLong("auth_user_id");
                    this.authFactor1KeyHash =  rsx.getLong("auth_factor_1_key_hash");
                    this.authFactor2KeyHash =  rsx.getLong("auth_factor_2_key_hash");
                    this.serviceProvider =  rsx.getString("service_provider");
                    this.serviceCustomerId =  rsx.getString("service_customer_id"); 
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
