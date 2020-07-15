package br.comau.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15/07/2020
 */
public class ConvertMongoDate {
    private static String convertMongoDate(String val){
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat= new SimpleDateFormat("yyyy/MM/dd");
        try {
            String finalStr = outputFormat.format(inputFormat.parse(val));
            System.out.println(finalStr);
            return finalStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
