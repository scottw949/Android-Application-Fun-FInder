package com.example.funfinder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesViewHolder extends RecyclerView.ViewHolder
{

    RVClickInterface rvClick;
    //objects
    public TextView placeName;
    public TextView placeDescription;
    public ImageView placeIMG;
    public ImageView clickIMG;
    public TextView border;
    public ImageView heartIMG;
    //public RVClickInterface rvClickInterface;
    //FavoritesAdapter.OnFavoritesClick onFavoritesListener;

    public FavoritesViewHolder(@NonNull View itemView) {
        super(itemView);
        //initialize objs
        placeName = itemView.findViewById(R.id.nameOfPlaceTV);
        placeDescription = itemView.findViewById(R.id.descriptionTV);
        placeIMG = itemView.findViewById(R.id.CVImageIV);
        clickIMG = itemView.findViewById(R.id.clickButtonIV);
        border = itemView.findViewById(R.id.borderTV);
        heartIMG = itemView.findViewById(R.id.heartIV);

        rvClick = FavoritesAdapter.rvClickInterface;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvClick.onItemClick(getAdapterPosition());
            }
        });

    } //end of constructor



} //end of class
