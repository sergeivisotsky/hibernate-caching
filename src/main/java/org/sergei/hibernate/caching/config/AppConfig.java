package org.sergei.hibernate.caching.config;

import org.mapstruct.factory.Mappers;
import org.sergei.hibernate.caching.mapper.PolicyDTOMapper;
import org.sergei.hibernate.caching.mapper.PolicyModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackages = {
        "org.sergei.hibernate.caching.*"
})
public class AppConfig {

    @Bean
    public PolicyModelMapper policyModelMapper() {
        return Mappers.getMapper(PolicyModelMapper.class);
    }

    @Bean
    public PolicyDTOMapper policyDTOMapper() {
        return Mappers.getMapper(PolicyDTOMapper.class);
    }
}
