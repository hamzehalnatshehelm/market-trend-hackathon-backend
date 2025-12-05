package elm.hackathon.markettrands.user_management.general.util;

import elm.hackathon.markettrands.user_management.general.enums.DatePattern;
import elm.hackathon.markettrands.user_management.general.exception.enums.ErrorCode;
import elm.hackathon.markettrands.user_management.general.exception.schema.response.BaseException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.HijrahChronology;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

public class UtilDate {

    private UtilDate() {
    }

    public static final String ASIA_RIYADH_ZONE = "Asia/Riyadh";
    public static final ZoneId ZONE_ID = ZoneId.of(ASIA_RIYADH_ZONE);

    public static LocalDateTime findRiyadhZoneLocalDateTime() {
        return LocalDateTime.now(ZONE_ID);
    }

    public static Date findRiyadhZoneDate() {
        return Date
                .from(LocalDateTime.now(ZONE_ID).atZone(ZONE_ID)
                        .toInstant());
    }

    public static Date convertLocalDateTimeToRiyadhZone(LocalDateTime localDateTime) {
        return Date
                .from(localDateTime.atZone(ZONE_ID)
                        .toInstant());
    }

    public static String convertLocalDateTimeToString(LocalDateTime localDateTime, DatePattern datePattern) {
        if (localDateTime == null || datePattern == null) {
            return null;
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(datePattern.getPattern()));
    }

    public static Date convertLocalDateToRiyadhZone(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay()
                .atZone(ZONE_ID)
                .toInstant());
    }

    public static Date convertDateToRiyadhZone(Date date) {
        var formatter = new SimpleDateFormat(DatePattern.PATTERN_1.getPattern(), Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(ASIA_RIYADH_ZONE));
        try {
            return formatter.parse(date.toString());
        } catch (Exception e) {
            throw BaseException.builder().errorCode(ErrorCode.INVALID_DATE_FORMAT).build();
        }
    }

    public static LocalDate convertStringToLocalDate(String stringDate, DatePattern pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern.getPattern());
        return LocalDate.parse(stringDate, formatter);
    }

    public static Date convertStringToDate(String stringDate, DatePattern pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern.getPattern(), Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone(ASIA_RIYADH_ZONE));
        try {
            return formatter.parse(stringDate);
        } catch (Exception e) {
            throw BaseException.builder().errorCode(ErrorCode.INVALID_DATE_FORMAT).build();
        }
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert
                .toInstant()
                .atZone(ZONE_ID)
                .toLocalDate();
    }

    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert
                .toInstant()
                .atZone(ZONE_ID)
                .toLocalDateTime();
    }

    public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return Date
                .from(dateToConvert
                        .atZone(ZONE_ID)
                        .toInstant());
    }

    public static Date fromHijriToGregorian(String hijriDate) {
        // Define the formatter for the Hijri date
        DateTimeFormatter hijriFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                .withChronology(HijrahChronology.INSTANCE);

        // Parse the Hijri date string to a HijrahDate
        LocalDate localDate = LocalDate.from(hijriFormatter.parse(hijriDate));

        // Convert LocalDate to Date
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static void validateStartAndEndDate(LocalDateTime startDate, LocalDateTime endDate) {
        if (Objects.nonNull(startDate)
                && Objects.nonNull(endDate)
                && (startDate.isAfter(endDate)
                || startDate.isEqual(endDate))) {
            throw new BaseException(ErrorCode.NOT_ALLOWED_START_DATE_AFTER_END_DATE);
        }
    }

    public static LocalDateTime toStartOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    public static LocalDateTime toEndOfDay(LocalDate date) {
        return date.atTime(23, 59, 59, 999999999);
    }

    public static BigDecimal calculateDurationInSecond(LocalDateTime requestAt, LocalDateTime responseAt) {
        if (requestAt == null || responseAt == null) {
            return new BigDecimal("0.0");
        }
        Instant start = requestAt.atZone(ZONE_ID).toInstant();
        Instant end = responseAt.atZone(ZONE_ID).toInstant();
        return
                new BigDecimal(Duration.between(start, end).toMillis())
                        .divide(new BigDecimal("1000"), 10, RoundingMode.HALF_UP);
    }

}
