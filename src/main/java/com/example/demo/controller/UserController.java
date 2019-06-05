package com.example.demo.controller;

import com.example.demo.entity.primary.UserEntity;
import com.example.demo.service.UserService1;
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

  @RequestMapping("/index")

  public List<UserEntity> index(){
    List<UserEntity> list = userService1.findUser();
    return list;
  }


}
