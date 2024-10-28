package com.jackdodev.newco.project;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String subject;

    private String category;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime lastModified;

    private UUID authorId;

    private Project() {}

    public Project(String subject, String category, String content) {
        this.subject = subject;
        this.category = category;
        this.content = content;
    }
    public Project(UUID id, String subject, String category, String content) {
        this.id = id;
        this.subject = subject;
        this.category = category;
        this.content = content;
    }

    public static Project convertProjectFromProjectDTO(ProjectDTO projectDto) {
        return new Project(projectDto.subject, projectDto.category, projectDto.content);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getContent() {
        return this.content;
    }

    public String getCategory() {
        return this.category;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getLastModified() {
        return this.lastModified;
    }
}
