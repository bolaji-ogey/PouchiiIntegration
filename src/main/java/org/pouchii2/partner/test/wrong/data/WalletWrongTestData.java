/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.test.wrong.data;
  
 
import org.json.JSONObject;
import org.pouchii2.partner.base.AuthourizationInterface;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class WalletWrongTestData  extends     AuthourizationInterface {
    
    public static  final String   SEND_MONEY       = "/send-money";    // POST
    public static  final String   REQUEST_MONEY    = "/request-money";     // POST
    public static  final String   RETRIEVE_NUBAN   = "/nuban/retrieve/{phoneNumber}";   // POST
    public static  final String   RETRIEVE_NUBAN_BY_SCHEME  = "/customer-wallet-accounts-scheme/{phoneNumber}/{scheme}";  //  GET
    
    public static  final String   USER_WALLETS            = "/customer_wallet-accounts";   // GET
    public static  final String   LIST_OF_FUND_REQUESTS   = "/myinvoices";   // GET
    public static  final String   WALLET_TRXNS            = "/customer_debit_credit";   // GET
    public static  final String   WALLET_ACCOUNT_STATEMENT   = "/account-statement/{accountNumber}/{fromDate}/{toDate}";   // GET
    public static  final String   SPECIFIC_WALLET_TRXNS      = "/account_debit_credit/";   // GET
    
    public static  final String   ACCOUNT_BALANCE           = "/get-account-details/";   // GET
    
    public static  final String   USER_BENEFICIARY          = "/beneficiary/{phoneNumber}";   // GET
    public static  final String   DELETE_USER_BENEFICIARY   = "/beneficiaries/{id}";   // DELETE
    public static  final String   COMMERCIAL_BANKS          = "/banks/commercial";   // GET
    public static  final String   MICROFINANCE_BANKS        = "/banks/microfinance";   // GET
     
    public static  final String   VERIFY_ACCOUNT            = "/verify-account";    // POST
    public static  final String   CREATE_WALLET_EXTERNAL    = "/wallet-external";     // POST
  
  
        
      
    public  static JSONObject  getSendMoneyToWalletData(){
        return  new JSONObject()
            .put("accountNumber", "3492553479")
            .put("amount", 108.0)
            .put("channel", "wallettowallet")
            .put("sourceBankCode", "ADB")
            .put("sourceAccountNumber", "1869593834")
            .put("destBankCode", "039") 
            .put("pin", "1111")
            .put("transRef", "22311518724429")
            .put("narration", "My Pouchii - Init Test Funds")
            .put("walletAccount", true)
            .put("toBeSaved", true);
    }
      
       
    public  static JSONObject  getSendMoneyBulkTestData(){
        JSONObject[]  recptAccnts  =  new JSONObject[2];
        recptAccnts[1]
                     .put("accountNumber", "")
                     .put("amount", 100.0)
                     .put("bankCode", "");
        recptAccnts[2]
                     .put("accountNumber", "")
                     .put("amount", 100.0)
                     .put("bankCode", "");
        return  new JSONObject()
            .put("amount", "+2348095510360")
            .put("channel", "1111")
            .put("sourceBankCode", "MoneyWise123#")
            .put("sourceAccountNumber", "MoneyWise123#")
            .put("pin", "MoneyWise123#")
            .put("transRef", "500999954162455")
            .put("narration", "Sms Test Funds")
            .put("bulkAccountNos", recptAccnts);
        
    }
      
       
    public  static JSONObject  getSendMoneyToBankData(){
        return  new JSONObject()
            .put("accountNumber", "0003727404")
            .put("amount", 108.0)
            .put("channel", "wallettobank")
            .put("sourceBankCode", "ADB")
            .put("sourceAccountNumber", "1869593834")
            .put("destBankCode", "039") 
            .put("pin", "1111")
            .put("transRef", "22311518724429")
            .put("phoneNumber", "+2349333387423")
            .put("narration", "My Pouchii - Init Test Funds")
            .put("shortComment", "My comment")
            .put("beneficiaryName", "Bolaji Ogeyingbo")
            .put("walletAccount", true)
            .put("toBeSaved", true);
    }
    
     

   public  static JSONObject  getRequestMoneyTestData(){
        return  new JSONObject()
            .put("accountNumber", "3492553479")
            .put("amount", 108.0)
            .put("channel", "wallettowallet")
            .put("destBankCode", "ABC")
            .put("sourceAccountNumber", "1869593834")
            .put("sourceBankCode", "SPECS") 
            .put("transRef", "22311518724429");
    }
   
   
   
  public  static JSONObject  getAccountVerifyTestData(){
        return  new JSONObject()
            .put("accountNumber", "0003727404")
            .put("accountType", "bank")
            .put("bankCode", "039");
    }
  
  
 
  public  static JSONObject  getExternalWalletTestData(){
        return  new JSONObject()
            .put("phoneNumber", "+2349000797979")
            .put("firstName", "Nate")
            .put("lastName", "Dash")
            .put("password", "Bola@1234#")
            .put("pin", "5555")
            .put("dateOfBirth", "2019-02-20") 
            .put("gender", "MALE") 
            .put("state", "Lagos")
            .put("localGovt", "Eti-osa")
            .put("latitude", "6.605874") 
            .put("longitude", "3.349149") 
            .put("address", "Lagon Way, Lagos") 
            .put("scheme", "5061794d61737461")
            .put("accountName", "Paymasta Dashboard Access")
            .put("email", "bogeyingbo@gmail.com") 
            .put("photo", "9j4AAQSkZJRgABAQAAAQABAAD") ;
    }
  
  
  
 
   
   
   
   
}
   



