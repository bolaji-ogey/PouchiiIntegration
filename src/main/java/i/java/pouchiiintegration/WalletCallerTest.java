/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.java.pouchiiintegration;

import i.ogeyingbo.testgroup.WalletTestData;
import i.ogeyingbo.testgroup.AuthourizationTestData;
import i.ogeyingbo.testgroup.AuthourizationWrongTestData;
import i.java.pouchiiintegration.open.api.WalletCaller;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class WalletCallerTest    {
    
    
    
    WalletCaller    walletCaller  = new  WalletCaller();
       
       
      public  static void main(String[] args){
        WalletCallerTest    walletCallerTest  = new  WalletCallerTest(); 
         System.out.println(String.valueOf(
              walletCallerTest.testAuthenticateCall(AuthourizationTestData.getLoginTestData())) 
         ); 
        
              //  System.out.println(String.valueOf(walletCallerTest.testGetCustomerWalletsCall()));
              //  System.out.println(String.valueOf(walletCallerTest.testGetWalletFundRequestsCall()));
                //  System.out.println(String.valueOf(walletCallerTest.testGetWalletTrxnsCall()));
                // System.out.println(String.valueOf(walletCallerTest.testGetWalletAccountStatementCall()));
                 System.out.println(String.valueOf(walletCallerTest.testCreateExternalWalletAccountCall()));
     }
    
      
      
        
      public   JSONObject   testAuthenticateCall(final  JSONObject    testData){
        return   walletCaller.callAuthenticate(testData);
     }
      
       
      public  JSONObject   testSendMoneyToWalletCall(){ 
            return  walletCaller.callSendMoneyToWallet(WalletTestData.getSendMoneyToWalletData());  
      }
    
    
    
  //  private  JSONObject   testSendMoneyToBankBulkCall(){
  //    return   walletCaller.callSendMoneyToBankBulk(WalletTestData.getSendMoneyBulkTestData());                 
  //  }
    
     
    public  JSONObject   testSendMoneyToBankCall(){ 
      return   walletCaller.callSendMoneyToBank(WalletTestData.getSendMoneyToBankData());  
   }
    
     
    public  JSONObject   testRequestMoneyCall(){
       return  walletCaller.callRequestMoney(WalletTestData.getRequestMoneyTestData()); 
    }
    
     
    public  JSONObject   testRetieveNubanNumberCall(){ 
        return  walletCaller.callRetrieveNubanNumber(walletCaller.PROFILE_PHONE_NUMBER); 
     }
     
    
    public  JSONObject   testRetrieveNubanNumberBySchemeCall(){ 
       return    walletCaller.callRetrieveNubanNumberByScheme(walletCaller.PROFILE_PHONE_NUMBER, walletCaller.SCHEME);        
   }
    
     
     public  JSONObject   testGetCustomerWalletsCall(){
        return  walletCaller.getCustomerWallets(); 
   }
     
      
     
   public  JSONObject   testGetWalletFundRequestsCall(){
       return  walletCaller.getWalletFundRequests(); 
   }
   
    
    public  JSONObject   testGetWalletTrxnsCall(){
          return   walletCaller.getWalletTrxns(); 
   }
    
     
    
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
     
        
  public  JSONObject   testDeleteUserBeneficiaryCall(){
      return  walletCaller.callDeleteUserBeneficiary(walletCaller.BENEFICIARY_ID); 
   }
      
       
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
    
     
    
}
