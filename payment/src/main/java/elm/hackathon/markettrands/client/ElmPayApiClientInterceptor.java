package elm.hackathon.markettrands.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



public class ElmPayApiClientInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type", "application/json");
        requestTemplate.header("ProductCode", "");
        requestTemplate.header("ClientKey", "");
        requestTemplate.header("MessageId", "");
        requestTemplate.header("Timestamp", "");
        requestTemplate.header("app-id", "");
        requestTemplate.header("app-key", "");
    }
}