package com.example.demo.entity.secondary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/****************************************************************************
 * Project Name:demo
 * File Name:UserEntity.java
 * Package Name:com.example.demo.entity
 * Copyright: Copyright ©2019 Bangcle. All Rights Reserved.
 *
 * ClassName:UserEntity <br/>
 * Description: TODO <br/>
 *
 * @author ltj
 * @version 1.0
 * Date:     19-6-5 下午3:10 <br/>
 ****************************************************************************/
@Entity
@Table(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;

  @Column
  private String username;

}
