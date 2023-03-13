package com.musti.mylibrary.service;

import com.musti.mylibrary.model.BookResponseDTO;
import com.musti.mylibrary.model.CreateBookRequestDTO;

import java.util.List;

public interface BookService {

    public List<BookResponseDTO> findAll();

    public BookResponseDTO findById(int theId);

    public BookResponseDTO save(CreateBookRequestDTO createBookRequestDTO);

    public void deleteById(int theId);
}
