/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.requests;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class FetchMerchantCredentials  extends   PouchiiAdminRequestBase {
    
    private final String  requestMethod  = "GET";
    private final String  url  = "https://stagingapi.pouchii.net/identityservice/rest/api/fetch/merchant/credentials";
    
    
    public  String  getRequestMethod(){
        return  requestMethod;
    }
    
    public  String  getUrl(){
        return  url;
    }
    
    
}
