package com.tj.library_sys.service;

import com.tj.library_sys.entity.BookEntity;
import com.tj.library_sys.entity.CategoryEntity;
import com.tj.library_sys.repository.BookRepository;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private CategoryService categoryService;

  public List<BookEntity> getlist() {
    Sort sort = Sort.by(Sort.Direction.DESC, "id");
    return bookRepository.findAll(sort);
  }

  public BookEntity addOrUpdate(BookEntity book) {
    Validate.notNull(book,"传过来的书籍实体不能为空");
    Validate.notEmpty(String.valueOf(book.getCategory().getId()),"传过来的分类信息不能为空");
    Validate.notEmpty(book.getAuthor(),"书籍的作者信息不能为空");
    Validate.notEmpty(book.getTitle(),"书籍的标题不能为空");
    System.out.println();

    //为空，说明是新增书籍,判断是否存在
    if(book.getId() == null){
      BookEntity bookEntity = bookRepository.findByAuthorAndTitle(book.getAuthor(),book.getTitle());
      Validate.isTrue(bookEntity == null,"该书籍已存在，无法重复添加");
    }
    //书籍id不为空，说明是进行数据更新，直接刷新
    return bookRepository.save(book);
  }

  public void deleteById(int id) {
    bookRepository.deleteById(id);
  }

  public List<BookEntity> listByCategory(int cid) {
    CategoryEntity category = categoryService.findById(cid);
    Sort sort = Sort.by(Sort.Direction.DESC, "id");
    return bookRepository.findAllByCategory(category);
  }
  public List<BookEntity> listByCondition(String parm) {
    return bookRepository.findAllByTitleOrAuthor(parm);
  }
}
