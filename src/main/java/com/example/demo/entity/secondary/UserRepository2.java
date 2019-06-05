package com.example.demo.entity.secondary;

import com.example.demo.entity.secondary.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/****************************************************************************
 * Project Name:demo
 * File Name:UserRepository1.java
 * Package Name:com.example.demo.entity.secondary
 * Copyright: Copyright ©2019 Bangcle. All Rights Reserved.
 *
 * ClassName:UserRepository1 <br/>
 * Description: TODO <br/>
 *
 * @author ltj
 * @version 1.0
 * Date:     19-6-5 下午3:35 <br/>
 ****************************************************************************/
public interface UserRepository2 extends JpaRepository<UserEntity,Long> {

}
