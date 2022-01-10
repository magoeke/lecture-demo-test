package de.magoeke.lecture.demo.spring;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Component
public class ApiKeyRegistration {

    @Bean
    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {
        final var registrationBean = new FilterRegistrationBean<ApiKeyFilter>();

        registrationBean.setFilter(new ApiKeyFilter());
        registrationBean.addUrlPatterns("/roman-numbers/*");

        return registrationBean;
    }

    //@Bean
    //public OpenAPI openAPI() {
    //    return new OpenAPI()
    //            .components(new Components()
    //                    .addSecuritySchemes("apiKey", new SecurityScheme()
    //                            .type(SecurityScheme.Type.APIKEY)
    //                            .in(SecurityScheme.In.HEADER)
    //                            .name("X-API-KEY")));
    //}

}
