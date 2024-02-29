import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderAScooter {
    private WebDriver driver;
    private static final By CLICK_BUTTON_COOKIE = By.xpath("//*[@id=\"rcc-confirm-button\"]"); //локатор для принятия куки
    private static final By INPUT_FIELD_NAME = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input"); //локатор для поля "Имя"
    private static final By INPUT_FIELD_SURNAME = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input"); //локатор для поля "Фамилия"
    private static final By INPUT_FIELD_ADRESS = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input"); //локатор для поля "Адрес"
    private static final By INPUT_FIELD_DDL_METRO_STATION = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input"); //локатор для поля "Станция метро"
    //private static final By DDL_METRO_STATION = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[%d]"); //локатор для значения в выпадающем списке "Станция метро"
    private static final By INPUT_FIELD_PHONE = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input"); //локатор для поля "Телефон"
    private static final By BUTTON_FURTHER = By.xpath("/html/body/div/div/div[2]/div[3]/button"); //локатор для кнопки "Далее"
    private static final By INPUT_FIELD_WHEN_TO_BRING_THE_SCOOTER = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input"); //локатор для поля "КОгда привезти самокат
    private static final By THE_RENTAL_PERIOD = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div/div[1]"); //локатор для "Срок аренды"
    private static final By CHECKBOX_BLACK = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]/input"); //локатор для чекбокса "чёрный жемчуг"
    private static final By CHECKBOX_GREY = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[2]/input"); //локатор для чекбокса "серая безысходность"
    private static final By NEXT_MONTH_BUTTON = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/button[2]"); //локатор для кнопки переключения месяца на календаре
    public static final By INPUT_FIELD_COMMENT = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input"); //локатор для поля "Комментарий"
    private static final By BUTTON_ORDER_YES = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]"); //локатор для кнопка "Да" во всплывающем окне для оформления заказа
    private static final By BUTTON_FOR_ORDER = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]"); //локатор кнопки "Заказать" для завершения оформления заказа

    public OrderAScooter(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCookie(){ //принять куки
        WebElement cookie = driver.findElement(CLICK_BUTTON_COOKIE);
        cookie.click();
    }

    public void clickButtonOrder(By buttonLocator) { //клик по кнопке "Заказать" в шапке стенда
        WebElement element = driver.findElement(buttonLocator); //найти элемент по локатору
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //скролл до элемента
        element.click(); //клик по элементу
    }

    public void clickAndInputName(String name) { //клик по полю "Имя" и ввод текста
        WebElement nameField = driver.findElement(INPUT_FIELD_NAME);
        nameField.click();
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void clickAndInputSurname(String surname) { //клик по полю "Фамилия и ввод текста
        WebElement surnameField = driver.findElement(INPUT_FIELD_SURNAME);
        surnameField.click();
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    public void clickAndInputAdress(String address) { //клик по полю "Адрес" и ввод текста
        WebElement addressField = driver.findElement(INPUT_FIELD_ADRESS);
        addressField.click();
        addressField.clear();
        addressField.sendKeys(address);
    }
    public void clickAndSelectMetroStation(int metro) { //выбираем станцию метро
        WebElement metroStationField = driver.findElement(INPUT_FIELD_DDL_METRO_STATION);
        metroStationField.click();
        metroStationField.clear();
        String locator = String.format("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[%d]", metro);
        WebElement ddlMetroStation = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ddlMetroStation);
        ddlMetroStation.click();
    }

    public void clickAndInputPhone(String phone) { //клик по полю "Телефон" и ввод текста
        WebElement phoneField = driver.findElement(INPUT_FIELD_PHONE);
        phoneField.click();
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void clickButtonFurther() { //клик по кнопку "Далее"
        driver.findElement(BUTTON_FURTHER).click();
    }

    public void clickInputFieldWhenToBringTheScooter(int daysToAdd) { //выбираем дату в календаре

        driver.findElement(INPUT_FIELD_WHEN_TO_BRING_THE_SCOOTER).click();

        // Определение целевой даты
        DateFormat dateFormat = new SimpleDateFormat("d");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daysToAdd);
        String targetDay = dateFormat.format(cal.getTime());

        // Поиск элемента календаря с целевой датой и клик на него
        String targetDayXpath = "//div[text()='" + targetDay + "']";
        WebElement targetDayElement = driver.findElement(By.xpath(targetDayXpath));

        // Если элемент не найден, клик на кнопку для перехода к следующему месяцу
        if (!targetDayElement.isDisplayed()) {
            WebElement nextMonthButton = driver.findElement(NEXT_MONTH_BUTTON);
            nextMonthButton.click();
            // Повторный поиск элемента для целевой даты в новом месяце и клик на него
            targetDayElement = driver.findElement(By.xpath(targetDayXpath));
        }
        targetDayElement.click();
    }

    public void clickDdlTheRentalPeriod(String option) { //выбираем срок аренды
        WebElement rentalPeriod = driver.findElement(THE_RENTAL_PERIOD);
        rentalPeriod.click();
        // Выбор нужного значения в выпадающем списке
        WebElement optionElement = driver.findElement(By.xpath("//div[@class='Dropdown-menu']//div[contains(text(), '" + option + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
    }

    public void selectCheckboxes(boolean checkbox1, boolean checkbox2) { //находим чекбоксы и выбираем их

        if (checkbox1) {
            WebElement checkbox1Element = driver.findElement(CHECKBOX_BLACK);
            checkbox1Element.click();
        }
        if (checkbox2) {
            WebElement checkbox2Element = driver.findElement(CHECKBOX_GREY);
            checkbox2Element.click();
        }
    }

    public void setComment(String commentText) { // Находим поле "Комментарий" и кликаем по нему
        WebElement commentField = driver.findElement(INPUT_FIELD_COMMENT);
        commentField.clear();
        commentField.sendKeys(commentText);
    }
    public void clickButtonOrder() { //клик по кнопке "Заказать" для оформления заказа
        WebElement buttonOrder = driver.findElement(BUTTON_FOR_ORDER);
        buttonOrder.click();
    }
    public void clickButtonYes(){ //клик по кнопке "Да" и проверка наличия окна
        WebElement buttonOrderYes = driver.findElement(BUTTON_ORDER_YES);
        buttonOrderYes.click();
        // Проверяем наличие всплывающего окна
        if (driver.getPageSource().contains("Заказ оформлен")) {
            System.out.println("Тест пройден: Всплывающее окно 'Заказ оформлен' обнаружено.");
        } else {
            System.out.println("Тест не удался: Всплывающее окно 'Заказ оформлен' не найдено.");
        }
    }

    public void theScreenForWhomIsTheScooter(String name, String surname, String address, String phone, int daysToAdd, String option, boolean checkbox1, boolean checkbox2, String commentText, By buttonLocator, int metro) {
        // Выполнение последовательности действий на экране
        clickCookie();
        clickButtonOrder(buttonLocator);
        clickAndInputName(name);
        clickAndInputSurname(surname);
        clickAndInputAdress(address);
        clickAndSelectMetroStation(metro);
        clickAndInputPhone(phone);
        clickButtonFurther();
        clickInputFieldWhenToBringTheScooter(daysToAdd);
        clickDdlTheRentalPeriod(option);
        selectCheckboxes(checkbox1, checkbox2);
        setComment(commentText);
        clickButtonOrder();
        clickButtonYes();
    }

}
