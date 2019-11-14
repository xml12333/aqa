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
    public  static WebDriverWait wait;

    String loginEmail = "xml12333@gmail.com";
    String createAccountContent = "CREATE AN ACCOUNT";
    String errorMessage= "There are 2 errors";

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
    public void SignIntoAccountTest()  {

        pageTesting
                .openApplication();
//                .goToSignInPage()
//                .enterRegistrationEmail(loginEmail)
//                .goToRegistrationPage();
//
//        Assert.assertEquals( createAccountContent, pageTesting.getCreateAccountContentValue());


    }

//    @Test
//    public void CreateAccountTest(){
//        SignIntoAccountTest();
//        pageTesting
//                .setFirstName("Nik")
//                .setLastName("Nik")
//                .enterPassword("123444")
//                .setAddrFirstName("NikF")
//                .setAddrLastName("NikL")
//                .setAddress("Some str.")
//                .setCity("Kiev")
//                .setCode("124")
//                .setMobilePhone("05012345678")
//                .setAlias("Some str.")
//                .registerAccount();
//
//        Assert.assertEquals( errorMessage, pageTesting.getCreateAccountErrorMessage());
//
//    }

    public static void main(String[] args) {

    }
}
