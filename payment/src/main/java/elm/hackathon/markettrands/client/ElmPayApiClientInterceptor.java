package elm.hackathon.markettrands.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.UUID;


public class ElmPayApiClientInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
//        requestTemplate.header("Content-Type", "application/json");
        requestTemplate.header("Accept", "application/json");
        requestTemplate.header("ProductCode", "817");
        requestTemplate.header("ClientKey", "4E012D6C-7B3E-4D3A-9890-5E3C0815EA12");
        requestTemplate.header("MessageId", UUID.randomUUID().toString());
        requestTemplate.header("Timestamp", LocalDateTime.now().toString());
        requestTemplate.header("app-id", "8ab5d791");
        requestTemplate.header("app-key", "77a0e640a57cf7e166acfcb4645ddd8c");
    }
}