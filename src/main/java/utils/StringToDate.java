package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class returns literal dates converted to date format.
 */
public class StringToDate {
    private Date date;
    private SimpleDateFormat formatter;
    private String result;

    /**
     * Converts literal date String to a string in date format.
     *
     * @param stringToConvert a literal date String.
     * @return a string in date format.
     */
    public String convert(final String stringToConvert) {
        String resultDate = "";
        if (stringToConvert == null) {
            throw new RuntimeException("Value is null");
        }
        if (stringToConvert.equals("")) {
            throw new RuntimeException("Value is empty");
        }

        if (stringToConvert.matches("TODAY|TOMORROW|YESTERDAY")) {
            resultDate = dayName(stringToConvert);
        }

        if (stringToConvert.contains("from now")) {
            resultDate = futureValue(stringToConvert);
        }

        if (stringToConvert.contains("ago")) {
            resultDate = pastValue(stringToConvert);
        }
        return resultDate;
    }

    /**
     * Converts 'TODAY, TOMORROW, YESTERDAY' to a string in date format.
     *
     * @param dateString a literal date String.
     * @return a string in date format.
     */
    public String dayName(final String dateString) {
        String date = null;
        if ("TODAY".equals(dateString)) {
            date = getTodayDate();
        }
        if ("TOMORROW".equals(dateString)) {
            date = getFuture(1, Calendar.DATE);
        }
        if ("YESTERDAY".equals(dateString)) {
            date = getPast(1, Calendar.DATE);
        }
        return date;
    }

    /**
     * Converts literal dates that contains 'from now' to a string in date format.
     *
     * @param dateString a literal date String.
     * @return a string in date format.
     */
    public String futureValue(final String dateString) {
        String dateResult = null;
        if (dateString.contains(" years ")) {
            dateResult = getFuture(getIntFromString(dateString), Calendar.YEAR);
        }

        if (dateString.contains(" months ")) {
            dateResult = getFuture(getIntFromString(dateString), Calendar.MONTH);
        }

        if (dateString.contains(" days ") || dateString.contains(" day ")) {
            dateResult = getFuture(getIntFromString(dateString), Calendar.DATE);
        }

        return dateResult;
    }

    /**
     * Converts literal dates that contains 'ago' to a string in date format.
     *
     * @param dateString a literal date String.
     * @return a string in date format.
     */
    public String pastValue(final String dateString) {
        String dateResult = null;
        if (dateString.contains(" years ")) {
            dateResult = getPast(getIntFromString(dateString), Calendar.YEAR);
        }

        if (dateString.contains(" months ")) {
            dateResult = getPast(getIntFromString(dateString), Calendar.MONTH);
        }

        if (dateString.contains(" days ") || dateString.contains(" day ")) {
            dateResult = getPast(getIntFromString(dateString), Calendar.DATE);
        }

        return dateResult;
    }

    /**
     * Gets a number that is inside a string.
     *
     * @param string a string that contains a number.
     * @return a number that is inside a string.
     */
    public int getIntFromString(final String string) {
        return Integer.parseInt(string.replaceAll("[\\D]", ""));
    }

    /**
     * Gets actual date in an string in date format.
     *
     * @return a string in date format.
     */
    public String getTodayDate() {
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        result = formatter.format(date);
        return result;
    }

    /**
     * Gets a future 'day, month, year' in an string in date format.
     *
     * @param number the number of 'day, month, year' from now.
     * @param type the type of value (day, month, year)
     * @return a string in date format.
     */
    public String getFuture(final int number, final int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(type, number);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        result = formatter.format(date);
        return result;
    }

    /**
     * Gets a past 'day, month, year' in an string in date format.
     *
     * @param number the number of 'day, month, year' ago.
     * @param type the type of value (day, month, year)
     * @return a string in date format.
     */
    public String getPast(final int number, final int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(type, - number);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        result = formatter.format(date);
        return result;
    }

}
