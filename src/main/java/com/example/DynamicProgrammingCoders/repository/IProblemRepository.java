package com.example.DynamicProgrammingCoders.repository;

import com.example.DynamicProgrammingCoders.model.Problem;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IProblemRepository extends JpaRepository<Problem,Integer> {
    @Query("select s.problemId from Submission s where s.userName.userName=:userId and s.status=1")
    Set<Problem> getProblemsSolvedByAnUser(@Param("userId")String userId);
}
