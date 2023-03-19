package com.musti.mylibrary.controller.view;

import com.musti.mylibrary.entity.Book;
import com.musti.mylibrary.entity.Type;
import com.musti.mylibrary.model.BookResponseDTO;
import com.musti.mylibrary.model.CreateBookRequestDTO;
import com.musti.mylibrary.model.CreateTypeRequestDTO;
import com.musti.mylibrary.model.TypeResponseDTO;
import com.musti.mylibrary.service.AuthorService;
import com.musti.mylibrary.service.BookService;
import com.musti.mylibrary.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookViewController {


    private BookService bookService;
    private AuthorService authorService;
    private TypeService typeService;


    @Autowired
    public BookViewController(BookService theBookService, AuthorService theAuthorService, TypeService theTypeService){
        bookService = theBookService;
        authorService = theAuthorService;
        typeService = theTypeService;
    }

    @GetMapping("/books")
    public String findAll(Model model){

        List<BookResponseDTO> books =  bookService.findAll();

        model.addAttribute("books",books);

        return "book/books-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        CreateBookRequestDTO book = new CreateBookRequestDTO();

        model.addAttribute("book", book);

        List<TypeResponseDTO> typeResponseDTO = typeService.findAllTypeResponseDTO();
        List<String> types = new ArrayList<>();
        for (TypeResponseDTO type: typeResponseDTO) {
            types.add(type.getName());
        }

        model.addAttribute("types",types);

        return "book/book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") CreateBookRequestDTO createBookRequestDTO){

        bookService.save(createBookRequestDTO);

        return "redirect:/book/books";
    }
}
