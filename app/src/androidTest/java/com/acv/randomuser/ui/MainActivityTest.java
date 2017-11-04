package com.acv.randomuser.ui;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public IntentsTestRule<MainActivity> activityRule
            = new IntentsTestRule<>(MainActivity.class, true, false);

    @Before
    public void setUp() throws Exception {
    }
}