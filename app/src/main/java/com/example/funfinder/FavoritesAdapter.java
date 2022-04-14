package com.example.funfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.file.attribute.FileTime;
import java.util.List;


// <FavoritesViewHolder> ---------------------------------------- |
public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesViewHolder>
{
    private List<FavoritesModel> favoritesList;

    public FavoritesAdapter(List<FavoritesModel>favoritesList)
    {
        this.favoritesList = favoritesList;
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_design_rv, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
       /* int placeIMG = favoritesList.get(position).getPlaceIMG();
        int clickIMG = favoritesList.get(position).getClickIMG();
        String placeName = favoritesList.get(position).getPlaceName();
        String placeDescription = favoritesList.get(position).getPlaceDescription();
        String border = favoritesList.get(position).getBorder();

        holder.setData(placeIMG, clickIMG, placeName, placeDescription, border); */


        holder.placeName.setText(favoritesList.get(position).getPlaceName());
        holder.placeDescription.setText(favoritesList.get(position).getPlaceDescription());
        holder.border.setText(favoritesList.get(position).getBorder());
        holder.placeIMG.setImageResource(favoritesList.get(position).getPlaceIMG());
        holder.clickIMG.setImageResource(favoritesList.get(position).getClickIMG());


    }

    @Override
    public int getItemCount() {
        return favoritesList.size();
    }
} //end of class
