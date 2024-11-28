package Class_Files;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closeLoginPopup() {
        try{
              List<WebElement> popupButtons = driver.findElements(By.xpath("//span[@role='button' and contains(text(),'✕')]"));
        if (!popupButtons.isEmpty() && popupButtons.get(0).isDisplayed()) {
            popupButtons.get(0).click();
            System.out.println("Login popup closed.");
        } else {
            System.out.println("Login popup not found.");
        }
    } catch (Exception e) {
        System.out.println("An error occurred while closing the popup: " + e.getMessage());
    }
    }
}
