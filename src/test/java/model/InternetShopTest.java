package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InternetShopTest {
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final String SECTION = "Mēbeles";
    private final By MENU_ITEM = By.xpath(".//li[contains(@class, 'submenu-lvl1__list-item--has-child')]");
    private final By MENU = By.xpath("//div[contains(@class, 'submenu-lvl1--index')]");
    @Test
    public void productPresenceInCartCheck(){
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.1a.lv");

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        //Find Element
        WebElement acceptCookiesBtn = browser.findElement(ACCEPT_COOKIES_BTN);

        //Click on this element
        acceptCookiesBtn.click();

        //Find necessary section (Mēbeles) AND Click on it
        WebElement menuBlock = browser.findElement(MENU);
        List<WebElement> items = menuBlock.findElements(MENU_ITEM);     // создали лист WebElement-ов и назвали его items

        boolean isSectionFound = false;
        for (WebElement we : items) {                    // для каждого WebElement-а (которое обозвали we) из списка menuItems выполняем то, что в {} скобках
            if (we.getText().equals(SECTION)) {          // ЕСЛИ (if) we содержит текст (getText()), и этот текст равен (.equals) тому, который я указала в локаторе выше(стринг SECTION)
                wait.until(ExpectedConditions.elementToBeClickable(we));
                isSectionFound = true;
                we.click();                              // то кликаем ( click() ) по этому элементу
                break;                                   // команда, чтоб перестать ходить по списку после нахождения
            }
        }

        Assertions.assertTrue(isSectionFound, "Section Not Found");

    }
}
