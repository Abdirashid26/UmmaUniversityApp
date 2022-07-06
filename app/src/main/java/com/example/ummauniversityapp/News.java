package com.example.ummauniversityapp;

import androidx.recyclerview.widget.RecyclerView;

public class News  {

    private String title,admin,date,image;


    public News(){
        System.out.println("Something is Wrong !");
    }

    public News(String title, String admin, String date, String image) {

        this.title = title;
        this.admin = admin;
        this.date = date;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", admin='" + admin + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
