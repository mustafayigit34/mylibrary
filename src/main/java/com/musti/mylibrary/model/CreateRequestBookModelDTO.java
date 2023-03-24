package com.musti.mylibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRequestBookModelDTO {


    private int id;
    private String name;
    private String authorName;
    private int pageNumber;
    private int status;

    private String typeNames;

    public CreateRequestBookModelDTO(@JsonProperty("name") int id, @JsonProperty("name") String name, @JsonProperty("author_name") String authorName,
                                     @JsonProperty("page_number") int pageNumber, @JsonProperty("status") int status,
                                     @JsonProperty("type_names")String typeNames) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.pageNumber = pageNumber;
        this.status = status;
        this.typeNames = typeNames;

    }

    public CreateRequestBookModelDTO() {
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

    public String getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(String typeNames) {
        this.typeNames = typeNames;
    }
}
