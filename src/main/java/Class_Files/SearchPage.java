package Class_Files;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchPage {
    WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='cPHDOP col-12-12']")
    private List<WebElement> productLinks;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchTerm(String term) {
        searchBox.sendKeys(term);
    }

    public void submitSearch() {
        searchBox.submit();
    }

    public void addFirstTwoItemsToCart() {
        String originalTab = driver.getWindowHandle(); // Store the original tab handle
        int addToCartCount = 0;
        int i = 2;
        while(addToCartCount<2){
            productLinks.get(i).click(); // Open the product in a new tab

            // Switch to the newly opened tab
            String newTab = null;
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(originalTab)) {
                    newTab = handle;
                    driver.switchTo().window(handle);
                    break;
                }
            }

            if (newTab == null) {
                System.out.println("New tab not found for product " + i);
                return; // Stop further execution if tab switching fails
            }

            try {
                // Wait for the "Add to Cart" button to be visible and clickable
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to cart')]")));
                if (addToCartButton.isEnabled()) {
                    addToCartButton.click();
                    addToCartCount++;
                    System.out.println("Item added to the cart at index: " + (i - 2));
                } else {
                    System.out.println("Add to Cart button is disabled for product at index: " + (i - 2));
                }
            } catch (Exception e) {
                System.out.println("Failed to add item to the cart: " + e.getMessage());
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted while waiting: " + e.getMessage());
            }
            
            if (i == 2) {
                i++;
                driver.close();
                driver.switchTo().window(originalTab);
            }

            
        }
    }

}
