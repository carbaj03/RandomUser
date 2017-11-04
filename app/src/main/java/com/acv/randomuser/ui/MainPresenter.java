package com.acv.randomuser.ui;


import java.util.LinkedList;
import java.util.List;


public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void loadRandomUsers() {
        List<RandomUserModel> randomUsers = getRandomUsers(10);
        view.showRandomUsers(randomUsers);
    }

    private List<RandomUserModel> getRandomUsers(int numberOfRandomUsers) {
        List<RandomUserModel> randomUserModels = new LinkedList<>();
        for (int i = 0; i < numberOfRandomUsers; i++) {
            String fullname = "RandomUser - " + i;
            String email = "Email - " + i;
            String picture = "https://i.annihil.us/u/prod/marvel/i/mg/c/60/55b6a28ef24fa.jpg";
            String phone = "69979088 " + i;
            RandomUserModel randomUserModel =
                    new RandomUserModel(fullname, email, picture, phone);
            randomUserModels.add(randomUserModel);
        }
        return randomUserModels;
    }
}
