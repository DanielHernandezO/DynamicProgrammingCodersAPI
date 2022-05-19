package com.example.DynamicProgrammingCoders.repository;

import com.example.DynamicProgrammingCoders.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubmissionRepository extends JpaRepository<Submission,Integer> {

}
