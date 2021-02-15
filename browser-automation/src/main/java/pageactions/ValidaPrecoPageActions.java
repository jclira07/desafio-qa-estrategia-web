package pageactions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.ValidaPrecoPageObjects;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ValidaPrecoPageActions
{
    ValidaPrecoPageObjects pageObjects;

    WebDriver driver;
    WebDriverWait wait;

    public ValidaPrecoPageActions(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
        pageObjects = new ValidaPrecoPageObjects(driver, new WebDriverWait(driver, 20));
    }

    public void denyNotificationPopup()
    {
        pageObjects.getButtonDenyNotifications().click();
    }

    public void openPorProfessor()
    {
        pageObjects.getButtonPorProfessor().click();
    }

    public void filterBy(String inputFilter) throws Exception
    {
        TimeUnit.SECONDS.sleep(3);
        pageObjects.getFilterBy().sendKeys(inputFilter);
        TimeUnit.SECONDS.sleep(3);

        //click on the result
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), '" + inputFilter + "')]")))).click();
    }

    public void validateCoursePrice() throws Exception
    {
        TimeUnit.SECONDS.sleep(3);
        String priceInsideDetails;
        String priceTextOnTheList;
        String realPriceCalculed;
        int i = 0;

        List<WebElement> priceList = pageObjects.getPriceOfTheCourseOnTheList();

        for (WebElement w : priceList)
        {
            priceTextOnTheList = wait.until(ExpectedConditions.visibilityOf(w)).getText();
            realPriceCalculed = realPriceCalculation(priceTextOnTheList);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", w);

            String url = pageObjects.getButtonDetailsOnTheList().get(i).getAttribute("href");

            ((JavascriptExecutor) driver).executeScript("window.open()");

            Set<String> tabs = driver.getWindowHandles();
            driver.switchTo().window(tabs.toArray()[1].toString());

            driver.get(url);

            try{
                priceInsideDetails = pageObjects.getPriceOfTheDetails().getText();
                priceComparisonLog(realPriceCalculed, priceInsideDetails);
            }catch(Exception e)
            {
                System.out.println("Preço não encontrado no link: " + url);
            }

            i = i + 1;

            driver.close();
            driver.switchTo().window(tabs.toArray()[0].toString());
        }
    }

    public String realPriceCalculation(String priceText)
    {
        String realPrice;
        if (Objects.equals(priceText.substring(0, 1), "c"))
        {
            String beforeCalc = priceText.substring(24, priceText.length());
            beforeCalc = beforeCalc.replace(",", ".");
            float calculedPrice = Float.parseFloat(beforeCalc) * 12;

            Locale ptBr = new Locale("pt", "BR");

            realPrice = NumberFormat.getCurrencyInstance(ptBr).format(calculedPrice);
        }
        else
        {
            realPrice = priceText;
        }
        return realPrice;
    }

    public void priceComparisonLog(String priceBefore, String priceDetails) throws Exception {
        //changing nbsp to a true space
        if (priceDetails.equals(priceBefore.replace("\u00a0"," ")))
        {
            System.out.println(priceBefore + " é igual a " + priceDetails);
        }
        else
        {
            System.out.println(priceBefore + " é diferente de " + priceDetails);
        }
    }
}
