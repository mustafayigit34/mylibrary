package com.musti.mylibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musti.mylibrary.entity.Book;
import com.musti.mylibrary.entity.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeResponseDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("books")
    private List<BookResponseDTO> bookResponseDTO;

    public TypeResponseDTO(Type type){
        id = type.getId();
        name = type.getName();
        bookResponseDTO = new ArrayList<>();
        if(type.getBooks() != null){
            for (Book book: type.getBooks()) {
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
