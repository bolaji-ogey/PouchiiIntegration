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
public class TrxnAmountValidator {
    
    
    // digit  
    private static final String TRXN_AMT_PATTERN =  "^(?=.*[.0-9])";
     
    private static final Pattern pattern = Pattern.compile(TRXN_AMT_PATTERN);

    public static boolean isValid(final String trxnAmt) {
        Matcher matcher = pattern.matcher(trxnAmt);
        return matcher.matches();
    }
    
        
  
    public static boolean isAcceptableTrxnAmt(String  trxnAmt) {
        // Validate strong password
        return  Pattern.compile(TRXN_AMT_PATTERN)
               .matcher(trxnAmt)
               .find();  
    }
    
}
