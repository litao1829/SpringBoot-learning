package com.example.repository;

import com.example.domain.Discuss;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface DiscussRepository  extends JpaRepository<Discuss,Integer> {
    List<Discuss> findByIdEquals(Integer id);
    List<Discuss> findByAuthorNotNull();
    List<Discuss> findByAuthorEquals(String name);
    List<Discuss> findByAIdEquals(Integer aid);


// 分页查询
    @Query("select c from  t_comment c")
    List<Discuss> getDiscussByPage(Pageable pageable);

}
