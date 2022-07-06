package com.example.ummauniversityapp;

public class Feed {

    private String title;
    private String date;
    private String fulltext;

    public Feed(){

    }


    public Feed(String title, String date, String fulltext) {
        this.title = title;
        this.date = date;
        this.fulltext = fulltext;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "name='" + title + '\'' +
                ", date='" + date + '\'' +
                ", fulltext='" + fulltext + '\'' +
                '}';
    }
}
