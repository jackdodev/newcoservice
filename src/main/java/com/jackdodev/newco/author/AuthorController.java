package com.jackdodev.newco.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public Optional<AuthorDTO> getAuthorById(@PathVariable String id) {
        Optional<Author> opAuthor =  authorService.getAuthorById(UUID.fromString(id));
        return opAuthor.map(AuthorDTO::convertAuthorDTOFrommAuthor);

    }

    @PostMapping
    public Author createAuthor(@RequestBody AuthorDTO authorDto) {
        Author author = Author.convertAuthorFromAuthorDTO(authorDto);
        author.setId(UUID.randomUUID());

        return authorService.createAuthor(author);
    }

    @PutMapping("/{id}")
    public Optional<Author> updateAuthor(@PathVariable String id, @RequestBody AuthorDTO authorDto) {
        Optional<Author> opAuthor = authorService.getAuthorById(UUID.fromString(id));
        if (opAuthor.isPresent()) {
            Author author = opAuthor.get();
            author = new Author(author.getId(), authorDto.firstName, authorDto.lastName);

            return Optional.of(authorService.createAuthor(author));
        }

        return Optional.empty();
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable String id) {
        authorService.deleteAuthor(UUID.fromString(id));
    }
}
