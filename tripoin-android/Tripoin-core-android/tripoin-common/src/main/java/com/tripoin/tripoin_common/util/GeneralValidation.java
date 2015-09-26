package com.tripoin.tripoin_common.util;

import android.widget.EditText;

import com.tripoin.tripoin_common.dto.DTOPasswordValidMessenger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created on 10/1/2014.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * Validating input from user to proper format
 */
public class GeneralValidation {

    /**
     * Validate if birthdate is valid
     * @param birthDate String
     * @param validAge int
     * @return boolean
     */
    public boolean isValidAge( String birthDate, int validAge ){
        boolean result;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar bdCal = Calendar.getInstance();
        try {
            bdCal.setTime( df.parse( birthDate ) );
            if( getAge( bdCal.get(Calendar.YEAR), bdCal.get(Calendar.YEAR), bdCal.get(Calendar.YEAR) ) >= validAge  ){
                result = true;
            }else{
                result = false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }


    /**
     * Get age
     * @param year int
     * @param month int
     * @param day int
     * @return int
     */
    public int getAge(int year, int month, int day) {
        Date now = new Date();
        int nowMonth = now.getMonth()+1;
        int nowYear = now.getYear()+1900;
        int result = nowYear - year;

        if (month > nowMonth) {
            result--;
        }
        else if (month == nowMonth) {
            int nowDay = now.getDate();

            if (day > nowDay) {
                result--;
            }
        }
        return result;
    }

    /**
     * Validate Email
     * @param email String
     * @return boolean
     */
    public boolean isValidEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        boolean result;
        email = email.trim();
        result = email.matches(emailPattern) && email.length() > 0;
        return result;
    }

    /**
     * Validate if a String is a Phone Number
     * @param phoneNumber String
     * @return boolean
     */
    public boolean isValidPhoneNumber(String phoneNumber){
        String phoneNumberPattern = "^([0-9\\(\\)\\/\\+ \\-]*)$";
        boolean result;
        phoneNumber = phoneNumber.trim();
        result = phoneNumber.matches( phoneNumberPattern ) && phoneNumber.length() > 0;
        return result;
    }

    /**
     * Validate if a String contains at Least 1 UpperCase
     * @param str String
     * @return boolean
     */
    public boolean isContainUpperCase(String str){
        String pattern = ".*[A-Z].*";
        boolean result;
        str = str.trim();
        result = str.matches( pattern );
        return result;
    }

    /**
     * Validate if a String contain at least one LowerCase
     * @param str String
     * @return boolean
     */
    public boolean isContainLowerCase(String str){
        String pattern = ".*[a-z].*";
        boolean result;
        str = str.trim();
        result = str.matches( pattern );
        return result;
    }

    /**
     * Validate if a String contain at Least one Numeric
     * @param str String
     * @return boolean
     */
    public boolean isContainNumber(String str){
        String pattern = ".*\\d.*";
        boolean result;
        str = str.trim();
        result = str.matches( pattern );
        return result;
    }

    /**
     * Validate if a String contain at Least one Special Symbols ( @#$% )
     * @param str String
     * @return boolean
     */
    public boolean isContainSpecialSymbols(String str){
        String pattern = ".*[@*$!].*";
        boolean result;
        str = str.trim();
        result = str.matches( pattern );
        return result;
    }

    /**
     * Validate if a String length is min 8 max 20
     * @param str String
     * @return boolean
     */
    public boolean isInDeterminedLength(String str){
        String pattern = ".{8,20}";
        boolean result;
        str = str.trim();
        result = str.matches( pattern );
        return result;
    }


    /**
     * Validate Numeric input
     * @param value String
     * @return boolean
     */
    public boolean isValidNumeric(String value){
        String numericPattern = "[0-9]+?";
        boolean result;
        value = value.trim();
        result = value.matches(numericPattern) && value.length() > 0;
        return result;
    }

    /**
     * Validate IP Address
     * @param ipAddress String
     * @return boolean
     */
    public boolean isValidIpAddress(String ipAddress){
        String ipPattern = "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
        boolean result;
        ipAddress = ipAddress.trim();
        result = ipAddress.matches(ipPattern) && ipAddress.length() > 0;
        return result;
    }

    /**
     * Validate EditText whether empty or not
     * true = not empty
     * false = empty
     * @param editText EditText
     * @return boolean
     */
    public boolean isEmptyEditText(EditText editText){
        return !(editText.getText() != null && editText.getText().toString().length() > 0);
    }


    /**
     * Validate Scheduler to work at working day and hour only
     * Working day = MONDAY to FRIDAY
     * @param startWorkingHour int
     * @param stopWorkingHour int
     * @return boolean
     */
    public boolean isWorkingHour( int startWorkingHour, int stopWorkingHour ){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get( Calendar.DAY_OF_WEEK );
        boolean result;
        /*if( (day> Calendar.SUNDAY) && (day< Calendar.SATURDAY) ){*/
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            result = (currentHour >= startWorkingHour) && (currentHour < stopWorkingHour);
        /*}else{
            result = false;
        }*/
        return result;
    }

    /**
     * Validate password with requirements :
     * - must contains one digit from 0-9
     * - must contains one lowercase characters
     * - must contains one uppercase characters
     * - must contains one special symbols in the list "@#$%"
     * - match anything with previous condition checking
     * - length at least 6 characters and maximum of 20
     * @param password String
     * @return boolean
     */
    public boolean isValidPasswordBundle(String password){
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * Validate password with requirements :
     * - must contains one digit from 0-9
     * - must contains one lowercase characters
     * - must contains one uppercase characters
     * - must contains one special symbols in the list "@#$%"
     * - match anything with previous condition checking
     * - length at least 6 characters and maximum of 20
     * @param password String
     * @return String
     */
    public DTOPasswordValidMessenger isValidPasswordPerMessage(String password){
        DTOPasswordValidMessenger dtoPasswordValidMessenger = new DTOPasswordValidMessenger();
        if( isContainNumber( password ) ){
            dtoPasswordValidMessenger.setResult(true);
            if( isContainLowerCase( password )){
                dtoPasswordValidMessenger.setResult(true);
                if( isContainUpperCase( password )){
                    dtoPasswordValidMessenger.setResult(true);
                    if( isContainSpecialSymbols( password ) ){
                        dtoPasswordValidMessenger.setResult(true);
                        if( isInDeterminedLength( password )){
                            dtoPasswordValidMessenger.setResult(true);
                        }else{
                            dtoPasswordValidMessenger.setResult(false);
                            dtoPasswordValidMessenger.setMessage("Password length min 8 max 20");
                        }
                    }else{
                        dtoPasswordValidMessenger.setResult(false);
                        dtoPasswordValidMessenger.setMessage("Password should contain special symbols @#$%");
                    }
                }else{
                    dtoPasswordValidMessenger.setResult(false);
                    dtoPasswordValidMessenger.setMessage("Password should contain upper case");
                }
            }else{
                dtoPasswordValidMessenger.setResult(false);
                dtoPasswordValidMessenger.setMessage("Password should contain lower case");
            }
        }else{
            dtoPasswordValidMessenger.setResult(false);
            dtoPasswordValidMessenger.setMessage("Password should contain number");
        }
        return dtoPasswordValidMessenger;
    }

    /**
     * Validate a String only contains a number in specific 45 characters range
     * @param str
     * @return boolean
     */
    public boolean isOnlyNumbersLimited45( String str ){
        String pattern = "^[0-9]{1,45}$";
        boolean result;
        str = str.trim();
        result = str.matches( pattern );
        return result;
    }



}
