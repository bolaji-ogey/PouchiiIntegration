 
import java.math.BigDecimal;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AES256 {
    
 
  private  static String SECRET_KEY = "my_super_secret_key";
  private  static  String SALT = "ssshhhhhhhhhhh!!!!";
  
  
  
  public   AES256(final String secretKey, final String salt){
	  synchronized(this) {
		  SECRET_KEY =  secretKey; 
		  SALT  = salt;
	  }
 }
  
  
  
   public   AES256(){
	  synchronized(this) {
		  SECRET_KEY =  "excuse_me_key"; 
		  SALT  = "watabambam";
	  } 
	  System.out.println("KEY USED >>> "+SECRET_KEY);
	  System.out.println("SALT USED >>> "+SALT+"\n\n");
  }
  
  
 
  public static String encrypt(String strToEncrypt) {
    try {
      byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      IvParameterSpec ivspec = new IvParameterSpec(iv);
 
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
      SecretKey tmp = factory.generateSecret(spec);
      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
 
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
      return Base64.getEncoder()
          .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
    } catch (Exception e) {
      System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
  }
 

  
 
  public static String decrypt(String strToDecrypt) {
    try {
      byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      IvParameterSpec ivspec = new IvParameterSpec(iv);
 
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
      SecretKey tmp = factory.generateSecret(spec);
      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
 
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
      return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    } catch (Exception e) {
      System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
  }
 




   
     public static void testLargeBigDecimal() {
         try {
        	 
             
               BigDecimal   value =  new BigDecimal(111111111111111.00); 
             
               System.out.println("value.precision(): "+value.precision());
               BigDecimal   value2 =  new BigDecimal(111111111111111.00); 
               value = value.add(value2); 
               
             String encryptedData = AES256.encrypt(String.valueOf(value)); 
             String decryptedData = AES256.decrypt(encryptedData);
             
             System.out.println(new BigDecimal(decryptedData));

             System.out.println("Encrypted Data : " + encryptedData);
             System.out.println("Decrypted Data : " + decryptedData);
         } catch (Exception ignored) {
         }
     } 

     
     
     
     
     public static void testLargeBigDecimalAdd() {
         try {
        	 
             
               BigDecimal   value =  new BigDecimal(9999999999999.99); 
             
               System.out.println("value.precision(): "+value.precision());
               BigDecimal   value2 =  new BigDecimal(9999999999999.99); 
               value = value.add(value2); 
               
               long   startTime  =    System.currentTimeMillis();
               
             String encryptedData = AES256.encrypt(String.valueOf(value)); 
             String decryptedData = AES256.decrypt(encryptedData);
             
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
     
  

     
     
     public static void testLargeBigDecimalAdd(String   decimal1,   String  decimal2) {
         try {
        	 AES256 aes_encryption = new AES256(); 
             
               BigDecimal   value =  new BigDecimal(decimal1); 
             
               System.out.println("value.precision(): "+value.precision());
               BigDecimal   value2 =  new BigDecimal(decimal2); 
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
               AES256.testLargeBigDecimalAdd("99364265285.2","99711974474.2");   // Ideal wallet tier
            //   AES256.testLargeBigDecimalAdd("436426528589.99","571197447478.99");   // Exceptional wallet tier
        	// AES256.testLargeBigDecimalAdd("4364265285.2","5711974474.2"); // Normal customer wallet
                // AES256.testLargeBigDecimalAdd("99999999999.99","99999999999.99"); // Real Ideal wallet tier / Normal wallet
        	 /***
        	System.out.println(runtime.availableProcessors());
        	runtime.freeMemory(); 
        	**/
                 
           //  AES256  aes256 =  new  AES256();
          
        } catch (Exception ignored) {
        }
    } 
      
      
      
      
}
