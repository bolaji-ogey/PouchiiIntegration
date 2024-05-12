/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.open.api.test;

import org.json.JSONObject;
import   org.pouchii2.integration.open.api.BillerCaller; 
import   org.pouchii2.partner.test.correct.data.BillerTestData;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BillerTest   extends  BillerCaller  {
    
     
    
       public  JSONObject   callMyAirtimeBenefReq(){
          return  super.callMyAirtimeBenefReq(BillerTestData.getMyBeneficiaryData());
       }
      
      
      public  JSONObject   callMyDataBenefReq(){
          return  super.callMyDataBenefReq(BillerTestData.getMyBeneficiaryData());
       }
      
      
      public  JSONObject   callMyDSTVBenefReq(){
          return  super.callMyDSTVBenefReq(BillerTestData.getMyBeneficiaryData());
       }
      
      
       public  JSONObject   callMyGOTVBenefReq(){
          return  super.callMyGOTVBenefReq(BillerTestData.getMyBeneficiaryData());
       }
      
      
      public  JSONObject   callMyStarTimeBenefReq(){
          return  super.callMyStarTimeBenefReq(BillerTestData.getMyBeneficiaryData());
       }
    
      
      public  JSONObject   callMyElectricityBenefReq(){
          return   super.callMyElectricityBenefReq(BillerTestData.getMyBeneficiaryData());
       }
      
      
      @Override
       public  JSONObject   getBillerProviders(){
           return    super.getBillerProviders();
        }
       
       
       @Override
        public  JSONObject   getAirtimeProviders(){
           return    super.getAirtimeProviders();
        }
        
       @Override 
       public  JSONObject   getDataProviders(){
           return    super.getDataProviders();
        }
         
       @Override   
       public  JSONObject   getDataPlans(){
           return    super.getDataPlans();
        }
       
       
      
       public  JSONObject   callAirtimePurchaseReq(){
           return  super.callAirtimePurchaseReq(BillerTestData.getAirtimePurchaseData());
        }
       
       
       public  JSONObject   callLookupData(final  JSONObject    testData){
            return  postRequest(false, BillerTestData.FETCH_DATA_PLANS, testData);
        }
        
       
       public  JSONObject   callSubscribeDataReq(){
            return super.callSubscribeDataReq(BillerTestData.getDataSubscriptionData());
       }
         
      
      
       /***
       public  JSONObject   callValidateMeter(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.BILLER_VALIDATION_REQUEST, BillerTest.getValidation);
        }
       
      
       @Override
       public  JSONObject   getElectricityProviders(){ 
          return   super.getElectricityProviders();
       }
       
       
      public  JSONObject   callBuyElectricity(){
          return  super.callBuyElectricity(BillerTestData.getElectricityTestData());
       }
        **/
       
      public  JSONObject   callValidateMultichoice(final  JSONObject    testData){
          return  postRequest(false, BillerTestData.BILLER_VALIDATION_REQUEST, testData);
       }  
        
     
      @Override
      public  JSONObject   getDSTVBouquets(){ 
          return  super.getDSTVBouquets();
       }
      
      
      
}
