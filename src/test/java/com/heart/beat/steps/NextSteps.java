package com.heart.beat.steps;
import com.hart.beat.pages.pages.NextPages;
import com.hart.beat.pages.utils.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;


public class NextSteps {

    WebDriver driver = Utils.getDriver();
    NextPages nextPageObject = new NextPages(driver);

    @Given("^I am on home page \"(.*?)\"$")
    public void i_am_on_home_page(String url) throws InterruptedException {

        driver.get(url);
      //  driver.wait(10);
    }

    @When("^I search for product \"(.*?)\"$")
    public void i_search_for_product(String searchItem) throws InterruptedException {
        nextPageObject.clickCookie();
        Thread.sleep(1000);
        nextPageObject.enterSearchItem(searchItem);
    }

    @When("^I click on search button$")
    public void i_click_on_search_button() throws Throwable {
        Thread.sleep(1000);
        nextPageObject.clickSearchButton();
    }
    @Then("^appropriate page should be displayed with title as \"(.*?)\"$")
    public void appropriate_page_should_be_displayed_with_title_as(String resultString) throws Throwable {
        Thread.sleep(1000);
        nextPageObject.validateResultString(resultString);
    }
    @When("^I choose a product \"(.*?)\"$")
    public void i_choose_a_product(String chooseProduct) throws InterruptedException {
        Thread.sleep(1000);
        nextPageObject.chooseProduct(chooseProduct);
    }

    @When("^I choose size \"(.*?)\"$")
    public void i_choose_size(String sizeElement) throws InterruptedException {
        Thread.sleep(1000);
        nextPageObject.chooseSize();
    }

    @When("^I click add to bag button$")
    public void i_click_add_to_bag_button() {
        nextPageObject.clickAddToBag();
    }

    @Then("^I should see the product \"(.*?)\" in the bag$")
    public void i_should_see_the_product_in_the_bag(String itemAdded) throws Throwable {
        nextPageObject.validateItemAddedInCart();
    }
}

