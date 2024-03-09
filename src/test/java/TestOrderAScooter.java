import pageobjectmodel.OrderAScooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestOrderAScooter {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/"; //локатор для url стенда
    private WebDriver driver;
    private String buttonLocation;
    private String name; //для значения поля "имя"
    private String surname; //для значения поля "Фамилия"
    private String address; ////для значения поля "Адрес"
    private int metro; //для значения поля "Станция метро"
    private String phone; //для значения поля "Телефон"
    private int daysToAdd; //для значения "Когда привезти самокат"
    private String option; //для значения "Срок аренды"
    private boolean checkboxBlack; //для выбора цвета самоката
    private boolean checkboxGrey; //для выбора цвета самоката
    private String commentText; //для значения поля "Комментарий"
    public TestOrderAScooter(String buttonLocation, String name, String surname, String address, int metro, String phone, int daysToAdd, String option,
                             boolean checkboxBlack, boolean checkboxGrey, String commentText) {
        this.buttonLocation = buttonLocation;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.daysToAdd = daysToAdd;
        this.option = option;
        this.checkboxBlack = checkboxBlack;
        this.checkboxGrey = checkboxGrey;
        this.commentText = commentText;

    }

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

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"header","Имя","Фамилия","Адресс, 1",5,"79999999999",1,"сутки",true,true,"Комментарий"},
                {"middle","Имя","Фамилия","Адресс, 1",5,"79999999999",1,"сутки",true,true,"Комментарий"},
                {"middle","Карлик","Карликов","Адресс, 350",50,"79666666666",3,"семеро суток",true,false,""}
        };
    }

    @Test
    public void testOrderWithValidData() {
        Boolean actual = new OrderAScooter(driver)

                // Ввод данных клиента
                .customerDataForm(buttonLocation,name, surname,address,metro,phone)
                // Ввод данных заказа
                .orderDetails(daysToAdd, option, checkboxBlack, checkboxGrey, commentText)
                //Проверка на наличие окна
                .checkOrderConfirmationWindow();

        assertTrue("Окно Заказ оформлен отсутсвует",actual);
    }
}