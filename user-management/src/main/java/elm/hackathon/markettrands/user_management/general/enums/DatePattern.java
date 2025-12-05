package elm.hackathon.markettrands.user_management.general.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DatePattern {

    PATTERN_1("EEE MMM dd HH:mm:ss zzz yyyy"),
    PATTERN_2("yyyy-MM-dd'T'HH:mm:ss"),

    /**
     * serve agriServ Invoice integration
     */
    PATTERN_3("yyyy-MM-dd HH:mm:ss"),
    PATTERN_4("yyyy-MM-dd'T'HH:mm:ss.SSS"),
    YEAR_MONTH_DAY("yyyy/MM/dd");

    private final String pattern;

}
