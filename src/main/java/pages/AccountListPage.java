package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AccountListPage extends BasePage {
    public AccountListPage(WebDriver driver) {
        super(driver); }
    private static String URL = "https://bnc2.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    private static By TYPE_XPATH = By.xpath("//slot/lightning-formatted-text");
    private static By PHONE_XPATH = By.xpath("//a[@href='tel:+1234567890']");
    private static By WEBSITE_XPATH = By.xpath("//slot/lightning-formatted-url/a");
    private static By BILLING_ADDRESS_XPATH = By.xpath("//div[@class='slds-truncate']");
    public void openPage() {
        driver.get(URL);
    }
    public String getWebsite() {
        return driver.findElement(WEBSITE_XPATH).getText();
    }
    public String getType(){
        return driver.findElement(TYPE_XPATH).getText();
    }
    public String getBillingAddress(){
        return driver.findElement(BILLING_ADDRESS_XPATH).getText();
    }
}
