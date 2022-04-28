package com.example.funfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UserFavActivity extends AppCompatActivity implements RVClickInterface{

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    public List<FavoritesModel> userFavList;
    public FavoritesAdapter adapter;
    String border = "----------------------------------------------------------------------------------------------------";
    //FavoritesActivity favoritesActivity = new FavoritesActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fav);

        Log.d("BTN CLICK", "created new act");

        initData();
        initRecyclerView();
    } //end on create

    //TODO ~~ made this public
    public void initData()
    {


        userFavList = new ArrayList<>();

        if (FavoritesActivity.tempList != null)
        {
            userFavList.addAll(FavoritesActivity.tempList);
        }
        //userFavList = new ArrayList<>();

        //userFavList.add(new FavoritesModel("Leon's", "Leon's is fine seafood and poultry dining that encapsulates southern living.",
               // R.drawable.leons, R.drawable.blue_click_icon, R.drawable.red_heart, border));

        //userFavList.add(new FavoritesModel("Poe's", "Leon's is fine seafood and poultry dining that encapsulates southern living.",
                //R.drawable.leons, R.drawable.blue_click_icon, R.drawable.red_heart, border));


        //userFavList.addAll(FavoritesActivity.tempList);

        Log.d("BTN CLICK", "created new RV");

    } //end initData()

    private void initRecyclerView()
    {
        recyclerView = findViewById(R.id.userFavRV);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FavoritesAdapter(userFavList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(int position)
    {
        Toast.makeText(this, "ITEM DELETED FROM FAVORITES", Toast.LENGTH_SHORT).show();
        userFavList.remove(position);
        FavoritesActivity.tempList.remove(position);
        adapter.notifyItemRemoved(position);
    }
} //end class