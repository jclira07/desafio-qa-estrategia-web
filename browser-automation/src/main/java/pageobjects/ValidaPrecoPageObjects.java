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

    @FindBy(xpath = "//a[contains(text(),'Por professor')]")
    protected WebElement buttonPorProfessor;

    @FindBy(xpath = "//input[@placeholder='Filtrar']")
    protected WebElement filterBy;

    @FindBy(className = "card-prod-details")
    protected List<WebElement> buttonDetailsOnTheList;

    @FindBy(className = "card-prod-price")
    protected List<WebElement> priceOfTheCourseOnTheList;

    @FindBy(className = "value")
    protected WebElement priceOfTheDetails;

    //Constructor
    public ValidaPrecoPageObjects(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public WebElement getButtonDenyNotifications() {
        return wait.until(ExpectedConditions.visibilityOf(buttonDenyNotifications));
    }

    public WebElement getButtonPorProfessor() {
        return wait.until(ExpectedConditions.visibilityOf(buttonPorProfessor));
    }
    public WebElement getFilterBy() {
        return wait.until(ExpectedConditions.visibilityOf(filterBy));
    }
    public List<WebElement> getButtonDetailsOnTheList() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(buttonDetailsOnTheList));
    }
    public List<WebElement> getPriceOfTheCourseOnTheList() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(priceOfTheCourseOnTheList));
    }
    public WebElement getPriceOfTheDetails() {
        return wait.until(ExpectedConditions.visibilityOf(priceOfTheDetails));
    }

}
