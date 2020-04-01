package com.tj.library_sys.service;

import com.tj.library_sys.entity.NoteEntity;
import com.tj.library_sys.entity.UserEntity;
import com.tj.library_sys.repository.NoteRepository;
import com.tj.library_sys.repository.UserRepository;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService {
  @Autowired
  private NoteRepository noteRepository;

  @Autowired
  private UserRepository userRepository;

  public List<NoteEntity> getlistNoteEntity(String createrName){
    UserEntity userEntity = userRepository.findByUsername(createrName);
    Validate.notNull(userEntity,"传入的账号查找不到用户信息");
    List<NoteEntity> result = noteRepository.findAllByCreator(userEntity);
    return result;
  }

  public NoteEntity saveOrUpdate(NoteEntity noteEntity,String username) {
    Validate.notNull(noteEntity,"传过来的笔记实体不能为空");
    Validate.notEmpty(username,"创建修改的用户名不能为空");
    UserEntity userEntity = userRepository.findByUsername(username);
    Validate.notNull(userEntity,"创建和修改用户实体不能为空");
    //新建，增加创建时间
    if(noteEntity.getCreateTime() == null){
      noteEntity.setCreateTime(new Date());
      noteEntity.setCreator(userEntity);
    }
    noteEntity.setLastUpdateTime(new Date());
    return noteRepository.save(noteEntity);
  }
  public void deleteById(Integer id){
    noteRepository.deleteById(id);
  }
  public NoteEntity findById(Integer id){
    return noteRepository.findById(id).orElse(null);
  }

}
