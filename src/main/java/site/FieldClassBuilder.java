package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FieldClassBuilder {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private String pathToChromeWebDriver;
    private String url;
    private String searchString;
    private By searchField;
    private By searchButton;
    private By listButton;
    private By addToCartButton;

    public FieldClassBuilder() {

    }
    public static Builder newBuilder() {
        return new FieldClassBuilder().new Builder();
    }
    public class Builder {

        public FieldClassBuilder build() {
            return FieldClassBuilder.this;
        }

        public Builder setPathToChromeWebDriver(String pathToChromeWebDriver) {
            FieldClassBuilder.this.pathToChromeWebDriver = pathToChromeWebDriver;
            return this;
        }

        public Builder setUrl(String url) {
            FieldClassBuilder.this.url = url;
            return this;
        }

        public Builder setSearchField(By searchField) {
            FieldClassBuilder.this.searchField = searchField;
            return this;
        }

        public Builder setSearchButton(By searchButton) {
            FieldClassBuilder.this.searchButton = searchButton;
            return this;
        }

        public Builder setListButton(By listButton) {
            FieldClassBuilder.this.listButton = listButton;
            return this;
        }

        public Builder setAddToCartButton(By addToCartButton) {
            FieldClassBuilder.this.addToCartButton = addToCartButton;
            return this;
        }
        public Builder setSearchString(String searchString) {
            FieldClassBuilder.this.searchString = searchString;
            return this;
        }
        public Builder setDriverAndWait(String searchString){
            System.setProperty("webdriver.chrome.driver",searchString);
            FieldClassBuilder.this.driver = new ChromeDriver();
            FieldClassBuilder.this.wait = new WebDriverWait(FieldClassBuilder.this.driver, 5);
            FieldClassBuilder.this.driver.manage().window().maximize();
            FieldClassBuilder.this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.setPathToChromeWebDriver(searchString);
            return this;
        }

        private Builder() {

        }
    }

    public By getSearchField() {
        return searchField;
    }

    public By getSearchButton() {
        return searchButton;
    }

    public By getListButton() {
        return listButton;
    }

    public By getAddToCartButton() {
        return addToCartButton;
    }

    public String getUrl() {
        return url;
    }

    public String getPathToChromeWebDriver() {
        return pathToChromeWebDriver;
    }

    public String getSearchString() {
        return searchString;
    }




}
