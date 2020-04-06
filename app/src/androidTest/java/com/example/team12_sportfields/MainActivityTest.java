package com.example.team12_sportfields;

import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception {

        mainActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view = mainActivity.findViewById(R.id.tvMainText);

        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {

        mainActivity = null;
    }

}