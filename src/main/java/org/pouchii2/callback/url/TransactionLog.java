/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.callback.url;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class TransactionLog {
    
     private  long  transactionId =  0L;
    private  String  transactionReference =  "";
    private  String  processorResponseCode =  ""; 
    private  String  processorResponseReference =  ""; 
    private  long  transactionStatusCode =  0L; 
    private  String  transactionStatus =  ""; 
    private  BigDecimal  transactionAmount =  new BigDecimal(0.00); 
    private  BigDecimal  transactionValueAmount =   new BigDecimal(100.00); 
    private  BigDecimal  transactionFeeAmount =   new BigDecimal(0.00); 
    private  BigDecimal  bonusPotCreditAmount =    new BigDecimal(0.00); 
    private  BigDecimal  bonusPotDebitAmount =   new BigDecimal(0.00);  
    
    private  String  customerReference =  "-"; 
    private  String  beneficiaryCustomerId =  "-"; 
    private  String  beneficiaryAccountName =  "";    
    private  String  beneficiaryAccountNumber =  ""; 
    private  String  beneficiaryBankName =  ""; 
    private  String  beneficiaryBankCode =  ""; 
    
    private  String  sourceAccountName =  ""; 
    private  String  sourceAccountNumber =  ""; 
    private  String  narration =  ""; 
    private  String  remark =  ""; 
    private  String  transactionStartDate =  ""; 
    private  String  transactionEndDate =  ""; 
    
    private  String  transactionMode =  ""; 
    
    ArrayList<TransactionFee>     transactionFees    =  new  ArrayList<>();
     
    public  TransactionLog(){};        
    
    public  TransactionLog(JSONObject  inResultData){
        
        transactionId = inResultData.getLong("transactionId");
        transactionReference = inResultData.getString("transactionReference");
        processorResponseCode = inResultData.getString("processorResponseCode");
        processorResponseReference = inResultData.getString("processorResponseReference");
        transactionStatus =  inResultData.getString("transactionStatus");
        transactionAmount = new BigDecimal(inResultData.getString("transactionAmount"));
        transactionValueAmount = new BigDecimal(inResultData.getString("transactionValueAmount"));
        transactionFeeAmount = new BigDecimal(inResultData.getString("transactionFeeAmount"));
        bonusPotCreditAmount = new BigDecimal(inResultData.getString("bonusPotCreditAmount"));
        bonusPotDebitAmount =  new BigDecimal(inResultData.getString("bonusPotDebitAmount"));
        
        customerReference =  inResultData.getString("customerReference");
        beneficiaryCustomerId =  inResultData.getString("beneficiaryCustomerId");
        beneficiaryAccountName =  inResultData.getString("beneficiaryAccountName");
        beneficiaryAccountNumber  =  inResultData.getString("beneficiaryAccountNumber");
        beneficiaryBankName  = inResultData.getString("beneficiaryBankName");
        beneficiaryBankCode  = inResultData.getString("beneficiaryBankCode");
        sourceAccountName  = inResultData.getString("sourceAccountName");
        sourceAccountNumber  = inResultData.getString("sourceAccountNumber");
        
        narration  = inResultData.getString("narration");
        transactionStartDate = inResultData.getString("transactionStartDate");
        transactionEndDate =  inResultData.getString("transactionEndDate");
        transactionMode = inResultData.getString("transactionMode");
        
        
        JSONArray  inTrxnFees  =   inResultData.getJSONArray("transactionFees");
        for(int v = 0; v < inTrxnFees.length();  v++){
            TransactionFee   transactionFee =  new TransactionFee((JSONObject)inTrxnFees.get(v));
            transactionFee.logOut();
            transactionFees.add(transactionFee);
        }
    }
    
    
    
    public  TransactionLog(long  inTransId, String inTransRef, String inRespCode, String inRespRef, long inTransStatusCode,
                          String inTransStatus,  BigDecimal  inTransAmount,  BigDecimal  inTransValueAmount, 
                             BigDecimal  inTransFeeAmount,  BigDecimal  inBonusPotCreditAmount, BigDecimal  inBonusPotDebitAmount, 
                               String  inCustomerReference,  String  inBenefCustomerId, 
                             String  inBenefAccountName,  String  inBenefAccountNumber, String  inBenefBankName,  String  inBenefBankCode, 
                                String  inSourceAccountName,  String  inSourceAccountNumber,  String  inNarration,  String  inRemarks,  
                                 String  inTransStartDate, String  inTransEndDate, String  inTransMode){
        
        transactionId = inTransId;
        transactionReference =  inTransRef;
        processorResponseCode = inRespCode;
        processorResponseReference = inRespRef;
        transactionStatusCode = inTransStatusCode;
        transactionStatus = inTransStatus;
        transactionAmount = inTransAmount;
        transactionValueAmount = inTransValueAmount;
        transactionFeeAmount = inTransFeeAmount;
        bonusPotCreditAmount =  inBonusPotCreditAmount;
        bonusPotDebitAmount =  inBonusPotDebitAmount;
        
        customerReference =  inCustomerReference;
        beneficiaryCustomerId =  inBenefCustomerId;
        beneficiaryAccountName =  inBenefAccountName;
        beneficiaryAccountNumber  =  inBenefAccountNumber;
        beneficiaryBankName  = inBenefBankName;
        beneficiaryBankCode  = inBenefBankCode;
        sourceAccountName  = inSourceAccountName;
        sourceAccountNumber  = inSourceAccountNumber;
        
        narration  = inNarration;
        remark = inRemarks;
        transactionStartDate = inTransStartDate;
        transactionEndDate =  inTransEndDate;
        transactionMode = inTransMode; 
    }
    
    
   
    
    public  void  logOut(){
        System.out.println("transactionId  --> "+transactionId);
        System.out.println("transactionReference  --> "+transactionReference);
        System.out.println("processorResponseCode  --> "+processorResponseCode);
        System.out.println("processorResponseReference  --> "+processorResponseReference);
         System.out.println("transactionStatusCode  --> "+transactionStatusCode);
        System.out.println("transactionStatus  --> "+transactionStatus);
        System.out.println("transactionAmount  --> "+transactionAmount);
        System.out.println("transactionValueAmount  --> "+transactionValueAmount);
        System.out.println("transactionFeeAmount  --> "+transactionFeeAmount);
        
        System.out.println("bonusPotCreditAmount  --> "+bonusPotCreditAmount);
        System.out.println("bonusPotDebitAmount  --> "+bonusPotDebitAmount);
        
        System.out.println("customerReference  --> "+customerReference);
        System.out.println("beneficiaryCustomerId  --> "+beneficiaryCustomerId);
        System.out.println("beneficiaryAccountName  --> "+beneficiaryAccountName);
        System.out.println("beneficiaryAccountNumber  --> "+beneficiaryAccountNumber);
        System.out.println("beneficiaryBankName  --> "+beneficiaryBankName);
        System.out.println("beneficiaryBankCode  --> "+beneficiaryBankCode);
        System.out.println("sourceAccountName  --> "+sourceAccountName);
        System.out.println("sourceAccountNumber  --> "+sourceAccountNumber);
        System.out.println("narration  --> "+narration);
        System.out.println("transactionStartDate  --> "+transactionStartDate);
        System.out.println("transactionEndDate  --> "+transactionEndDate);
        System.out.println("transactionMode  --> "+transactionMode); 
    
        
    }
 
    
    
    public  void  setStatusCode(long inStatusCode){
        transactionStatusCode =  inStatusCode;
    }
    
    
    public  long  getTransStatusCode(){
        return  transactionStatusCode;
    }
    
    public  String  getTransStatus(){
       return transactionStatus;
    }
    
    public  String  getTransRef(){
       return transactionReference;
    }
    
    public  String  getProcessorRespRef(){
       return processorResponseReference;
    }

    
    public  String  getProcessorRespCode(){
       return processorResponseCode;
    }
    
    public  String  getCustomerReference(){
       return   customerReference;
    }
    
    public  String  getBeneficiaryCustomerId(){
       return  beneficiaryCustomerId;
    }
    
    public  void  setTransactionValueAmount(BigDecimal  inTrxnValueAmount){
         transactionValueAmount = inTrxnValueAmount;
    }
    
    public  BigDecimal  getTransactionValueAmount(){
       return  transactionValueAmount;
    }

   public int  recordTransactionLog(Connection    con) {
           
         int recordsInserted = 0;
         PreparedStatement ps  =    null;
         
        StringBuilder  TRANS_LOG_FIELDS = new StringBuilder(300);
        TRANS_LOG_FIELDS.append(" trans_id, trans_ref, processor_resp_code,  processor_resp_ref,  trans_status_code, trans_status, ");
        TRANS_LOG_FIELDS.append(" trans_amount, trans_value, total_trans_fees,  bonus_pot_debit_amount, bonus_pot_credit_amount, ");
        TRANS_LOG_FIELDS.append(" customer_reference,  beneficiary_customer_id, beneficiary_account_name, beneficiary_bank_code,  ");
        TRANS_LOG_FIELDS.append("   beneficiary_bank_name,  beneficiary_account_number, source_account_number,  ");
        TRANS_LOG_FIELDS.append("  source_account_name,  narration, remark, trans_start_date, trans_end_date,   trans_mode ");
            
            try { 
                
                String rwInsertString =   "INSERT  INTO  transaction_log (%s) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                String  insertString = String.format(rwInsertString, TRANS_LOG_FIELDS.toString());

                 ps = con.prepareStatement(insertString); 
                  
                // Parameters start with 1
                ps.setLong(1, transactionId);
                ps.setString(2, transactionReference);  
                ps.setString(3, processorResponseCode);
                ps.setString(4, processorResponseReference);                   
                ps.setLong(5,  transactionStatusCode); 
                ps.setString(6,  transactionStatus);
                ps.setBigDecimal(7,  transactionAmount);   
                ps.setBigDecimal(8,  transactionValueAmount); 
                ps.setBigDecimal(9,  transactionFeeAmount); 
                
                ps.setBigDecimal(10,  bonusPotDebitAmount); 
                ps.setBigDecimal(11,  bonusPotCreditAmount); 
                ps.setString(12, customerReference); 
                ps.setString(13, beneficiaryCustomerId); 
                ps.setString(14, beneficiaryAccountName); 
                ps.setString(15, beneficiaryBankCode);  
                ps.setString(16, beneficiaryBankName); 
                ps.setString(17, beneficiaryAccountNumber); 
                
                ps.setString(18, sourceAccountNumber); 
                ps.setString(19, sourceAccountName); 

                ps.setString(20, narration); 
                ps.setString(21, remark);
                ps.setString(22, transactionStartDate);
                ps.setString(23, transactionEndDate);
                ps.setString(24, transactionMode);

                recordsInserted = ps.executeUpdate();
                
               
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try{
                    ps.close();
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
          return  recordsInserted;
         }
   
   
   
   

 public     ArrayList<TransactionLog>   getTransactionLogs(Connection  con, final String  filter){
             
           int index =  0; 
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmnt =    null;
           ResultSet rs = null;
           ArrayList<TransactionLog>   transLogs =   new ArrayList<>();
            
           try {  
               
                
                sbQuery.append(" SELECT  trans_id, trans_ref, processor_resp_code,  processor_resp_ref,  trans_status_code, trans_status, ");
                sbQuery.append(" trans_amount, trans_value, total_trans_fees,  bonus_pot_credit_amount, bonus_pot_debit_amount, ");
                sbQuery.append("  customer_reference, beneficiary_customer_id,  beneficiary_account_name, beneficiary_account_number, ");
                sbQuery.append("   beneficiary_bank_name, beneficiary_bank_code,   source_account_name, source_account_number,  ");
                sbQuery.append("  narration, remark, trans_start_date, trans_end_date,   trans_mode  FROM     transaction_log  ");
                sbQuery.append(filter);

                 
                stmnt =    con.createStatement();
                rs = stmnt.executeQuery(sbQuery.toString());
                  
                // Parameters start with 1
                while (rs.next()) {                    
                    
                    TransactionLog   transLog  =  new  TransactionLog(rs.getLong("trans_id"),   rs.getString("trans_ref"),
                            rs.getString("processor_resp_code"), rs.getString("processor_resp_ref"), 
                            rs.getLong("trans_status_code"), rs.getString("trans_status"), rs.getBigDecimal("trans_amount"), 
                             rs.getBigDecimal("trans_value"), rs.getBigDecimal("total_trans_fees"), 
                            rs.getBigDecimal("bonus_pot_credit_amount"), rs.getBigDecimal("bonus_pot_debit_amount"), 
                            rs.getString("customer_reference"), 
                       rs.getString("beneficiary_customer_id"),    rs.getString("beneficiary_account_name"),   
                     rs.getString("beneficiary_account_number"),  rs.getString("beneficiary_bank_name"),  
                            rs.getString("beneficiary_bank_code"), rs.getString("source_account_name"),  
                            rs.getString("source_account_number"),  rs.getString("narration"),   rs.getString("remark"),      
                           rs.getString("trans_start_date"), rs.getString("trans_end_date"),  rs.getString("trans_mode")); 
                    
                    transLogs.add(transLog); 
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{
                     stmnt.close();
                    stmnt = null;
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
           return   transLogs;
       } 
    
 




 public      TransactionLog    getTransactionLog(Connection  con){
             
           TransactionLog   transLog  = null; 
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
            
           try {  
               
                
                sbQuery.append(" SELECT  trans_id, trans_ref, processor_resp_code,  processor_resp_ref,  trans_status_code, trans_status, ");
                sbQuery.append(" trans_amount, trans_value, total_trans_fees,  bonus_pot_credit_amount, bonus_pot_debit_amount, ");
                 sbQuery.append(" customer_reference, ");
                sbQuery.append("  beneficiary_customer_id,  beneficiary_account_name, beneficiary_account_number,  beneficiary_bank_name, ");
                sbQuery.append("  beneficiary_bank_code,   source_account_name, source_account_number, narration, remark, ");
                sbQuery.append("   trans_start_date, trans_end_date,   trans_mode  FROM     transaction_log   ");
                 sbQuery.append("   WHERE id =  (select max(id) from transaction_log)   ");
                stmntx =    con.createStatement();
                rsx = stmntx.executeQuery(sbQuery.toString());
                  
                // Parameters start with 1
                while (rsx.next()) {                    
                                    
                    transactionId =  rsx.getLong("trans_id");
                    transactionReference =  rsx.getString("trans_ref");
                    processorResponseCode = rsx.getString("processor_resp_code");
                    processorResponseReference = rsx.getString("processor_resp_ref");
                    transactionStatusCode = rsx.getLong("trans_status_code");
                    transactionStatus = rsx.getString("trans_status");
                    transactionAmount = rsx.getBigDecimal("trans_amount");
                    transactionValueAmount = rsx.getBigDecimal("trans_value");
                    transactionFeeAmount = rsx.getBigDecimal("total_trans_fees");
                    bonusPotCreditAmount =  rsx.getBigDecimal("bonus_pot_credit_amount");
                    bonusPotDebitAmount =  rsx.getBigDecimal("bonus_pot_debit_amount");

                    customerReference =  rsx.getString("customer_reference");
                    beneficiaryCustomerId =  rsx.getString("beneficiary_customer_id");
                    beneficiaryAccountName =  rsx.getString("beneficiary_account_name");
                    beneficiaryAccountNumber  =  rsx.getString("beneficiary_account_number");
                    beneficiaryBankName  = rsx.getString("beneficiary_bank_name");
                    beneficiaryBankCode  = rsx.getString("beneficiary_bank_code");
                    sourceAccountName  = rsx.getString("source_account_name");
                    sourceAccountNumber  = rsx.getString("source_account_number");

                    narration  = rsx.getString("narration");
                    remark = rsx.getString("remark");
                    transactionStartDate = rsx.getString("trans_start_date");
                    transactionEndDate =  rsx.getString("trans_end_date");
                    transactionMode =  rsx.getString("trans_mode"); 
        
          transLog  =  new  TransactionLog(rsx.getLong("trans_id"),   rsx.getString("trans_ref"),
                            rsx.getString("processor_resp_code"), rsx.getString("processor_resp_ref"), 
                            rsx.getLong("trans_status_code"), rsx.getString("trans_status"), rsx.getBigDecimal("trans_amount"), 
                             rsx.getBigDecimal("trans_value"), rsx.getBigDecimal("total_trans_fees"), 
                            rsx.getBigDecimal("bonus_pot_credit_amount"), rsx.getBigDecimal("bonus_pot_debit_amount"), 
                           rsx.getString("customer_reference"), 
                       rsx.getString("beneficiary_customer_id"),    rsx.getString("beneficiary_account_name"),   
                     rsx.getString("beneficiary_account_number"),  rsx.getString("beneficiary_bank_name"),  
                            rsx.getString("beneficiary_bank_code"), rsx.getString("source_account_name"),  
                            rsx.getString("source_account_number"),  rsx.getString("narration"),   rsx.getString("remark"),      
                           rsx.getString("trans_start_date"), rsx.getString("trans_end_date"),  rsx.getString("trans_mode")); 
                       
                     
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
           return   transLog;
       } 
    
 
 
 
 
 
 
   public int  updateWalletBalance(Connection    con) {
           
         int recordsInserted = 0;
         PreparedStatement ps  =    null;
         
          String   WALLET_UPDATE_SQL
          =    "UPDATE  mini_wallet  SET  previous_balance =  balance,  balance = balance + %.2f  WHERE customer_reference = '%s'";
           
            try {
 
                 ps = con.prepareStatement(String.format(WALLET_UPDATE_SQL, transactionValueAmount,  customerReference));
                 
                 recordsInserted = ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try{
                    ps.close();
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
          return  recordsInserted;
    }
   
   
   
   
   
   
   
 public   long    getTrxnHistoryColumnRef(Connection  con){
             
           TransactionLog   transLog  = null; 
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           long   trxnHistoryColumnRef =  0;
            
           try {  
                
                sbQuery.append("  SELECT  current_column_ref  FROM   transaction_history   ");
               sbQuery.append("  WHERE  customer_reference  =  '%s'   ");
               sbQuery.append("  AND (id  = (SELECT MAX(id) FROM  transaction_history  WHERE   customer_reference = '%s')) ");
         
                stmntx =    con.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), customerReference, customerReference));
                  
                // Parameters start with 1
                while (rsx.next()) {                    
                                    
                    trxnHistoryColumnRef =  rsx.getLong("current_column_ref");  
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
           return   trxnHistoryColumnRef;
       } 
    
 
 
 
   
   public int  updateTrxnHistory(Connection    con, long  inCurrentColumnRef) {
           
         PreparedStatement ps  =    null; 
         int recordsInserted = 0;
         
         StringBuilder  UPDATE_TRXN_HIST_SQL =  new StringBuilder(200); 
         
         UPDATE_TRXN_HIST_SQL.append("UPDATE  transaction_history  SET  current_column_ref =  ");
         UPDATE_TRXN_HIST_SQL.append("    current_column_ref + 1,  trxn_date_%d =  CURRENT_DATE,  ");
         UPDATE_TRXN_HIST_SQL.append("  trxn_time_%d =  CURRENT_TIME,   trxn_amount_%d  =  %.2f,  trxn_fee_%d  =  %.2f  ");
         UPDATE_TRXN_HIST_SQL.append("   WHERE  (customer_reference = '%s')   AND  (current_column_ref <=  7)  ");
         UPDATE_TRXN_HIST_SQL.append("  AND (id  = (SELECT MAX(id) FROM  transaction_history  WHERE   customer_reference = '%s')) ");
         
            try {
 
                if(inCurrentColumnRef <= 7 ){
                    ps = con.prepareStatement(String.format(UPDATE_TRXN_HIST_SQL.toString(),   inCurrentColumnRef, 
                                inCurrentColumnRef, inCurrentColumnRef, transactionValueAmount,  inCurrentColumnRef,
                                transactionFeeAmount, customerReference,  customerReference));

                    recordsInserted = ps.executeUpdate();
                }
                 
                  if(inCurrentColumnRef > 7 || recordsInserted == 0){
                     StringBuilder  INSERT_TRXN_HIST_SQL =  new StringBuilder(200);
                     
                     INSERT_TRXN_HIST_SQL.append("INSERT  INTO  transaction_history  (current_column_ref,  ");
                     INSERT_TRXN_HIST_SQL.append(" customer_reference,  trxn_date_0, trxn_time_0,  trxn_amount_0, ");
                     INSERT_TRXN_HIST_SQL.append("   trxn_fee_0) VALUES (1, '%s', CURRENT_DATE,  CURRENT_TIME,  %.2f, %.2f) ");
                   
                     ps = con.prepareStatement(String.format(INSERT_TRXN_HIST_SQL.toString(),   
                                    customerReference, transactionValueAmount, transactionFeeAmount));
                 
                      recordsInserted = ps.executeUpdate();
                 }

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try{
                     ps.close();  ps =  null;
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
          return  recordsInserted;
    }
   
   
   
   
   
   
      
 public   long    getWalletBalHistoryColumnRef(Connection  con){
             
           TransactionLog   transLog  = null; 
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           long   trxnHistoryColumnRef =  0;
            
           try {  
                
                sbQuery.append("  SELECT  current_column_ref  FROM   wallet_balance_compact_history   ");
               sbQuery.append("  WHERE  customer_reference  =  '%s'   ");
               sbQuery.append("  AND (id  = (SELECT MAX(id) FROM  wallet_balance_compact_history  WHERE   customer_reference = '%s')) ");
         
                stmntx =    con.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), customerReference, customerReference));
                  
                // Parameters start with 1
                while (rsx.next()) {                    
                                    
                    trxnHistoryColumnRef =  rsx.getLong("current_column_ref");  
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
           return   trxnHistoryColumnRef;
       } 
 
 
 
   
   public int  updateWalletBalanceHistory(Connection    con, long  inCurrentColumnRef) {
           
         int recordsInserted = 0;
         PreparedStatement ps  =    null; 
        
          StringBuilder  UPDATE_BAL_HIST_SQL =  new StringBuilder(200);
         UPDATE_BAL_HIST_SQL.append("UPDATE  wallet_balance_compact_history SET  current_column_ref =  ");
         UPDATE_BAL_HIST_SQL.append("    current_column_ref + 1, balance_%d_change_date =  CURRENT_DATE,  ");
         UPDATE_BAL_HIST_SQL.append(" balance_%d_change_time =  CURRENT_TIME,   balance_%d  =   %.2f  ");
         UPDATE_BAL_HIST_SQL.append("    WHERE  (customer_reference = '%s')   AND  (current_column_ref <=  7) ");
         UPDATE_BAL_HIST_SQL.append("  AND (id  = (SELECT MAX(id) FROM  wallet_balance_compact_history WHERE   customer_reference = '%s')) ");
         
            try {
 
                 if(inCurrentColumnRef <= 7 ){
                    ps = con.prepareStatement(String.format(UPDATE_BAL_HIST_SQL.toString(),  inCurrentColumnRef, 
                                              inCurrentColumnRef, inCurrentColumnRef, transactionValueAmount,  
                                                      customerReference, customerReference));

                    recordsInserted = ps.executeUpdate();
                 }
                 
                 if(inCurrentColumnRef > 7 || recordsInserted == 0){
                     StringBuilder  INSERT_BAL_HIST_SQL =  new StringBuilder(200);
                     INSERT_BAL_HIST_SQL.append("INSERT  INTO  wallet_balance_compact_history  (current_column_ref,   ");
                     INSERT_BAL_HIST_SQL.append(" customer_reference,  balance_0_change_date, balance_0_change_time,  ");
                     INSERT_BAL_HIST_SQL.append("   balance_0) VALUES (1, '%s',CURRENT_DATE,  CURRENT_TIME,  %.2f) ");
                   
                     ps = con.prepareStatement(String.format(INSERT_BAL_HIST_SQL.toString(),  
                                                             customerReference, transactionValueAmount));
                 
                      recordsInserted = ps.executeUpdate();
                 }

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try{
                    ps.close();
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
          return  recordsInserted;
    }
   
   
   
 
}
