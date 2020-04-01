package com.tj.library_sys.repository;

import com.tj.library_sys.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
  /**
   * 自动生成的按名称查询方法，不用写sql语句
   *parm username
   */
  UserEntity findByUsername(String username);

  UserEntity getByUsernameAndPassword(String username, String password);
}
