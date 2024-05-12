/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */ 
 import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



public class AESWithKey2 {

  private static SecretKeySpec secretKey;
  private static byte[] key;

  public static void setKey(final String myKey) {
    MessageDigest sha = null;
    try {
      key = myKey.getBytes("UTF-8");
      sha = MessageDigest.getInstance("SHA-256");
      key = sha.digest(key);
      key = Arrays.copyOf(key, 16);
      secretKey = new SecretKeySpec(key, "AES");
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  public static String encrypt(final String strToEncrypt, final String secret) {
    try {
      setKey(secret);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      return Base64.getEncoder()
        .encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    } catch (Exception e) {
      System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
  }

  
  
  
  
  public static String decrypt(final String strToDecrypt, final String secret) {
    try {
      setKey(secret);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      return new String(cipher.doFinal(Base64.getDecoder()
        .decode(strToDecrypt)));
    } catch (Exception e) {
      System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
  }
 
  
  
  
  
  
  

   
     public static void testLargeBigDecimal(String  keyString) {
         try {
        	 
               BigDecimal   value =  new BigDecimal(111111111111111.00); 
             
               System.out.println("value.precision(): "+value.precision());
               BigDecimal   value2 =  new BigDecimal(111111111111111.00); 
               value = value.add(value2); 
               
             String encryptedData = AESWithKey.encrypt(String.valueOf(value), keyString); 
             String decryptedData = AESWithKey.decrypt(encryptedData, keyString);
             
             System.out.println(new BigDecimal(decryptedData));

             System.out.println("Encrypted Data : " + encryptedData);
             System.out.println("Decrypted Data : " + decryptedData);
         } catch (Exception ignored) {
         }
     } 

     
     
     
     
     public static void testLargeBigDecimalAdd(String  keyString) {
         try { 
             
               BigDecimal   value =  new BigDecimal(9999999999999.99); 
             
               System.out.println("value.precision(): "+value.precision());
               BigDecimal   value2 =  new BigDecimal(9999999999999.99); 
               value = value.add(value2); 
               
               long   startTime  =    System.currentTimeMillis();
               
             String encryptedData = AESWithKey.encrypt(String.valueOf(value), keyString); 
             String decryptedData = AESWithKey.decrypt(encryptedData, keyString);
             
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
     
  

     
     
     public static void testLargeBigDecimalAdd(String   decimal1,   String  decimal2, String  keyString) {
         try { 
             
               BigDecimal   value =  new BigDecimal(decimal1); 
             
               System.out.println("value.precision(): "+value.precision());
               BigDecimal   value2 =  new BigDecimal(decimal2); 
               value = value.add(value2); 
               
               long   startTime  =    System.currentTimeMillis();
               
             String encryptedData =  AESWithKey.encrypt(String.valueOf(value), keyString); 
             String decryptedData =  AESWithKey.decrypt(encryptedData, keyString);
             
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
             //   AES256.testLargeBigDecimalAdd("99364265285.2","99711974474.2");   // Ideal wallet tier
            //   AES256.testLargeBigDecimalAdd("436426528589.99","571197447478.99");   // Exceptional wallet tier
        	// AES256.testLargeBigDecimalAdd("4364265285.2","5711974474.2"); // Normal customer wallet
                 AESWithKey2.testLargeBigDecimalAdd("99999999999.99","99999999999.99", "Hello"); // Real Ideal wallet tier / Normal wallet
        	 /***
        	System.out.println(runtime.availableProcessors());
        	runtime.freeMemory(); 
        	**/
          
        } catch (Exception ignored) {
        }
    } 
      
      
    
}
