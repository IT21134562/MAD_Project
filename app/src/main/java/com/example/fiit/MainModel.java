package com.example.fiit;

public class MainModel {

    String name, duration, price, surl;

    MainModel(){

    }


    public MainModel(String name, String duration, String price, String surl) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.surl = surl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
