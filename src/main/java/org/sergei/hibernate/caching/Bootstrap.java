package org.sergei.hibernate.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;

/**
 * Main Spring Boot entry point
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@SpringBootApplication(exclude = {
        LiquibaseAutoConfiguration.class
})
public class Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }
}
