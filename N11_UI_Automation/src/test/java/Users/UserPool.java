package Users;
/**
 * Created by onur on 10/12/21.
 */
import java.util.Random;

public class UserPool {

    public static AccountInformation getUserFirst() {
        return new AccountInformation("qquestionanswerr@gmail.com", "qwe123?");
    }
    public static AccountInformation getUserSecond() {
        return new AccountInformation("onur", "345dfg?");
    }
    public static AccountInformation getUserThird() {
        return new AccountInformation("qquestionanswerr@gmail.com", "dfhsd3");
    }
    public static AccountInformation getUserFourth() {
        return new AccountInformation("asdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşi", "erw45435");
    }

    public static AccountInformation getUserFıve() {
        return new AccountInformation("asdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşi", "");
    }
    public static AccountInformation getUserSix() {
        return new AccountInformation("qquestionanswerr@gmail.com", "1234567890asdfghjk");
    }
    public static AccountInformation getUserSeven() {
        return new AccountInformation("qquestionanswerr@gmail.com", "rr");
    }
    public static AccountInformation getUserEight() {
        return new AccountInformation("asdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşi", "er");
    }
    public static AccountInformation getUserNine() {
        return new AccountInformation("asdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşi", "1234567890asdfghjk");
    }

    public static AccountInformation getUserJustMail() {
        return new AccountInformation("qquestionanswerr@gmail.com" );
    }

    public static AccountInformation getUserDoenstInSystem() {
        return new AccountInformation("sdfsdlkfjdsklvd34534sşcasa,@gmail.com" );
    }
    public static AccountInformation getUserMoreLegth48() {
        return new AccountInformation("sdfsdlkfjdsklvd34534sşcasaasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşiasdfghjklşi@gmail.com" );
    }
}
