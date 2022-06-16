package com.example.diplomaproject.Adapter;

public class RecyclerClass {
    int image;
    String title, description, author;


    public RecyclerClass(int image, String title, String description, String author) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor(){return author;}


}
