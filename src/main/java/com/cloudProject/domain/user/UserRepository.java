package com.cloudProject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("select count(u.id) from User u where u.id=?1")
    int CountUserById(String id);

    @Query("select u from User u where u.id=?1")
    Optional<User> findUserById(String id);
}
