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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(List<String> typeNames) {
        this.typeNames = typeNames;
    }
}
