/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * this class is responsible to get the current date in the system
 * and transform date to String when writing to a CSV File and String to Date when read by the program to construct the object
 * @author Francisco
 */
public class DateFormatUtil {
    /**
     * gets a String and parse as a date
     * @param dateStr
     * @return
     */
    public static Date fromString(String dateStr) {
        if(dateStr==null || dateStr.isEmpty()){
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateStr);
        } catch (ParseException ex) {
            System.out.println(dateStr);
            
            Logger.getLogger(DateFormatUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * gets a String and cast Parse into a date
     * @param date
     * @return
     */
    public static String asString(Date date) {
        if(date==null)return "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
    /**
     * returns the current date
     * @return 
     */
    public static Date today() {
        return Calendar.getInstance().getTime();
        
    }
}
