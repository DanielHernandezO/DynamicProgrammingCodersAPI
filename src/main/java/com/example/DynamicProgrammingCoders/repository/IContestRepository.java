package com.example.DynamicProgrammingCoders.repository;

import com.example.DynamicProgrammingCoders.model.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IContestRepository extends JpaRepository<Contest,Integer> {
    @Query("from Contest c where c.userId.id=:userId")
    List<Contest> findAllByContestId(@Param("userId") Integer userId);
}
