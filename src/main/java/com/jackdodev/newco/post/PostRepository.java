package com.jackdodev.newco.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    Optional<List<Post>> findAllByAuthorIdOrderByCreatedAtDesc(UUID authorId);

    @Query("SELECT p FROM Post p WHERE p.authorId = :authorId AND p.id = :id")
    Optional<Post> findPostByAuthorIdAndId(@Param("authorId") UUID authorId, @Param("id") UUID id);

    void deleteByAuthorIdAndId(UUID postId, UUID author_id);
}
