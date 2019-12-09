import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import site.FieldClassBuilder;
import site.MainPage;

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
//        pageTesting = new site.MainPage(fieldObj);

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
