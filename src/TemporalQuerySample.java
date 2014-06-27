import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;

/** Implements TemporalQuery
 *
 */



public class TemporalQuerySample {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        //Built in TemporalQueries tell us things about Temporal objects
        System.out.printf("localDate zone is %s%n", localDate.query(TemporalQueries.zone()));
        System.out.printf("localDate precision is %s%n", localDate.query(TemporalQueries.precision()));
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        System.out.printf("zonedDateTime zone is %s%n", zonedDateTime.query(TemporalQueries.zone()));
        System.out.printf("zonedDateTime precision is %s%n", zonedDateTime.query(TemporalQueries.precision()));

        LocalTime morning = LocalTime.of(11, 30);
        //Or we can write our own either as a class implementing TemporalQuery...
        System.out.printf("Time of %s is morning=%B%n", morning, morning.query(new IsItMorning()));
        //...or as a new style method reference
        System.out.printf("Time of %s is evening=%B%n", morning, morning.query(TemporalQuerySample::isItEvening));

    }

    //Method used as TemporalQuery for method reference
    public static boolean isItEvening(TemporalAccessor temporal) {
        int hour = temporal.get(ChronoField.HOUR_OF_DAY);
        return (hour < 17 ? Boolean.TRUE : Boolean.FALSE);
    }


}

