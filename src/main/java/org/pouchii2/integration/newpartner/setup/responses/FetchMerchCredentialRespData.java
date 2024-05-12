/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class FetchMerchCredentialRespData {
    
    private  String  publicKey  = "";
    private  String  secretKey  = "";
    private  String  encryptionKey  = "";
    private  String  merchantId  = "";
    
    
    public  String  getPublicKey(){
        return  publicKey;
    }
    
    public  String  getSecretKey(){
        return  secretKey;
    }
    
    public  String  getEncryptionKey(){
        return  encryptionKey;
    }
    
    public  String  getMerchantId(){
        return  merchantId;
    }
    
    
    
    
    public  void  getPublicKey(String  inPublicKey){
           publicKey = inPublicKey;
    }
    
    public  void  getSecretKey(String  inSecretKey){
           secretKey = inSecretKey;
    }
    
    public  void  getEncryptionKey(String  inEncryptionKey){
           encryptionKey = inEncryptionKey;
    }
    
    public  void  getMerchantId(String  inMerchantId){
           merchantId = inMerchantId;
    }
    
    
    
    
}
