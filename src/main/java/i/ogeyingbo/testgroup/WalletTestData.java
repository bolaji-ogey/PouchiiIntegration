/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.testgroup;

import org.json.JSONArray;
import org.json.JSONObject;
import static org.slf4j.MDC.put;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class WalletTestData {
    
    public static  final String   SEND_MONEY       = "/send-money";    // POST
    public static  final String   REQUEST_MONEY    = "/request-money";     // POST
    public static  final String   RETRIEVE_NUBAN   = "/nuban/retrieve/{phoneNumber}";   // POST
    public static  final String   RETRIEVE_NUBAN_BY_SCHEME  = "/customer-wallet-accounts-scheme/{phoneNumber}/{scheme}";  //  GET
    
    public static  final String   USER_WALLETS            = "/customer_wallet-accounts";   // GET
    public static  final String   LIST_OF_REQUEST_FUNDS   = "/myinvoices";   // GET
    public static  final String   WALLET_TRXNS_URL_EXT            = "/customer_debit_credit";   // GET
    public static    String   WALLET_ACCOUNT_STATEMENT   = "/account-statement/{walletID}/{fromDate}/{toDate}";   // GET
    public static    String   WALLET_ACCOUNT_STATEMENT_TEST   = "/account-statement";   // GET
    public static  final String   SPECIFIC_WALLET_TRXNS      = "/account_debit_credit/{walletID}";   // GET
    
    public static  final String   ACCOUNT_BALANCE           = "/get-account-details/";   // GET
    
    public static  final String   USER_BENEFICIARY          = "/beneficiary/{phoneNumber}";   // GET
    public static  final String   DELETE_USER_BENEFICIARY   = "/beneficiaries/{id}";   // DELETE
    public static  final String   COMMERCIAL_BANKS          = "/banks/commercial";   // GET
    public static  final String   MICROFINANCE_BANKS        = "/banks/microfinance";   // GET
     
    public static  final String   VERIFY_ACCOUNT            = "/verify-account";    // POST
    public static  final String   MY_TRANSACTION_HISTORY    = "/transactionservice/rest/api/my/transaction/history";     // POST
    
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
            .put("phoneNumber", "+2349051797971")
            .put("firstName", "Nates")
            .put("lastName", "Dasher")
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
            .put("email", "bogeyingbi@gmail.com") 
            .put("photo", "Transfer") ;
           // .put("photo", "9j4AAQSkZJRgABAQAAAQABAAD") ;
    }
  
  
  
 
    public  static JSONObject  getTransactionHistoryTestData(){
        return  new JSONObject()
            .put("customerReference", "FORGE-841368157864707")
            .put("page", 0)
            .put("lastRecord", 0)
            .put("pageSize", 30)
            .put("walletIds", new Object[717])
            .put("transactionStatus", getTransactionStatus()) 
            .put("transEvent",  getTransEvent()) 
            .put("transType",getTransType())
            .put("transactionMode", getTransactionMode())
            .put("transactionStartDate", "1988-04-22") 
            .put("transactionEndDate", "2024-05-05") 
            .put("narration", "") ;
    }
    
    
    private  static JSONArray   getTransEvent(){
        JSONArray   trxnsEvent  =  new  JSONArray();
        trxnsEvent.put("SendMoney");
        trxnsEvent.put("Deposit");
        trxnsEvent.put("RequestMoney");
        trxnsEvent.put("AirtimeTopup");
        trxnsEvent.put("EPinPurchase");
        trxnsEvent.put("DataSubscription");
        trxnsEvent.put("PayRRR");
        trxnsEvent.put("PayElectricity");
        trxnsEvent.put("CableTV");
        trxnsEvent.put("InternetSubscription");
        trxnsEvent.put("BillsPayment");
        trxnsEvent.put("Reversal");
        trxnsEvent.put("Referral");
        trxnsEvent.put("Disbursement");
        return trxnsEvent;
    }
    
    
    
    private  static JSONArray   getTransactionStatus(){
        JSONArray   trxnStatus  =  new  JSONArray();
        trxnStatus.put("Successful");
        trxnStatus.put("Pending");
        trxnStatus.put("Failed");
        return trxnStatus;
    }
    
    
     private  static JSONArray   getTransType(){
        JSONArray   trxnsType  =  new  JSONArray();
        trxnsType.put("Debit");
        trxnsType.put("Credit"); 
        return trxnsType;
    }
     
     
      private  static JSONArray   getTransactionMode(){
        JSONArray   trxnsMode  =  new  JSONArray();
        trxnsMode.put("WalletToWallet");
        trxnsMode.put("BankToWallet");
        trxnsMode.put("WalletToBank");
        trxnsMode.put("BonusWallet");
        trxnsMode.put("Ussd");
        trxnsMode.put("Card");
        return trxnsMode;
    }
    
   
}
   



