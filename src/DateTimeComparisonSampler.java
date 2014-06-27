import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Debbie on 23/06/2014.
 * Comparing usage differences between old Date/Time classes and new API
 */
public class DateTimeComparisonSampler {

    public static int numberOfDaysWrongJava7(String fromDateStr,String toDateStr)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fromDate = new Date();
        Date toDate = new Date();
        try {
            fromDate = dateFormat.parse(fromDateStr);
            toDate = dateFormat.parse(toDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
        //This is often seen as a way to get the number of days between 2 dates
        //but it won't always give the right answer if your span crosses a daylight
        //saving change - see what happens in the output from main
        return (int)( (toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static int numberOfDaysBetterJava7(String fromDateStr, String toDateStr)
    {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fromDate = new Date();
        Date toDate = new Date();
        try {
            fromDate = dateFormat.parse(fromDateStr);
            toDate = dateFormat.parse(toDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

        return getDaysBetween(fromDate, toDate);

    }

    private static int getDaysBetween(Date fromDate, Date toDate) {
        java.util.Calendar cal1 = new java.util.GregorianCalendar();
        java.util.Calendar cal2 = new java.util.GregorianCalendar();
        cal1.setTime(fromDate);
        cal2.setTime(toDate);

        int daysBetween = 0;
        while (cal1.before(cal2)) {
            cal1.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

    public static long numberOfDaysJava8Style(String fromDateStr, String toDateStr){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fromDate = LocalDate.parse(fromDateStr, dateFormat );
        LocalDate toDate = LocalDate.parse(toDateStr, dateFormat);

        return getDaysBetween(fromDate, toDate);
    }

    private static long getDaysBetween(LocalDate fromDate, LocalDate toDate) {
        return ChronoUnit.DAYS.between(fromDate, toDate);
    }

    public static void main(String args[]){

        String[][] dateExamples = new String [][]{{"24-04-2013", "27-04-2013"},{"24-10-2014","27-10-2014"},{"29-03-2014","31-03-2014"},{"01-04-2014","31-03-2014"}} ;
        for (String[] testData  : dateExamples) {
            int num = DateTimeComparisonSampler.numberOfDaysWrongJava7(testData[0], testData[1]);
            System.out.println(new StringBuilder().append("Number of days between ")
                    .append(testData[0]).append(" and ")
                    .append(testData[1]).append(" are: ")
                    .append(num).toString());
        }
        for (String[] testData  : dateExamples) {
            int num = DateTimeComparisonSampler.numberOfDaysBetterJava7(testData[0], testData[1]);
            System.out.println(new StringBuilder().append("Number of days between ")
                    .append(testData[0]).append(" and ")
                    .append(testData[1]).append(" are: ")
                    .append(num).toString());
        }
        for (String[] testData  : dateExamples) {
            long num = DateTimeComparisonSampler.numberOfDaysJava8Style(testData[0], testData[1]);
            System.out.println(new StringBuilder().append("Number of days between ")
                    .append(testData[0]).append(" and ")
                    .append(testData[1]).append(" are: ")
                    .append(num).toString());
        }
    }
}
