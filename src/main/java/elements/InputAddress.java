package elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class InputAddress {
    WebDriver driver;
    String data;
    private static final String INPUTADDRESS_XPATH = "//span[contains(text(),'%s')]/ancestor::div[contains(@class,'uiInput')]//textarea";
    public InputAddress(WebDriver driver, String data) {
        this.driver = driver;
        this.data = data; }
    public void writeAddress(String text){
        driver.findElement(By.xpath(String.format(INPUTADDRESS_XPATH, data))).sendKeys(text); }
}
