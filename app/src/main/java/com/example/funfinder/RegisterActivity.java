package com.example.funfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText userId;
    EditText password;
    EditText name;

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //get info from registration
        userId = findViewById(R.id.emailRegET);
        password = findViewById(R.id.passRegET);
        name = findViewById(R.id.nameRegET);
        register = findViewById(R.id.registerBTN);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create a new listener on click of register btn
                UserEntity newUser = new UserEntity();
                newUser.setUserID(userId.getText().toString());
                newUser.setPassword(password.getText().toString());
                newUser.setName(name.getText().toString());

                if (validateUserInput(newUser))
                {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());

                    UserDAO userDao = userDatabase.userDao();
                    new Thread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            userDao.registerUser(newUser);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "SUCCESSFULLY REGISTERED!", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).start(); //end new thread

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "ALL INPUTS ARE REQUIRED!", Toast.LENGTH_SHORT).show();
                }

            } //end on click method
        }); //end set on click listener

    } // end of on create method

    private boolean validateUserInput(UserEntity newUser)
    {
        if (newUser.getName().isEmpty() || newUser.getPassword().isEmpty() ||
         newUser.getUserID().isEmpty())
        {
            return false;
        }

        return true;
    } //end validate user input method
}