package Class_Files;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='eGXlor pk3Guc']")
    private List<WebElement> cartItemCount;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateCartItemCount(int expectedCount) {
        int countText = cartItemCount.size();
        if (countText!=expectedCount) {
            throw new AssertionError("Cart count mismatch: Expected " + expectedCount + ", but got " + countText);
        }
    }
}
