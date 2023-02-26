package saucedemo;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class LoginPage extends BaseSeleniumPage {

    @FindBy(id = "user-name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//h3")
    private WebElement errorMessage;

    public LoginPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    //авторизируемся
    public ProductsPage auth_user(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return new ProductsPage();
    }

    //получаем сообщение со страницы
    public String get_error_message() {
        String error = errorMessage.getText();
        return error;
    }

}