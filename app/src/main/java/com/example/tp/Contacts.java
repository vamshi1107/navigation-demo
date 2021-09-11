package com.example.tp;

public class Contacts {
    private int id;
    private String Name;
    private String Phone;
    Contacts()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    Contacts(String Name, String Phone)
    {
        this.Name=Name;
        this.Phone=Phone;
    }

}
