
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
public class AccountClass {
    public static final short PLASTIC   = 1;
    public static final short BRONZE    = 2;
    public static final short SILVER    = 3;
    public static final short GOLD      = 4;
    public static final short PLATINIUM = 5;
    public static final short DIAMOND   = 6;

    // PLASTIC(1),BRONZE(2), SILVER(3), GOLD(4), PLATINIUM(5), DIAMOND(6);
    private short classOfAccount = PLASTIC;

    public static String getClass(short accountClass) {
        String type = "";

        switch (accountClass) {
        case 1 : {
            type = "PLASTIC";

            break;
        }

        case 2 : {
            type = "BRONZE";

            break;
        }

        case 3 : {
            type = "SILVER";

            break;
        }

        case 4 : {
            type = "GOLD";

            break;
        }

        case 5 : {
            type = "PLATINIUM";

            break;
        }

        case 6 : {
            type = "DIAMOND";

            break;
        }

        default : {
            type = "PLASTIC";

            break;
        }
        }

        return type;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
