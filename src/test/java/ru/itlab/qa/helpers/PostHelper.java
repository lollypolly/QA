package ru.itlab.qa.helpers;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.itlab.qa.models.Post;

public class PostHelper extends HelperBase {
    private AppManager appManager;
    private Post post;

    public PostHelper(AppManager appManager, Post post) {
        this.appManager = appManager;
        this.post = post;
        driver = appManager.getDriver();
    }

    @SneakyThrows
    public void newPost() {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".dyH:nth-child(2)")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#__PWS_ROOT__ > div > div.appContent > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div > div > div:nth-child(2) > div > button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".DUt:nth-child(2) .tBJ")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("boardEditName")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("boardEditName")).sendKeys(post.getName());
        driver.findElement(By.id("boardEditName")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        {
            WebElement element = driver.findElement(By.cssSelector(".RCK"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        Thread.sleep(7000);
        {
            WebElement element = driver.findElement(By.cssSelector(".jx-"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".RCK > .tBJ")).click();
        Thread.sleep(7000);
    }
}
