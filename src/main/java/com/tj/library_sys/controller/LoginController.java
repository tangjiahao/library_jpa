package com.tj.library_sys.controller;

import com.tj.library_sys.entity.UserEntity;
import com.tj.library_sys.result.Result;
import com.tj.library_sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;


@Controller
public class LoginController {
  @Autowired
  private UserService userService;

  @CrossOrigin
  @PostMapping(value = "api/login")
  @ResponseBody
  public Result login(@RequestBody UserEntity requestUser) {
    // 对 html 标签进行转义，防止 XSS 攻击
    String username = requestUser.getUsername();
    username = HtmlUtils.htmlEscape(username);
    UserEntity userEntity = userService.getUserByNameAndPwd(username,requestUser.getPassword());
    if (userEntity == null) {
      String message = "账号密码错误";
      System.out.println(message);
      return new Result(400);
    } else {
      userEntity.setLastLoginTime(new Date());
      userService.saveUser(userEntity);
      return new Result(200);
    }
  }
}
