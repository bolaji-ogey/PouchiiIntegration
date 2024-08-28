/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.integration.using.jsonobjects;

  
import  org.pouchii2.integration.wallet.requests.*;
import org.pouchii2.integration.open.api.WalletCaller; 
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.pouchii2.integration.merchant.requests.MerchantIntAuthRequest;
import org.pouchii2.partner.test.correct.data.WalletTestData; 
import  org.pouchii2.partner.base.GenericCaller;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class WalletCallerTest  extends  GenericCaller  {
    
    
    
    WalletCaller    walletCaller  = new  WalletCaller();
       
       
      public  static void main(String[] args){
        WalletCallerTest    walletCallerTest  = new  WalletCallerTest(); 
       AuthourizationCallerTest  authCallerTest  = new  AuthourizationCallerTest();
         MerchantIntAuthRequest   merchantIntAuthRequest =  new  MerchantIntAuthRequest();
        System.out.println(String.valueOf(
             authCallerTest.testAuthenticateCall(merchantIntAuthRequest.convertToJSON()))
         );  
      
              //  System.out.println(String.valueOf(walletCallerTest.testGetCustomerWalletsCall()));
              //  System.out.println(String.valueOf(walletCallerTest.testGetWalletFundRequestsCall()));
                //  System.out.println(String.valueOf(walletCallerTest.testGetWalletTrxnsCall()));
                // System.out.println(String.valueOf(walletCallerTest.testGetWalletAccountStatementCall()));
                 System.out.println(String.valueOf(walletCallerTest.testCreateExternalWalletAccountCall()));
     }
    
      
      
     /***   
      public   JSONObject   testAuthenticateCall(final  JSONObject    testData){
        return   walletCaller.callAuthenticate(testData);
     }
      
       
      public  JSONObject   testSendMoneyToWalletCall(){ 
            return  walletCaller.callSendMoneyToWallet(WalletTestData.getSendMoneyToWalletData());  
      }
    
    
    
     private  JSONObject   testSendMoneyToBankBulkCall(){
       return   walletCaller.callSendMoneyToBankBulk(WalletTestData.getSendMoneyBulkTestData());                 
     }
    
     
    public  JSONObject   testSendMoneyToBankCall(){ 
      return   walletCaller.callSendMoneyToBank(WalletTestData.getSendMoneyToBankData());  
   }
    ***/
      
      
     
    public  JSONObject   testRequestMoneyCall(){
       return  walletCaller.callRequestMoney(WalletTestData.getRequestMoneyTestData()); 
    }
    
     
    public  JSONObject   testRetieveNubanNumberCall(){ 
        return  walletCaller.callRetrieveNubanNumber(walletCaller.PROFILE_PHONE_NUMBER); 
     }
     
  /***  
    public  JSONObject   testRetrieveNubanNumberBySchemeCall(){ 
       return    walletCaller.callRetrieveNubanNumberByScheme(walletCaller.PROFILE_PHONE_NUMBER, walletCaller.SCHEME);        
   }
    ***/
     
     public  JSONObject   testGetCustomerWalletsCall(){
        return  walletCaller.getCustomerWallets(); 
   }
     
      
     
   public  JSONObject   testGetWalletFundRequestsCall(){
       return  walletCaller.getWalletFundRequests(); 
   }
   
    
   /****
    public  JSONObject   testGetWalletTrxnsCall(){
          return   walletCaller.getWalletTrxns(); 
   }
    ****/
     
    
    public  JSONObject    testGetWalletAccountStatementCall(){
       return   walletCaller.getWalletAccountStatement(walletCaller.PROFILE_WALLET_ID,
                       walletCaller.FROM_DATE,  walletCaller.TO_DATE); 
   }
     
    
    public  JSONObject   testGetSpecificWalletTrxnsCall(){
      return   walletCaller.getSpecificWalletTrxns(walletCaller.PROFILE_WALLET_ID);
   }
    
      
    public  JSONObject   testGetUserBeneficiarysCall(){
         return   walletCaller.getUserBeneficiarys(walletCaller.PROFILE_PHONE_NUMBER); 
   }
     
   /**     
  public  JSONObject   testDeleteUserBeneficiaryCall(){
      return  walletCaller.callDeleteUserBeneficiary(walletCaller.BENEFICIARY_ID); 
   }
    ***/  
       
    public  JSONObject  testGetAllCommercialBanksCall(){ 
        return  walletCaller.getAllCommercialBanks();  
   }
    
     
    
    public  JSONObject   testGetAllMicrofinanceBanksCall(){
       return   walletCaller.getAllMicrofinanceBanks(); 
   }
    
     
   public  JSONObject   testVerifyBankAccountCall(){
      return  walletCaller.callVerifyBankAccount(WalletTestData.getAccountVerifyTestData());  
   }
   
    
    public  JSONObject   testCreateExternalWalletAccountCall(){  
        return  walletCaller.callCreateExternalWalletAccount(WalletTestData.getExternalWalletTestData());                        
   }
    
     
    public  JSONObject   testMyTransactionHistoryCall(){ 
         return  walletCaller.getWalletTrxnHist(new FetchMyTrxnHistory().convertToJSON());  
   }
    
}
