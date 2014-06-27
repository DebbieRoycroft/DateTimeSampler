import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by Debbie on 27/06/2014.
 */
public class TimeSpanSample {
    public static void main(String[] args){

        LocalDate dayOne = LocalDate.of(2013, Month.APRIL,21);
        LocalDate dayTwo = LocalDate.of(2014,Month.APRIL,12);
        //Period lets you break down mixed units
        Period difference = dayOne.until(dayTwo);
        System.out.printf("From Period Years is %d Months is %d Days is %d%n",
                difference.getYears(), difference.getMonths(), difference.getDays());
        //ChronoUnit between counts in a single unit
        System.out.printf("ChronoUnit.DAYS.between is : %s%n", ChronoUnit.DAYS.between(dayOne, dayTwo));
        //Duration
        System.out.printf("Duration between is %s%n", Duration.between(Instant.now(), Instant.now().plusSeconds(30)));

        System.out.printf("Adding Period on gives %s%n", dayTwo.plus(difference));

    }
}
