package unittests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.StringToDate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringToDateTests {
    private StringToDate stringToDate;
    private Date newActualDate;
    SimpleDateFormat dateFormat;

    @BeforeTest
    public void setup() {
        stringToDate = new StringToDate();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    }

    @Test
    public void testTodayDate() {
        Calendar newCalendar = Calendar.getInstance();
        newActualDate = newCalendar.getTime();
        String actual = stringToDate.convert("TODAY");
        String expected = dateFormat.format(newActualDate.getTime());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testTomorrowDate() {
        Calendar newCalendar = Calendar.getInstance();
        newActualDate = newCalendar.getTime();
        String actual = stringToDate.convert("TOMORROW");
        newCalendar.add(Calendar.DATE, 1);
        String expected = dateFormat.format(newCalendar.getTime());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testYesterdayDate() {
        Calendar newCalendar = Calendar.getInstance();
        newActualDate = newCalendar.getTime();
        String actual = stringToDate.convert("YESTERDAY");
        newCalendar.add(Calendar.DATE, - 1);
        String expected = dateFormat.format(newCalendar.getTime());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testTenDaysAgoDate() {
        Calendar newCalendar = Calendar.getInstance();
        newActualDate = newCalendar.getTime();
        String actual = stringToDate.convert("10 days ago");
        newCalendar.add(Calendar.DATE,- 10);
        String expected = dateFormat.format(newCalendar.getTime());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testTenDaysFromNowDate() {
        Calendar newCalendar = Calendar.getInstance();
        newActualDate = newCalendar.getTime();
        String actual = stringToDate.convert("10 days from now");
        newCalendar.add(Calendar.DATE, 10);
        String expected = dateFormat.format(newCalendar.getTime());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testTenMonthsAgoDate() {
        Calendar newCalendar = Calendar.getInstance();
        newActualDate = newCalendar.getTime();
        String actual = stringToDate.convert("10 months ago");
        newCalendar.add(Calendar.MONTH,- 10);
        String expected = dateFormat.format(newCalendar.getTime());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testTenMonthsFromNowDate() {
        Calendar newCalendar = Calendar.getInstance();
        newActualDate = newCalendar.getTime();
        String actual = stringToDate.convert("10 months from now");
        newCalendar.add(Calendar.MONTH, 10);
        String expected = dateFormat.format(newCalendar.getTime());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testTenYearsAgoDate() {
        Calendar newCalendar = Calendar.getInstance();
        newActualDate = newCalendar.getTime();
        String actual = stringToDate.convert("10 years ago");
        newCalendar.add(Calendar.YEAR,- 10);
        String expected = dateFormat.format(newCalendar.getTime());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testTenYearsFromNowDate() {
        Calendar newCalendar = Calendar.getInstance();
        newActualDate = newCalendar.getTime();
        String actual = stringToDate.convert("10 years from now");
        newCalendar.add(Calendar.YEAR, 10);
        String expected = dateFormat.format(newCalendar.getTime());
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = {RuntimeException.class})
    public void testNullDate() {
        String actual = stringToDate.convert(null);
    }

    @Test(expectedExceptions = {RuntimeException.class})
    public void testEmptyDate() {
        String actual = stringToDate.convert("");
    }
}
