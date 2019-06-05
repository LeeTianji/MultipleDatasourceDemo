package com.example.demo.datasource;

import java.util.Map;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/****************************************************************************
 * Project Name:demo
 * File Name:SecondaryConfig.java
 * Package Name:com.example.demo.datasource
 * Copyright: Copyright ©2019 Bangcle. All Rights Reserved.
 *
 * ClassName:SecondaryConfig <br/>
 * Description: TODO <br/>
 *
 * @author ltj
 * @version 1.0
 * Date:     19-6-5 下午3:24 <br/>
 ****************************************************************************/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef="entityManagerFactorySecondary",
    transactionManagerRef="transactionManagerSecondary",
    basePackages= { "com.example.demo.entity.secondary" }) //设置Repository所在位置
public class SecondaryConfig {

  @Autowired
  @Qualifier("secondaryDataSource")
  private DataSource secondaryDataSource;

  @Bean(name = "entityManagerSecondary")
  public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
    return entityManagerFactorySecondary(builder).getObject().createEntityManager();
  }

  @Bean(name = "entityManagerFactorySecondary")
  public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary (EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(secondaryDataSource)
        .properties(getVendorProperties(secondaryDataSource))
        .packages("com.example.demo.entity.secondary") //设置实体类所在位置
        .persistenceUnit("secondaryPersistenceUnit")
        .build();
  }

  @Autowired
  private JpaProperties jpaProperties;

  private Map<String, String> getVendorProperties(DataSource dataSource) {
    return jpaProperties.getHibernateProperties(dataSource);
  }

  @Bean(name = "transactionManagerSecondary")
  PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
    return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
  }

}
