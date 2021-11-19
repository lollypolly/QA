package ru.itlab.qa.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itlab.qa.models.AccountData;
import ru.itlab.qa.models.Post;

@Slf4j
public class AppManager {
    public WebDriver driver;
    public JavascriptExecutor js;
    private AccountData accountData;
    private Post post;

    private LoginHelper loginHelper;
    private PostHelper postHelper;

    public AppManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        accountData = new AccountData();
        accountData.setEmail("polik_dlya_spama@mail.ru");
        accountData.setPassword("1234spam");
        post = new Post();
        post.setName("testGG2");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        loginHelper = new LoginHelper(this, accountData);
        postHelper = new PostHelper(this, post, js);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop() {
        driver.quit();
    }

    public LoginHelper getLoginHelper() {return loginHelper;}

    public PostHelper getPostHelper() {
        return postHelper;
    }
}
