package passwordGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetTodayDate {
    public String getTodayDate(){

        //get date as a string
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmmss");
        Date today = Calendar.getInstance().getTime();
        String myDate = df.format(today);
        return myDate;
    }

}
