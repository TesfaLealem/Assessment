package com.yet.assessment.repository;



import com.yet.assessment.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {


    @Query("select p from Parent p  where p.id in :parentId")
    public Parent findParentById(@Param("parentId") Long parentId);


}

