package com.example.funfinder;

import android.widget.ImageView;

public class FavoritesModel
{
    private String placeName;
    private String placeDescription;
    private int placeIMG;
    private int clickIMG;


    private int heartIMG;
    private String border;

    //TRY THIS


    //constructor
    public FavoritesModel(String placeName, String placeDescription, int placeIMG, int clickIMG, int heartIMG, String border) {
        this.placeName = placeName;
        this.placeDescription = placeDescription;
        this.placeIMG = placeIMG;
        this.clickIMG = clickIMG;
        this.heartIMG = heartIMG;
        this.border = border;


    }


    public int getHeartIMG() {
        return heartIMG;
    }

    public void setHeartIMG(int heartIMG) {
        this.heartIMG = heartIMG;
    }




    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public int getPlaceIMG() {
        return placeIMG;
    }

    public void setPlaceIMG(int placeIMG) {
        this.placeIMG = placeIMG;
    }

    public int getClickIMG() {
        return clickIMG;
    }

    public void setClickIMG(int clickIMG) {
        this.clickIMG = clickIMG;
    }
}
