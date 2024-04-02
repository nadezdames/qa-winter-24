package pageobject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.BaseFunc;

import java.util.List;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final String SECTION = "Mēbeles";
    private final By MENU_ITEM = By.xpath(".//li[contains(@class, 'submenu-lvl1__list-item--has-child')]");
    private final By MENU = By.xpath("//div[contains(@class, 'submenu-lvl1--index')]");
    private final By REGISTRATION_BTN = By.xpath(".//div[@class='user-block__title']");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_COOKIES_BTN);
    }

    public void selectMenuItem(String menuItemName) {
        WebElement menuBlock = baseFunc.findElement(MENU);
        List<WebElement> items = menuBlock.findElements(MENU_ITEM);     // refactor later

        boolean isSectionFound = false;
        for (WebElement we : items) {                    // для каждого WebElement-а (которое обозвали we) из списка menuItems выполняем то, что в {} скобках
            if (we.getText().equals(menuItemName)) {          // ЕСЛИ (if) we содержит текст (getText()), и этот текст равен (.equals) тому, который я указала в локаторе выше(стринг SECTION)
                isSectionFound = true;
                we.click();                              // то кликаем ( click() ) по этому элементу
                break;                                   // команда, чтоб перестать ходить по списку после нахождения
            }
        }

        Assertions.assertTrue(isSectionFound, "Can not find menu item " + menuItemName);
    }

    public void openLoginPage() {
        baseFunc.click(REGISTRATION_BTN);
    }
}
