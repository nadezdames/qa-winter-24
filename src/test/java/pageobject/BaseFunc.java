package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFunc {
    private WebDriver browser;
    private WebDriverWait wait;

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
}
