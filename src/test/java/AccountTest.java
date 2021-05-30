import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountListPage;
import pages.NewAccountModalPage;
import java.util.concurrent.TimeUnit;
public class AccountTest {
    private static final String LOGIN = "tms_qa05_6-ug00@force.com";
    private static final String PASSWORD = "Spring_2021";
    private static final String URL = "https://bnc2.my.salesforce.com";
    @Test
    public void createAccountTest(){
        //driver setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //login
        driver.get(URL);
        driver.findElement(By.id("username")).sendKeys(LOGIN);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("Login")).click();
        //open New account
        NewAccountModalPage newAccountModalPage = new NewAccountModalPage(driver);
        newAccountModalPage.openPage();
        /** New account creation test
        */
        newAccountModalPage.create("FirstAccount", "www.tut.by", "Customer", "+1234567890",
                "Chemicals", "The account is activated.", "Park Lane", "5th avenue");
        newAccountModalPage.saveAccount();
        Assert.assertTrue(newAccountModalPage.isAccountCreation());

        /** Assert on created account fields
         */
        AccountListPage accountListPage = new AccountListPage(driver);
        String website = accountListPage.getWebsite();
        Assert.assertEquals(website,"www.tut.by");
        String type = accountListPage.getType();
        Assert.assertEquals(type, "Customer");
        String billingAddress = accountListPage.getBillingAddress();
        Assert.assertEquals(billingAddress, "Park Lane");
    }
}
