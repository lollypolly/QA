package ru.itlab.qa.helpers;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.itlab.qa.models.AccountData;

public class LoginHelper extends HelperBase{
    private AppManager manager;
    private AccountData data;

    public LoginHelper(AppManager manager, AccountData data) {
        this.manager = manager;
        this.data = data;
        driver = manager.getDriver();
    }

    @SneakyThrows
    public void login() {
        driver.get("https://www.pinterest.ru/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.findElement(By.cssSelector(".Il7 > .tBJ")).click();
        {
            WebElement element = driver.findElement(By.linkText("Условия предоставления услуг"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.id("email")).click();

        driver.findElement(By.id("email")).sendKeys(data.getEmail());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(data.getPassword());
        driver.findElement(By.cssSelector(".red")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".red"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
    }
}
