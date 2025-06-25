package com.wellsfargortask2.springinit;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Slf4j
@ComponentScan(basePackages = "com.wellsfargortask2")
public class SpringInit {



    public SpringInit(){
        log.info("Spring Init Constructor method is invoking ..");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getBean(){
        log.info("LocalContainerEntityManagerFactoryBean method is invoking");
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(getDataSource());
        bean.setPackagesToScan("com.wellsfargortask2.entity");
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        bean.setJpaProperties(getProperties());
        return bean;

    }

    @Bean
    public DataSource getDataSource(){
        log.info("invoking the datasource method..");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/finicial");
        dataSource.setUsername("root");
        dataSource.setPassword("Xworkzodc@123Sowmya");
        return dataSource;

    }

    @Bean
    public Properties getProperties(){
        log.info("invoking the Properties method..");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        return properties;
    }


}
