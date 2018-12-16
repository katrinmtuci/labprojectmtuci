package com.plotnikova.oracle;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class TimeUtil {



    static Time time(String dateString) {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            java.util.Date date = simpleDateFormat.parse(dateString);
            return new Time(date.getTime());
        } catch (Exception e) {}
        return new Time(0);
    }


}
