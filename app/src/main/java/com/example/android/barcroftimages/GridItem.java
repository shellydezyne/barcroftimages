package com.example.android.barcroftimages;

import android.graphics.Bitmap;

/**
 * Created by KRISHAN KUMAR on 19-02-2017.
 */

public class GridItem {

     private Bitmap image;
    private String title;


     GridItem(Bitmap image, String title) {
        this.image = image;
        this.title = title;

    }


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
