package elm.hackathon.markettrands.user_management.general.util;

import elm.hackathon.markettrands.user_management.general.enums.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class UtilTranslate {

    private final MessageSource messageSource;

    public String findTranslatedMessage(String message, Language language) {
        return message != null && !message.isEmpty()
                ? messageSource.getMessage(message, null, Locale.of(language.getCode()))
                : "";
    }

    public String findTranslatedMessage(String message, String[] args, Language language) {
        return message != null && !message.isEmpty()
                ? messageSource.getMessage(message, args, Locale.of(language.getCode()))
                : "";
    }

}
