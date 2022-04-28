package com.example.funfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.file.attribute.FileTime;
import java.util.List;


// <FavoritesViewHolder> ---------------------------------------- |
public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesViewHolder>
{


    private List<FavoritesModel> favoritesList;

    public static RVClickInterface rvClickInterface;

    public FavoritesAdapter(List<FavoritesModel>favoritesList, RVClickInterface rvClickInterface)
    {
        this.favoritesList = favoritesList;
        this.rvClickInterface = rvClickInterface;
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_design_rv, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        holder.placeName.setText(favoritesList.get(position).getPlaceName());
        holder.placeDescription.setText(favoritesList.get(position).getPlaceDescription());
        holder.border.setText(favoritesList.get(position).getBorder());
        holder.placeIMG.setImageResource(favoritesList.get(position).getPlaceIMG());
        holder.clickIMG.setImageResource(favoritesList.get(position).getClickIMG());
        holder.heartIMG.setImageResource(favoritesList.get(position).getHeartIMG());


    }

    @Override
    public int getItemCount() {
        return favoritesList.size();
    }

} //end of class
