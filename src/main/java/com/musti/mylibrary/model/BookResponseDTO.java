package com.musti.mylibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musti.mylibrary.entity.Book;
import com.musti.mylibrary.entity.Type;

import java.util.ArrayList;
import java.util.List;

public class BookResponseDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("author_name")
    private String authorId;
    @JsonProperty("page_number")
    private int pageNumber;
    @JsonProperty("status")
    private int status;

    @JsonProperty("type_names")
    private List<String> typeNames;

    public BookResponseDTO(Book book) {
        id = book.getId();
        name = book.getName();
        authorId = book.getAuthor().getName();
        pageNumber = book.getPageNumber();
        status = book.getStatus();
        typeNames = new ArrayList<>();
        if(book.getTypes() != null){
            for (Type types: book.getTypes()) {
                typeNames.add(types.getName());
            }
        }
    }
}
