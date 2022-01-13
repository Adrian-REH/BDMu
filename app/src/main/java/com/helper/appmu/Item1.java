package com.helper.appmu;

public class Item1 {
    private String name;
    private String info;
    private String link;
    private String correo;
    private String page;
    private int photo;

    public Item1(String name, String info, String link, String correo, String page, int photo) {
        this.name = name;
        this.info = info;
        this.link = link;
        this.correo = correo;
        this.page = page;
        this.photo = photo;
    }


    public String getInfo() {
        return info;
    }

    public String getPage() {
        return page;
    }

    public String getCorreo() {
        return correo;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLink() {
        return link;
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
