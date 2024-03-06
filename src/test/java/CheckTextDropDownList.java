import POM.HomePageAScooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckTextDropDownList {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver; //объявление переменной driver типа WebDriver
    private String idQuestionText; //индекс элемента ддл
    private String questionText; //содержание текста вопроса
    private String expectedAnswerText; //содержание текста ответа

    public CheckTextDropDownList(String idQuestionText, String questionText, String expectedAnswerText) {
        this.idQuestionText = idQuestionText;
        this.questionText = questionText;
        this.expectedAnswerText = expectedAnswerText;
    }

    @Before
    public void setUp() {
        boolean useFirefox = true; //поменять драйвер на мозилу - указать значение на false
        driver = getWebDriver(useFirefox);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver(boolean useFirefox) {
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
                {"0","Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"1","Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"2","Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"3","Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"4","Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"5","Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"6","Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"7","Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }

    @Test
    public void testDropDownListText() {
        // HomePageAScooter objHomePageAScooter = new HomePageAScooter(driver);
        String actualText = new HomePageAScooter(driver)
                .scrollAndClickElementDropDownList(questionText) //кликаем на элемент ддл
                .getAndVerifyTextDropDownList(idQuestionText);
        assertEquals("Текст не соответствует ожидаемому.", expectedAnswerText, actualText);

    }
}