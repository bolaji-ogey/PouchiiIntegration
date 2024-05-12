/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RandomString {
    
    
        //  Generate Random Unbounded String With Plain Java
         public void givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
                byte[] array = new byte[7]; // length is bounded by 7
                new SecureRandom().nextBytes(array);
                String generatedString = new String(array, Charset.forName("UTF-8"));

                System.out.println(generatedString);
            }
    
    
           //  Generate Random Unbounded String With Plain Java - Lower case characters only
         public void givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {

                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'
                int targetStringLength = 10;
                SecureRandom  secureRandom = new SecureRandom();
                StringBuilder buffer = new StringBuilder(targetStringLength);
                for (int i = 0; i < targetStringLength; i++) {
                    int randomLimitedInt = leftLimit + (int) 
                      (secureRandom.nextFloat() * (rightLimit - leftLimit + 1));
                    buffer.append((char) randomLimitedInt);
                }
                String generatedString = buffer.toString();

                System.out.println(generatedString);
            }
         
         
         
          //  Generate Random Unbounded String With Plain Java - Lower case characters only (Java 8)
         public void givenUsingJava8_whenGeneratingRandomAlphabeticString_thenCorrect() {
                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'
                int targetStringLength = 10;
                SecureRandom  secureRandom = new SecureRandom();

                String generatedString = secureRandom.ints(leftLimit, rightLimit + 1)
                  .limit(targetStringLength)
                  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                  .toString();

                System.out.println(generatedString);
            }
         
         
         
         
          //  Generate Random Unbounded alphanumeric String With Plain Java (Java 8)
         public void givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            SecureRandom secureRandom = new SecureRandom();

            String generatedString = secureRandom.ints(leftLimit, rightLimit + 1)
              .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
              .limit(targetStringLength)
              .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
              .toString();

            System.out.println(generatedString);
        }
         
         
         
         
         
         //  Generate Bounded Random String With Apache Commons Lang
        public void givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect() {

            int length = 10;
            boolean useLetters = true;
            boolean useNumbers = false;
            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

            System.out.println(generatedString);
        }
         
         
         
        
        
        //    Generate Alphabetic String With Apache Commons Lang
        public void givenUsingApache_whenGeneratingRandomAlphabeticString_thenCorrect() {
            String generatedString = RandomStringUtils.randomAlphabetic(10);

            System.out.println(generatedString);
        }
         
    
        public void givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
          String generatedString = RandomStringUtils.randomAlphanumeric(10);

          System.out.println(generatedString);
      }
    
    
}
