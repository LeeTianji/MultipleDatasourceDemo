package com.example.demo.controller;

import com.example.demo.entity.primary.UserEntity;
import com.example.demo.service.UserService1;
import com.example.demo.service.UserService2;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****************************************************************************
 * Project Name:demo
 * File Name:UserController.java
 * Package Name:com.example.demo.controller
 * Copyright: Copyright ©2019 Bangcle. All Rights Reserved.
 *
 * ClassName:UserController <br/>
 * Description: TODO <br/>
 *
 * @author ltj
 * @version 1.0
 * Date:     19-6-5 下午3:52 <br/>
 ****************************************************************************/
@RestController
public class UserController {

  @Autowired
  private UserService1 userService1;
  @Autowired
  private UserService2 userService2;

  @RequestMapping("/index")

  public List<Object> index(){
    List<UserEntity> list1 = userService1.findUser();
    List<com.example.demo.entity.secondary.UserEntity> list2 = userService2.findUser();
    List<Object> list = new ArrayList<>();
    list.addAll(list1);
    list.addAll(list2);
    return list;
  }


}
