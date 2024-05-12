/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.test.correct.data;

import org.pouchii2.partner.test.data.*;
import i.ogeyingbo.testgroup.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.pouchii2.partner.base.AuthourizationInterface;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BillerTestData  extends     AuthourizationInterface {
    
    public static  final String   FETCH_AIRTIME_PROVIDERS   = "/vas/rest/api/fetch/telco/airtime/billers";   // GET
    public static  final String   FETCH_DATA_PROVIDERS      = "/vas/rest/api/fetch/telco/data/billers";   // GET
    public static  final String   FETCH_DATA_PLANS      = "/vas/rest/api/fetch/{billerId}/data/plans";   // GET
    public static  final String   AIRTIME_PURCHASE     = "/transactionservice/rest/api/airtime/topup/payment";    // POST 
    public static  final String   DATA_SUBSCRIPTION_REQUEST   = "/transactionservice/rest/api/data/subscription/payment";    // POST
    public static  final String   BILLER_VALIDATION_REQUEST   = "/vas/rest/api/biller/validation/request";     // POST
    
    public static  final String   BILLS_PAYMENT_REQUEST   = "/transactionservice/rest/api/bills/payment";    // POST
    public static  final String   FETCH_BILLER_PROVIDER_REQUEST   = "/vas/rest/api/fetch/{billerType}/providers/request";  // GET
    
    public static  final String   MY_AIRTIME_BENEFICIARY_LIST   = "/vas/rest/api/fetch/my/airtime/beneficiary/list/0/30";    // POST 
    public static  final String   MY_DATA_BENEFICIARY_LIST   = "/vas/rest/api/fetch/my/data/beneficiary/list/0/30";    // POST 
    public static  final String   MY_ELECTRICITY_BENEFICIARY_LIST   = "/vas/rest/api/fetch/my/electricity/beneficiary/list/0/30";    // POST 
    public static  final String   MY_DSTV_BENEFICIARY_LIST   = "/vas/rest/api/fetch/my/dstv/beneficiary/list/0/30";    // POST 
    public static  final String   MY_GOTV_BENEFICIARY_LIST   = "/vas/rest/api/fetch/my/gotv/beneficiary/list/0/30";    // POST 
    public static  final String   MY_STARTIME_BENEFICIARY_LIST   = "/vas/rest/api/fetch/my/startimes/beneficiary/list/0/30";    // POST 
    
    
    public static  final String   CABLETV_PAYMENT_REQUEST   = "/transactionservice/rest/api/cabletv/subscription/payment";    // POST 
    public static  final String   ELECTRICITY_PAYMENT_REQUEST   = "/transactionservice/rest/api/electricity/subscription/payment";    // POST 
    public static  final String   FETCH_DSTV_BOUQUETS   = "/vas/rest/api/fetch/my/startimes/beneficiary/list/0/30";    // POST
    public static  final String   FETCH_GOTV_BOUQUETS   = "/vas/rest/api/fetch/my/startimes/beneficiary/list/0/30";    // POST 
    public static  final String   FETCH_STARTIMES_BOUQUETS   = "";    // POST 
    
    
    
    public  static JSONObject  getAirtimePurchaseData(){
        return  new JSONObject()
            .put("requestChannelId", "TEST-MERCHANT") 
            .put("requestChannel", "Api")
            .put("requestChannelType", "Integrator")
            .put("requestApplicationCode", "POUCHII")
            .put("requestPartnerCode", "TEST-MERCHANT") 
            .put("customerReference", "")
            .put("walletId", 168)
            .put("customerId", "09060009334")
            .put("billerName", "MTN")
            .put("billerCode", "M301")
            .put("billerId", 1)
            .put("paymentAmount", 100)
            .put("paymentWithBonus", false)
            .put("bonusAmount", 0.00)
            .put("currency", "NGN")
            .put("transactionPin", 1234)
            .put("saveBeneficiary", true)
            .put("saveBeneficiaryName", "My Friend")
            .put("transactionReference", "TEST-MERCHANT-37186461");
    }
    
     
    
     public  static JSONObject  getDataSubscriptionData(){
        return  new JSONObject()
            .put("requestChannelId", "TEST-MERCHANT") 
            .put("requestChannel", "Api")
            .put("requestChannelType", "Integrator")
            .put("requestApplicationCode", "POUCHII")
            .put("requestPartnerCode", "TEST-MERCHANT") 
            .put("customerReference", "")
            .put("walletId", 168)
            .put("customerId", "09060009334")
            .put("billerName", "MTN")
            .put("billerCode", "M302")
            .put("billerId", 6)
            .put("paymentAmount", 200.00)
            .put("paymentWithBonus", false)
            .put("bonusAmount", 0.00)
            .put("currency", "NGN")
            .put("transactionPin", 1234)
            .put("saveBeneficiary", true)
            .put("saveBeneficiaryName", "My Friend")
            .put("transactionReference", "TEST-MERCHANT-37186461");
    }
     
      
     public  static JSONObject  getBillerValidationData(){
        return  new JSONObject()
            .put("requestChannelId", "TEST-MERCHANT") 
            .put("requestChannel", "Api")
            .put("requestChannelType", "Integrator")
            .put("requestApplicationCode", "POUCHII")
            .put("requestPartnerCode", "TEST-MERCHANT") 
            .put("billerId", "15")
            .put("productId", 15)
            .put("serviceType", "ibadan_electric_prepaid")
            .put("serviceCategory", "POWER")
            .put("customerId", "14298190407");
     }
     
     
     
    public  static JSONObject  getBillsPaymentReqData(){ 
      JSONObject[]  jsonArr  =  new JSONObject[2];
      return  new JSONObject()
          .put("requestChannelId", "TEST-MERCHANT") 
          .put("requestChannel", "Api")
          .put("requestChannelType", "Integrator")
          .put("requestApplicationCode", "POUCHII")
          .put("requestPartnerCode", "TEST-MERCHANT") 
          .put("customerReference", "")
          .put("walletId", 168)
          .put("customerId", "09060009334")
          .put("billerName", "MTN")
          .put("billerCode", "M302")
          .put("billerId", 6)
          .put("paymentAmount", 200.00)
          .put("paymentWithBonus", false)
          .put("bonusAmount", 0.00)
          .put("currency", "NGN")
          .put("transactionPin", 1234)
          .put("saveBeneficiary", true)
          .put("saveBeneficiaryName", "My Friend")
          .put("transactionReference", "TEST-MERCHANT-37186461")
          .put("formData", jsonArr);
    }
                
     
    
     public  static JSONObject  getMyBeneficiaryData(){
        return  new JSONObject()
            .put("requestChannelId", "TEST-MERCHANT") 
            .put("requestChannel", "Api")
            .put("requestChannelType", "Integrator")
            .put("requestApplicationCode", "POUCHII")
            .put("requestPartnerCode", "TEST-MERCHANT") 
            .put("customerReference", "");
     } 
     
     
     
      public  static JSONObject  getBillerProvidersData(){
        return  new JSONObject()
            .put("requestChannelId", "TEST-MERCHANT") 
            .put("requestChannel", "Api")
            .put("requestChannelType", "Integrator")
            .put("requestApplicationCode", "POUCHII")
            .put("requestPartnerCode", "TEST-MERCHANT") 
            .put("customerReference", "");
     } 
     
      
      
   
       
        
     
     
}
 