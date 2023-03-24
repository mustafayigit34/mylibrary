package com.musti.mylibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateBookRequestDTO {

    private int id;
    private String name;
    private String authorName;
    private int pageNumber;
    private int status;

    private List<String> typeNames;

    public CreateBookRequestDTO(@JsonProperty("name") String name, @JsonProperty("author_name") String authorName,
                                @JsonProperty("page_number") int pageNumber, @JsonProperty("status") int status,
                                @JsonProperty("type_names")List<String> typeNames) {
        this.name = name;
        this.authorName = authorName;
        this.pageNumber = pageNumber;
        this.status = status;
        this.typeNames = new ArrayList<>();
        this.typeNames = typeNames;

    }

    public CreateBookRequestDTO() {
    }

    public CreateBookRequestDTO(CreateRequestBookModelDTO createRequestBookModelDTO){
        this.id = createRequestBookModelDTO.getId();
        this.name = createRequestBookModelDTO.getName();
        this.authorName = createRequestBookModelDTO.getAuthorName();
        this.pageNumber = createRequestBookModelDTO.getPageNumber();
        this.status =  createRequestBookModelDTO.getStatus();
        this.typeNames = new ArrayList<>();
        this.typeNames = Arrays.asList(createRequestBookModelDTO.getTypeNames().split(","));

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
