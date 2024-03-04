import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOrderAScooter {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/"; //локатор для url стенда
    private WebDriver driver;

    @Before
    public void setUp() {
        boolean useFirefox = true; //поменять драйвер на мозилу - указать значение на false
        driver = getWebDriver(useFirefox);
        driver.get(URL);
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
    public void firstTestOrderWithValidData() {
        OrderAScooter objOrderAScooter = new OrderAScooter(driver);
        // Ввод корректных данных для заказа
        String name = "Имя";
        String surname = "Фамилия";
        String address = "Адресс, 1";
        int metro = 5;
        String phone = "79999999999";
        int daysToAdd = 1;
        String option = "сутки";
        boolean checkboxBlack = true;
        boolean checkboxGrey = true;
        String commentText = "Комментарий";
        objOrderAScooter.theScreenForWhomIsTheScooter(name, surname, address, phone, daysToAdd, option, checkboxBlack, checkboxGrey, commentText, metro);
    }

    @Test
    public void secondTestOrderWithValidData() {
        OrderAScooter objOrderAScooter = new OrderAScooter(driver);
        // Ввод корректных данных для заказа
        String name = "Карлик";
        String surname = "Карликов";
        String address = "Адресс, 350";
        int metro = 50;
        String phone = "79666666666";
        int daysToAdd = 3;
        String option = "семеро суток";
        boolean checkboxBlack = true;
        boolean checkboxGrey = false;
        String commentText = "";
        objOrderAScooter.theScreenForWhomIsTheScooter(name, surname, address, phone, daysToAdd, option, checkboxBlack, checkboxGrey, commentText, metro);
    }
    @Test
    public void testClickButtonInMiddle() {
        OrderAScooter objOrderAScooter = new OrderAScooter(driver);
        objOrderAScooter.clickButtonOrderInMiddle();

    }
}