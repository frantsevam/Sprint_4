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

@RunWith(Parameterized.class)
public class CheckTextDropDownList {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver; //объявление переменной driver типа WebDriver
    private String expectedFirstText;
    private String expectedSecondText;
    private String expectedThirdText;
    private String expectedFourthText;
    private String expectedFifthText;
    private String expectedSixthText;
    private String expectedSeventhText;
    private String expectedEighthText;
    public CheckTextDropDownList(String expectedFirstText, String expectedSecondText, String expectedThirdText, String expectedFourthText,
                                 String expectedFifthText, String expectedSixthText, String expectedSeventhText, String expectedEighthText) {
        this.expectedFirstText = expectedFirstText;
        this.expectedSecondText = expectedSecondText;
        this.expectedThirdText = expectedThirdText;
        this.expectedFourthText = expectedFourthText;
        this.expectedFifthText = expectedFifthText;
        this.expectedSixthText = expectedSixthText;
        this.expectedSeventhText = expectedSeventhText;
        this.expectedEighthText = expectedEighthText;

    }


    @Before
    public void setUp() {
        boolean useFirefox = true; //поменять драйвер на мозилу - указать значение на false
        driver = getWebDriver(useFirefox);
        driver.get(URL);
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
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }

    @Test
    public void testDropDownListText() {
        HomePageAScooter objHomePageAScooter = new HomePageAScooter(driver);

        objHomePageAScooter.clickDropDownFirstElement();
        String firstDropdownText = objHomePageAScooter.getDropdownFirstText();
        objHomePageAScooter.verifyDropdownFirstText(firstDropdownText, expectedFirstText);

        objHomePageAScooter.clickDropDownSecondElement();
        String secondDropdownText = objHomePageAScooter.getDropdownSecondText();
        objHomePageAScooter.verifyDropdownSecondText(secondDropdownText, expectedSecondText);

        objHomePageAScooter.clickDropDownThirdElement();
        String thirdDropdownText = objHomePageAScooter.getDropdownThirdText();
        objHomePageAScooter.verifyDropdownThirdText(thirdDropdownText, expectedThirdText);

        objHomePageAScooter.clickDropDownFourthElement();
        String fourthDropdownText = objHomePageAScooter.getDropdownFourthText();
        objHomePageAScooter.verifyDropdownFourthText(fourthDropdownText, expectedFourthText);

        objHomePageAScooter.clickDropDownFifthElement();
        String fifthDropdownText = objHomePageAScooter.getDropdownFifthText();
        objHomePageAScooter.verifyDropdownFifthText(fifthDropdownText, expectedFifthText);

        objHomePageAScooter.clickDropDownSixthElement();
        String sixthDropdownText = objHomePageAScooter.getDropdownSixthText();
        objHomePageAScooter.verifyDropdownSixthText(sixthDropdownText, expectedSixthText);

        objHomePageAScooter.clickDropDownSeventhElement();
        String seventhDropdownText = objHomePageAScooter.getDropdownSeventhText();
        objHomePageAScooter.verifyDropdownSeventhText(seventhDropdownText, expectedSeventhText);

        objHomePageAScooter.clickDropDownEighthElement();
        String eighthDropdownText = objHomePageAScooter.getDropdownEighthText();
        objHomePageAScooter.verifyDropdownEighthText(eighthDropdownText, expectedEighthText);
    }
}