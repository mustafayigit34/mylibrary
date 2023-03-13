package com.musti.mylibrary.controller;

import com.musti.mylibrary.model.BookResponseDTO;
import com.musti.mylibrary.model.CreateBookRequestDTO;
import com.musti.mylibrary.service.AuthorService;
import com.musti.mylibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;
    private AuthorService authorService;


    @Autowired
    public BookController(BookService theBookService, AuthorService theAuthorService){
        bookService = theBookService;
        authorService = theAuthorService;
    }

    // return list of books
    @GetMapping("/books")
    public List<BookResponseDTO> findAll(){

        return bookService.findAll();
    }

    // get book by id
    @GetMapping("/books/{bookId}")
    public BookResponseDTO findById(@PathVariable int bookId){

        BookResponseDTO theBookResponseDTO = bookService.findById(bookId);

        if(theBookResponseDTO == null){
            throw new RuntimeException("Book not found - " + bookId);
        }

        return theBookResponseDTO;
    }

    // add new book
    @PostMapping("/books")
    public BookResponseDTO save(@RequestBody CreateBookRequestDTO createBookRequestDTO){

        return bookService.save(createBookRequestDTO);
    }

    // delete book by id
    @DeleteMapping("/books/{bookId}")
    public String deleteById(@PathVariable int bookId){

        bookService.deleteById(bookId);

        return "Deleted - " + Integer.toString(bookId);
    }
}

