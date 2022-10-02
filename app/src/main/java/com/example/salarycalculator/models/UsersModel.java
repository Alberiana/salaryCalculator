package com.example.salarycalculator.models;

public class UsersModel {
    private int id;
    private String name,surname, pagabr,konPensional, pagatat;

    public UsersModel(int id, String name, String surname, String pagabr, String konPensional, String pagatat) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pagabr = pagabr;
        this.konPensional = konPensional;
        this.pagatat = pagatat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPagabr() {
        return pagabr;
    }

    public void setPagabr(String pagabr) {
        this.pagabr = pagabr;
    }

    public String getKonPensional() {
        return konPensional;
    }

    public void setKonPensional(String konPensional) {
        this.konPensional = konPensional;
    }

    public String getPagatat() {
        return pagatat;
    }

    public void setPagatat(String pagatat) {
        this.pagatat = pagatat;
    }

}
