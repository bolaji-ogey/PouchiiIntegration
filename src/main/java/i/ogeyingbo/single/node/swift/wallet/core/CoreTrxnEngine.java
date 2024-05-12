/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.swift.wallet.core;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CoreTrxnEngine   extends  SingleNodeTrxnEngine {
    
    /***
    protected  String  trxnReference = "";
    protected  String  sourceAccountNo = "";
    protected  String  beneficiaryAccountNo = "";
    
    protected  BigDecimal  trxnValueAmount = new BigDecimal(0.00);
    
    protected  String  debitWalletTable = "";
    protected  String  creditWalletTable = "";
    ***/ 
    
    
     
     
      
     
     
 public    boolean   decryptWalletBalance(Connection    con, String  InWalletAcctNo, 
                                                   String  inWalletTableName,  long  inLogSessionId) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordUpdtd  = false; 
         
         /***
         update  test_wallets set current_balance_plain = (select
       cast(PGP_SYM_DECRYPT(decode(current_balance, 'BASE64'),  'AES_KEY') as decimal)   from test_wallets where  id = 4)  where id = 4;
       ***/
         /***
           StringBuilder  SET_WALLET_PLAIN_BAL_SQL =  new StringBuilder(200);
            SET_WALLET_PLAIN_BAL_SQL.append("UPDATE  ?   SET  available_balance_plain  =  (SELECT  ");
           SET_WALLET_PLAIN_BAL_SQL.append("  cast(PGP_SYM_DECRYPT(decode(available_balance, 'BASE64'), 'AES_KEY') as decimal(15,2))  ");
           SET_WALLET_PLAIN_BAL_SQL.append("   FROM  ?  WHERE  (wallet_acct_no = ?)) ");
           SET_WALLET_PLAIN_BAL_SQL.append("  WHERE  (wallet_acct_no = ?)   AND (sys_acct_lock = 'N') AND (log_session_id  =  -1)  ");
          ***/
           
         StringBuilder  SET_WALLET_PLAIN_BAL_SQL =  new StringBuilder(200);
            SET_WALLET_PLAIN_BAL_SQL.append("UPDATE  ?   SET  available_balance_plain  =  (SELECT  ");
           SET_WALLET_PLAIN_BAL_SQL.append("  cast(PGP_SYM_DECRYPT(decode(available_balance, 'BASE64'), 'AES_KEY') as decimal(15,2))  ");
            SET_WALLET_PLAIN_BAL_SQL.append("   FROM  ?  WHERE  (wallet_acct_no = ?)), ");
           SET_WALLET_PLAIN_BAL_SQL.append("  daily_cummulative_debit_plain   =  ");
            SET_WALLET_PLAIN_BAL_SQL.append(" cast(PGP_SYM_DECRYPT(decode(daily_cummulative_debit, 'BASE64'), 'AES_KEY') as decimal(15,2)) ");
             SET_WALLET_PLAIN_BAL_SQL.append("   FROM  ?  WHERE  (wallet_acct_no = ?)), ");
            SET_WALLET_PLAIN_BAL_SQL.append("  daily_cummulative_credit_plain   =  ");
            SET_WALLET_PLAIN_BAL_SQL.append(" cast(PGP_SYM_DECRYPT(decode(daily_cummulative_credit, 'BASE64'), 'AES_KEY') as decimal(15,2))  ");
            SET_WALLET_PLAIN_BAL_SQL.append("   FROM  ?  WHERE  (wallet_acct_no = ?)) ");
           SET_WALLET_PLAIN_BAL_SQL.append("  WHERE  (wallet_acct_no = ?)   AND (sys_acct_lock = 'N') AND (log_session_id  =  -1) ");
            
          
            try { 
                   
                        ps = con.prepareStatement(String.format(SET_WALLET_PLAIN_BAL_SQL.toString()));
                                 
                        ps.setString(1, inWalletTableName); 
                        ps.setString(2, inWalletTableName);
                        ps.setString(3, InWalletAcctNo);
                        ps.setString(4, inWalletTableName);
                        ps.setString(5, InWalletAcctNo);
                        ps.setString(6, inWalletTableName);
                        ps.setString(7, InWalletAcctNo);
                        ps.setString(8, InWalletAcctNo); 
                        

                        isRecordUpdtd  =  (ps.executeUpdate() == 1);    
                                           
            } catch (Exception e) {
                e.printStackTrace();
            }finally{ 
                SET_WALLET_PLAIN_BAL_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordUpdtd;
    }
      
        
    
    
    
     // STEP  2  -- Pre-Value Transaction
    public    boolean   debitTotalTrxnValueIntoTransitHold(Connection    con, String  inWalletAcctNo, String  inWalletTableName, 
                                         long  inLogSessionId,  String inTrxnSerial,  BigDecimal  inTrxnValueAmount) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
           
         StringBuilder  UPDATE_WALLET_BAL_SQL =  new StringBuilder(200);
            UPDATE_WALLET_BAL_SQL.append("UPDATE  ?   SET  available_balance_plain  =  (available_balance_plain - ? ), "); 
            UPDATE_WALLET_BAL_SQL.append(" available_balance   =  '_', "); 
            UPDATE_WALLET_BAL_SQL.append("  daily_cummulative_debit_plain   =   daily_cummulative_debit_plain  + 1,  "); 
            UPDATE_WALLET_BAL_SQL.append("   debit_count   =   debit_count  + 1   "); 
            UPDATE_WALLET_BAL_SQL.append("    WHERE  (wallet_acct_no = ?) AND (log_session_id  =  ?)   ");
             UPDATE_WALLET_BAL_SQL.append("  AND (sys_acct_lock = 'N' AND (available_balance_plain >=  ?) ");
          
            try { 
                        
                        ps = con.prepareStatement(String.format(UPDATE_WALLET_BAL_SQL.toString()));
                                 
                        ps.setString(1, inWalletTableName); 
                        ps.setBigDecimal(2, inTrxnValueAmount);
                        ps.setString(3, inWalletAcctNo); 
                        ps.setLong(4, inLogSessionId);                                                                                                                                                                                                                                                                                                                                                                
                        ps.setBigDecimal(5, inTrxnValueAmount);

                        isRecordInserted  =  (ps.executeUpdate() == 1);    
                                           
            } catch (Exception e) {
                e.printStackTrace();
            }finally{ 
                UPDATE_WALLET_BAL_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }
    
    
    
    
    
    
     // STEP  2  -- Pre-Value Transaction
    public    boolean   creditTrxnValueIntoWalletBalance(Connection    con,  String  inWalletAcctNo, String  inWalletTableName, 
                                           long  inLogSessionId, String inTrxnSerial,  BigDecimal  inTrxnValueAmount) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
           
         StringBuilder  UPDATE_WALLET_BAL_SQL =  new StringBuilder(200);
            UPDATE_WALLET_BAL_SQL.append("UPDATE  ?   SET  available_balance_plain  =  (available_balance_plain + ? ), "); 
            UPDATE_WALLET_BAL_SQL.append(" available_balance   =  '_', "); 
            UPDATE_WALLET_BAL_SQL.append("  daily_cummulative_credit_plain   =   daily_cummulative_credit_plain  + 1,  "); 
            UPDATE_WALLET_BAL_SQL.append("   credit_count   =   credit_count  + 1   "); 
            UPDATE_WALLET_BAL_SQL.append("    WHERE  (wallet_acct_no = ?) AND (log_session_id  =  ?) AND (sys_acct_lock = 'N'  "); 
          
            try { 
                        
                        ps = con.prepareStatement(String.format(UPDATE_WALLET_BAL_SQL.toString()));
                                 
                        ps.setString(1, inWalletTableName); 
                        ps.setBigDecimal(2, trxnValueAmount);
                        ps.setString(3, inWalletAcctNo); 
                        ps.setLong(4, inLogSessionId);   
                         

                        isRecordInserted  =  (ps.executeUpdate() == 1);    
                                           
            } catch (Exception e) {
                e.printStackTrace();
            }finally{ 
                UPDATE_WALLET_BAL_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }
    
    
    
    
     // STEP 3
    public    boolean   encryptWalletBalance(Connection    con, String  InWalletAcctNo, 
                                                   String  inWalletTableName,  long  inLogSessionId) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordUpdtd  = false; 
         /**
        update  test_wallets  set  current_balance = (select  encode(PGP_SYM_ENCRYPT(cast(current_balance_plain as text),'AES_KEY'), 'BASE64')::text 
          from test_wallets where  id = 4)  where id = 4; 
         **/
          /**
            StringBuilder  SET_WALLET_PLAIN_BAL_SQL =  new StringBuilder(200);
            SET_WALLET_PLAIN_BAL_SQL.append("UPDATE  ?   SET  available_balance   =   (SELECT ");
           SET_WALLET_PLAIN_BAL_SQL.append("  encode(PGP_SYM_ENCRYPT(cast(available_balance_plain as text), 'BASE64'), 'AES_KEY')::text "); 
            SET_WALLET_PLAIN_BAL_SQL.append("  FROM  ?  WHERE (wallet_acct_no = ?))  WHERE  (wallet_acct_no = ?) AND (log_session_id  =  ?) AND (sys_acct_lock = 'N') ");
           **/
          
         StringBuilder  SET_WALLET_PLAIN_BAL_SQL =  new StringBuilder(200);
         
            SET_WALLET_PLAIN_BAL_SQL.append("UPDATE  ?   SET  available_balance   =   (SELECT ");
           SET_WALLET_PLAIN_BAL_SQL.append("  encode(PGP_SYM_ENCRYPT(cast(available_balance_plain as text), 'BASE64'), 'AES_KEY')::text ");
             SET_WALLET_PLAIN_BAL_SQL.append("  FROM  ?  WHERE  (wallet_acct_no = ?)), ");
           SET_WALLET_PLAIN_BAL_SQL.append("  daily_cummulative_debit  =  (SELECT  ");
            SET_WALLET_PLAIN_BAL_SQL.append(" encode(PGP_SYM_ENCRYPT(cast(daily_cummulative_debit_plain as text), 'BASE64'), 'AES_KEY')::text ");
              SET_WALLET_PLAIN_BAL_SQL.append("  FROM  ?  WHERE  (wallet_acct_no = ?)), ");
            SET_WALLET_PLAIN_BAL_SQL.append("  daily_cummulative_credit  =  (SELECT  ");
            SET_WALLET_PLAIN_BAL_SQL.append("  encode(PGP_SYM_ENCRYPT(cast(daily_cummulative_credit_plain as text), 'BASE64'), 'AES_KEY')::text ");
            SET_WALLET_PLAIN_BAL_SQL.append("  FROM  ?  WHERE  (wallet_acct_no = ?)),  SET   log_session_id  =  -1 ");
            SET_WALLET_PLAIN_BAL_SQL.append(" WHERE  (wallet_acct_no = ?)   AND (sys_acct_lock = 'N') ");
          
            try { 
                   
                        ps = con.prepareStatement(String.format(SET_WALLET_PLAIN_BAL_SQL.toString()));
                                 
                        ps.setString(1, inWalletTableName); 
                        ps.setString(2, inWalletTableName);
                        ps.setString(3, InWalletAcctNo);
                        ps.setString(4, inWalletTableName); 
                        ps.setString(5, InWalletAcctNo);
                        ps.setString(6, inWalletTableName); 
                        ps.setString(7, InWalletAcctNo);
                        ps.setString(8, InWalletAcctNo);                                                                                                                                                                                                                                                                          
                        

                        isRecordUpdtd  =  (ps.executeUpdate() == 1);    
                                           
            } catch (Exception e) {
                e.printStackTrace();
            }finally{ 
                SET_WALLET_PLAIN_BAL_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordUpdtd;
    }
      
       
}
