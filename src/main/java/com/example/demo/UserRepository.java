package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // method names query (SELECT * FROM USER WHERE name = :name;)
    Optional<User> findByName(String name);

    // JPQL
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> searchUserByIdJPQL(@Param("id") int userId);

    // Native Queries
    @Query(value = "SELECT * FROM USER WHERE ID = ?", nativeQuery = true)
    Optional<User> searchUserByIdNative(String id);

}
