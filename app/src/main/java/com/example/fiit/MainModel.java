package com.example.fiit;

public class MainModel {

    String name, surl, exe1, exe2, exe3, exe4, exe5;

    MainModel(){

    }

    public MainModel(String name, String surl, String exe1, String exe2, String exe3, String exe4, String exe5) {
        this.name = name;
        this.surl = surl;
        this.exe1 = exe1;
        this.exe2 = exe2;
        this.exe3 = exe3;
        this.exe4 = exe4;
        this.exe5 = exe5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public String getExe1() {
        return exe1;
    }

    public void setExe1(String exe1) {
        this.exe1 = exe1;
    }

    public String getExe2() {
        return exe2;
    }

    public void setExe2(String exe2) {
        this.exe2 = exe2;
    }

    public String getExe3() {
        return exe3;
    }

    public void setExe3(String exe3) {
        this.exe3 = exe3;
    }

    public String getExe4() {
        return exe4;
    }

    public void setExe4(String exe4) {
        this.exe4 = exe4;
    }

    public String getExe5() {
        return exe5;
    }

    public void setExe5(String exe5) {
        this.exe5 = exe5;
    }
}
