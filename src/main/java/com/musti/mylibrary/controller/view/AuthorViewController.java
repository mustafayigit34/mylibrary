package com.musti.mylibrary.controller.view;

import com.musti.mylibrary.model.AuthorResponseDTO;
import com.musti.mylibrary.service.AuthorService;
import com.musti.mylibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AuthorViewController {


    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorViewController(AuthorService theAuthorService, BookService theBookService){
        authorService = theAuthorService;
        bookService = theBookService;
    }

    @GetMapping("/authors")
    public String findAll(Model model){

        List<AuthorResponseDTO> authors = authorService.findAllAuthorResponseDTO();

        model.addAttribute("authors",authors);
        model.addAttribute("books",authors.get(2).getBookResponseDTO());

        return "authors-list";
    }
}
