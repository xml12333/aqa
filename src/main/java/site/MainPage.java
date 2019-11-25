package site;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;


public class MainPage {

    static MainPage mainPageTesting;
    private WebDriver driver;
    private WebDriverWait wait;
    private FieldClassBuilder field;

    public MainPage() {
    }

    public MainPage setInitialField(FieldClassBuilder field){
        this.driver = field.driver;
        this.wait = field.wait;
        this.field = field;
        return this;
    }

    public MainPage openApplication() {
        driver.get(field.getUrl());
        return this;
    }

    public MainPage enterSearchString() {
        driver.findElement(field.getSearchField()).sendKeys(field.getSearchString());
        return this;
    }
    public MainPage goSearchPage() {
        driver.findElement(field.getSearchButton()).click();
        return this;
    }
    public MainPage chengeViewToList() {
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
                .setSearchString("dell")
                .build();
        mainPageTesting = new MainPage();
        mainPageTesting = mainPageTesting.setInitialField(fieldObj);

    }
    @Test
    public void MakeSearch()  {

        mainPageTesting
                .openApplication()
                .enterSearchString()
                .goSearchPage();

    }

    @Test
    public void MakeListView()  {
        MakeSearch();
        mainPageTesting
                .chengeViewToList();

    }

    @AfterClass
    public static void closeBrowser(){
        mainPageTesting.driver.quit();
    }
}
