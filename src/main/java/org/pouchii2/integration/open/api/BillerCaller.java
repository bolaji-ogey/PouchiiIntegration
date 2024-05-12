/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.open.api;
 
import  org.pouchii2.partner.test.correct.data.BillerTestData;
import  org.pouchii2.partner.base.GenericCaller;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.pouchii2.partner.test.correct.data.AuthourizationTestData;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BillerCaller   extends   GenericCaller   {
    
    
       public  static  void  main(String[]  args){
           BillerCaller   billerCaller  =  new  BillerCaller(); 
           billerCaller.callAuthenticate(false, AuthourizationTestData.LOGIN,  AuthourizationTestData.getLoginTestData());
           System.out.println(billerCaller.getElectricityProviders());
       }
    
    
       public  JSONObject   callMyAirtimeBenefReq(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.MY_AIRTIME_BENEFICIARY_LIST, testData);
       }
      
      
      public  JSONObject   callMyDataBenefReq(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.MY_DATA_BENEFICIARY_LIST, testData);
       }
      
      
      public  JSONObject   callMyDSTVBenefReq(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.MY_DSTV_BENEFICIARY_LIST, testData);
       }
      
      
       public  JSONObject   callMyGOTVBenefReq(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.MY_GOTV_BENEFICIARY_LIST, testData);
       }
      
      
      public  JSONObject   callMyStarTimeBenefReq(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.MY_STARTIME_BENEFICIARY_LIST, testData);
       }
    
      
      public  JSONObject   callMyElectricityBenefReq(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.MY_ELECTRICITY_BENEFICIARY_LIST, testData);
       }
      
      
       public  JSONObject   getBillerProviders(){
           return    getRequest(false, BillerTestData.FETCH_BILLER_PROVIDER_REQUEST);
        }
       
       
        public  JSONObject   getAirtimeProviders(){
           return    getRequest(false, BillerTestData.FETCH_AIRTIME_PROVIDERS);
        }
        
        
       public  JSONObject   getDataProviders(){
           return    getRequest(false, BillerTestData.FETCH_DATA_PROVIDERS);
        }
         
          
       public  JSONObject   getDataPlans(){
           return    getRequest(false, BillerTestData.FETCH_DATA_PLANS);
        }
       
       
       
       public  JSONObject   callAirtimePurchaseReq(final  JSONObject    testData){
           return  postRequest(false, BillerTestData.AIRTIME_PURCHASE, testData);
        }
       
       
       public  JSONObject   callLookupData(final  JSONObject    testData){
            return  postRequest(false, BillerTestData.FETCH_DATA_PLANS, testData);
        }
        
        
       public  JSONObject   callSubscribeDataReq(final  JSONObject    testData){
            return postRequest(false, BillerTestData.DATA_SUBSCRIPTION_REQUEST, testData);
       }
         
      
       public  JSONObject   callValidateMeter(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.BILLER_VALIDATION_REQUEST, testData);
        }
       
      
       public  JSONObject   getElectricityProviders(){
          String  billerProviderUrl  = BillerTestData.FETCH_BILLER_PROVIDER_REQUEST;
          billerProviderUrl  =  billerProviderUrl.replace("{billerType}", "power");
          System.out.println("Used billerProviderUrl:  "+billerProviderUrl);
          return  getRequest(false, billerProviderUrl);
       }
       
       
      public  JSONObject   callBuyElectricity(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.BILLS_PAYMENT_REQUEST, testData);
       }
        
       
      public  JSONObject   callValidateMultichoice(final  JSONObject    testData){
          return   postRequest(false, BillerTestData.BILLER_VALIDATION_REQUEST, testData);
       }  
       
      
      
       public  JSONObject   getCableTVProviders(){
          String  billerProviderUrl  = BillerTestData.FETCH_BILLER_PROVIDER_REQUEST;
          billerProviderUrl  =  billerProviderUrl.replace("{billerType}", "cabletv");
          System.out.println("Used billerProviderUrl:  "+billerProviderUrl);
          return  getRequest(false, billerProviderUrl);
       }
      
     
      public  JSONObject   getDSTVBouquets(){
          String  billerProviderUrl  = BillerTestData.FETCH_BILLER_PROVIDER_REQUEST;
          billerProviderUrl  =  billerProviderUrl.replace("{billerType}", "cabletv");
          System.out.println("Used billerProviderUrl:  "+billerProviderUrl);
          return  getRequest(false, billerProviderUrl);
       }
      
      
      
      
      /***
      public  JSONObject   callSubscribeMultichoice(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.SUBSCRIBE_MULTICHOICE, testData);
       }
      
      
      public  JSONObject   callValidateStartimes(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.VALIDATE_STARTIMES, testData);
       }
      
      
      public  JSONObject   callInternetValidation(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.INTERNET_VALIDATION, testData);
       }
      
      
      public  JSONObject   callInternetBundles(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.INTERNET_BUNDLES, testData);
       }
      
      
      public  JSONObject   callInternetSubscribe(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.INTERNET_SUBSCRIBE, testData);
       }
      
      
      public  JSONObject   callCableTvBouquet(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.CABLETV_BOUQUETS, testData);
       }
      
      
      public  JSONObject   callValidateCableTv(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.VALIDATE_CABLETV, testData);
       }
      
      
      public  JSONObject   callSubscribeCableTv(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.SUBSCRIBE_CABLETV, testData);
       }
      **/
      
}
