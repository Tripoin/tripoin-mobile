package com.tripoin.tripoin_common.util;

import android.util.Base64;

import com.tripoin.tripoin_common.constant.GeneralConstant;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created on 9/30/2014.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * Collector class to convert processed result for Activity
 */
public class GeneralConverter {

    private SimpleDateFormat simpleDateFormat;

    public String getMainUrl( String completeURl ){
        String result = completeURl.substring( 7, completeURl.length() );
        result  = removeLastChar( result );
        return result ;
    }

    /**
     * To convert BER ( Bit Error Rate ) into Signal Quality
     * @param ber
     * @return String
     */
    public String berToSignalQualityTelkomselBased(int ber){
        String result = "";
        if ( ber <= 0.2 ){
            result = "5";
        }else if ( ber > 0.2 && ber <= 0.4 ){
            result = "4";
        }else if ( ber > 0.4 && ber <= 0.8 ){
            result = "3";
        }else if( ber > 0.81 && ber <= 1.6 ){
            result = "2";
        }else if ( ber > 1.6 && ber <= 3.2 ){
            result = "1";
        }else if ( ber > 3.2 ){
            result = "0";
        }
        return result;
    }

    /**
     * To convert BER ( Bit Error Rate ) into Signal Quality
     * @param ber
     * @return String
     */
    public String berToSignalQuality(int ber){
        String result = "";
        if ( ber <= 0.2){
            result = "0";
        }else if ( ber > 0.2 && ber <= 0.4 ){
            result = "1";
        }else if ( ber > 0.4 && ber <= 0.8 ){
            result = "2";
        }else if( ber > 0.81 && ber <= 1.6 ){
            result = "3";
        }else if ( ber > 1.6 && ber <= 3.2 ){
            result = "4";
        }else if ( ber > 3.2 && ber <= 6.4 ){
            result = "5";
        }else if ( ber > 6.4 && ber <= 12.8){
            result = "6";
        }else if ( ber > 12.8){
            result = "7";
        }
        return result;
    }

    /**
     * Rounding up a value with N decimal places
     * @param value
     * @param decimalPlaces
     * @return double
     */
    public double roundingUp(double value, int decimalPlaces){
        BigDecimal bd = new BigDecimal( value );
        bd = bd.setScale( decimalPlaces, BigDecimal.ROUND_UP);
        value = bd.doubleValue();
        return value;
    }

    /**
     * Convert from Mbps To Kbps
     * @param value
     * @return double
     */
    public double mbpsToKbps(double value){
        return value * 1024;
    }


    /**
     * Convert string with first letter upper case
     * @param s
     * @return String
     */
    public String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    /**
     * Convert Date into Time format ( hh:mm:ss )
     * @param date
     * @return String
     */
    public String getDateToFormatTime(Date date){
        simpleDateFormat = new SimpleDateFormat( "hh:mm:ss" );
        return simpleDateFormat.format( date );
    }

    /**
     * Convert Date into Date only format
     * @param date
     * @return String
     */
    public String getDateToFormatDateColonSeparator(Date date){
        simpleDateFormat = new SimpleDateFormat( "yyyy:MM:dd" );
        return simpleDateFormat.format( date );
    }

    /**
     * Convert Date into Date only format
     * @param date
     * @return String
     */
    public String getDateToFormatDateHyphenSeparator(Date date){
        simpleDateFormat = new SimpleDateFormat( "dd-MM-yyyy" );
        return simpleDateFormat.format( date );
    }


    /**
     * Convert Date into Time format ( hh:mm:ss )
     * @param date
     * @return Date
     */
    public Date getDateToFormatTimeAsDate(Date date){
        simpleDateFormat = new SimpleDateFormat( "HH:mm:ss", Locale.ENGLISH );
        String result = simpleDateFormat.format( date );
        Date _result = null;
        try {
            _result = simpleDateFormat.parse(String.valueOf(result));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return _result;
    }

    /**
     * Converting date to proper format for Web service specification
     * @param date
     * @return
     */
    public String getDateToFormatDateWS( Date date ){
        simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS"  );
        return simpleDateFormat.format( date );
    }

    /**
     * Converting date to proper format for Web service specification
     * @param date
     * @return
     */
    public Date getDateToComparator( String date ){
        simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" );
        Date result = null;
        try {
            result = simpleDateFormat.parse( date );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * Converting date to proper format for Web service specification
     * @param date
     * @return
     */
    public String getDateToFormatTestId( Date date ){
        simpleDateFormat = new SimpleDateFormat( "yyyyMMddHHmmss"  );
        return simpleDateFormat.format(date);
    }


    /**
     * Convert from seconds to Minutes
     * @param seconds
     * @return double
     */
    public double secondToMinute(int seconds){
        double secondsDouble = Double.valueOf(seconds);
        return roundingUp( secondsDouble/60, 2 );
    }

    /**
     * Convert from seconds to Minutes
     * @param minute
     * @return double
     */
    public int minuteToSeconds(int minute){
        return minute * 60;
    }

    /**
     * Utility to remove last char of a String ( usually for URLBuilder in Web Service )
     * @param s
     * @return
     */
    public String removeLastChar( String s ){
        if ( s!= null && s!= "" ){
            return s.substring( 0 , s.length()-1 );
        }else{
            return "";
        }
    }

    /**
     * Removing special character used within web service data
     * @param s
     * @return
     */
    public String removeSpecialChar( String s ){
        try{
            return s.replaceAll("[^\\w\\s\\-_]", "");
        }catch (Exception e){
            return GeneralConstant.Punctuation.HYPHEN;
        }
    }

    /**
     * Get Time in Seconds from ISO8601 Format
     * @param data String
     * @return Integer
     */
    public Integer getDurationIso8601( String data ){
        String result = data.substring( 2, data.length() );
        Integer intResult = null;
        Integer mResult = 0 ;
        Integer sResult;
        if ( result.contains("M")){
            mResult = minuteToSeconds( Integer.valueOf(result.substring(0, result.indexOf("M"))) );
            sResult = Integer.valueOf(result.substring(result.indexOf("M") + 1, result.indexOf("S")));
        }else{
            sResult = Integer.valueOf(result.substring(0, result.indexOf("S")));
        }
        intResult = mResult + sResult;
        return intResult;
    }

    public String encodeToBase64(String s){
        return Base64.encodeToString(s.getBytes(), Base64.NO_WRAP);
    }
}
