package com.example.funfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UserFavActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<FavoritesModel> userFavList;
    FavoritesAdapter adapter;
    String border = "----------------------------------------------------------------------------------------------------";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fav);

        Log.d("BTN CLICK", "created new act");

        initData();
        initRecyclerView();
    } //end on create


    private void initData()
    {

        userFavList = new ArrayList<>();

        userFavList.add(new FavoritesModel("Leon's", "Leon's is fine seafood and poultry dining that encapsulates southern living.",
                R.drawable.leons, R.drawable.blue_click_icon, R.drawable.red_heart, border));

        Log.d("BTN CLICK", "created new RV");

    } //end initData()

    private void initRecyclerView()
    {
        recyclerView = findViewById(R.id.userFavRV);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FavoritesAdapter(userFavList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



} //end class