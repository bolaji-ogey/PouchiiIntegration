/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

/**
 *
 * @author Bolaji
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
 
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import  java.util.Base64;

/**
 *
 * @author bogeyingbo
 */
public class AESUtil {
      
    private static final String PRIVATE_KEY = "AES_KEY";  // !123456_#9ABCDEF";
    private static final String ALGO = "AES";
    private static  byte[] keyValue;
    private  static  final  String   IVector   =    "1234567890123456";
    
   
    
public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(n);
    SecretKey key = keyGenerator.generateKey();
    return key;
}





public static SecretKey getKeyFromPassword(String password, String salt)
    throws NoSuchAlgorithmException, InvalidKeySpecException {
    
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
    SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
        .getEncoded(), "AES");
    return secret;
}



public static IvParameterSpec generateIv() {
    byte[] iv = new byte[16];
    new SecureRandom().nextBytes(iv);
    return new IvParameterSpec(iv);
}



    
    
    
public static String encrypt(String algorithm, String input, SecretKey key,
    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
    InvalidAlgorithmParameterException, InvalidKeyException,
    BadPaddingException, IllegalBlockSizeException {
    
    Cipher cipher = Cipher.getInstance(algorithm);
    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
    byte[] cipherText = cipher.doFinal(input.getBytes());
    return Base64.getEncoder()
        .encodeToString(cipherText);
}
    
    
    
public static String decrypt(String algorithm, String cipherText, SecretKey key,
    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
    InvalidAlgorithmParameterException, InvalidKeyException,
    BadPaddingException, IllegalBlockSizeException {
    
    Cipher cipher = Cipher.getInstance(algorithm);
    cipher.init(Cipher.DECRYPT_MODE, key, iv);
    byte[] plainText = cipher.doFinal(Base64.getDecoder()
        .decode(cipherText));
    return new String(plainText);
}
    
 
    
    public  void  doRun(){
         String encodedString = Base64.getEncoder().encodeToString("8101".getBytes());
        
         byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
         String decodedString = new String(decodedBytes);

         System.out.println(decodedString);
    }
    
    
    public    static  void  main(String[]  args)
    {
        
         String encodedString = Base64.getEncoder().encodeToString("8101".getBytes());
         System.out.println(encodedString);
        
         byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
         String decodedString = new String(decodedBytes);

         System.out.println(decodedString);
    }
 

    
}

