package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunc {
    private WebDriver browser;
    private WebDriverWait wait;
    private JavascriptExecutor executor;

    // Конструктор public BaseFunc() {}
    // Конструктор выполняется принудительно в момент создания экземпляра объекта.
    // Конструктор - это метод содержимое которого выполняется в обязательном порядке при создании экземпляра объект
    // Конструктор всегда public. Никогда ничего не возвращает. Называется так же как класс
    // В конструкторе то, что должно быть выполнено ОБЯЗАТЕЛЬНО (например открытие браузерного окна)
    // Конструктор - это метод в классе, в объекте, который подготавливает его к работе
    public BaseFunc() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();

        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        executor = (JavascriptExecutor) browser;
    }

    public void openURL(String url) {
//        //if TRUE
//        if (url.startsWith("http://") || url.startsWith("https://")) {        // logical operators: AND (&&) and OR (||)
//                                                                              // тут пусто - а так не принято! Ниже будет правильный if
//        } else {
//        //if FALSE
//            url = "http://" + url;
//        }

        if (!url.startsWith("http://") && !url.startsWith("https://")) {    // logical operators: AND (&&) and OR (||)
            url = "http://" + url;
        }

        browser.get(url);
    }

    public void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // "Cant's perform click by Selenium"
    public void hardClick(WebElement we) {
        try {
            we.click(); // в try мы указываем, что пытаемся сделать с помощью стандартного selenium
        } catch (ElementClickInterceptedException e) {
//            System.out.println("Cant's perform click by Selenium");
            executor.executeScript("arguments[0].click();", we);
        }
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }


    public void scrollToElement(WebElement we) {
        executor.executeScript("arguments[0].scrollIntoView(true)", we);
        // OR use this JavaScript For Scroll down
        executor.executeScript("window.scrollBy(0, 500);");         // For Scroll UP use "window.scrollBy(0,-250)"

    }

    public void waitForText(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void typeText(By locator, String text) {
        WebElement input = findElement(locator);
        input.clear();
        input.sendKeys(text);
    }

    public void typeTextInCustomField(By locator, String text) {
        WebElement input = findElement(locator);
//        input.click();
        hardClick(input);
//        for (int i = 0; i < input.getAttribute("value").length(); i++) {
//            input.sendKeys(Keys.BACK_SPACE);
//        }
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(text);
    }

    public void pressEnter(By locator) {
        findElement(locator).sendKeys(Keys.ENTER);
    }

}
