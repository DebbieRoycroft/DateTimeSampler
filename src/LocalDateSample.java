import java.time.*;

/**
 * Created by Debbie on 27/06/2014.
 */
public class LocalDateSample {
    public static void main(String[] args){

        //Start with current system time (default timezone)
        LocalDate myLocalDate = LocalDate.now();
        //LocalDate lets us access various properties (this is just a sample)
        int monthDay = myLocalDate.getDayOfMonth();
        DayOfWeek weekDay = myLocalDate.getDayOfWeek();
        Month month = myLocalDate.getMonth();
        boolean isLeapYear = myLocalDate.isLeapYear();
        System.out.printf("myLocalDate is %s today is %s %d %s this year %s a leap year%n",
                myLocalDate, weekDay, monthDay, month, isLeapYear ? "is" : "is not");

        //We can get a new date by adding (or subtracting through minus())
        LocalDate newLocalDate = myLocalDate.plusMonths(2);

        //We can create a known date/time
        LocalDateTime myDateAndTime = LocalDateTime.of(2014, Month.JUNE, 26, 19, 0);
        //And access properties
        int hour = myDateAndTime.getHour();
        System.out.printf("myDateAndTime is %s the hour is %d%n", myDateAndTime, hour);

        //We can convert between the various classes
        LocalTime theTime = myDateAndTime.toLocalTime();
        LocalDateTime anotherDateTime = LocalDateTime.of(myLocalDate, theTime);
        System.out.printf("theTime is %s, anotherDateTime is %s%n", theTime, anotherDateTime);

    }
}
