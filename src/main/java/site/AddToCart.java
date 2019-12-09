package site;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

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



    @DataProvider
    public Object[][] manyPrintString() {
        return new Object[][]{
                {"Test PrintString1 from site.AddToCart class",this.PrintString1()},
                {"Test PrintString2 from site.AddToCart class",this.PrintString2()}
        };
    }
    @Test(dataProvider = "manyPrintString")
    public void TestPrintString(String s1,String s2)  {
        assertEquals(s1,s2);

    }
    public static String PrintString1()  {
        return "Test PrintString1 from site.AddToCart class";

    }
    public static String PrintString2()  {
        return "Test PrintString2 from site.AddToCart class";

    }
    @AfterClass
    public static void closeBrowser(){
        addToCartPageTesting.driver.quit();
    }

 }
