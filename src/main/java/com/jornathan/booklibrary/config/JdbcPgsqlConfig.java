package com.jornathan.booklibrary.config;

//import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//@Configuration
//@EnableJpaRepositories
//(
//        basePackages = "com.web.repository.pgsql",
//        entityManagerFactoryRef = "pgsqlFactoryBean",
//        transactionManagerRef = "pgsqlTransactionManager"
//)
public class JdbcPgsqlConfig {
//    @Primary
//    @Bean(name = "pgsqlDataSource")
//    @ConfigurationProperties(prefix = "spring.pgsql")
//    public DataSource getDataSource()
//    {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "pgsqlFactoryBean")
//    public LocalContainerEntityManagerFactoryBean getFactoryBean(EntityManagerFactoryBuilder builder)
//    {
//        return builder.dataSource(getDataSource()).packages("com.web.domain.pgsql").build();
//    }
//
//    @Primary
//    @Bean(name = "pgsqlTransactionManager")
//    PlatformTransactionManager getTransactionManager(EntityManagerFactoryBuilder builder)
//    {
//        return new JpaTransactionManager(getFactoryBean(builder).getObject());
//    }
}
