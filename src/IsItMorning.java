import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;

/**
* Created by Debbie on 25/06/2014.
*/

public class IsItMorning implements TemporalQuery<Boolean> {
    @Override
    public Boolean queryFrom(TemporalAccessor temporal) {
        int hour = temporal.get(ChronoField.HOUR_OF_DAY);
        return (hour < 12 ? Boolean.TRUE : Boolean.FALSE);
    }
}