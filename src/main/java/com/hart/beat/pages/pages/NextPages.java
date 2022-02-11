package com.hart.beat.pages.pages;

import com.hart.beat.pages.utils.Constant;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NextPages {

    WebDriver driver;
    public NextPages(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver =driver;
    }
    @FindBy(id="sli_search_1")
    WebElement searchTxtField;

    @FindBy(className = "SearchButton")
   // @FindBy(xpath = "//*[@id=\'newsearch\']/input[4]")
    WebElement searchButton;

    @FindBy(xpath = "//div//div//h1//div")
    WebElement resultString;

    @FindBy(xpath = "//div//div//button[@id=\"onetrust-accept-btn-handler\"]")
    WebElement cookieField;

   @FindBy(xpath = "//*[@id=\'i1\']/section/div[1]/h2/a")
    WebElement selectElement;

   @FindBy(xpath = "//*[@id=\'dk_container_Size-156-696\']/a")
    WebElement chooseSizeDropdown;

   @FindBy(xpath = "//div[@class=\'AddToBag\']//a[text()=\'ADD TO BAG\']")
   WebElement addToBagBtn;

   @FindBy(xpath = "//div[@class=\'ItemCount\']/span")
   WebElement itemCount;

   @FindBy(xpath = "//div[@class=\'bagHeader\']//div")
   WebElement itemAddedMsg;

  @FindBy(xpath = "//*[@id=\'gel-bag-summary\']")
   WebElement clickCart;

    @FindBy(xpath = "//*[@id=\'Style311213\']/section/div[2]/div[1]/h1")
    WebElement validateChooseElement;

    @FindBy(css = "#dk_container_Size-156-696 > div > ul > li:nth-child(3) > a")
    WebElement selectSize;

    //method to accept cookie
    public void clickCookie(){
        cookieField.click();
    }
    //method to enter search string
    public void enterSearchItem(String searchTerm) throws InterruptedException {
        searchTxtField.sendKeys(searchTerm);
        Thread.sleep(2000);
    }
    //method to click search button
    public void clickSearchButton(){
        searchButton.click();
    }
    //method to validate search keyword
    public void validateResultString(String resultStringTerm){
        String resultStringText = resultString.getText();
        Assert.assertEquals(resultStringTerm,resultStringText);
    }
    //method to select the product item from the result page
    public void chooseProduct(String chooseProductTerm) throws InterruptedException {
        Thread.sleep(1000);
        selectElement.click();
        Assert.assertEquals(chooseProductTerm,validateChooseElement.getText());
    }
    //method to choose the size
    public void chooseSize() throws InterruptedException {
        Thread.sleep(2000);
        clickChooseSizeDropdown();
        Thread.sleep(2000);
        selectSize.click();
    }

    public void clickChooseSizeDropdown(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(chooseSizeDropdown));
        chooseSizeDropdown.click();
    }
    public void clickAddToBag(){
        addToBagBtn.click();
    }
    //method to validate added item in the cart
    public void validateItemAddedInCart() throws InterruptedException {
        Thread.sleep(3000);

        Assert.assertEquals(Constant.ADDED_ITEM_COUNT,itemCount.getText());
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(clickCart));

        Thread.sleep(3000);
        clickCart.click();

        Thread.sleep(3000);
        Assert.assertEquals(Constant.ITEM_ADDED_MESSAGE,itemAddedMsg.getText());
    }
}
