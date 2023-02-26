package saucedemo;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChekoutPage extends BaseSeleniumPage {

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    private WebElement successMessage;

    public ChekoutPage() {
        PageFactory.initElements(driver, this);
    }

    public ChekoutPage fill_fields(String firs_name, String last_name, String postal_code) {
        firstName.sendKeys(firs_name);
        lastName.sendKeys(last_name);
        postalCode.sendKeys(postal_code);
        continueButton.click();
        return this;
    }

    //нажимаем кнопку FINISH
    public ChekoutPage finish_click() {
        finishButton.click();
        return this;
    }

    //получаем сообщение со страницы
    public String get_success_message() {
        return successMessage.getText();
    }

    //получаем URL текущей страницы
    public String get_url() {
        String strUrl = driver.getCurrentUrl();
        return strUrl;
    }

}