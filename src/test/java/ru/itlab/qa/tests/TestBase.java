package ru.itlab.qa.tests;

import org.junit.After;
import org.junit.Before;
import ru.itlab.qa.helpers.AppManager;

public class TestBase {
    private AppManager appManager;

    @Before
    public void setUp(){
        appManager = new AppManager();
    }

    @After
    public void tearDown(){
        appManager.stop();
    }

    public void auth(){
        appManager.getLoginHelper().login();
    }

    public void createNewPost(){
        appManager.getPostHelper().newPost();
    }
}

