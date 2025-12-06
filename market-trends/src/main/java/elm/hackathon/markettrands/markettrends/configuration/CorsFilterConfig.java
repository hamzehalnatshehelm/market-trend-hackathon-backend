package elm.hackathon.markettrands.markettrends.configuration;

import com.google.common.net.HttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CorsFilterConfig {

    public static final List<String> allowedHeaders =
            List
                    .of(
                            HttpHeaders.AUTHORIZATION,
                            HttpHeaders.SET_COOKIE,
                            HttpHeaders.CACHE_CONTROL,
                            HttpHeaders.CONTENT_TYPE,
                            HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN
                    );

    /**
     * cors Bean
     */
    @Bean
    public CorsFilter corsFilter() {
        var source = new UrlBasedCorsConfigurationSource();
        var config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedHeader("*");
        config.addExposedHeader("*");
        config.addAllowedOriginPattern("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("PATCH");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.setAllowedMethods(List.of("*", "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD"));
        config.setAllowedHeaders(allowedHeaders);
        config.setExposedHeaders(allowedHeaders);
        config.setAllowedOrigins(List.of("*"));
        config.setAllowedOriginPatterns(List.of("*"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
