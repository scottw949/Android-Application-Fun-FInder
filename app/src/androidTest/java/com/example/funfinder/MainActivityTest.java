package com.example.funfinder;

import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withInputType;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    //private MainActivity mainActivity = null;

    private String email = "scott@gmail.com";
    private String pass = "Scott3!";

    @Before
    public void setUp() throws Exception
    {
        //mainActivity = mainActivityActivityTestRule.getActivity();
    }

    @Test
    public void testLogIn()
    {

        Espresso.onView(withId(R.id.emailET)).perform(typeText(email));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.passET)).perform(typeText(pass));

        Espresso.onView(withId(R.id.signInBTN)).perform();


    }



    @After
    public void tearDown() throws Exception
    {
        //mainActivity = null;
    }

    /* testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    androidTestImplementation 'com.android.support.test:rules:1.0.2'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'*/
}