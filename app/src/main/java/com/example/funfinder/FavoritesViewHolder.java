package com.example.funfinder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesViewHolder extends RecyclerView.ViewHolder
{
    //objects
    public TextView placeName;
    public TextView placeDescription;
    public ImageView placeIMG;
    public ImageView clickIMG;
    public TextView border;
    public ImageView heartIMG;

    public FavoritesViewHolder(@NonNull View itemView) {
        super(itemView);
        //initialize objs
        placeName = itemView.findViewById(R.id.nameOfPlaceTV);
        placeDescription = itemView.findViewById(R.id.descriptionTV);
        placeIMG = itemView.findViewById(R.id.CVImageIV);
        clickIMG = itemView.findViewById(R.id.clickButtonIV);
        border = itemView.findViewById(R.id.borderTV);
        heartIMG = itemView.findViewById(R.id.heartIV);

    } //end of constructor
} //end of class
