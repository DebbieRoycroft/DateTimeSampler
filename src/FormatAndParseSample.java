import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Created by Debbie on 24/06/2014.
 */
public class FormatAndParseSample {
    public static void main(String args[]){

        //Parsing - take a string to a temporal object
        //Use a pattern you define
        DateTimeFormatter patternFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
        LocalDate myDate = LocalDate.parse("26-Jun-2014", patternFormatter);
        //Without specifying a pattern the appropriate ISO format gets used
        ZonedDateTime take2 = ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]");
        //Or you can use a standard format based on the locale
        DateTimeFormatter localFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.UK);
        LocalDate anotherDate = LocalDate.parse("26/06/14", localFormatter);

        //Formatting is very similar, dates can be output as strings in various forms
        //the examples below show what the localised standard formats look like
        DateTimeFormatter englishFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                .withLocale(Locale.UK);
        System.out.println("in English format " + myDate.format(englishFormatter));

        DateTimeFormatter usFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                .withLocale(Locale.US);
        System.out.println("in US format " + myDate.format(usFormatter));

        DateTimeFormatter frenchFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                .withLocale(Locale.FRENCH);
        System.out.println("in French format " + myDate.format(frenchFormatter));

        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN);
        System.out.println("in German format " + myDate.format(germanFormatter));

        DateTimeFormatter spanishFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.forLanguageTag("ES"));
        System.out.println("in Spanish format " + myDate.format(spanishFormatter));

        DateTimeFormatter chineseFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.CHINESE);
        System.out.println("in Chinese format " + myDate.format(chineseFormatter));

        //You can also format with your own pattern
        DateTimeFormatter patternFormatter2 = DateTimeFormatter.ofPattern("dd/MMM/yyyy G");
        System.out.println("with pattern format " + myDate.format(patternFormatter2));
        //Or one of the predefined ones
        System.out.println("with predefined pattern format " + myDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
