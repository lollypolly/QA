package ru.itlab.qa.tests;

import org.junit.After;
import org.junit.Before;
import ru.itlab.qa.helpers.AppManager;

public class TestBase {
    private static AppManager appManager;
    static {
        appManager = new AppManager();
    }

    public static void tearDown(){
        appManager.stop();
    }

    public void auth(){
        appManager.getLoginHelper().login();
    }

    public void createNewPost(){
        appManager.getPostHelper().newPost();
    }

    public void deleteLastPost(){
        appManager.getPostHelper().deleteLastPost();
    }
}

