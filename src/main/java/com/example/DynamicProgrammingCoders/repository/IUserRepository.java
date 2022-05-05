package com.example.DynamicProgrammingCoders.repository;

import com.example.DynamicProgrammingCoders.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,String> {
    @Query("from User u where u.userName = :userName ")
    Optional<User> findUserByUserName(@Param("userName")String userName);
}
