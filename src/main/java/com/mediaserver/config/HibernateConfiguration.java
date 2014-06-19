package com.mediaserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean setupSessionFactory(DataSource dataSource) throws Exception {
        LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
        localSessionFactory.setDataSource(dataSource);
        localSessionFactory.setPackagesToScan("com.mediaserver.domain");
        localSessionFactory.setAnnotatedPackages("com.mediaserver.domain");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("jdbc.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", environment.getProperty("jdbc.showSql"));
        localSessionFactory.setHibernateProperties(hibernateProperties);
        return localSessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}
