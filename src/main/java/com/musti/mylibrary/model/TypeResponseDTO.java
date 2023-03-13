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
        for (Book book: type.getBooks()) {
            bookResponseDTO.add(new BookResponseDTO(book));
        }
    }
}
