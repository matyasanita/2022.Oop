package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static boolean leapYear(int year){
        boolean leap = false;

        if (year % 4 == 0){
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }

        return leap;
    }

    public static boolean isValidDate(int year, int month, int day){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        if ( year > 0 ){
            if (month > 0 && month <= 12){
                if (day > 0 && day < 32){
                    //feb
                    if (month == 2){
                        if (leapYear(year) && day != 29)
                            return false;
                        else if (!leapYear(year) && day != 28)
                            return false;
                    }
                    //jan, march, may, july, august, october, november, december
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 ||month == 12 )
                        if (day != 31)
                            return false;

                    //april, june, september, november
                    if (month == 4 || month == 6 || month == 9 || month == 11 )
                        if (day != 30)
                            return false;
                }
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;

        return true;
    }
}

