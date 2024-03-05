package net.penguincoders.splitwise.config.dao;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Lazy
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "net.penguincoders.splitwise.dataaccess.repository",
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean",
        transactionManagerRef = "platformTransactionManager")
public class DbaConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean("localContainerEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(final EntityManagerFactoryBuilder builder,
                                                                                         final @Qualifier("dataSource") DataSource datasource) {
        return builder.dataSource(datasource)
                .packages("net.penguincoders.splitwise.dataaccess.model")
                .persistenceUnit("dataSource")
                .build();
    }

    @Bean(name = "platformTransactionManager")
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier("localContainerEntityManagerFactoryBean") EntityManagerFactory entityManagerFactoryBuilder
    ) {
        return new JpaTransactionManager(entityManagerFactoryBuilder);
    }

    @Bean(name = "dataSource")
    public HikariDataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(dataSourceProperties.getJdbcUrl());
        hikariConfig.setPassword(dataSourceProperties.getPassword());
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikariConfig.setMaximumPoolSize(50);

        return new HikariDataSource(hikariConfig);
    }

}
