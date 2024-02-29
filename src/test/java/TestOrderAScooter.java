import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOrderAScooter {
    private WebDriver driver;

    @Before
    public void setUp() {
        boolean useFirefox = true; //поменять драйвер на мозилу - указать значение на false
        driver = getWebDriver(useFirefox);
        driver.get("https://qa-scooter.praktikum-services.ru/");
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

    @Test
    public void testOrderWithValidData() {
        OrderAScooter objOrderAScooter = new OrderAScooter(driver);
        // Ввод корректных данных для заказа
        String name = "Имя";
        String surname = "Фамилия";
        String address = "Адресс, 1";
        int metro = 5;
        String phone = "79999999999";
        int daysToAdd = 1;
        String option = "сутки";
        boolean checkbox1 = true;
        boolean checkbox2 = true;
        String commentText = "Комментарий";
        By buttonLocator = By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/button[1]");
        objOrderAScooter.theScreenForWhomIsTheScooter(name, surname, address, phone, daysToAdd, option, checkbox1, checkbox2, commentText, buttonLocator, metro);
    }

    @Test
    public void testOrderWithInvalidData() {
        OrderAScooter objOrderAScooter = new OrderAScooter(driver);
        // Ввод некорректных данных для заказа
        String name = "Карлик";
        String surname = "Карликов";
        String address = "Адресс, 350";
        int metro = 100;
        String phone = "79666666666";
        int daysToAdd = 3;
        String option = "семеро суток";
        boolean checkbox1 = true;
        boolean checkbox2 = false;
        String commentText = "";
        By buttonLocator = By.xpath("/html/body/div/div/div[1]/div[4]/div[2]/div[5]/button");
        objOrderAScooter.theScreenForWhomIsTheScooter(name, surname, address, phone, daysToAdd, option, checkbox1, checkbox2, commentText, buttonLocator, metro);
    }
}