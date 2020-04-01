package com.tj.library_sys.service;

import com.tj.library_sys.entity.CategoryEntity;
import com.tj.library_sys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  public List<CategoryEntity> findAll() {
    //查询结果按照id倒排
    Sort sort = Sort.by(Sort.Direction.DESC, "id");
    return categoryRepository.findAll(sort);
  }

  public CategoryEntity findById(int id) {
    CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
    return categoryEntity;
  }
}
