package com.example.funfinder;

public class FavoritesModel
{
    private String placeName;
    private String placeDescription;
    private int placeIMG;
    private int clickIMG;
    private String border;

    //constructor


    public FavoritesModel(String placeName, String placeDescription, int placeIMG, int clickIMG, String border) {
        this.placeName = placeName;
        this.placeDescription = placeDescription;
        this.placeIMG = placeIMG;
        this.clickIMG = clickIMG;
        this.border = border;
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
