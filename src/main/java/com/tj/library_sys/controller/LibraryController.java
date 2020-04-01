package com.tj.library_sys.controller;

import com.tj.library_sys.entity.BookEntity;
import com.tj.library_sys.service.BookService;
import org.elasticsearch.transport.InboundMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/library")
public class LibraryController {
  @Autowired
  BookService bookService;

  private static final Logger log = LoggerFactory.getLogger(LibraryController.class);
  @GetMapping("/getBooks")
  public List<BookEntity> list() throws Exception {
    List<BookEntity> listBook=bookService.getlist();
    return listBook;
  }

  @PostMapping("/addOrUpdate")
  public BookEntity addOrUpdate(@RequestBody BookEntity book) throws Exception {
      BookEntity bookEntity=bookService.addOrUpdate(book);
      return bookEntity;
  }

  @PostMapping("/delete")
  public void delete(@RequestBody BookEntity book) throws Exception {
    bookService.deleteById(book.getId());
  }


  @GetMapping("/categories/{cid}/books")
  public List<BookEntity> listByCategory(@PathVariable("cid") int cid) throws Exception {
    if (0 != cid) {
      return bookService.listByCategory(cid);
    } else {
      return list();
    }
  }
  @RequestMapping("/search")
  public List<BookEntity> listByContion(String condition) throws Exception{
    if (condition != null && !"".equals(condition)) {
      return bookService.listByCondition(condition);
    } else {
      return this.list();
    }
  }
}
