package com.example.recyclerviewwithmultipleviewtypes.models;

public class News {
    private String newTitle,news;

    public News(String newTitle, String news) {
        this.newTitle = newTitle;
        this.news = news;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public String getNews() {
        return news;
    }
}
