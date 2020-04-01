package com.tj.library_sys.controller;

import com.tj.library_sys.entity.NoteEntity;
import com.tj.library_sys.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/note")
public class NoteController {

  @Autowired
  private NoteService noteService;
  @GetMapping("/getNotes")
  public List<NoteEntity> getByCreator(String name) {
    List<NoteEntity> noteEntities = noteService.getlistNoteEntity(name);
    return noteEntities;
  }

  @PostMapping("/addOrUpdate")
  public NoteEntity addOrUpdate(@RequestBody NoteEntity noteEntity, @RequestParam String username){
    NoteEntity result = noteService.saveOrUpdate(noteEntity,username);
    return result;
  }

  @PostMapping("/delete")
  public void delete(@RequestBody NoteEntity noteEntity){
    noteService.deleteById(noteEntity.getId());
  }

  @GetMapping("findById")
  public NoteEntity findById(@RequestParam String noteId){
    NoteEntity result = noteService.findById(Integer.parseInt(noteId));

    return result;
  }

}
