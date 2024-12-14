package com.example.a16pract;

import java.io.Serializable;

public class Users implements Serializable {
    private String id;
    private String Name;
    private String Email;
    private String Cel;
    private String Tirazh;

    public Users(String id , String name, String email, String cel, String tirazh) {
        this.id = id; this.Name = name; this.Email = email; this.Cel = cel; this.Tirazh = tirazh;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getCel() {
        return Cel;
    }

    public String getTirazh() {
        return Tirazh;
    }

    public String getId() {
        return id;
    }

    public void setNameAuthor(String author) {
    }

    public void setNameBook(String book) {
    }

    public void setEmailAuthor(String email) {
    }

    public void setNumberPhone(String phone) {

    }
}
