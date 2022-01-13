package com.helper.appmu;

public class Item {
    private String name;
    private String info;
    private String link;
    private String correo;
    private String page;
    private int photo;

    public Item(String name, int photo) {
        this.name = name;

        this.photo = photo;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
