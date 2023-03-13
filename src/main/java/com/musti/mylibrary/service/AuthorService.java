package com.musti.mylibrary.service;

import com.musti.mylibrary.entity.Author;
import com.musti.mylibrary.model.AuthorResponseDTO;

import java.util.List;

public interface AuthorService {
    public List<Author> findAll();

    public Author findById(int theId);

    public Author save(Author theAuthor);

    public void deleteById(int theId);

    List<AuthorResponseDTO> findAllAuthorResponseDTO();

    AuthorResponseDTO findByIdAuthorResponseDTO(int authorId);
}
