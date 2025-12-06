package elm.hackathon.markettrands.client;

import org.springframework.context.annotation.Bean;


//@Configuration
public class ElmPayApiClientConfig {

    @Bean
    public ElmPayApiClientInterceptor declarationApiClientInterceptor() {
        return new ElmPayApiClientInterceptor();
    }

    @Bean
    public ElmPayErrorDecoder declarationErrorDecoder() {
        return new ElmPayErrorDecoder();
    }

}
