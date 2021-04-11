package org.sergei.hibernate.caching.config;

import java.util.Properties;
import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Springs' configuration for database connection establishment.
 * Plus hibernate configuration.
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@Configuration
@EnableTransactionManagement
public class DatasourceConfig {

    private final String url;
    private final String driverClassName;
    private final String username;
    private final String password;
    private final String hibernateDialect;
    private final String hibernateDdlAuto;
    private final String newGeneratorMappings;
    private final String useQueryCache;
    private final String useSecondLevelCache;
    private final String cacheFactoryClass;
    private final String missingCacheStrategy;
    private final String liquibaseChangeLog;

    public DatasourceConfig(@Value("${datasource.url}") String url,
                            @Value("${datasource.driverClassName}") String driverClassName,
                            @Value("${datasource.username}") String username,
                            @Value("${datasource.password}") String password,
                            @Value("${hibernate.dialect}") String hibernateDialect,
                            @Value("${hibernate.hbm2ddl-auto}") String hibernateDdlAuto,
                            @Value("${hibernate.id_new_generator_mappings}") String newGeneratorMappings,
                            @Value("${hibernate.cache.use_query_cache}") String useQueryCache,
                            @Value("${hibernate.cache.use_second_level_cache}") String useSecondLevelCache,
                            @Value("${hibernate.cache.factory_class}") String cacheFactoryClass,
                            @Value("${hibernate.cache.ehcache.missing_cache_strategy}") String missingCacheStrategy,
                            @Value("${liquibase.change-log}") String liquibaseChangeLog) {
        this.url = url;
        this.driverClassName = driverClassName;
        this.username = username;
        this.password = password;
        this.hibernateDialect = hibernateDialect;
        this.hibernateDdlAuto = hibernateDdlAuto;
        this.newGeneratorMappings = newGeneratorMappings;
        this.useQueryCache = useQueryCache;
        this.useSecondLevelCache = useSecondLevelCache;
        this.cacheFactoryClass = cacheFactoryClass;
        this.missingCacheStrategy = missingCacheStrategy;
        this.liquibaseChangeLog = liquibaseChangeLog;
    }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();

        entityManager.setDataSource(dataSource());
        entityManager.setPersistenceUnitName("default");
        entityManager.setPackagesToScan("org.sergei.hibernate.caching.dao");
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManager.setJpaProperties(hibernateProperties());

        return entityManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();

        props.setProperty("hibernate.dialect", hibernateDialect);
        props.setProperty("hibernate.hbm2ddl.auto", hibernateDdlAuto);
        props.setProperty("hibernate.id.new_generator_mappings", newGeneratorMappings);
        props.setProperty("hibernate.cache.use_query_cache", useQueryCache);
        props.setProperty("hibernate.cache.use_second_level_cache", useSecondLevelCache);
        props.setProperty("hibernate.cache.region.factory_class", cacheFactoryClass);
        props.setProperty("hibernate.cache.ehcache.missing_cache_strategy", missingCacheStrategy);

        return props;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource());
        liquibase.setChangeLog(liquibaseChangeLog);
        return liquibase;
    }

}
