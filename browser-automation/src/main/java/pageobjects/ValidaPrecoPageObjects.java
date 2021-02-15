package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ValidaPrecoPageObjects
{
    WebDriver driver;
    WebDriverWait wait;

    //Page elements
    @FindBy(id = "onesignal-slidedown-cancel-button")
    protected WebElement buttonDenyNotifications;
    public WebElement getButtonDenyNotifications() {
        return wait.until(ExpectedConditions.visibilityOf(buttonDenyNotifications));
    }

    @FindBy(xpath = "/html/body/header/nav/div/div/div[1]/a[3]")
    protected WebElement buttonPorProfessor;
    public WebElement getButtonPorProfessor() {
        return wait.until(ExpectedConditions.visibilityOf(buttonPorProfessor));
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/section[1]/header/div/div/form/input")
    protected WebElement filterBy;
    public WebElement getFilterBy() {
        return wait.until(ExpectedConditions.visibilityOf(filterBy));
    }

    //list
    @FindBy(className = "card-prod-details")
    protected List<WebElement> buttonDetailsOnTheList;
    public List<WebElement> getButtonDetailsOnTheList() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(buttonDetailsOnTheList));
    }

    @FindBy(className = "card-prod-price")
    protected List<WebElement> priceOfTheCourseOnTheList;
    public List<WebElement> getPriceOfTheCourseOnTheList() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(priceOfTheCourseOnTheList));
    }

    @FindBy(className = "value")
    protected WebElement priceOfTheDetails;
    public WebElement getPriceOfTheDetails() {
        return wait.until(ExpectedConditions.visibilityOf(priceOfTheDetails));
    }

    public ValidaPrecoPageObjects(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
