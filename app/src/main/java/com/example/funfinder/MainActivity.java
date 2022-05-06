package com.example.funfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    EditText userId;
    EditText password;

    Button logIn;
    Button createAct;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = findViewById(R.id.emailET);
        password = findViewById(R.id.passET);

        logIn = findViewById(R.id.signInBTN);
        createAct = findViewById(R.id.registerActBTN);

        //TODO: DELETE LATER
        //locationBTN = findViewById(R.id.testerBTN);
        //

        //TODO: DELETE LATER
        //open location activity when register button is clicked
       /* locationBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openLocationActivity();
            }
        });
        // */



        //open register activity when register button is clicked
        createAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openRegisterActivity();
            }
        });


        // log user in once sign in is clicked
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String userIdText = userId.getText().toString();
                String passwordText = password.getText().toString();

                if (userIdText.isEmpty() || passwordText.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "ALL INPUTS MUST BE FILLED!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //initialize database
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());

                    UserDAO userDAO = userDatabase.userDao();
                    new Thread(new Runnable(){

                        @Override
                        public void run()
                        {
                            UserEntity userEntity = userDAO.logIn(userIdText, passwordText);
                            if (userEntity == null)
                            {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run()
                                    {
                                        Toast.makeText(getApplicationContext(), "INVALID CREDENTIALS.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            else
                            {
                                String name = userEntity.name;
                               // Toast.makeText(getApplicationContext(), "WELCOME!", Toast.LENGTH_SHORT).show();
                                openFavoritesActivity();
                            }
                        }
                    }).start();; //end new thread
                }
            } //end onclick method

        });  //end set on click listener

    } //end of on create method


    //open activity 2 once clicked and login is successful
    public void openFavoritesActivity()
    {
        Intent intent = new Intent(this, FavoritesActivity.class);
        startActivity(intent);
    } //end openFavorites method

    public void openRegisterActivity()
    {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    } //end open Register Activity

    //TODO: DELETE LATER
    public void openLocationActivity()
    {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    } //end open Register Activity
    //

}