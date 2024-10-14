package com.jackdodev.newco.project;

import java.time.LocalDateTime;

import com.jackdodev.newco.author.AuthorDTO;

public class ProjectDTO {
    public String subject;
    public String category;
    public String content;
    public AuthorDTO author;
    public LocalDateTime createdAt;
    public LocalDateTime lastModified;

    public ProjectDTO(String subject, String category, String content) {
       this.subject = subject;
       this.category = category;
       this.content = content;
    }

    public static ProjectDTO convertProjectDTOFromProject(Project project, AuthorDTO authorDto) {
        ProjectDTO projectDto = new ProjectDTO(project.getSubject(), project.getCategory(), project.getContent());
        projectDto.createdAt = project.getCreatedAt();
        projectDto.lastModified = project.getLastModified();
        projectDto.author = authorDto;

        return projectDto;
    }
}
