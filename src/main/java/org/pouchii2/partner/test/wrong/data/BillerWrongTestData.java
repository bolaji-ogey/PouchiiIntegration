/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.test.wrong.data;
 
import org.json.JSONObject;
import org.pouchii2.partner.base.AuthourizationInterface;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BillerWrongTestData  extends     AuthourizationInterface {
    
    public static  final String   ALL_BILLERS      = "/itex/billers";   // GET
    public static  final String   PURCHASE_VTU     = "/itex/purchase/vtu";    // POST
    public static  final String   LOOKUP_DATA      = "/itex/lookup/data";     // POST
    public static  final String   SUBSCRIBE_DATA   = "/itex/subscribe/data";    // POST
    public static  final String   VALIDATE_METER   = "/itex/validate/meter";     // POST
    
    public static  final String   PURCHASE_ELECTRICITY   = "/itex/purchase/electricity";    // POST
    public static  final String   VALIDATE_MULTICHOICE   = "/itex/validate/multichoice";     // POST
    public static  final String   MULTICHOICE_BOUQUETS   = "/itex/multichoice/bouquets";    // POST
    public static  final String   SUBSCRIBE_MULTICHOICE   = "/itex/subscribe/multichoice";     // POST
    public static  final String   VALIDATE_STARTIMES     = "/itex/validate/startimes";     // POST
    
    public static  final String   SUBSCRIBE_STARTIMES   = "/itex/subscribe/startimes";     // POST
    public static  final String   INTERNET_VALIDATION     = "/itex/internet/validattion";     // POST
    public static  final String   INTERNET_BUNDLES       = "/itex/internet/bundles";     // POST
    public static  final String   INTERNET_SUBSCRIBE     = "/itex/internet/subscribe";     // POST
    
    public static  final String   CABLETV_BOUQUETS      = "/itex/cabletv/bouquets";     // POST
    public static  final String   VALIDATE_CABLETV      = "/itex/validate/cabletv";     // POST
    public static  final String   SUBSCRIBE_CABLETV     = "/itex/subscribe/cabletv";     // POST
    
    
    
  
    public  static JSONObject  getPurchaseVTUData(){
        return  new JSONObject()
            .put("phoneNumber", "08083064718") 
            .put("paymentMethod", "cash")
            .put("service", "airtelvtu")
            .put("amount", "50")
            .put("clientReference", "ard4978716271752715157570") 
            .put("channel", "MOBILE")
            .put("sourceAccountNumber", "3129637109")
            .put("transactionPin", "1234")
            .put("narration", "airtime")
            .put("redeemBonus", false)
            .put("bonusAmount", 0);
    }
    
    
    
    
    public  static JSONObject  getLookupData(){
        return  new JSONObject()
            .put("service", "mtndata") 
            .put("channel", "MOBILE");
    }
    
    
   
    public  static JSONObject  getSubscribeIntData(){
        return  new JSONObject()
            .put("phoneNumber", "08083064718") 
            .put("code", "103")
            .put("paymentMethod", "cash")
            .put("service", "airteldata")
            .put("amount", "50")
            .put("clientReference", "ard4978716271752715157570") 
            .put("productCode", "MOBILE")
            .put("card", new JSONObject())
            .put("sourceAccountNumber", "3129637109")
            .put("transactionPin", "1234")
            .put("narration", "airtime")
            .put("redeemBonus", false)
            .put("bonusAmount", 0);
    }
     
     
    
    public  static JSONObject  getValidateMeterData(){
        return  new JSONObject()
            .put("meterNo", "14298190407")
            .put("accountType", "prepaid")
            .put("service", "ibedc")
            .put("amount", "100")
            .put("channel", "MOBILE");
    }
    
    
    
    
    public  static JSONObject  getBuyElectricityData(){
        return  new JSONObject()
            .put("customerPhoneNumber", "3492553479")
            .put("paymentMethod", "cash")
            .put("service", "ibedc")
            .put("clientReference", "ADB")
            .put("productCode", "prepaid-14298190407")
            .put("card", new JSONObject()) 
            .put("amount", 1)
            .put("sourceAccountNumber", "22311518724429")
            .put("transactionPin", "1111")
            .put("narration", "electricity")
            .put("redeemBonus", true)
            .put("bonusAmount", 0);
    }
    
    
    
    public  static JSONObject  getValidateMultichoiceData(){
        return  new JSONObject()
            .put("service", "multichoice") 
            .put("channel", "MOBILE")
            .put("type", "DSTV")
            .put("account", "1869593834")
            .put("smartCardCode", "039");
    }
    
    
    
    
    public  static JSONObject  getMultichoiceBouquetData(){
        return  new JSONObject()
            .put("service", "3492553479") 
            .put("type", "GOTV");
    }
    
    
    
    public  static JSONObject  getSubscribeMultichoiceData(){
        return  new JSONObject()
            .put("phone", "08095510360")
            .put("code", "")
            .put("renew", "true")
            .put("paymentMethod", "cash")
            .put("service", "multichoice")
            .put("clientReference", "039") 
            .put("productMonths", "1")
            .put("totalAmount", "1111")
            .put("productCode", "1111")
            .put("card", new JSONObject())
            .put("channel", "B2B")
            .put("transactionPin", "1111") 
            .put("narration", "DSTV Subscription")
            .put("redeemBonus", true)
            .put("bonusAmount", true);
    }
    
    
    
    public  static JSONObject  getValidateStartimesData(){
        return  new JSONObject()
            .put("service", "smile")
            .put("channel", "MOBILE")
            .put("type", "account")
            .put("account", "ADB")
            .put("smartCardCode", "1869593834");
    }
    
    
    
    
    public  static JSONObject  getSubscribeStartimesData(){
        return  new JSONObject()
            .put("phone", "08095510360")
            .put("bouquet", "BASIC")
            .put("cycle", "daily")
            .put("paymentMethod", "cash")
            .put("service", "startimes")
            .put("clientReference", "039") 
            .put("productCode", "1111")
            .put("card", new JSONObject())
            .put("sourceAccountNumber", "My Pouchii - Init Test Funds")
            .put("transactionPin", "1111") 
            .put("narration", "Startimes Subscription")
            .put("redeemBonus", "false")
            .put("bonusAmount", 0);
    }
    
    
    
    
    public  static JSONObject  getInternetValidationData(){
        return  new JSONObject()
            .put("service", "smile") 
            .put("channel", "MOBILE")
            .put("type", "account")
            .put("account", "1869593834");
    }
    
    
    
    
    public  static JSONObject  getInternetBundlesData(){
        return  new JSONObject()
            .put("service", "smile") 
            .put("channel", "MOBILE")
            .put("type", "account")
            .put("account", "1869593834");
    }
    
    
    
    
    public  static JSONObject  getInternetSubscribeData(){
        return  new JSONObject()
            .put("phone", "08095510360")
            .put("type", "subscription")
            .put("code", "624")
            .put("amount", "50")
            .put("paymentMethod", "cash")
            .put("service", "039") 
            .put("clientReference", "1111")
            .put("productCode", "22311518724429")
            .put("card", new JSONObject()) 
            .put("sourceAccountNumber", "1111")
            .put("transactionPin", "1111")
            .put("narration", "Smile Internet Subscription");
    }
    
    
    
    
    public  static JSONObject  getCableTvBouquetsData(){
        return  new JSONObject()
            .put("service", "startimes") 
            .put("type", "default");
    }
    
    
    
    
    public  static JSONObject  getValidateCabletvData(){
        return  new JSONObject()
            .put("service", "multichoice")
            .put("channel", "MOBILE")
            .put("type", "GOTV")
            .put("account", "70242492447")
            .put("amount", "1.0")
            .put("smartCardCode", "1239");
    }
    
    
    
    
    public  static JSONObject  getSubscribeCabletvData(){
        return  new JSONObject()
            .put("phone", "multichoice")
            .put("code", "RENEW")
            .put("paymentMethod", "cash")
            .put("service", "multichoice")
            .put("clientReference", "1.0")
            .put("pin", "1111")
            .put("productCode", "22311518724429")
            .put("card", "My Pouchii - Init Test Funds")
            .put("amount", 1)
            .put("sourceAccountNumber", "42794472")
            .put("transactionPin", "1111")
            .put("narration", "CableTV Subscription")
            .put("redeemBonus", "false")
            .put("bonusAmount", 0);
    }
    
    
     
    
    
    
    
}
 