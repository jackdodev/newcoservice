package com.jackdodev.newco.author;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    private UUID id;

    private String firstName;

    private String lastName;

    private Author() {}

    public Author(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Author convertAuthorFromAuthorDTO(AuthorDTO dto) {
        return new Author(dto.firstName, dto.lastName);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
