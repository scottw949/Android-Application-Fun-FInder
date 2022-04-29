package com.example.funfinder;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity implements RVClickInterface {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    public List<FavoritesModel> favoritesList;
    FavoritesAdapter adapter;
    String border = "----------------------------------------------------------------------------------------------------";

    Button toFavBTN;
    ImageView heartIV;

    public static ArrayList<FavoritesModel> tempList = new ArrayList<>();

    //UserFavActivity userFavActivity = new UserFavActivity();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        toFavBTN = findViewById(R.id.toUserFavBTN);
        //heartIV = findViewById(R.id.heartIV);


        toFavBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserFavActivity();
                Log.d("BTN CLICK", "openUserFavActivity: called method on click");
            }
        });

        initData();
        initRecyclerView();

    } //end on create


    private void initData()
    {
        favoritesList = new ArrayList<>();

        favoritesList.add(new FavoritesModel("Leon's", "Leon's is fine seafood and poultry dining that encapsulates southern living.",
                R.drawable.leons, R.drawable.blue_click_icon, R.drawable.blk_heart, border, 32.79852, -79.94594));

        favoritesList.add(new FavoritesModel("Home Team", "Home Team is a barbecue restaurant with reliably awesome food & drinks in a hip, family-friendly atmosphere.",
                R.drawable.home_team, R.drawable.blue_click_icon, R.drawable.blk_heart, border, 32.80943, -79.94637));

        favoritesList.add(new FavoritesModel("Folly Beach", "Folly Beach is a city on Folly Island, in South Carolina, just south of Charleston.",
                R.drawable.folly_beach, R.drawable.blue_click_icon,R.drawable.blk_heart, border, 32.65488, -79.93968));

        favoritesList.add(new FavoritesModel("Poe's", "Poe's Tavern is a gastropub with locations across North & South Carolina and Florida.",
                R.drawable.poes, R.drawable.blue_click_icon, R.drawable.blk_heart, border, 32.76368, -79.83699));

        favoritesList.add(new FavoritesModel("Windjammer", "The Windjammer is Charleston's premier live music beach venue for the last 49 years.",
                R.drawable.windjammer, R.drawable.blue_click_icon, R.drawable.blk_heart, border, 32.78483, -79.79017));

        favoritesList.add(new FavoritesModel("The Battery", "The Battery is a landmark defensive seawall and promenade in Charleston, South Carolina, famous for its stately antebellum homes.",
                R.drawable.battery, R.drawable.blue_click_icon, R.drawable.blk_heart, border, 32.77042, -79.92877));

        favoritesList.add(new FavoritesModel("COFC", "The College of Charleston is a state-supported comprehensive university providing a high-quality education in the arts and sciences, education and business.",
                R.drawable.cofc, R.drawable.blue_click_icon, R.drawable.blk_heart, border, 32.78394, -79.93729));

        favoritesList.add(new FavoritesModel("Shem Creek", "Shem Creek is lined with places to eat and drink, offering award-winning coastal cuisines combined with stunning waterfront views.",
                R.drawable.shem_creek, R.drawable.blue_click_icon, R.drawable.blk_heart, border, 32.79190, -79.88177));

    }

    private void initRecyclerView()
    {
        recyclerView = findViewById(R.id.favoritesRV);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FavoritesAdapter(favoritesList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    } //end init recycler view

    public void openUserFavActivity()
    {
        Intent intent = new Intent(this, UserFavActivity.class);
        startActivity(intent);
    } //end open userFaveActivity

    @Override
    public void onItemClick(int position)
    {

        Toast.makeText(this, "OPENING GOOGLE MAPS", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:" + favoritesList.get(position).getLat() + "," + favoritesList.get(position).getLongitude()));
        startActivity(intent);

        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }


    }


    public void addToList(String placeName, String placeDesc, int placeIMG, int clickIMG, int heartIMG, String border, double lat, double longitude)
    {

        tempList.add(new FavoritesModel(placeName, placeDesc, placeIMG, clickIMG, heartIMG, border, lat, longitude));
    }


    @Override
    public void onLongClick(int position)
    {

        Toast.makeText(this, "ADDED TO FAVORITES", Toast.LENGTH_SHORT).show();

        //TODO ~~ may not work
        String placeName = favoritesList.get(position).getPlaceName();
        String placeDescription = favoritesList.get(position).getPlaceDescription();
        int placeIMG = favoritesList.get(position).getPlaceIMG();
        int clickIMG = favoritesList.get(position).getClickIMG();
        int heartIMG = R.drawable.red_heart;
        String border = favoritesList.get(position).getBorder();
        double lat = favoritesList.get(position).getLat();
        double longitude = favoritesList.get(position).getLongitude();

        addToList(placeName, placeDescription, placeIMG, clickIMG, heartIMG, border, lat, longitude);
    }


}