package com.example.funfinder;

import static org.junit.Assert.*;

import android.widget.Button;
import android.widget.EditText;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception
    {
        mainActivity = mainActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLogIn()
    {


                EditText email = mainActivity.findViewById(R.id.emailET);
                EditText pass = mainActivity.findViewById(R.id.passET);
                email.setText("scott@gmail.com");
                pass.setText("Scott3!");
                Button loginBtn = mainActivity.findViewById(R.id.signInBTN);
                loginBtn.performClick();
              //  assertTrue();


    }

    @After
    public void tearDown() throws Exception
    {
        mainActivity = null;
    }
}