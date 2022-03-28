package com.project.chessbooksapp.dto;

public class BookEntityDto {
    private String id;
    private String bookName;
    private AuthorEntityDto author;

    public BookEntityDto() {
    }

    public BookEntityDto(String id, String bookName, AuthorEntityDto author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public AuthorEntityDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntityDto author) {
        this.author = author;
    }
}