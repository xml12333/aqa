import site.PageTesting;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Main {
    public static WebDriver driver;

    String searchString = "Blouse";
    String currency = "$";
    String totalProductsInCart= "54.00";
    String totalProductsShipingInCart= "2.00";
    String totalInCart= "56.00";
    String taxInCart= "0.00";
    String bigTotalInCart= "56.00";
    String emptyCart = "Your shopping cart is empty.";
    static PageTesting pageTesting;

    @BeforeClass
    public static void setupClass() {

        System.setProperty("webdriver.chrome.driver","D:\\temp\\chromedriver_78\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        pageTesting = new PageTesting(driver);

    }

    @Test
    public void MakeSearch()  {

        pageTesting
                .openApplication()
                .enterSearchString(searchString)
                .goSearchPage();

    }

    @Test
    public void AddAndCheckCart(){
        MakeSearch();
        pageTesting
                 .chengeViewToList()
                .addToCart()
                .proceedToCheckOut()
                .addCountIncheckOut();

        Assert.assertEquals( currency+totalProductsInCart, pageTesting.getTotalProductsInCart(currency+totalProductsInCart));
        Assert.assertEquals( currency+totalProductsShipingInCart, pageTesting.getTotalProductsShipingInCart());
        Assert.assertEquals( currency+totalInCart, pageTesting.getTotalInCart());
        Assert.assertEquals( currency+taxInCart, pageTesting.getTaxInCart());
        Assert.assertEquals( currency+bigTotalInCart, pageTesting.getBigTotalInCart());
//
    }

    @Test
    public void DeleteAndCheckCart(){
        AddAndCheckCart();
        pageTesting
                .deleteFromCart();
        Assert.assertEquals( emptyCart, pageTesting.checkCart(emptyCart));
    }

    public static void main(String[] args) {

    }
}
