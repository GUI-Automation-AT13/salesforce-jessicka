package unittests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.StringToDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringToDateTests {
    private StringToDate stringToDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @BeforeTest
    public void setup() {
        stringToDate = new StringToDate();
    }

    @Test
    public void testTodayDate() {
        Calendar newCalendar = Calendar.getInstance();
        Date expected = newCalendar.getTime();
        Date actual = stringToDate.convert("TODAY");
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testTomorrowDate() {
        Calendar newCalendar = Calendar.getInstance();
        Date actual = stringToDate.convert("TOMORROW");
        newCalendar.add(Calendar.DATE, 1);
        Date expected = newCalendar.getTime();
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testYesterdayDate() {
        Calendar newCalendar = Calendar.getInstance();
        Date actual = stringToDate.convert("YESTERDAY");
        newCalendar.add(Calendar.DATE, - 1);
        Date expected = newCalendar.getTime();
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testTenDaysAgoDate() {
        Calendar newCalendar = Calendar.getInstance();
        Date actual = stringToDate.convert("10 days ago");
        newCalendar.add(Calendar.DATE,- 10);
        Date expected = newCalendar.getTime();
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testTenDaysFromNowDate() {
        Calendar newCalendar = Calendar.getInstance();
        Date actual = stringToDate.convert("10 days from now");
        newCalendar.add(Calendar.DATE, 10);
        Date expected = newCalendar.getTime();
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testTenMonthsAgoDate() {
        Calendar newCalendar = Calendar.getInstance();
        Date actual = stringToDate.convert("10 months ago");
        newCalendar.add(Calendar.MONTH,- 10);
        Date expected = newCalendar.getTime();;
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testTenMonthsFromNowDate() {
        Calendar newCalendar = Calendar.getInstance();
        Date actual = stringToDate.convert("10 months from now");
        newCalendar.add(Calendar.MONTH, 10);
        Date expected = newCalendar.getTime();
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testTenYearsAgoDate() {
        Calendar newCalendar = Calendar.getInstance();
        Date actual = stringToDate.convert("10 years ago");
        newCalendar.add(Calendar.YEAR,- 10);
        Date expected = newCalendar.getTime();
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testTenYearsFromNowDate() {
        Calendar newCalendar = Calendar.getInstance();
        Date actual = stringToDate.convert("10 years from now");
        newCalendar.add(Calendar.YEAR, 10);
        Date expected = newCalendar.getTime();
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testValidDate() throws ParseException {
        stringToDate = new StringToDate();
        Date actual = stringToDate.convert("7/14/2021");
        Date expected = dateFormat.parse("7/14/2021");
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
            expectedExceptionsMessageRegExp = "Value is null.*")
    public void testNullDate() {
        Date actual = stringToDate.convert(null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
            expectedExceptionsMessageRegExp = "Value is empty.*")
    public void testEmptyDate() {
        Date actual = stringToDate.convert("");
    }
}
