/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  i.ogeyingbo.core.utils;

/**
 *
 * @author Bolaji
 */
public class ExtractUnitType {
    
    
    public static final short CUSTOMER_PERSON       = 1;
    public static final short ANONYMOUS_CUSTOMER    = 0;
    public static final short PROFIT               =  -1; 
      
    
       public static String getExtractUnitType(short  extractUnitTypeId) {
        String retExtractUnitType = "";

        switch (extractUnitTypeId) {
                case  CUSTOMER_PERSON  : {
                    retExtractUnitType = "CUSTOMER_PERSON";

                    break;
                }

                case ANONYMOUS_CUSTOMER : {
                    retExtractUnitType = "ANONYMOUS_CUSTOMER";

                    break;
                }

                case PROFIT: {
                    retExtractUnitType = "PROFIT";

                    break;
                }

     
                default : {
                       retExtractUnitType = "CUSTOMER_PERSON";

                    break;
                }
        }

        return   retExtractUnitType;
    }
       
    
       
       
       
       
       
}
