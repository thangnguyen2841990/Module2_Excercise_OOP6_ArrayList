package com.codegym;

import java.io.Serializable;

public class Book extends Document implements Serializable {
    private String nameOfWriter;
    private int totalPages;

    public Book(String nameOfWriter, int totalPages) {
        this.nameOfWriter = nameOfWriter;
        this.totalPages = totalPages;
    }

    public Book(int documentCode, String imprint, int releaseNumber, String nameOfWriter, int totalPages) {
        super(documentCode, imprint, releaseNumber);
        this.nameOfWriter = nameOfWriter;
        this.totalPages = totalPages;
    }

    public String getNameOfWriter() {
        return nameOfWriter;
    }

    public void setNameOfWriter(String nameOfWriter) {
        this.nameOfWriter = nameOfWriter;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTên tác giả:" + this.nameOfWriter + ", tổng số trang: " + this.totalPages;
    }
}
