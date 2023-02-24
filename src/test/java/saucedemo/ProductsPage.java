package saucedemo;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseSeleniumPage {

    @FindBy(css = "button[name=add-to-cart-sauce-labs-backpack]")
    private WebElement addButton;

    @FindBy(css = "a[class=shopping_cart_link]")
    private WebElement basketButton;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    //добавляем первый продукт и переходим в корзину
    public BasketPage add_product() {
        addButton.click();
        basketButton.click();
        return new BasketPage();
    }

}