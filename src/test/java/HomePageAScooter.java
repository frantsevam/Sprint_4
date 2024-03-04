import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageAScooter {
    private WebDriver driver;
    private static final By FIRST_DROPDOWN_ELEMENT = By.xpath("//*[@id=\"accordion__heading-0\"]"); //локатор для первого элемента выпадающего списка
    private static final By FIRST_DROPDOWN_TEXT = By.xpath("//*[@id=\"accordion__panel-0\"]"); //локатор для текста первого элемента выпадающего списка
    private static final By SECOND_DROPDOWN_ELEMENT = By.xpath("//*[@id=\"accordion__heading-1\"]"); //локатор для второго элемента выпадающего списка
    private static final By SECOND_DROPDOWN_TEXT = By.xpath("//*[@id=\"accordion__panel-1\"]"); //локатор для текста второго элемента выпадающего списка
    private static final By THIRD_DROPDOWN_ELEMENT = By.xpath("//*[@id=\"accordion__heading-2\"]"); //локатор для третьего элемента выпадающего списка
    private static final By THIRD_DROPDOWN_TEXT = By.xpath("//*[@id=\"accordion__panel-2\"]"); //локатор для текста третьего элемента выпадающего списка
    private static final By FOURTH_DROPDOWN_ELEMENT = By.xpath("//*[@id=\"accordion__heading-3\"]"); //локатор для четвертого элемента выпадающего списка
    private static final By FOURTH_DROPDOWN_TEXT = By.xpath("//*[@id=\"accordion__panel-3\"]"); //локатор для текста четвёртого элемента выпадающего списка
    private static final By FIFTH_DROPDOWN_ELEMENT = By.xpath("//*[@id=\"accordion__heading-4\"]"); //локатор для пятого элемента выпадающего списка
    private static final By FIFTH_DROPDOWN_TEXT = By.xpath("//*[@id=\"accordion__panel-4\"]"); //локатор для текста пятого элемента выпадающего списка
    private static final By SIXTH_DROPDOWN_ELEMENT = By.xpath("//*[@id=\"accordion__heading-5\"]"); //локатор для шестого элемента выпадающего списка
    private static final By SIXTH_DROPDOWN_TEXT = By.xpath("//*[@id=\"accordion__panel-5\"]"); //локатор для текста шестого элемента выпадающего списка
    private static final By SEVENTH_DROPDOWN_ELEMENT = By.xpath("//*[@id=\"accordion__heading-6\"]"); //локатор для седьмого элемента выпадающего списка
    private static final By SEVENTH_DROPDOWN_TEXT = By.xpath("//*[@id=\"accordion__panel-6\"]"); //локатор для текста седьмого элемента выпадающего списка
    private static final By EIGHTH_DROPDOWN_ELEMENT = By.xpath("//*[@id=\"accordion__heading-7\"]"); //локатор для восьмого элемента выпадающего списка
    private static final By EIGHTH_DROPDOWN_TEXT = By.xpath("//*[@id=\"accordion__panel-7\"]"); //локатор для текста восьмого элемента выпадающего списка
    public HomePageAScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDropDownFirstElement() { //поиск и клик по первому элементу
        WebElement element = driver.findElement(FIRST_DROPDOWN_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getDropdownFirstText() { //получаем текст первого элемента
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_DROPDOWN_TEXT));
        return driver.findElement(FIRST_DROPDOWN_TEXT).getText();
    }

    public void verifyDropdownFirstText(String actualText, String expectedText) { //сравниваем ФР и ОР
        Assert.assertEquals("Текст в первом выпадающем списке не соответствует ожидаемому.", expectedText, actualText);
    }
    public void clickDropDownSecondElement() {
        WebElement element = driver.findElement(SECOND_DROPDOWN_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getDropdownSecondText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SECOND_DROPDOWN_TEXT));
        return driver.findElement(SECOND_DROPDOWN_TEXT).getText();
    }

    public void verifyDropdownSecondText(String actualText, String expectedText) {
        Assert.assertEquals("Текст во втором выпадающем списке не соответствует ожидаемому.", expectedText, actualText);
    }
    public void clickDropDownThirdElement() {
        WebElement element = driver.findElement(THIRD_DROPDOWN_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getDropdownThirdText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(THIRD_DROPDOWN_TEXT));
        return driver.findElement(THIRD_DROPDOWN_TEXT).getText();
    }

    public void verifyDropdownThirdText(String actualText, String expectedText) {
        Assert.assertEquals("Текст во втором выпадающем списке не соответствует ожидаемому.", expectedText, actualText);
    }
    public void clickDropDownFourthElement() {
        WebElement element = driver.findElement(FOURTH_DROPDOWN_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getDropdownFourthText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FOURTH_DROPDOWN_TEXT));
        return driver.findElement(FOURTH_DROPDOWN_TEXT).getText();
    }

    public void verifyDropdownFourthText(String actualText, String expectedText) {
        Assert.assertEquals("Текст во втором выпадающем списке не соответствует ожидаемому.", expectedText, actualText);
    }
    public void clickDropDownFifthElement() {
        WebElement element = driver.findElement(FIFTH_DROPDOWN_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getDropdownFifthText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIFTH_DROPDOWN_TEXT));
        return driver.findElement(FIFTH_DROPDOWN_TEXT).getText();
    }

    public void verifyDropdownFifthText(String actualText, String expectedText) {
        Assert.assertEquals("Текст во втором выпадающем списке не соответствует ожидаемому.", expectedText, actualText);
    }
    public void clickDropDownSixthElement() {
        WebElement element = driver.findElement(SIXTH_DROPDOWN_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getDropdownSixthText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SIXTH_DROPDOWN_TEXT));
        return driver.findElement(SIXTH_DROPDOWN_TEXT).getText();
    }

    public void verifyDropdownSixthText(String actualText, String expectedText) {
        Assert.assertEquals("Текст во втором выпадающем списке не соответствует ожидаемому.", expectedText, actualText);
    }
    public void clickDropDownSeventhElement() {
        WebElement element = driver.findElement(SEVENTH_DROPDOWN_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getDropdownSeventhText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEVENTH_DROPDOWN_TEXT));
        return driver.findElement(SEVENTH_DROPDOWN_TEXT).getText();
    }

    public void verifyDropdownSeventhText(String actualText, String expectedText) {
        Assert.assertEquals("Текст во втором выпадающем списке не соответствует ожидаемому.", expectedText, actualText);
    }
    public void clickDropDownEighthElement() {
        WebElement element = driver.findElement(EIGHTH_DROPDOWN_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getDropdownEighthText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(EIGHTH_DROPDOWN_TEXT));
        return driver.findElement(EIGHTH_DROPDOWN_TEXT).getText();
    }

    public void verifyDropdownEighthText(String actualText, String expectedText) {
        Assert.assertEquals("Текст во втором выпадающем списке не соответствует ожидаемому.", expectedText, actualText);
    }
}