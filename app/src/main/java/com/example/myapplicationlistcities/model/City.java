package com.example.myapplicationlistcities.model;

import java.io.Serializable;

public class City implements Serializable {
    int nameCity;
    int imagecity;

    public City(int nameCity, int imagecity) {
        this.nameCity = nameCity;
        this.imagecity = imagecity;
    }

    public int getNameCity() {
        return nameCity;
    }

    public void setNameCity(int nameCity) {
        this.nameCity = nameCity;
    }

    public int getImagecity() {
        return imagecity;
    }

    public void setImagecity(int imagecity) {
        this.imagecity = imagecity;
    }
}
