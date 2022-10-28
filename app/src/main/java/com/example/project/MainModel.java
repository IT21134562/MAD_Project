package com.example.project;

public class MainModel {

    String title, desc, rarity, img;

    MainModel(){


    }

    public MainModel(String title, String desc, String rarity, String img) {
        this.title = title;
        this.desc = desc;
        this.rarity = rarity;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
