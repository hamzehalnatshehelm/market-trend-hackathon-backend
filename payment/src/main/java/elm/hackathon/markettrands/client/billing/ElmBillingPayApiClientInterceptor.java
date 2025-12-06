package elm.hackathon.markettrands.client.billing;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.hibernate.id.GUIDGenerator;

import java.time.LocalDateTime;
import java.util.UUID;


public class ElmBillingPayApiClientInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type", "application/json");
        requestTemplate.header("ProductCode", "817");
        requestTemplate.header("ClientKey", "9e7364b7-f5a4-4495-8746-7fe6b341973c");
        requestTemplate.header("MessageId", UUID.randomUUID().toString());
        requestTemplate.header("Timestamp", LocalDateTime.now().toString());
        requestTemplate.header("app-id", "a26c555d");
        requestTemplate.header("app-key", "c440f95c0be4981f8c2d2a465e83edcb");
    }
}