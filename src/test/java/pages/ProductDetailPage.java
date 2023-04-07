package pages;

import org.openqa.selenium.By;

public class ProductDetailPage extends BaseMethods {

    private final By ADD_CART_BUTTON = By.xpath("//span[.='Add to cart']/span");

    public void clickAddCart() throws InterruptedException {
        Thread.sleep(2000);
        click(ADD_CART_BUTTON);
    }
}
