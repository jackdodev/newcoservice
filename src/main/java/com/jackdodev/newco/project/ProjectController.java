package com.jackdodev.newco.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jackdodev.newco.author.Author;
import com.jackdodev.newco.author.AuthorDTO;
import com.jackdodev.newco.author.AuthorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public Optional<ProjectDTO> getProjectByProjectIdAndAuthorId(@RequestHeader(value="authorId") String authorId, @PathVariable String projectId) {
        authorService.getAuthorById(UUID.fromString(authorId));
        Project project = projectService.getProjectById(UUID.fromString(authorId), UUID.fromString(projectId));

        Optional<Author> opAuthor = authorService.getAuthorById(UUID.fromString(authorId));
        if (opAuthor.isPresent()) {
            AuthorDTO authorDto = AuthorDTO.convertAuthorDTOFrommAuthor(opAuthor.get());
            return Optional.of(ProjectDTO.convertProjectDTOFromProject(project, authorDto));
        }
        return Optional.empty();
    }

    @GetMapping
    public List<Project> getAllProject(@RequestHeader(value = "authorId") String authorId) {
        return projectService.getAllProjectsByAuthor(UUID.fromString(authorId));
    }

    @PostMapping
    public void createProject(@RequestBody ProjectDTO projectDto) {
        Project project = Project.convertProjectFromProjectDTO(projectDto);
        project.setId(UUID.randomUUID());
        projectService.saveProject(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@RequestHeader(value = "authorId") String authorId, @PathVariable String projectId) {
        projectService.deleteProject(UUID.fromString(authorId), UUID.fromString(projectId));
    }
}
