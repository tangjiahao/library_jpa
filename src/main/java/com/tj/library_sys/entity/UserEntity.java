package com.tj.library_sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user")
//忽略hibernate运行时的代理实体产生的两个属性
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  Integer id;

  @Column(name = "username")
  String username;

  @Column(name = "password")
  String password;

  @Column(name = "nick_name")
  String nickName;

  @Column(name = "sexy")
  String sexy;

  @Column(name = "last_login_time")
  Date lastLoginTime;

  @Column(name = "bref_comment")
  String brefComment;

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getSexy() {
    return sexy;
  }

  public void setSexy(String sexy) {
    this.sexy = sexy;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public String getBrefComment() {
    return brefComment;
  }

  public void setBrefComment(String brefComment) {
    this.brefComment = brefComment;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
