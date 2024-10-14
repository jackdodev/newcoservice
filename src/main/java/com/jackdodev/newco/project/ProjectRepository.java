package com.jackdodev.newco.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByAuthorId(UUID authorId);
    Project findByIdAndAuthorId(UUID projectId, UUID userId);

    void deleteByAuthorIdAndId(UUID userId, UUID projectId);
}
