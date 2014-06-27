import java.time.*;

/**
 * Created by Debbie on 27/06/2014.
 */
public class ZonedDateTimeSample {
    public static void main(String [] args){
        ZonedDateTime timeNowUK = ZonedDateTime.now(ZoneId.of("Europe/London"));
        System.out.printf("UK local now is : %s%n", timeNowUK);
        System.out.printf("Paris local now is : %s%n",
                timeNowUK.withZoneSameInstant(ZoneId.of("Europe/Paris")));
        System.out.printf("Same clock time in NY is : %s%n",
                timeNowUK.withZoneSameLocal(ZoneId.of("America/New_York")));
        OffsetDateTime offsetDateTime = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("-02:00"));
        OffsetTime offsetTime = OffsetTime.of(LocalTime.now(), ZoneOffset.ofHours(-8));
        System.out.printf("OffsetDateTime -02:00 from now is %s%n", offsetDateTime);
        System.out.printf("OffsetTime -8 hours from now is %s%n", offsetTime);
    }
}
