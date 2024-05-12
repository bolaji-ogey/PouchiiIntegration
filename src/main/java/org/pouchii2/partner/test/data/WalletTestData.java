/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.test.data;
 
import org.json.JSONObject;
import org.pouchii2.partner.base.AuthourizationInterface; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class WalletTestData    extends     AuthourizationInterface {
    
    public static  final String   SEND_MONEY_TO_WALLET       = "/transactionservice/rest/api/send/money";    // POST
    public static  final String   SEND_MONEY_TO_BANK         = "/transactionservice/rest/api/send/money";    // POST
    public static  final String   REQUEST_MONEY              = "/transactionservice/rest/api/request/funds";    // POST
    public static  final String   ACCEPT_OR_REJECT_REQUEST_MONEY   = "/transactionservice/rest/api/accept/or/reject/request/funds"; // POST
    public static  final String   BAMK_LIST_REQUEST   = "/walletservice/rest/api/wallet/bank/list";   // GET 
    public static  final String   BALANCE_ENQUIRY_REQUEST   = "/walletservice/rest/api/wallet/balance/enquiry";   // POST
    public static  final String   WALLET_ENQUIRY_NAME_BY_PHONENO   = "/walletservice/rest/api/wallet/lookup/2348083064718";   // GET 
    public static  final String   FETCH_MY_WALLET_BALANCES   = "/walletservice/rest/api/wallet/my/wallet/balances";   // GET 
    
    public static  final String   MY_WALLET_BENEFICIARIES_LIST   = "/walletservice/rest/api/wallet/my/beneficiary/list/0/50";   // GET 
    public static  final String   DELETE_WALLET_BENEFICIARy_REQUEST   = "/walletservice/rest/api/wallet/delete/beneficiary";   // post
    public static  final String   WALLET_KYC_LIST   = "/walletservice/rest/api/wallet/kyc/list";   // GET
    public static  final String   GENERATE_WALLET_QR_CODE   = "/walletservice/rest/api/generate/wallet/qrcode";   // POST
    public static  final String   VIEW_MY_WALLET_QR_CODE   = "/walletservice/rest/api/view/wallet/qrcode/7590124838";    // GET
    public static  final String   FETCH_MY_PROFILE_REQUEST   = "/identityservice/rest/api/fetch/myprofile/information";  // GET
    public static  final String   LOG_OUT   = "/identityservice/rest/api/authentication/logout";   // POST
    
    
    
    public static  final String   PASSWORD_RESET_REQUEST   = "/identityservice/rest/api/authentication/reset/password";   // POST
    public static  final String   UPDATE_PASSWORD_REQUEST   = "/identityservice/rest/api/authentication/update/password";   // POST
    public static  final String   CHANGE_PASSWORD_REQUEST   = "/identityservice/rest/api/authentication/change/password";   // POST
    public static  final String   CREATE_AUTHORIZATION_PIN   = "/identityservice/rest/api/authentication/create/transaction/pin";   // POST
    public static  final String   CHANGE_AUTHORIZATION_PIN   = "/identityservice/rest/api/authentication/change/transaction/pin";   // POST
    public static  final String   IMAGE_UPLOAD_REQUEST   = "/identityservice/rest/api/document/image/upload/SPECS";   // POST
    public static  final String   DOCUMENT_UPLOAD_REQUEST   = "/identityservice/rest/api/file/image/upload/SPECS";   // POST
    
    public static  final String   FETCH_MY_SECURITY_QUESTION_FLOW   = "/identityservice/rest/api/authentication/fetch/mysecurityquestion/flow";   // GET
    public static  final String   CREATE_SECURITY_QUESTION   = "/identityservice/rest/api/authentication/creation/security/question";   // POST
    public static  final String   CHANGE_SECURITY_QUESTION_REQUEST   = "/identityservice/rest/api/authentication/change/security/question";   // POST
    
    
     
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
    public static  final String   CREATE_WALLET_EXTERNAL    = "/wallet-external";     // POST
  
  
        
      
    public  static JSONObject  getSendMoneyToWalletData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("transactionAmount", 50.00)
            .put("narration", "Send-Money")
            .put("currency", "NGN")
            .put("sourceAccount", "_")
            .put("sourceAccountType", "Wallet")
            .put("saveBeneficiary", true)
            .put("beneficiaryAccount", "_")
            .put("beneficiaryAccountName", "_")
            .put("beneficiaryBankCode", "058") 
            .put("beneficiaryAccountType", "Bank") 
            .put("transactionPin", "1234")
            .put("chargeMyBonusWallet", true)
            .put("amountChargedFromBonusWallet", 50.00);
    }
      
    
    
       
     public  static JSONObject  getSendMoneyToBankData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("transactionAmount", 50.00)
            .put("narration", "Send-Money")
            .put("currency", "NGN")
            .put("sourceAccount", "_")
            .put("sourceAccountType", "Bank")
            .put("saveBeneficiary", true)
            .put("beneficiaryAccount", "_")
            .put("beneficiaryAccountName", "_")
            .put("beneficiaryBankCode", "058") 
            .put("beneficiaryAccountType", "Bank") 
            .put("transactionPin", "1234")
            .put("chargeMyBonusWallet", true)
            .put("amountChargedFromBonusWallet", 50.00);
    }
      
       
     

  public  static JSONObject  getRequestMoneyData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("requestAmount", 50.00) 
            .put("currency", "NGN") 
            .put("beneficiaryWallet", "_")
            .put("sourceWalletNumber", "_")
            .put("reason", "Request Money");
    }
   
   
  
  
   public  static JSONObject  getAcceptOrRejectRequestMoneyData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("requestMoneyId", 10) 
            .put("requestMoneyStatus", false) 
            .put("cancelRequest", false)
            .put("reason", "Accepted")
            .put("transactionPin", 1234);
    }
   
   
   
   
   
   public  static JSONObject  getBalanceEnquiryRequestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("accountNumber", "SPECS") 
            .put("accountType", "Bank") 
            .put("currency", "NGN") ;
    }
  
   
   
   public  static JSONObject  getDeleteWalletBeneficiaryRequestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("beneficiaryList", new Integer[1]) ; 
    }
   
   
   
   public  static JSONObject  getGenerateWalletQRCodeData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("walletNumber", "7592420882") ; 
    }
   
   
   
   public  static JSONObject  getLogOutData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("logoutReason", "Self_logout") ; 
    }
   
   
   
    public  static JSONObject  getPasswordResetRequestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("username", "john@systemspecs.com.ng") ; 
    }
   
   
    public  static JSONObject  getUpdatePasswordRequestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("username", "john@systemspecs.com.ng")
            .put("password", "1234#") 
            .put("confirmPassword", "1234#") 
            .put("requestAuthorization", "1234#") 
            .put("confirmPassword", new JSONObject()
                  .put("verificationEvent", REQUEST_CHANNEL_ID)
                  .put("verificationReference", "0692")
                  .put("verificationCode", "OTP")
            ); 
    }
   
    
     public  static JSONObject  getChangePasswordRequestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("oldPassword", "execsOld123#") 
            .put("password", "new123#")
            .put("confirmPassword", "new123#"); 
    }
   
     
      public  static JSONObject  getPasswordResetSendNewPasswordData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("username", "john@systemspecs.com.ng") 
            .put("generateAndSendPassword", true) ; 
    }
   
   
   
    public  static JSONObject  getCreateAuthourizationPinData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("pin", 1234) 
            .put("confirmPin", 1234) ; 
    }
    
    
    
    
     public  static JSONObject  getChangeAuthourizationPinData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("currentPin", 4321)
            .put("newPin", 1234) 
            .put("confirmPin", 1234) ; 
    }
   
   
     
    public  static JSONObject  getCreateSecurityQuestionData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("securityQuestion", "2")
            .put("hasCustomSecurityQuestion", true)
            .put("securityQuestionAnswer", "Leave Am"); 
    }
    
    
   
    public  static JSONObject  getChangeSecurityQuestionRequestData(){
        return  new JSONObject()
             .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("securityQuestion", "Make i leave am or make we chop am?")
            .put("hasCustomSecurityQuestion", true)
            .put("securityQuestionAnswer", "Leave Am");
    }
       
       
    public  static JSONObject  getChangeAuthourizationPinData2(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("currentPin", 4321)
            .put("newPin", 1234) 
            .put("confirmPin", 1234) ; 
    }
           
           
           
    public  static JSONObject  getChangeAuthourizationPinData3(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("currentPin", 4321)
            .put("newPin", 1234) 
            .put("confirmPin", 1234) ; 
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
  
  
  
 
   
   
   
   
}
   



