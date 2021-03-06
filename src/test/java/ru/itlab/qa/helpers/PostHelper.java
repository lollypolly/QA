package ru.itlab.qa.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.itlab.qa.models.Post;

import java.util.List;

@Slf4j
public class PostHelper extends HelperBase {
    private AppManager appManager;
    private Post post;
    private JavascriptExecutor js;

    public PostHelper(AppManager appManager, Post post, JavascriptExecutor js) {
        this.appManager = appManager;
        this.post = post;
        this.js = js;
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
        Thread.sleep(4000);
        //!-- asset ------!
        System.out.println(isPostExist());
        //!-- end asset ------!
        Thread.sleep(7000);
    }

    @SneakyThrows
    public void deleteLastPost() {
        driver.get("https://www.pinterest.ru/");
        {
            WebElement element = driver.findElement(By.cssSelector(".Jea > svg"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".Jea > svg")).click();
        Thread.sleep(2000);
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);
        {
            WebElement element = driver.findElement(By.cssSelector(".xuA > .zI7 > .RCK > .tBJ"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        Thread.sleep(2000);
        {
            WebElement element = driver.findElement(By.cssSelector(".xuA > .gjz > .sLG > .tBJ"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".NSs path")).click();
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[2]/div/form/div/div[9]/div/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[3]/div/div/div[2]/button")).click();
    }

    @SneakyThrows
    public boolean isPostExist() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        driver.get("https://www.pinterest.ru/sport_register/_saved/");
        Thread.sleep(4000);
        log.info("Trying to find POST");
        // ?? 2???? ???????????? ?????? ???????????? ?????????????? ??????????????
        short i = 2;
        while (i < 6) {
            log.info("i = " + i);
            By divWithText = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div[3]/div/div[2]/div/div[1]/div/div/div/div["+i+"]/div/a/div/div/div/div[2]/div[1]/h2");

            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(divWithText));

            String str = driver.findElement(divWithText).getText();
            log.info(str);
            i++;
            Thread.sleep(500);
            if (str.contains(post.getName())) return true;

        }
        return false;
    }
}
