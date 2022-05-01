package com.example.funfinder;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withInputType;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    //private MainActivity mainActivity = null;

    private final String email = "scott@gmail.com";
    private final String pass = "Scott3!";
    private final String regEmail = "Test@gmail.com";
    private final String regPass = "Test1!";
    private final String regName = "Scott";

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void unitTestLogIn()
    {

        Espresso.onView(withId(R.id.emailET)).perform(typeText(email));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.passET)).perform(typeText(pass));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.signInBTN)).perform(ViewActions.click());
    }

    @Test
    public void integrationTest()
    {

        //sign in page --> create account page
        Espresso.onView(withId(R.id.registerActBTN)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.emailRegET)).perform(typeText(regEmail));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.passRegET)).perform(typeText(regPass));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.nameRegET)).perform(typeText(regName));

        Espresso.closeSoftKeyboard();

        //create account page --> sign in page
        Espresso.onView(withId(R.id.registerBTN)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.emailET)).perform(typeText(regEmail));

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.passET)).perform(typeText(regPass));

        Espresso.closeSoftKeyboard();


        // sign in page --> nearBy activity page
        Espresso.onView(withId(R.id.signInBTN)).perform(ViewActions.click());





    }



    @After
    public void tearDown() throws Exception
    {

    }


}