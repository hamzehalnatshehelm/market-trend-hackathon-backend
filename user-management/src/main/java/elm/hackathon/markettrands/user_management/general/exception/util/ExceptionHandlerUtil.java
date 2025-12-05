package elm.hackathon.markettrands.user_management.general.exception.util;


import elm.hackathon.markettrands.user_management.general.enums.Language;
import elm.hackathon.markettrands.user_management.general.exception.enums.ErrorCode;
import elm.hackathon.markettrands.user_management.general.exception.schema.response.BaseError;
import elm.hackathon.markettrands.user_management.general.exception.schema.response.BaseException;
import elm.hackathon.markettrands.user_management.general.util.UtilTranslate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExceptionHandlerUtil {

    private final UtilTranslate utilTranslate;

    public ResponseEntity<BaseError> commonReturn(BaseException e) {
        return returnBaseErrorResponseEntity(e);
    }

    private ResponseEntity<BaseError> returnBaseErrorResponseEntity(BaseException e) {

        ErrorCode errorCode = e.getErrorCode();
        BaseError errorInfo = new BaseError(errorCode,
                utilTranslate.findTranslatedMessage(errorCode.getMessageCode(), e.getArgs(), Language.AR),
                utilTranslate.findTranslatedMessage(errorCode.getMessageCode(), e.getArgs(), Language.EN),
                e.getDetail());

        HttpStatus status = e.getHttpStatus() != null ? e.getHttpStatus() : HttpStatus.NOT_ACCEPTABLE;
        log.warn("base exception: errorInfo={}, status={}, object={}", errorInfo, status, e.getDetail());
        return new ResponseEntity<>(errorInfo, status);
    }

}
