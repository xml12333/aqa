package site;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.BeforeClass;
import ru.stqa.selenium.factory.WebDriverPool;

public class AddToCart {
    static AddToCart addToCartPageTesting;
    private WebDriver driver;
    private WebDriverWait wait;
    private FieldClassBuilder field;

    public AddToCart setInitialField(FieldClassBuilder field){
        this.driver = field.driver;
        this.wait = field.wait;
        this.field = field;
        return this;
    }
    public AddToCart openApplication() {
        driver.get(field.getUrl());
        return this;
    }

    public AddToCart enterSearchString() {
        driver.findElement(field.getSearchField()).sendKeys(field.getSearchString());
        return this;
    }
    public AddToCart goSearchPage() {
        driver.findElement(field.getSearchButton()).click();
        return this;
    }
    public AddToCart chengeViewToList() {
        driver.findElement(field.getListButton()).click();
        return this;
    }

@BeforeClass
public static void setupClass() {
        FieldClassBuilder fieldObj = FieldClassBuilder.newBuilder()
        .setDriverAndWait("D:\\temp\\chromedriver_78\\chromedriver.exe")
        .setUrl("https://rozetka.com.ua/")
        .setSearchField(By.xpath("//input[@name='search']"))
        .setSearchButton(By.xpath("//button[contains(.,'Найти')]"))
        .setListButton(By.xpath("//div[@id='filter_viewlist']/a"))
        .setAddToCartButton(By.xpath("//button[@name='topurchases']"))
        .setSearchString("XPS 13 9360")
        .build();
    addToCartPageTesting = new AddToCart();
    addToCartPageTesting = addToCartPageTesting.setInitialField(fieldObj);

        }
    @Test
    public void MakeSearch()  {

        addToCartPageTesting
                .openApplication()
                .enterSearchString()
                .goSearchPage();

    }

    @Test
    public void MakeListView()  {
        MakeSearch();
        addToCartPageTesting
                .chengeViewToList();

    }

    @AfterClass
    public static void closeBrowser(){
        addToCartPageTesting.driver.quit();
    }
 }
