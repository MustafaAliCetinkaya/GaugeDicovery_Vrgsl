package pages;

import base.BaseTest;
import base.FindeksBaseTest;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import java.util.ArrayList;

public class FindeksStepImplementation extends FindeksBaseTest {

    @Step("<int> saniye bekle")
    public void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("<key> elementine tikla")
    public void clickLogin(String key) {
        clickElement(key);
    }
    @Step("Banka sayfasına git")
    public void goMainPage() {
        driver.get("https://www.teb.com.tr/");
        oldTab = driver.getWindowHandle();
    }

    @Step("<key> elementinin üzerine gel")
    public void hover(String key) {
        hoverElement(key);
    }

    @Step("<key> elementi var mi")
    public void checkElement(String key) {
        try {
            Thread.sleep(3000);
            findElement(key);
        } catch (Exception e) {
            Assert.fail("Element bulunamadı.");
        }
    }

    @Step("Yeni sekmeye gec")
    public void switchToNewTab() {
        setNewTab(new ArrayList<String>(driver.getWindowHandles()));
        getNewTab().remove(getOldTab());
        driver.switchTo().window(getNewTab().get(0));
    }
    @Step("Gecilen sekmeyi kapat")
    public void switchToOldTab() {
        driver.close();
        driver.switchTo().window(getOldTab());
    }
    @Step("<key> elementinde yazan isim ile <text>'i karsilastir")
    public void checkName(String key, String text) {
        assertElementText(key, text);
    }
}