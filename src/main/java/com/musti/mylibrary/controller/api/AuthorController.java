package com.musti.mylibrary.controller.api;

import com.musti.mylibrary.entity.Author;
import com.musti.mylibrary.entity.Book;
import com.musti.mylibrary.model.AuthorResponseDTO;
import com.musti.mylibrary.model.CreateAuthorRequestDTO;
import com.musti.mylibrary.service.AuthorService;
import com.musti.mylibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorController(AuthorService theAuthorService, BookService theBookService){
        authorService = theAuthorService;
        bookService = theBookService;
    }

    // return list of authors
    @GetMapping("/authors")
    public List<AuthorResponseDTO> findAll(){

        return authorService.findAllAuthorResponseDTO();
    }

    // get author by id
    @GetMapping("/authors/{authorId}")
    public AuthorResponseDTO findById(@PathVariable int authorId){

        AuthorResponseDTO theAuthor = authorService.findByIdAuthorResponseDTO(authorId);

        if(theAuthor == null){
            throw new RuntimeException("Author not found - " + authorId);
        }

        return theAuthor;
    }

    // add new author
    @PostMapping("/authors")
    public Author save(@RequestBody CreateAuthorRequestDTO createAuthorRequestDTO){

        Author theAuthor = new Author(createAuthorRequestDTO.getName());

        authorService.save(theAuthor);

        return theAuthor;
    }

    @DeleteMapping("/authors/{authorId}")
    public String deleteById(@PathVariable int authorId){

        Author theAuthor = authorService.findById(authorId);

        for (Book theBook: theAuthor.getBooks()) {
            bookService.deleteById(theBook.getId());
        }

        authorService.deleteById(authorId);

        return "Deleted - " + Integer.toString(authorId);
    }
}

