package com.jackdodev.newco.post;

import java.time.LocalDateTime;

import com.jackdodev.newco.author.Author;
import com.jackdodev.newco.author.AuthorDTO;

public class PostDTO {
    public String subject;
    public String contents;
    public AuthorDTO author;
    public LocalDateTime createdAt;
    public LocalDateTime lastModified;

    public PostDTO(String subject, String contents) {
        this.subject = subject;
        this.contents = contents;
    }

    public static PostDTO convertPostDTOFromPost(Post post, AuthorDTO authorDto) {
        PostDTO postDto = new PostDTO(post.getSubject(), post.getContents());
        postDto.author = authorDto;
        postDto.createdAt = post.getCreatedAt();
        postDto.lastModified = post.getLastModified();

        return postDto;
    }
}
