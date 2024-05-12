/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.newpartner.integration.setup.using.json.objects;

import org.json.JSONObject;
import org.pouchii2.integration.newpartner.setup.requests.AdminUserLogin;
import org.pouchii2.integration.newpartner.setup.requests.CreatePartnerOperationalWallet;
import org.pouchii2.integration.newpartner.setup.requests.InitializePartnerWallet;
import org.pouchii2.integration.newpartner.setup.requests.MerchantCreationRequest;
import org.pouchii2.integration.newpartner.setup.requests.PartnerCreationRequest;
import org.pouchii2.integration.newpartner.setup.requests.UpdatePartnerInfoRequest;
import org.pouchii2.newpartner.base.integration.setup.open.api.GenericCallerPlus;
import org.pouchii2.newpartner.test.correct.data.AuthourizationTestData;
import java.util.UUID;
import java.util.random.RandomGenerator;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CreatePartnerMerchantCallerTest {
    
    private static  GenericCallerPlus   genericCallerPlus  = GenericCallerPlus.getInstance();
    
   public   int   tstAuthenticateCall(final  JSONObject    testData){
        return    genericCallerPlus.callAuthenticate(false, AuthourizationTestData.LOGIN, testData);
   }  
    
    
   
   public  static void   createNewPartner(){
          
         AdminUserLogin   adminUserLogin =  new  AdminUserLogin();
          
         if(genericCallerPlus.testAuthenticateCall(adminUserLogin.convertToJSON()) == 200){
             
             genericCallerPlus.resetErrorMessage();
             PartnerCreationRequest   partnerCreationRequest =  new  PartnerCreationRequest();
              partnerCreationRequest.setPartnerName(String.format("%s%d","PARTNER-", RandomGenerator.getDefault().nextInt())); 
             genericCallerPlus.setPartnerCode(partnerCreationRequest.getPartnerCode());
             partnerCreationRequest.setSupportMobileNumber(String.valueOf(UUID.randomUUID()));
             partnerCreationRequest.setSupportMobileNumber(String.valueOf(RandomGenerator.getDefault().nextInt()));
             partnerCreationRequest.setSupportEmailSender(String.format("%s%s", partnerCreationRequest.getPartnerCode(), partnerCreationRequest.getSupportEmailSender()));
             
             if(genericCallerPlus.testCreatePartner(partnerCreationRequest.convertToJSON()) == 200){
                      genericCallerPlus.resetErrorMessage();
                      UpdatePartnerInfoRequest   updatePartnerInfoRequest  =  new  UpdatePartnerInfoRequest();
                      
                           updatePartnerInfoRequest.setPartnerId(genericCallerPlus.getPartnerId());
                           updatePartnerInfoRequest.setPartnerCode(genericCallerPlus.getPartnerCode());
                           updatePartnerInfoRequest.setPartnerName(genericCallerPlus.getPartnerName());
                           updatePartnerInfoRequest.setSupportMobileNumber(String.valueOf(RandomGenerator.getDefault().nextInt()));
                           updatePartnerInfoRequest.setSupportEmailSender(String.format("%s%s", updatePartnerInfoRequest.getPartnerCode(), partnerCreationRequest.getSupportEmailSender()));
                           partnerCreationRequest = null;
                      if(genericCallerPlus.testUpdatePartnerInfo(updatePartnerInfoRequest.convertToJSON()) == 200){
                             genericCallerPlus.resetErrorMessage();
                             MerchantCreationRequest   merchantCreationRequest =  new  MerchantCreationRequest();
                             merchantCreationRequest.setPartnerIds(genericCallerPlus.getPartnerId());
                             merchantCreationRequest.setBvn(String.valueOf(RandomGenerator.getDefault().nextInt()));
                             merchantCreationRequest.setEmailAddress(String.format("%s%s",String.valueOf(UUID.randomUUID()),"@gmail.com"));
                             merchantCreationRequest.setContactPhoneNumber(String.valueOf(RandomGenerator.getDefault().nextInt()));
                             updatePartnerInfoRequest = null;
                            if(genericCallerPlus.testCreateMerchant(merchantCreationRequest.convertToJSON()) == 200){
                                    genericCallerPlus.resetErrorMessage();
                              //  FetchMerchantCredentials    fetchMerchantCredentials   =  new  FetchMerchantCredentials();  
                                   if(genericCallerPlus.testFetchMerchantCredential() == 200){
                                       genericCallerPlus.resetErrorMessage();
                                       InitializePartnerWallet   initializePartnerWallet  =  new  InitializePartnerWallet();
                                       initializePartnerWallet.setPartnerId(genericCallerPlus.getPartnerId());
                                       if(genericCallerPlus.testInitializePartnerWallet(initializePartnerWallet.convertToJSON()) == 200){
                                            genericCallerPlus.resetErrorMessage();
                                            CreatePartnerOperationalWallet    createPartnerOperationalWallet = new  CreatePartnerOperationalWallet();
                                            createPartnerOperationalWallet.setPartnerId(genericCallerPlus.getPartnerId());
                                            createPartnerOperationalWallet.setMerchantId(genericCallerPlus.getPartnerId());
                                            createPartnerOperationalWallet.setWalletName(String.format("%s_%s", genericCallerPlus.getPartnerCode(),
                                                                                 createPartnerOperationalWallet.getWalletName()));
                                            createPartnerOperationalWallet.setBankAccountName(String.format("%s_%s", genericCallerPlus.getPartnerCode(),
                                                                                 createPartnerOperationalWallet.getWalletName()));
                                            if(genericCallerPlus.testCreatePartnerOpWallet(createPartnerOperationalWallet.convertToJSON()) == 200){
                                                 System.out.println("SUCCESS:  NEW PARTNER CREATED SUCCESSFULLY");
                                            }else{
                                                System.out.println(String.format("%s%s", "Create Partner operational Wallet --> ", genericCallerPlus.getErrorMessage()));  
                                            }
                                       }else{
                                        System.out.println(String.format("%s%s", "Initialize Partner Wallet --> ", genericCallerPlus.getErrorMessage()));  
                                       }
                                   }else{
                                     System.out.println(String.format("%s%s", "Fetch Merchant Credentials --> ", genericCallerPlus.getErrorMessage()));  
                                   }
                             }else{
                                System.out.println(String.format("%s%s", "Create New Merchant --> ", genericCallerPlus.getErrorMessage()));
                            }
                      }else{
                         System.out.println(String.format("%s%s", "Update Partner Info --> ", genericCallerPlus.getErrorMessage()));
                      } 
                } else{
                    System.out.println(String.format("%s%s", "Create New Partner --> ", genericCallerPlus.getErrorMessage()));
                }         
         }else{
             System.out.println(String.format("%s%s", "Admin User Login --> ", genericCallerPlus.getErrorMessage()));
         }
         
       // System.out.println(String.valueOf("-->"+authCallerTest.testSendOTPCall("+2348095510360")));
    }
    
    
    
                
               
    
    
    public  static void main(String[] args){
       //  CreatePartnerMerchantCallerTest  authCallerTest  = new  CreatePartnerMerchantCallerTest();
       
       
         AdminUserLogin   adminUserLogin =  new  AdminUserLogin();
       //  CreatePartnerMerchantCallerTest.createNewPartner();  
       // System.out.println(String.valueOf("-->"+authCallerTest.testSendOTPCall("+2348095510360")));
       
        
    }
    
    
    
}
