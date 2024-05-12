/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.integration.using.jsonobjects;

  
import i.ogeyingbo.testgroup.BillerTestData; 
import i.java.pouchiiintegration.open.api.BillerCaller;
import i.ogeyingbo.testgroup.AuthourizationWrongTestData;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BillerCallerTest {
    
    
       BillerCaller    billerCaller  = new  BillerCaller();
       
       
    public  static void main(String[] args){
        BillerCallerTest    billerCallerTest  = new  BillerCallerTest(); 
        System.out.println(String.valueOf(
             billerCallerTest.testAuthenticateCall(AuthourizationWrongTestData.getLoginTestData()))
                    
        ); 
     }
    
    
     public   JSONObject   testAuthenticateCall(final  JSONObject    testData){
        return   billerCaller.callAuthenticate(testData);
     }
        
       
       public  JSONObject   testAllBillersCall(){
           return    billerCaller.getAllBillers();
        }
       
       
       public  JSONObject   testBuyAirtimeCall(){
           return  billerCaller.callBuyAirtime(BillerTestData.getPurchaseVTUData());
        }
       
       
       public  JSONObject   testLookupDataCall(){
            return   billerCaller.callLookupData(BillerTestData.getLookupData());
        }
        
        
       public  JSONObject   testSubscribeDataCall(){
            return  billerCaller.callSubscribeData(BillerTestData.getSubscribeIntData());
       }
         
      
       public  JSONObject   testValidateMeterCall(){
          return  billerCaller.callValidateMeter(BillerTestData.getValidateMeterData());
        }
       
        
      public  JSONObject   testBuyElectricityCall(){
          return  billerCaller.callBuyElectricity(BillerTestData.getBuyElectricityData());
       }
        
       
      public  JSONObject   testValidateMultichoiceCall(){
          return  billerCaller.callValidateMultichoice(BillerTestData.getValidateMultichoiceData());
       }  
        
     
      public  JSONObject   testMultichoiceBouquetCall(){
          return  billerCaller.callMultichoiceBouquet(BillerTestData.getMultichoiceBouquetData());
       }
      
      
      public  JSONObject   testSubscribeMultichoiceCall(){
          return  billerCaller.callSubscribeMultichoice(BillerTestData.getSubscribeMultichoiceData());
       }
      
      
      public  JSONObject   testValidateStartimesCall(){
          return  billerCaller.callValidateStartimes(BillerTestData.getValidateStartimesData());
       }
      
      
      public  JSONObject   testInternetValidationCall(){
          return  billerCaller.callInternetValidation(BillerTestData.getInternetValidationData());
       }
      
      
      public  JSONObject   testInternetBundlesCall(){
          return  billerCaller.callInternetBundles(BillerTestData.getInternetBundlesData());
       }
      
      
      public  JSONObject   testInternetSubscribeCall(){
          return  billerCaller.callInternetSubscribe(BillerTestData.getInternetSubscribeData());
       }
      
      
      public  JSONObject   callCableTvBouquet(){
          return  billerCaller.callCableTvBouquet(BillerTestData.getCableTvBouquetsData());
       }
      
      
      public  JSONObject   callValidateCableTv(){
          return  billerCaller.callValidateCableTv(BillerTestData.getValidateCabletvData());
       }
      
      
      public  JSONObject   callSubscribeCableTv(){
          return  billerCaller.callSubscribeCableTv(BillerTestData.getSubscribeCabletvData());
       }
    
}
