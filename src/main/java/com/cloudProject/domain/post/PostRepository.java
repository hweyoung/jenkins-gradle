package com.cloudProject.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p where p.postIdx=?1")
    Optional<Post> findByPostIdx(Long id);
}
