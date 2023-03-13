package com.musti.mylibrary.dao;

import com.musti.mylibrary.entity.Book;
import com.musti.mylibrary.model.BookResponseDTO;

import java.util.List;

public interface BookDAO {

    public List<BookResponseDTO> findAll();

    public Book findById(int theId);

    public void save(Book theBook);

    public void deleteById(int theId);
}
