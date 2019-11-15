package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    private static final By searchField = By.xpath("//input[@id='search_query_top']");
    private static final By searchButton = By.xpath("//button[@name='submit_search']");
    private static final By listButton = By.xpath("//li[@id='list']/a/i");
    private static final By addToCartButton = By.xpath("//span[contains(.,'Add to cart')]");

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


}
