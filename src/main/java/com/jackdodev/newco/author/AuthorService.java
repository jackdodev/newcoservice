package com.jackdodev.newco.author;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Optional<Author> getAuthorById(UUID id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);

        return authors;
    }

    public void deleteAuthor(UUID id) {
        authorRepository.deleteById(id);
    }
}
