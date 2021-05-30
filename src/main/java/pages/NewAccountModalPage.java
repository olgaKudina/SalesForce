package pages;
import elements.DropDown;
import elements.Input;
import elements.InputAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class NewAccountModalPage extends BasePage {
    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }
    private static String URL = "https://bnc2.lightning.force.com/lightning/o/Account/new";

    public void  openPage(){
        driver.get(URL);
    }
    public void create(String accountName, String website, String option, String phone, String industry, String description,
                       String billingStreet, String shippingStreet){
        new Input(driver, "Account Name").writeText(accountName);
        new Input(driver, "Website").writeText(website);
        new DropDown(driver, "Type").select(option);
        new Input(driver, "Phone").writeText(phone);
        new DropDown(driver,"Industry").select(industry);
        new InputAddress(driver, "Description").writeAddress(description);
        new InputAddress(driver, "Billing Street").writeAddress(billingStreet);
        new InputAddress(driver, "Shipping Street").writeAddress(shippingStreet);
    }
    public void saveAccount(){
        driver.findElement(By.xpath("//*[text()='Save']")).click();
    }
    public boolean isAccountCreation(){
       return driver.findElement(By.xpath("//span[contains(text(),'FirstAccount')]")).isDisplayed();
    }
}
