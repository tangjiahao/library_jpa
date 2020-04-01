package com.tj.library_sys.repository;

import com.tj.library_sys.entity.NoteEntity;
import com.tj.library_sys.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity,Integer> {

  @Query("from NoteEntity n where n.creator = :creator order by n.lastUpdateTime desc ")
  List<NoteEntity> findAllByCreator(@Param("creator") UserEntity creator);

}
