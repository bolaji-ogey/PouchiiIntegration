
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
public class AccountType {
    public static final short CUSTOMER_LOYALTY    = 1;
    public static final short DONATION             = 2;
    public static final short COLLECTIONANDCREDIT = 3;
    public static final short INVESTMENT          = 4;
    
     public static final short  MAX_ACCOUNT_TYPE         = 4;
    
    
       public static String getDepositType(short accountType) {
        String retAccountType = "";

        switch (accountType) {
        case CUSTOMER_LOYALTY  : {
            retAccountType = "loyaltydeposits";

            break;
        }

        case DONATION : {
            retAccountType = "donationdeposits";

            break;
        }

        case COLLECTIONANDCREDIT : {
            retAccountType = "collectionandcreditdeposits";

            break;
        }

        case INVESTMENT : {
            retAccountType = "investmentdeposits";

            break;
        }

        default : {
            retAccountType = "loyaltydeposits";

            break;
        }
        }

        return retAccountType;
    }
       

    public static String getAccountType(short accountType) {
        String retAccountType = "";

        switch (accountType) {
        case CUSTOMER_LOYALTY  : {
            retAccountType = "loyaltyaccount";

            break;
        }

        case DONATION : {
            retAccountType = "donationaccount";

            break;
        }

        case COLLECTIONANDCREDIT : {
            retAccountType = "collectionandcreditaccount";

            break;
        }

        case INVESTMENT : {
            retAccountType = "investmentaccount";

            break;
        }

        default : {
            retAccountType = "loyaltyaccount";

            break;
        }
        }

        return retAccountType;
    }

    public static String getFlowType(short accountType) {
        String inFlowType = "";

        switch (accountType) {
        case CUSTOMER_LOYALTY  : {
            inFlowType = "loyalty";

            break;
        }

        case DONATION : {
            inFlowType = "donation";

            break;
        }

        case COLLECTIONANDCREDIT : {
            inFlowType = "collectionandcredit";

            break;
        }

        case INVESTMENT : {
            inFlowType = "investment";

            break;
        }

        default : {
            inFlowType = "loyalty";

            break;
        }
        }

        return inFlowType;
    }

    public static String getType(short accountType) {
        String type = "";

        switch (accountType) {
        case CUSTOMER_LOYALTY  : {
            type = "loyalty";

            break;
        }

        case DONATION : {
            type = "donation";

            break;
        }

        case COLLECTIONANDCREDIT : {
            type = "collectionandcredit";

            break;
        }

        case INVESTMENT : {
            type = "investment";

            break;
        }

        default : {
            type = "loyalty";

            break;
        }
        }

        return type;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
