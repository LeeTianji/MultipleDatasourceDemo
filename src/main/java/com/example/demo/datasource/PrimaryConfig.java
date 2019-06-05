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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/****************************************************************************
 * Project Name:demo
 * File Name:PrimaryConfig.java
 * Package Name:com.example.demo.datasource
 * Copyright: Copyright ©2019 Bangcle. All Rights Reserved.
 *
 * ClassName:PrimaryConfig <br/>
 * Description: TODO <br/>
 *
 * @author ltj
 * @version 1.0
 * Date:     19-6-5 下午3:23 <br/>
 ****************************************************************************/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef="entityManagerFactoryPrimary",
    transactionManagerRef="transactionManagerPrimary",
    basePackages= { "com.example.demo.entity.primary" }) //设置Repository所在位置
public class PrimaryConfig {
  @Autowired
  @Qualifier("primaryDataSource")
  private DataSource primaryDataSource;

  @Primary
  @Bean(name = "entityManagerPrimary")
  public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
    return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
  }

  @Primary
  @Bean(name = "entityManagerFactoryPrimary")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(primaryDataSource)
        .properties(getVendorProperties(primaryDataSource))
        .packages("com.example.demo.entity.primary") //设置实体类所在位置
        .persistenceUnit("primaryPersistenceUnit")
        .build();
  }

  @Autowired
  private JpaProperties jpaProperties;

  private Map<String, String> getVendorProperties(DataSource dataSource) {
    return jpaProperties.getHibernateProperties(dataSource);
  }

  @Primary
  @Bean(name = "transactionManagerPrimary")
  public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
    return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
  }
}
