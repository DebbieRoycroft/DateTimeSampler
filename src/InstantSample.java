import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Debbie on 27/06/2014.
 */
public class InstantSample {
    public static void main(String[] args) {

        Instant instant = Instant.now();
        //Convert to other temporal objects
        LocalDateTime timeFromInstance = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        //Epoch is 00:00 01/01/1970
        Instant oldInstant = Instant.ofEpochSecond(0L);
        //compare Instants
        System.out.printf("Instant now=%s old instant=%s instant is before old =%b%n",
                instant, oldInstant, (instant.isBefore( oldInstant)) );
        ZonedDateTime oldInAustralia = oldInstant.atZone(ZoneId.of("Australia/Sydney"));
        System.out.printf("old instant in Australia zone=%s%n", oldInAustralia);

    }
}
