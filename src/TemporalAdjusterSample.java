import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Debbie on 27/06/2014.
 */
public class TemporalAdjusterSample {
    public static void main(String [] args)
    {
        //Get today's date
        LocalDate today = LocalDate.now();
        //Standard temporal adjusters work on dates
        //a static import could make this code neater today.with(lastInMonth(DayOfWeek.THURSDAY))
        LocalDate lastThursdayOfTheMonth = today.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        LocalDate nextYear = today.with(TemporalAdjusters.firstDayOfNextYear());
        //We can also write our own
        LocalDate nextWorkingDay = today.with( new NextWorkingDay());
        System.out.printf(
                "today is %s, last thursday of the month is %s, first day of next year is %s, next working day is %s%n",
                today, lastThursdayOfTheMonth, nextYear, nextWorkingDay);
    }

    public static class NextWorkingDay implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal input) {
            LocalDate date = LocalDate.from(input);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY ||
                    date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    date.getDayOfWeek() == DayOfWeek.SUNDAY){
                return input.with(date.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
            }
            else{
                return input.with(date.plusDays(1));
            }
        }
    }

}
