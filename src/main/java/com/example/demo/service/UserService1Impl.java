package com.example.demo.service;

import com.example.demo.entity.primary.UserEntity;
import com.example.demo.entity.primary.UserRepository1;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/****************************************************************************
 * Project Name:demo
 * File Name:UserService1Impl.java
 * Package Name:com.example.demo.service
 * Copyright: Copyright ©2019 Bangcle. All Rights Reserved.
 *
 * ClassName:UserService1Impl <br/>
 * Description: TODO <br/>
 *
 * @author ltj
 * @version 1.0
 * Date:     19-6-5 下午3:50 <br/>
 ****************************************************************************/
@Service
@Transactional
public class UserService1Impl implements UserService1 {

  @Autowired
  private UserRepository1 userRepository1;

  @Override
  public List<UserEntity> findUser() {
    return userRepository1.findAll();
  }
}
