package com.example.funfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {

    FusedLocationProviderClient fusedLocationProviderClient;
    public Button locationBTN;
    public TextView latitudeTV;
    public TextView longitudeTV;
    private static final int REQUEST_CODE = 100;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        locationBTN = findViewById(R.id.locationBTN);
        latitudeTV = findViewById(R.id.latitudeTV);
        longitudeTV = findViewById(R.id.longitudeTV);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        //set on click listener
        locationBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                getLastLocation();



            } //end on click
        }); //end on click listener
    } //end on create

    private void getLastLocation()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED)
        {
            Log.d("HERE", "getLastLocation: Permission granted");
            fusedLocationProviderClient.getLastLocation().addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("HERE", "onFailure" + e.getMessage());
                }
            }).addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            Log.d("HERE", "onSuccess: ");
                            
                            if (location != null)
                            {
                                Log.d("HERE", "onSuccess: locationValid");
                                Geocoder geocoder = new Geocoder(LocationActivity.this, Locale.getDefault());
                                List<Address> adrss = null;
                                try {
                                    adrss = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                                    Log.d("HERE", "onSuccess: geocoder is fine");
                                    latitudeTV.setText("Latitude: " + adrss.get(0).getLatitude());
                                    longitudeTV.setText("Longitude: " + adrss.get(0).getLongitude());

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }


                            } //end if


                        } //end on success method
                    }); //end on Success listen


        } //end if 1
        else
        {

            askPermission();

        } //end else

    } //end getLastLocation()


    private void askPermission()
    {
        ActivityCompat.requestPermissions(LocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);

    } //end askPermission()

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if (requestCode == REQUEST_CODE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                getLastLocation();
            }


        } //end if 1
        else
        {

            Toast.makeText(LocationActivity.this, "REQUIRED PERMISSIONS ARE NECESSARY!", Toast.LENGTH_LONG)
                    .show();

        } //end else

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
} //end class