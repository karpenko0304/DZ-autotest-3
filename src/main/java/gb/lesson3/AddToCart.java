package gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AddToCart {
    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://petdog.ru/");

        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.xpath("//a[contains(@href, 'https://petdog.ru/veterinarnaya-apteka/')]")).click();
        By authFormLocator = By.xpath("//a[contains(@href, 'https://petdog.ru/veterinarnaya-apteka/')]");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.xpath("//a[contains(text(),'Кардиопрепараты (для сердца)')]")).click();

        webDriver.findElement(By.xpath("//button[@id='button_cart_3009']")).click();

        webDriver.findElement(By.xpath("//div[@class='ty-dropdown-box']")).click();

        new WebDriverWait(webDriver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, 'https://petdog.ru/veterinarnaya-apteka/')]")));
        webDriver.quit();
    }
}

