package com.example.funfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    Button cameraBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fav);

        //Log.d("BTN CLICK", "created new act");
        cameraBTN = findViewById(R.id.cameraBTN);

        cameraBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }); //end camera on click listener

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
        Toast.makeText(this, "OPENING GOOGLE MAPS", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:" + userFavList.get(position).getLat() + "," + userFavList.get(position).getLongitude()));
        startActivity(intent);

        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }

    }

    @Override
    public void onLongClick(int position)
    {
        Toast.makeText(this, "ITEM DELETED FROM FAVORITES", Toast.LENGTH_SHORT).show();
        userFavList.remove(position);
        FavoritesActivity.tempList.remove(position);
        adapter.notifyItemRemoved(position);


    }
} //end class