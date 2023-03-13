package com.musti.mylibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musti.mylibrary.entity.Author;
import com.musti.mylibrary.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorResponseDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("books")
    private List<BookResponseDTO> bookResponseDTO;

    public AuthorResponseDTO(Author author){
        id = author.getId();
        name = author.getName();
        bookResponseDTO = new ArrayList<>();
        if(author.getBooks() != null){
            for (Book book: author.getBooks()) {
                bookResponseDTO.add(new BookResponseDTO(book));
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookResponseDTO> getBookResponseDTO() {
        return bookResponseDTO;
    }

    public void setBookResponseDTO(List<BookResponseDTO> bookResponseDTO) {
        this.bookResponseDTO = bookResponseDTO;
    }
}
