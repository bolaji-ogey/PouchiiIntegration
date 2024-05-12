/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.java.pouchiiintegration.open.api;

 
import i.ogeyingbo.testgroup.GenericCaller;
import i.ogeyingbo.testgroup.WalletTestData;   
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class WalletCaller   extends   GenericCaller {
    
    
    public  JSONObject   callSendMoneyToWallet(final  JSONObject    testData){
        testData.remove("channel");  testData.put("channel", "wallettowallet");
       return  postRequest(WalletTestData.SEND_MONEY, testData);  
   }
    
    
    
    private  JSONObject   callSendMoneyToBankBulk(final  JSONObject    testData){
      return   postRequest(WalletTestData.SEND_MONEY, testData);                 
    }
    
     
    public  JSONObject   callSendMoneyToBank(final  JSONObject    testData){
        testData.remove("channel");  testData.put("channel", "wallettobank");
      return  postRequest(WalletTestData.SEND_MONEY, testData);  
   }
    
     
    public  JSONObject   callRequestMoney(final  JSONObject    testData){
       return  postRequest(WalletTestData.REQUEST_MONEY, testData); 
    }
    
     
    public  JSONObject   callRetrieveNubanNumber(final  String  profileId){
        String  nubanRequestStr  =  WalletTestData.RETRIEVE_NUBAN;
        nubanRequestStr = nubanRequestStr.replace("{phoneNumber}", profileId);
        return  postRequest(nubanRequestStr, new JSONObject()); 
     }
     
    
    public  JSONObject   callRetrieveNubanNumberByScheme(final  String  profileId, final  String scheme){
       String  nubanBySchemeReqStr  =  WalletTestData.RETRIEVE_NUBAN_BY_SCHEME;
       nubanBySchemeReqStr = nubanBySchemeReqStr.replace("{phoneNumber}", profileId)
                .replace("{scheme}", scheme);
       return  getRequest(nubanBySchemeReqStr);        
   }
    
    
    
     
    
     public  JSONObject   getCustomerWallets(){
         return  getRequest(WalletTestData.USER_WALLETS); 
   }
     
     
      
     
   public  JSONObject   getWalletFundRequests(){
        return   getRequest(WalletTestData.LIST_OF_REQUEST_FUNDS); 
   }
   
   
    
   
    public  JSONObject   getWalletTrxns(){
    return   getRequest(WalletTestData.WALLET_TRXNS_URL_EXT); 
   }
    
     
    
    public  JSONObject   getWalletAccountStatementX(final String  profileWalletId,  
                                       final String  fromDate,    final String  toDate){ 
       return  getRequest(String.format("/%s/%s/%s",WalletTestData.WALLET_ACCOUNT_STATEMENT_TEST, 
                                                  profileWalletId, fromDate, toDate)); 
   }
    
    
    
     public  JSONObject   getWalletAccountStatement(final String  profileWalletId,  
                                       final String  fromDate,    final String  toDate){ 
         WalletTestData.WALLET_ACCOUNT_STATEMENT = WalletTestData.WALLET_ACCOUNT_STATEMENT.replace("{walletID}", profileWalletId);
         WalletTestData.WALLET_ACCOUNT_STATEMENT = WalletTestData.WALLET_ACCOUNT_STATEMENT.replace("{fromDate}", fromDate);
         WalletTestData.WALLET_ACCOUNT_STATEMENT = WalletTestData.WALLET_ACCOUNT_STATEMENT.replace("{toDate}", toDate);
       return  getRequest(WalletTestData.WALLET_ACCOUNT_STATEMENT); 
   }
     
    
    
    public  JSONObject   getSpecificWalletTrxns(final String  profileWalletId){
        String  walletUrlAccntStr  =   WalletTestData.SPECIFIC_WALLET_TRXNS;
        walletUrlAccntStr.replace("{walletID}",profileWalletId);
        return  getRequest(walletUrlAccntStr); 
   }
    
     
    
    public  JSONObject   getUserBeneficiarys(final String  profileId){
        String  beneficiaryUrl  =   WalletTestData.USER_BENEFICIARY;
          beneficiaryUrl = beneficiaryUrl.replace("{phoneNumber}", profileId);
       return  getRequest(beneficiaryUrl); 
   }
     
       
     
  public  JSONObject   callDeleteUserBeneficiary(final   String  beneficiaryId){
      String  userBeneficiaryStr  =  WalletTestData.DELETE_USER_BENEFICIARY;
       userBeneficiaryStr = userBeneficiaryStr.replace("{id}", beneficiaryId);
     return  deleteRequest(userBeneficiaryStr, beneficiaryId); 
   }
      
       
    public  JSONObject   getAllCommercialBanks(){ 
        return  getRequest(WalletTestData.COMMERCIAL_BANKS);  
   }
    
     
    
    public  JSONObject   getAllMicrofinanceBanks(){
       return  getRequest(WalletTestData.MICROFINANCE_BANKS); 
   }
    
    
      
   
   public  JSONObject   callVerifyBankAccount(final  JSONObject    testData){ 
        return  postRequest(WalletTestData.VERIFY_ACCOUNT, testData);                                
   }
   
   
    
   
    public  JSONObject   callCreateExternalWalletAccount(final  JSONObject    testData){ 
     //  return  postCreateWalletExt(WalletTestData.CREATE_WALLET_EXTERNAL, testData); 
        return  postRequest(WalletTestData.CREATE_WALLET_EXTERNAL, testData);                        
   }
    
    
    
       public  JSONObject   callMyTransactionHistory(final  JSONObject    testData){ 
     //  return  postCreateWalletExt(WalletTestData.CREATE_WALLET_EXTERNAL, testData); 
        return  postRequest(WalletTestData.CREATE_WALLET_EXTERNAL, testData);                        
   }
    
    
    
    
    
    
}
