package com.acv.randomuser.ui;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.acv.randomuser.R;
import com.acv.randomuser.recyclerview.RecyclerViewInteraction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    private static final int ANY_NUMBER_OF_RANDOM_USER = 10;

    @Rule
    public IntentsTestRule<MainActivity> activityRule
            = new IntentsTestRule<>(MainActivity.class, true, false);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void showAllInformationRandomUser() {
        List<RandomUserModel> randomUserModels = givenThereAreSomeRandomUser(ANY_NUMBER_OF_RANDOM_USER);

        startActivity();

        RecyclerViewInteraction.<RandomUserModel>onRecyclerView(withId(R.id.rvRandomUser))
                .withItems(randomUserModels)
                .check(new RecyclerViewInteraction.ItemViewAssertion<RandomUserModel>() {
                    @Override
                    public void check(RandomUserModel randomUser, View view, NoMatchingViewException e) {
                        matches(hasDescendant(withText(randomUser.getFullName()))).check(view, e);
                        matches(hasDescendant(withText(randomUser.getEmail()))).check(view, e);
                        matches(hasDescendant(withText(randomUser.getPhone()))).check(view, e);
                    }
                });
    }

    private List<RandomUserModel> givenThereAreSomeRandomUser(int numberOfRandomUsers) {
        List<RandomUserModel> randomUserModels = new LinkedList<>();
        for (int i = 0; i < numberOfRandomUsers; i++) {
            String fullname = "RandomUser - " + i;
            String email = "Email - " + i;
            String picture = "https://i.annihil.us/u/prod/marvel/i/mg/c/60/55b6a28ef24fa.jpg";
            String phone = "44444 " + i;
            RandomUserModel randomUserModel =
                    new RandomUserModel(fullname, email, picture, phone);
            randomUserModels.add(randomUserModel);
        }
        return randomUserModels;
    }

    private MainActivity startActivity() {
        return activityRule.launchActivity(null);
    }
}