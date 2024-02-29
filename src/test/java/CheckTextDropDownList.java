import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class CheckTextDropDownList {
    private static final By FIRST_DROPDOWN_ELEMENT = By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div[1]/div[1]/div"); //локатор для первого элемента
    private static final By FIRST_DROPDOWN_TEXT = By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div[1]/div[2]/p"); //локатор для текста первого элемента после клика
    private static final By SECOND_DROPDOWN_ELEMENT = By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div[2]/div[1]/div"); //локатор для второго элемента
    private static final By SECOND_DROPDOWN_TEXT = By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div[2]/div[2]/p"); //локатор для текста второго элемента после клика
    private WebDriver driver; //объявление переменной driver типа WebDriver
    private String expectedFirstText;
    private String expectedSecondText;

    public CheckTextDropDownList(String expectedFirstText, String expectedSecondText) {
        this.expectedFirstText = expectedFirstText;
        this.expectedSecondText = expectedSecondText;
    }

    @Before
    public void setUp() {
        boolean useFirefox = true; //поменять драйвер на мозилу - указать значение на false
        driver = getWebDriver(useFirefox);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public WebDriver getWebDriver (boolean useFirefox){
        WebDriver driver;
        if (useFirefox) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<String[]> data() {
        return Arrays.asList(new String[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}
        });
    }

    @Test
    public void testDropDownListText() {
        clickDropDownElement(FIRST_DROPDOWN_ELEMENT);
        String firstDropdownText = getDropdownText(FIRST_DROPDOWN_TEXT);
        verifyDropdownText(firstDropdownText, expectedFirstText);

        clickDropDownElement(SECOND_DROPDOWN_ELEMENT);
        String secondDropdownText = getDropdownText(SECOND_DROPDOWN_TEXT);
        verifyDropdownText(secondDropdownText, expectedSecondText);
    }

    public void clickDropDownElement(By elementLocator) {
        WebElement element = driver.findElement(elementLocator); //найти элемент по локатору
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //скролл до элемента
        element.click(); //клик по элементу
    }

    public String getDropdownText(By textLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Устанавливаем ожидание в 10 секунд
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
        return driver.findElement(textLocator).getText();
    }
    public void verifyDropdownText(String actualText, String expectedText) {
        Assert.assertEquals("Текст во втором выпадающем списке не соответствует ожидаемому.", expectedText, actualText);
    }

}