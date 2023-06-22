package com.yet.assessment.repository;



import com.yet.assessment.models.Child;
import com.yet.assessment.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    @Query("select c from Child c  where c.id in :childId")
    public Child findChildById(@Param("childId") Long childId);

    @Query("select c from Child c  where c.parent in :parent")
    public List<Child> findChildByParent(@Param("parent") Parent parent);







}

