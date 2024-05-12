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
public class Transaction  extends  PendingProcessTrxn {
                           
    
    
     
    public  Transaction(long inId, String inInitCompanyId,  String inPartnerCode,  String  inAppCode, 
                           String inProcessorNodeName,    String inProcessorNodeIP,String inTrxnRequestId, String inProcessorRef, 
                          String inTrxnReference,  long inBearerTokenHash,   long inProcessorAuthKeyHash, 
                             String inTrxnTypeId, long inLogSessionId, String inTrxnEvent, String inTrxnType,
                        String inTrxnMode, String inDebitCurrencyName, String inDebitCurrencyCode,  String  inDebitCurrencySymbol,
                        String inTrxnStartDate,  String inTrxnStartTime,   String inTrxnEndDate, String inTrxnEndTime,
                        String inSenderSchemeCode, String inSenderProfileTypeCode, String inSenderCustomerRef,
                        String inSenderName, String inSenderWallet,  long  inCurrencyExchangeLogRefId,  BigDecimal  inCurrencyExchangeRate,
                        String inRecieverSchemeCode, String inRecieverProfileTypeCode, String inRecieverCustomerRef,
                        String inRecieverName, String inRecieverBankCode,
                        String inRecieverAccount, String inRecieverBank, int inTrxnProcessCode, String inTrxnStatusCode,
                        String inTrxnStatus,  BigDecimal  inTotalTrxnAmount, BigDecimal  inTrxnValueAmount,
                        BigDecimal  inTotalTrxnFeeAmount, String inCreditCurrencyName, String inCreditCurrencyCode, 
                         String  inCreditCurrencySymbol, BigDecimal  inBonusCreditAmount, BigDecimal  inBonusDebitAmount,
                        BigDecimal  inAvailBalanceBeforeTrxn, BigDecimal  inAvailBalanceAfterTrxn, BigDecimal  inBookBalanceBeforeTrxn, 
                        BigDecimal  inBookBalanceAfterTrxn, long  inAuthUserId, long  inAuthFactor1KeyHash,
                        long  inAuthFactor2KeyHash, String  inPurchaseTokenEncrypt, String  inServiceProvider,
                        String  inServiceCustomerId, long  inPurchaseTokenHash, String  inProductProviderCustomerName,
                         String  inProductProviderCustomerAddress,  String  inTrxnDetail,  String  inNarration, String  inTrxnComment){
        
        super(inId,  inInitCompanyId,   inPartnerCode,   inAppCode,  inProcessorNodeName,    inProcessorNodeIP, 
                  inTrxnRequestId,   inProcessorRef,   inTrxnReference,  inBearerTokenHash, inProcessorAuthKeyHash, 
                     inTrxnTypeId,   inLogSessionId, inTrxnEvent,   inTrxnType,
                   inTrxnMode,   inDebitCurrencyName, inDebitCurrencyCode,  inDebitCurrencySymbol, 
                   inTrxnStartDate,   inTrxnStartTime,     inTrxnEndDate,  inTrxnEndTime,
             inSenderSchemeCode,  inSenderProfileTypeCode, inSenderCustomerRef, inSenderName,  inSenderWallet, 
            inCurrencyExchangeLogRefId,     inCurrencyExchangeRate, inRecieverSchemeCode,   inRecieverProfileTypeCode,  
                inRecieverCustomerRef,  inRecieverName,  inRecieverBankCode,  inRecieverAccount,  inRecieverBank, 
           inTrxnProcessCode,  inTrxnStatusCode,  inTrxnStatus,   inTotalTrxnAmount,   inTrxnValueAmount, inTotalTrxnFeeAmount,  
               inCreditCurrencyName,  inCreditCurrencyCode,   inCreditCurrencySymbol,  
            inBonusCreditAmount,   inBonusDebitAmount,  inAvailBalanceBeforeTrxn,   inAvailBalanceAfterTrxn, 
            inBookBalanceBeforeTrxn, inBookBalanceAfterTrxn,   inAuthUserId,   inAuthFactor1KeyHash,
            inAuthFactor2KeyHash,   inPurchaseTokenEncrypt,  inServiceProvider, inServiceCustomerId,  inPurchaseTokenHash,
               inProductProviderCustomerName, inProductProviderCustomerAddress,   inTrxnDetail, inNarration, inTrxnComment);               
    }
    
    
   
    
     
    public    boolean   createTransaction(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false;
           
                    
         StringBuilder  INSERT_TRANSACTION_SQL =  new StringBuilder(200);
            INSERT_TRANSACTION_SQL.append("INSERT  INTO  transaction_history  (init_company_id, partner_code,   ");
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
            INSERT_TRANSACTION_SQL.append(" product_provider_customer_address, is_debit_wallet_in_memory, is_credit_accnt_in_memory,  ");
            INSERT_TRANSACTION_SQL.append("  trxn_detail, narration,  trxn_comment)  VALUES  (?,?,?,?,?,?,?,?,?,?,?, "); 
            INSERT_TRANSACTION_SQL.append("  CURRENT_DATE, CURRENT_TIME,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");  
                   
            try { 
                        System.out.println("INSERT_TRANSACTION_SQL.toString() >>> "+INSERT_TRANSACTION_SQL.toString());
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
                        ps.setString(55, narration);                           
                        ps.setString(56, trxnComment); 

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
      
       
    
    private  final  int   updateTransaction(Connection    con) {         
         PreparedStatement ps  =    null; 
         int   resettedRecords = 0;
         
         StringBuilder  UPDATE_TRANSACTION_SQL =  new StringBuilder(200); 
         UPDATE_TRANSACTION_SQL.append(" UPDATE  transaction_history  SET  ");
         UPDATE_TRANSACTION_SQL.append(" trxn_end_date = CURRENT_DATE,  trxn_end_time = CURRENT_TIME,  ");
         UPDATE_TRANSACTION_SQL.append(" total_trxn_amount = ?,  total_trxn_fee_amount  = ?, ");
         UPDATE_TRANSACTION_SQL.append(" is_finalized  =  true, update_check  =  update_check + 1 "); 
         UPDATE_TRANSACTION_SQL.append("  WHERE  (init_company_id = ?)  AND (processor_reference = ?)  ");
         UPDATE_TRANSACTION_SQL.append("  AND (sender_wallet = ?)  AND (is_finalized = false) ");
                   
            try {                 
                     ps = con.prepareStatement(UPDATE_TRANSACTION_SQL.toString());
                     
                     ps.setBigDecimal(1, totalTrxnAmount);
                     ps.setBigDecimal(2, totalTrxnFeeAmount);
                     ps.setString(3, initCompanyId);
                     ps.setString(4, processorReference);
                     ps.setString(5, senderWallet);
                     
                    resettedRecords =  ps.executeUpdate(); 
                    
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                UPDATE_TRANSACTION_SQL = null; 
                try{
                    ps.close();
                    ps = null;
                }catch(Exception erx){
                    erx.printStackTrace();
                }
            } 
        return  resettedRecords;
    }
    
       
               
    public    boolean    retrieveTransaction(Connection  cron){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           int  recordCount   = 0;
           boolean  recordFound  = false;
           try {                  
               
               sbQuery.append("  SELECT  id, init_company_id, partner_code, application_code,    processor_node_name,  "); 
               sbQuery.append("  processor_node_ip, trxn_request_id,  trxn_reference,  processor_reference,  processor_auth_key_hash, "); 
               sbQuery.append("    trxn_type_id,   log_session_id, "); 
               sbQuery.append("    trxn_event, trxn_type, trxn_mode, debit_currency_name, debit_currency_code, debit_currency_symbol,  "); 
               sbQuery.append("   currency_exchange_log_ref_id,  currency_exchange_rate,    trxn_start_date,   ");
               sbQuery.append("  trxn_start_time, trxn_end_date, trxn_end_time,  sender_name, sender_wallet, reciever_name,  ");
               
               sbQuery.append("  reciever_bank_code,  reciever_account, reciever_bank, total_trxn_amount,   trxn_value_amount, ");
               sbQuery.append("  total_trxn_fee_amount,  credit_currency_name,  credit_currency_code, credit_currency_symbol,   ");
               sbQuery.append("    trxn_process_code, trxn_status_code, trxn_status,  bonus_credit_amount,  ");
               sbQuery.append("  bonus_debit_amount, avail_bal_before_trxn,  avail_bal_after_trxn,  book_bal_before_trxn, ");
               sbQuery.append("  book_bal_after_trxn, auth_user_id, auth_factor_1_key_hash,  auth_factor_2_key_hash,  service_provider,  ");
               sbQuery.append("  service_customer_id,  purchase_token_encrypt,  purchase_token_hash,  product_provider_customer_name, ");
               sbQuery.append("  product_provider_customer_address, trxn_detail,  narration, trxn_comment ");
               
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
                    this.trxnReference =  rsx.getString("trxn_reference");
                    this.processorReference =  rsx.getString("processor_reference");
                    this.processorAuthKeyHash =  rsx.getLong("processor_auth_key_hash");
                     this.trxnTypeId = rsx.getString("trxn_type_id");                 
                    this.logSessionId =  rsx.getLong("log_session_id");

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
                    this.recieverName =  rsx.getString("reciever_name");
                    this.senderName =  rsx.getString("reciever_bank_code");
                    this.senderWallet = rsx.getString("reciever_account");                 
                    this.recieverName =  rsx.getString("reciever_bank");
                    this.totalTrxnAmount =  rsx.getBigDecimal("total_trxn_amount");
                    this.trxnValueAmount = rsx.getBigDecimal("trxn_value_amount");                 
                    this.totalTrxnFeeAmount =  rsx.getBigDecimal("total_trxn_fee_amount");
                    this.trxnProcessCode =  rsx.getInt("trxn_process_code");
                    this.trxnStatusCode = rsx.getString("trxn_status_code");                 
                    this.trxnStatus =  rsx.getString("trxn_status");
                    this.bonusCreditAmount =  rsx.getBigDecimal("bonus_credit_amount");
                    this.bonusDebitAmount = rsx.getBigDecimal("bonus_debit_amount");                 
                    this.availBalanceBeforeTrxn =  rsx.getBigDecimal("avail_bal_before_trxn");
                    this.availBalanceAfterTrxn =  rsx.getBigDecimal("avail_bal_after_trxn");
                    this.bookBalanceBeforeTrxn =  rsx.getBigDecimal("book_bal_before_trxn");
                    this.bookBalanceAfterTrxn =  rsx.getBigDecimal("book_bal_after_trxn");
                    
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
                    this.isFinalized =  rsx.getBoolean("is_finalized");
                    this.updateCheck =  rsx.getInt("update_check");
                                        
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
