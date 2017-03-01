package com.example.android.barcroftimages;


import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.util.Date;

/**
 * Created by Dezyne 2 on 3/1/2017.
 */

public class DB_model_class {


    int id;
    byte[] image;
    String date;
    int series;


    public DB_model_class() {
    }

    public DB_model_class(int id, byte[] image, String date, int series) {
        this.id = id;
        this.image = image;
        this.date = date;
        this.series = series;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
         return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }


}
