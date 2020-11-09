package com.jornathan.booklibrary.config;

//import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

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
