/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.integration.newpartner.setup.requests;

 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class FetchApplicationPartner {
    
 
     private final String  requestMethod  = "GET";
     private final String  url  = "https://stagingapi.pouchii.net/identityservice/rest/api/fetch/active/pouchii/partner/infos/0";
    
    
    public  String  getRequestMethod(){
        return  requestMethod;
    }
    
    public  String  getUrl(){
        return  url;
    }
    
}
