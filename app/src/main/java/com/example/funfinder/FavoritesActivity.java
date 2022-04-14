package com.example.funfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<FavoritesModel> favoritesList;
    FavoritesAdapter adapter;
    String border = "----------------------------------------------------------------------------------------------------";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        initData();
        initRecyclerView();

    }

    private void initData()
    {
        favoritesList = new ArrayList<>();

        favoritesList.add(new FavoritesModel("Leon's", "Leon's is fine dining that encapsulates southern living",
                R.drawable.pineapple, R.drawable.blue_click_icon, border));

        favoritesList.add(new FavoritesModel("Home Team", "Home Team is ..................",
                R.drawable.folly_beach, R.drawable.blue_click_icon, border));

        favoritesList.add(new FavoritesModel("Folly Beach", "Folly beach ......... ",
                R.drawable.folly_beach, R.drawable.blue_click_icon, border));

        favoritesList.add(new FavoritesModel("Poe's", "Poe's is ..........",
                R.drawable.cofc, R.drawable.blue_click_icon, border));

        favoritesList.add(new FavoritesModel("The Windjammer", "The windjammer ........",
                R.drawable.pineapple, R.drawable.blue_click_icon, border));

        favoritesList.add(new FavoritesModel("Leon's", "Leon's is fine dining that encapsulates southern living",
                R.drawable.folly_beach, R.drawable.blue_click_icon, border));

        favoritesList.add(new FavoritesModel("Cofc", "Cofc is.........",
                R.drawable.cofc, R.drawable.blue_click_icon, border));

        favoritesList.add(new FavoritesModel("OSS", "OSS is.........",
                R.drawable.pineapple, R.drawable.blue_click_icon, border));

    }

    private void initRecyclerView()
    {
        recyclerView = findViewById(R.id.favoritesRV);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FavoritesAdapter(favoritesList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}