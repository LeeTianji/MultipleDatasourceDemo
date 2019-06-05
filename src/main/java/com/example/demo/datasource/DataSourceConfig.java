package com.example.demo.datasource;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/****************************************************************************
 * Project Name:demo
 * File Name:DataSourceConfig.java
 * Package Name:com.example.demo.datasource
 * Copyright: Copyright ©2019 Bangcle. All Rights Reserved.
 *
 * ClassName:DataSourceConfig <br/>
 * Description: TODO <br/>
 *
 * @author ltj
 * @version 1.0
 * Date:     19-6-5 下午3:21 <br/>
 ****************************************************************************/
@Configuration
public class DataSourceConfig {

  //配置第一个数据源
  @Bean(name = "primaryDataSource")
  @Qualifier("primaryDataSource")
  @ConfigurationProperties(prefix="spring.datasource.primary")
  public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
  }
  @Bean(name = "primaryJdbcTemplate")
  public JdbcTemplate primaryJdbcTemplate(
      @Qualifier("primaryDataSource") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
  //配置第二个数据源
  @Bean(name = "secondaryDataSource")
  @Qualifier("secondaryDataSource")
  @Primary
  @ConfigurationProperties(prefix="spring.datasource.secondary")
  public DataSource secondaryDataSource() {
    return DataSourceBuilder.create().build();
  }
  @Bean(name = "secondaryJdbcTemplate")
  public JdbcTemplate secondaryJdbcTemplate(
      @Qualifier("secondaryDataSource") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

}
