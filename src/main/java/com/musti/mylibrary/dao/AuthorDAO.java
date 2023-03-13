package com.musti.mylibrary.dao;

import com.musti.mylibrary.entity.Author;

import java.util.List;

public interface AuthorDAO {

    public List<Author> findAll();

    public Author findById(int theId);

    public Author save(Author theAuthor);

    public void deleteById(int theId);

}

