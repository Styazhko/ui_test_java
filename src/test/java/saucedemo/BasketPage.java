package saucedemo;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@id='checkout']")
    private WebElement chekoutButton;

    public BasketPage() {
        PageFactory.initElements(driver, this);
    }

    //нажимаем кнопку CHECKOUT
    public ChekoutPage chekout() {
        chekoutButton.click();
        return new ChekoutPage();
    }

}