/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.java.pouchiiintegration.open.api;

import i.ogeyingbo.testgroup.GenericCaller;
import i.ogeyingbo.testgroup.BillerTestData;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BillerCaller   extends   GenericCaller   {
    
    
       public  JSONObject   getAllBillers(){
           return    getRequest(BillerTestData.ALL_BILLERS);
        }
       
       
       public  JSONObject   callBuyAirtime(final  JSONObject    testData){
           return  postRequest(BillerTestData.PURCHASE_VTU, testData);
        }
       
       
       public  JSONObject   callLookupData(final  JSONObject    testData){
            return  postRequest(BillerTestData.LOOKUP_DATA, testData);
        }
        
        
       public  JSONObject   callSubscribeData(final  JSONObject    testData){
            return postRequest(BillerTestData.SUBSCRIBE_DATA, testData);
       }
         
      
       public  JSONObject   callValidateMeter(final  JSONObject    testData){
          return  postRequest(BillerTestData.VALIDATE_METER, testData);
        }
       
        
      public  JSONObject   callBuyElectricity(final  JSONObject    testData){
          return  postRequest(BillerTestData.PURCHASE_ELECTRICITY, testData);
       }
        
       
      public  JSONObject   callValidateMultichoice(final  JSONObject    testData){
          return  postRequest(BillerTestData.VALIDATE_MULTICHOICE, testData);
       }  
        
     
      public  JSONObject   callMultichoiceBouquet(final  JSONObject    testData){
          return  postRequest(BillerTestData.MULTICHOICE_BOUQUETS, testData);
       }
      
      
      public  JSONObject   callSubscribeMultichoice(final  JSONObject    testData){
          return  postRequest(BillerTestData.SUBSCRIBE_MULTICHOICE, testData);
       }
      
      
      public  JSONObject   callValidateStartimes(final  JSONObject    testData){
          return  postRequest(BillerTestData.VALIDATE_STARTIMES, testData);
       }
      
      
      public  JSONObject   callInternetValidation(final  JSONObject    testData){
          return  postRequest(BillerTestData.INTERNET_VALIDATION, testData);
       }
      
      
      public  JSONObject   callInternetBundles(final  JSONObject    testData){
          return  postRequest(BillerTestData.INTERNET_BUNDLES, testData);
       }
      
      
      public  JSONObject   callInternetSubscribe(final  JSONObject    testData){
          return  postRequest(BillerTestData.INTERNET_SUBSCRIBE, testData);
       }
      
      
      public  JSONObject   callCableTvBouquet(final  JSONObject    testData){
          return  postRequest(BillerTestData.CABLETV_BOUQUETS, testData);
       }
      
      
      public  JSONObject   callValidateCableTv(final  JSONObject    testData){
          return  postRequest(BillerTestData.VALIDATE_CABLETV, testData);
       }
      
      
      public  JSONObject   callSubscribeCableTv(final  JSONObject    testData){
          return  postRequest(BillerTestData.SUBSCRIBE_CABLETV, testData);
       }
      
      
}
