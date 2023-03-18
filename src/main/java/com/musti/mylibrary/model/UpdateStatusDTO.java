package com.musti.mylibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateStatusDTO {

    private int bookId;
    private Status status;

    public UpdateStatusDTO(@JsonProperty("bookId") int bookId, @JsonProperty("status") Status status) {
        this.bookId = bookId;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
