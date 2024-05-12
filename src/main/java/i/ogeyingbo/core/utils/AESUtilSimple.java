/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import java.math.BigDecimal;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import sun.misc.*;

/**
 *
 * @author Bolaji
 */
public class AESUtilSimple {
    
      private SecretKey key;
    private final int KEY_SIZE = 128;
    private final int DATA_LENGTH = 128;
    private Cipher encryptionCipher;
    private boolean initDone =  false;
    
    
    
    public  AESUtilSimple(){
        this.init();
    }

    public void init()  {
    	try{
	        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	        keyGenerator.init(KEY_SIZE);
	        key = keyGenerator.generateKey();
	        initDone = true;
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    
    public  boolean getInitDone(){
        return initDone;
    }
    
    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }
    
    
    public String encrypt(String data) {
    	byte[] encryptedBytes = null;
   	    try{
	        byte[] dataInBytes = data.getBytes();
	        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
	        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
	        encryptedBytes = encryptionCipher.doFinal(dataInBytes);
   	    }catch(Exception ex){
   	    	ex.printStackTrace();
   	    }
        return encode(encryptedBytes);
    }

    
    
     public String decrypt(String encryptedData)  {
    	 byte[] decryptedBytes = null;
    	 try{
	        byte[] dataInBytes = decode(encryptedData);
	        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
	        GCMParameterSpec spec = new GCMParameterSpec(DATA_LENGTH, encryptionCipher.getIV());
	        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
	        decryptedBytes = decryptionCipher.doFinal(dataInBytes);
    	 }catch(Exception ex){
    		 ex.printStackTrace();
    	 }
	    return new String(decryptedBytes);
    }
     
     
     
     
     
   
     
     
     
     public static void testLargeBigDecimal() {
         try {
         	AESUtilSimple aes_encryption = new AESUtilSimple();
             aes_encryption.init(); 
             
               BigDecimal   value =  new BigDecimal(111111111111111.00); 
             
               System.out.println("value.precision(): "+value.precision());
               BigDecimal   value2 =  new BigDecimal(111111111111111.00); 
               value = value.add(value2); 
               
             String encryptedData = aes_encryption.encrypt(String.valueOf(value)); 
             String decryptedData = aes_encryption.decrypt(encryptedData);
             
             System.out.println(new BigDecimal(decryptedData));

             System.out.println("Encrypted Data : " + encryptedData);
             System.out.println("Decrypted Data : " + decryptedData);
         } catch (Exception ignored) {
         }
     } 

     
     
     
     
     public static void testLargeBigDecimalAdd() {
         try {
         	AESUtilSimple aes_encryption = new AESUtilSimple();
                  aes_encryption.init(); 
             
               BigDecimal   value =  new BigDecimal(9999999999999.99); 
             
               System.out.println("value.precision(): "+value.precision());
               BigDecimal   value2 =  new BigDecimal(9999999999999.99); 
               value = value.add(value2); 
               
               long   startTime  =    System.currentTimeMillis();
               
             String encryptedData = aes_encryption.encrypt(String.valueOf(value)); 
             String decryptedData = aes_encryption.decrypt(encryptedData);
             
             long   tmeTaken  =  (System.currentTimeMillis() - startTime);// / divisionTime;
         	java.sql.Time    endTime  =   new java.sql.Time(tmeTaken);
                 
               //  System.out.println("Time taken is: "+endTime);
                 System.out.println("Time taken is in milliseconds: "+tmeTaken); 
                 System.out.println("\n\n");
             
             System.out.println(new BigDecimal(decryptedData));

             System.out.println("Encrypted Data : " + encryptedData);
             System.out.println("Decrypted Data : " + decryptedData);
         } catch (Exception ignored) {
         }
     } 
     
     
     
     
      
     
     
     public static void main(String[] args) {
        try { 
            
            
            AESUtilSimple  aesUtil = new  AESUtilSimple();
            
            System.out.println(aesUtil.encrypt("John"));
            /**
        	//AESUtilSimple.testLargeBigDecimalAdd();
        	Runtime  runtime = Runtime.getRuntime();
        	System.out.println(runtime.availableProcessors());
        	runtime.freeMemory(); 
            ***/
                    
        } catch (Exception ignored) {
        }
    } 

    
     
     
     
     
     
     
     
    



}
