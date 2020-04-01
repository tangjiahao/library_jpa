package com.tj.library_sys.controller;

import com.tj.library_sys.entity.BookEntity;
import com.tj.library_sys.entity.UserEntity;
import com.tj.library_sys.service.UserService;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserController {
  @Autowired
  private UserService userService;
  @RequestMapping("/getMessage")
  public UserEntity getMsg(String username) throws Exception {
    UserEntity userEntity =userService.getUserByName(username);
    return userEntity;
  }

  @PostMapping("/addOrUpdate")
  public UserEntity addOrUpdate(@RequestBody UserEntity userEntity) throws Exception {

    return userService.saveUser(userEntity);
  }

  @RequestMapping("/updatePwd")
  public UserEntity updatePwd(String username,String oldPwd,String newPwd) throws Exception {
    return userService.updatePwd(username,oldPwd,newPwd);
  }

}
