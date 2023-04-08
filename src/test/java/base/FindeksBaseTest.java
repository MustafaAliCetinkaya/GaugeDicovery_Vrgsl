package base;

import com.thoughtworks.gauge.AfterSuite;
import helper.ElementHelper;
import helper.StoreHelper;
import model.ElementInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FindeksBaseTest extends BaseTest{
    public static String oldTab;
    static ArrayList<String> newTab;

    public WebElement findElement(String key){
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 40);
        WebElement webElement = webDriverWait
                .until(ExpectedConditions.elementToBeClickable(infoParam));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
        return webElement;
    }

    public List<WebElement> findElements(String key){
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        return driver.findElements(infoParam);
    }

    public void clickElement(String key){

        findElement(key).click();
    }

    public void hoverElement(String key) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(key)).build().perform();
    }

    public void assertElementText(String key, String expectedText){
        String actualText = driver.findElement(By.id("purchasePopupHeader")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public static void setNewTab(ArrayList<String> newTab) {
        FindeksBaseTest.newTab = newTab;
    }

    public static ArrayList<String> getNewTab() {
        return newTab;
    }

    public static String getOldTab() {
        return oldTab;
    }
}