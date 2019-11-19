package site;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;


public class PageTesting {


    private WebDriver driver;
    private WebDriverWait wait;

    private static final String url = "http://automationpractice.com/index.php";
    private static final By registerEmail = By.id("email_create");
    private static final By signInButton = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private static final By createAccountButton = By.cssSelector("#SubmitCreate");
    private static final By registrationForm = By.cssSelector("#account-creation_form");
    private static final By createAccountContent = By.xpath("//h3[text()='Create an account']");

    private static final By firstName = By.id("customer_firstname");
    private static final By lastName = By.id("customer_lastname");
    private static final By email = By.id("email");
    private static final By password = By.id("passwd");
    private static final By addressFirstName = By.id("firstname");
    private static final By addressLastName = By.id("lastname");
    private static final By address = By.id("address1");
    private static final By city = By.id("city");
    private static final By code = By.id("postcode");
    private static final By mobilePhone = By.id("phone_mobile");
    private static final By alias = By.id("alias");
    private static final By registerButton = By.id("submitAccount");
    private static final By errorMessage = By.xpath("//div[contains(@class,'alert')]/p");


    //home task 11
    private static final By searchField = By.xpath("//input[@id='search_query_top']");
    private static final By searchButton = By.xpath("//button[@name='submit_search']");
    private static final By listButton = By.xpath("//li[@id='list']/a/i");
    private static final By addToCartButton = By.xpath("//span[contains(.,'Add to cart')]");
    private static final By proceedToCheckOutButton = By.xpath("//div[4]/a/span");
    private static final By addCountToCheckOutButton = By.xpath("//*[@id=\"cart_quantity_up_2_7_0_0\"]");
    private static final By totalProductsInCartString = By.xpath("//td[@id='total_product']");
    private static final By totalProductsShipingInCartString = By.xpath("//td[@id='total_shipping']");
    private static final By totalInCartString = By.xpath("//td[@id='total_price_without_tax']");
    private static final By taxInCartString = By.xpath("//td[@id='total_tax']");
    private static final By bigTotalInCartString = By.xpath("//span[@id='total_price']");
    private static final By trashButton = By.xpath("//a[@id=\'2_7_0_0\']/i");
    private static final By cartIsEmpty = By.xpath("//div[3]/div/p");

    public PageTesting(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }


    public PageTesting setFirstName(String name) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(name);
        return this;
    }

    public PageTesting setLastName(String nameLast) {
        driver.findElement(lastName).sendKeys(nameLast);
        return this;
    }

    public PageTesting enterEmail(String accEmail) {
        driver.findElement(email).sendKeys(accEmail);
        return this;
    }


    public PageTesting enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
        return this;
    }

    public PageTesting setAddrFirstName(String name) {
        driver.findElement(addressFirstName).sendKeys(name);
        return this;
    }

    public PageTesting setAddrLastName(String nameLast) {
        driver.findElement(addressLastName).sendKeys(nameLast);
        return this;
    }


    public PageTesting setAddress(String addr) {
        driver.findElement(address).sendKeys(addr);
        return this;
    }

    public PageTesting setCity(String cityname) {
        driver.findElement(city).sendKeys(cityname);
        return this;
    }

    public PageTesting setCode(String postCode) {
        driver.findElement(code).sendKeys(postCode);
        return this;
    }

    public PageTesting setMobilePhone(String phone) {
        driver.findElement(mobilePhone).sendKeys(phone);
        return this;
    }


    public PageTesting setAlias(String Aladdr) {
        driver.findElement(alias).sendKeys(Aladdr);
        return this;
    }

    public PageTesting registerAccount() {
        driver.findElement(registerButton).click();
        return this;
    }

    public String getCreateAccountErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public PageTesting openApplication() {
        driver.get(url);
        return this;
    }


    public PageTesting goToSignInPage() {
        driver.findElement(signInButton).click();
        return this;
    }

    public PageTesting enterRegistrationEmail(String email) {
        driver.findElement(registerEmail).sendKeys(email);
        return this;
    }


    public PageTesting goToRegistrationPage() {
        driver.findElement(createAccountButton).click();
        return this;
    }

    public String getCreateAccountContentValue() {
        return driver.findElement(createAccountContent).getText();
    }

    //for home task 11
    public PageTesting enterSearchString(String searchString) {
        driver.findElement(searchField).sendKeys(searchString);
        return this;
    }
    public PageTesting goSearchPage() {
        driver.findElement(searchButton).click();
        return this;
    }
    public PageTesting chengeViewToList() {
        driver.findElement(listButton).click();
        return this;
    }
    public PageTesting addToCart() {
        driver.findElement(addToCartButton).click();
        return this;
    }
    public PageTesting proceedToCheckOut() {
        driver.findElement(proceedToCheckOutButton).click();
        return this;
    }
    public PageTesting addCountIncheckOut() {
        driver.findElement(addCountToCheckOutButton).click();
        return this;
    }

    public String getTotalProductsInCart(String textToCheck) {
        WebElement ourWebElement = driver.findElement(totalProductsInCartString);
        wait.until(ExpectedConditions.textToBePresentInElement(ourWebElement,textToCheck));//find our text or test fails
        return ourWebElement.getText();
    }
    public String getTotalProductsShipingInCart() {
        return driver.findElement(totalProductsShipingInCartString).getText();
    }
    public String getTotalInCart() {
        return driver.findElement(totalInCartString).getText();
    }
    public String getTaxInCart() {
        return driver.findElement(taxInCartString).getText();
    }
    public String getBigTotalInCart() {
        return driver.findElement(bigTotalInCartString).getText();
    }

    public PageTesting deleteFromCart() {
        driver.findElement(trashButton).click();
        return this;
    }
    public String checkCart(String textToCheck) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartIsEmpty));
        return driver.findElement(cartIsEmpty).getText();
    }


}
