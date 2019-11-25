import org.junit.AfterClass;
import org.openqa.selenium.By;
import site.FieldClassBuilder;
import site.MainPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static WebDriver driver;

    static MainPage pageTesting;

    @BeforeClass
    public static void setupClass() {

        FieldClassBuilder fieldObj = FieldClassBuilder.newBuilder()
                .setPathToChromeWebDriver("D:\\temp\\chromedriver_78\\chromedriver.exe")
                .setUrl("https://rozetka.com.ua/")
                .setSearchField(By.xpath("//input[@name='search']"))
                .setSearchButton(By.xpath("//button[@type='submit']"))
                .setListButton(By.xpath("//div[@id='filter_viewlist']/a"))
                .setAddToCartButton(By.xpath("//button[@name='topurchases']"))
                .build();
//        pageTesting = new MainPage(fieldObj);

    }

    @Test
    public void MakeSearch()  {

        pageTesting
                .openApplication()
                .enterSearchString()
                .goSearchPage();

    }

    @AfterClass


    public static void main(String[] args) {

    }
}
