package elm.hackathon.markettrands.client.billing;

import org.springframework.context.annotation.Bean;


//@Configuration
public class ElmBillingPayApiClientConfig {

    @Bean
    public ElmBillingPayApiClientInterceptor declarationApiClientInterceptor() {
        return new ElmBillingPayApiClientInterceptor();
    }

    @Bean
    public ElmBillingPayErrorDecoder declarationErrorDecoder() {
        return new ElmBillingPayErrorDecoder();
    }

}
