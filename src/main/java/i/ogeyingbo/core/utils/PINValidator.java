/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PINValidator  {
     

    // digit  
    private static final String PIN_PATTERN =  "^(?=.*[0-9])";
     
    private static final Pattern pattern = Pattern.compile(PIN_PATTERN);

    public static boolean isValid(final String pin) {
        Matcher matcher = pattern.matcher(pin);
        return matcher.matches();
    }
    
    
  
    public static boolean isAcceptablePIN(String pin) {
        // Validate strong password
        return  Pattern.compile(PIN_PATTERN)
               .matcher(pin)
               .find();  
    }


    
}

