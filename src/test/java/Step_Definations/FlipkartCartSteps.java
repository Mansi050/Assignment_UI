package Step_Definations;

import Class_Files.HomePage;
import Class_Files.SearchPage;
import Class_Files.CartPage;

import io.cucumber.java.en.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartCartSteps {
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    CartPage cartPage;

    @Given("I open the Flipkart website")
    public void i_open_the_flipkart_website() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        cartPage = new CartPage(driver);
        homePage.closeLoginPopup();
    }

    @When("I search for {string}")
    public void i_search_for(String searchTerm) {
        searchPage.enterSearchTerm(searchTerm);
        searchPage.submitSearch();
    }

    @Then("I add the first two items to the cart")
    public void i_add_the_first_two_items_to_the_cart() {
        searchPage.addFirstTwoItemsToCart();
    }

    @Then("I validate the cart contains {int} items")
    public void i_validate_the_cart_contains_items(int itemCount) {
        cartPage.validateCartItemCount(itemCount);
        driver.quit();
    }
}
