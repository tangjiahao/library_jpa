package com.tj.library_sys.service;

import com.tj.library_sys.entity.UserEntity;
import com.tj.library_sys.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public boolean isExist(String username) {
    UserEntity user = this.getUserByName(username);
    return null != user;
  }

  public UserEntity getUserByName(String username) {
    return userRepository.findByUsername(username);
  }

  public UserEntity getUserByNameAndPwd(String username, String password) {
    return userRepository.getByUsernameAndPassword(username, password);
  }
  public UserEntity saveUser(UserEntity userEntity) {
    Validate.notNull(userEntity,"穿过来的用户实体不能为空");
    if(StringUtils.isNotBlank(String.valueOf(userEntity.getId()))){
      UserEntity user=userRepository.findById(userEntity.getId()).orElse(null);
      Validate.notNull(user,"不存在这个用户，修改失败");
      userEntity.setPassword(user.getPassword());
      return userRepository.save(userEntity);
    }
    return null;
  }
  public UserEntity updatePwd(String username,String oldPwd,String newPwd) {
    UserEntity userEntity =getUserByName(username);
    Validate.notNull(userEntity,"修改密码的用户不存在");
    Validate.notEmpty(oldPwd,"旧密码不能为空");
    Validate.notEmpty(oldPwd,"新密码不能为空");
    Validate.isTrue(oldPwd.equals(userEntity.getPassword()),"密码不正确");
    userEntity.setPassword(newPwd);

    return saveUser(userEntity);
  }

}
