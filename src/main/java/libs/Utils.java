package libs;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Utils {
    private Logger log;

    public Utils(){
        log = Logger.getLogger(getClass());
    }

    /**
     * Taking screenshot into .//target// + pathToScreenShot
     * @param pathToScreenShot
     * @param driver
     */
    public void screenShot(String pathToScreenShot, WebDriver driver){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(pathToScreenShot));
            log.info("ScreenShot: " + pathToScreenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hard wait
     * @param second
     */
    public static void waitABit(int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method returned SystemDateAndTime In Format yyyy-MM-dd_HH-mm-ss-SSS
     * @return
     */
    public static String getDateAndTimeFormated(){
        return getDateAndTime("yyyyMMddHHmmssSSS");
    }

    public static String getDateAndTimeCurrectChangedMin(int minutes) throws ParseException {
        return changeCurrentTimeMin("dd.MM.yyyy HH:mm:ss", minutes);
    }

    public static String getDateAndTimeCurrentChangedMinSec(int minutes, int seconds) throws ParseException {
        return changeCurrentTimeMinSec ("dd.MM.yyyy HH:mm:ss", minutes, seconds);
    }

    public static String getDateAndTimeCurrentChangedYear(int year) throws ParseException {
        return changeCurrentTimeYear ("dd.MM.yyyy HH:mm:ss", year);
    }

    public static String getDateAndTimeCurrentChangedDayHourMinSec(int days, int hours, int minutes, int seconds) throws ParseException {
        return changeCurrentTimeDayHourMinSec ("dd.MM.yyyy HH:mm:ss", days, hours, minutes, seconds);
    }

    /**
     * Method returned SystemDateAndTime
     * @return
     */
    private static String getDateAndTime(String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String dateFormated = dateFormat.format(date);
        System.out.println(dateFormated);
        return dateFormated;
    }

    private static String changeCurrentTimeMin(String format, int minutes) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String dateFormated = dateFormat.format(date);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dateFormated));
        c.add(Calendar.MINUTE, minutes);
        dateFormated = sdf.format(c.getTime());
        return dateFormated;
    }

    private static String changeCurrentTimeMinSec(String format, int minutes, int seconds) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String dateFormated = dateFormat.format(date);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dateFormated));
        c.add(Calendar.MINUTE, minutes);
        c.add(Calendar.SECOND, seconds);
        dateFormated = sdf.format(c.getTime());
        return dateFormated;
    }

    private static String changeCurrentTimeYear(String format, int year) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String dateFormated = dateFormat.format(date);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dateFormated));
        c.add(Calendar.YEAR, year);
        dateFormated = sdf.format(c.getTime());
        return dateFormated;
    }

    private static String changeCurrentTimeDayHourMinSec(String format, int days, int hours, int minutes, int seconds) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String dateFormated = dateFormat.format(date);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dateFormated));
        c.add(Calendar.HOUR, hours);
        c.add(Calendar.MINUTE, minutes);
        c.add(Calendar.SECOND, seconds);
        c.add(Calendar.DAY_OF_MONTH, days);
        dateFormated = sdf.format(c.getTime());
        return dateFormated;
    }



}
