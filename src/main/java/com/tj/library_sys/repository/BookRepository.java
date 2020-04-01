package com.tj.library_sys.repository;

import com.tj.library_sys.entity.BookEntity;
import com.tj.library_sys.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {
  List<BookEntity> findAllByCategory(CategoryEntity categoryEntity);
  @Query("from BookEntity b where b.title like concat('%',concat(:parm,'%')) or b.author like concat('%',concat(:parm,'%'))")
  List<BookEntity> findAllByTitleOrAuthor(@Param("parm") String parm);

  BookEntity findByAuthorAndTitle(String author,String title);
}
