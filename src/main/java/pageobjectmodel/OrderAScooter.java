package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderAScooter {
    private static final By BUTTON_LOCATOR_IN_HEADER = By.xpath("//button[contains(@class, 'Button_Button__ra12g')]"); //кнопка "Заказать" в шапке стенда
    private static final By BUTTON_LOCATOR_IN_MIDDLE = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //кнопка "Заказать" в середине стенда
    private WebDriver driver;
    private static final By CLICK_BUTTON_COOKIE = By.xpath("//*[@id=\"rcc-confirm-button\"]"); //локатор для принятия куки
    private static final By INPUT_FIELD_NAME = By.xpath("//input[@placeholder='* Имя']"); //локатор для поля "Имя"
    private static final By INPUT_FIELD_SURNAME = By.xpath("//input[@placeholder='* Фамилия']"); //локатор для поля "Фамилия"
    private static final By INPUT_FIELD_ADRESS = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); //локатор для поля "Адрес"
    private static final By INPUT_FIELD_DDL_METRO_STATION = By.xpath("//input[contains(@placeholder,'Станция метро')]"); //локатор для поля "Станция метро"
    private static final By INPUT_FIELD_PHONE = By.xpath("//input[contains(@placeholder,'Телефон')]"); //локатор для поля "Телефон"
    private static final By BUTTON_FURTHER = By.xpath("//button[text()='Далее']"); //локатор для кнопки "Далее"
    private static final By INPUT_FIELD_WHEN_TO_BRING_THE_SCOOTER = By.xpath("//input[contains(@placeholder,'Когда привезти самокат')]"); //локатор для поля "КОгда привезти самокат
    private static final By THE_RENTAL_PERIOD = By.xpath("//div[text()='* Срок аренды']"); //локатор для "Срок аренды"
    private static final By CHECKBOX_BLACK = By.xpath("//input[@id='black']"); //локатор для чекбокса "чёрный жемчуг"
    private static final By CHECKBOX_GREY = By.xpath("//input[@id='grey']"); //локатор для чекбокса "серая безысходность"
    private static final By NEXT_MONTH_BUTTON = By.xpath("//button[contains(@aria-label, \"Next Month\")]"); //локатор для кнопки переключения месяца на календаре
    public static final By INPUT_FIELD_COMMENT = By.xpath("//input[@placeholder=\"Комментарий для курьера\"]"); //локатор для поля "Комментарий"
    private static final By BUTTON_ORDER_YES = By.xpath("//button[text()='Да']"); //локатор для кнопка "Да" во всплывающем окне для оформления заказа
    private static final By BUTTON_FOR_ORDER = By.xpath("//button[contains(@class, \"Button_Button__ra12g\") and contains(@class, \"Button_Middle__1CSJM\") and text()='Заказать']"); //локатор кнопки "Заказать" для завершения оформления заказа
    private static final By THE_ORDER_HAS_BEEN_PLACED = By.xpath("//*[text() = 'Заказ оформлен']"); //локатор для окна "Заказ оформлен"
    public OrderAScooter(WebDriver driver) {
        this.driver = driver;
    }
    public OrderAScooter clickCookie(){ //принять куки
        WebElement cookie = driver.findElement(CLICK_BUTTON_COOKIE);
        cookie.click();
        return this;
    }

    public OrderAScooter clickButtonOrderInHeader() { //клик по кнопке "Заказать" в шапке стенда
        WebElement element = driver.findElement(BUTTON_LOCATOR_IN_HEADER); //найти элемент по локатору
        element.click(); //клик по элементу
        return this;
    }
    public OrderAScooter clickButtonOrderInMiddle() { //клик по кнопке "Заказать" в середине стенда
        WebElement element = driver.findElement(BUTTON_LOCATOR_IN_MIDDLE);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //скролл до элемента
        element.click(); //клик по элементу
        return this;
    }
    public OrderAScooter clickOrderButton(String buttonLocation) { //выбор по какой кнопке "Заказать" кликать
        if (buttonLocation.equals("header")) {
            clickButtonOrderInHeader();
        } else if (buttonLocation.equals("middle")) {
            clickButtonOrderInMiddle();
        }
        return this;
    }

    public OrderAScooter clickAndInputName(String name) { //клик по полю "Имя" и ввод текста
        WebElement nameField = driver.findElement(INPUT_FIELD_NAME);
        nameField.click();
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public OrderAScooter clickAndInputSurname(String surname) { //клик по полю "Фамилия и ввод текста
        WebElement surnameField = driver.findElement(INPUT_FIELD_SURNAME);
        surnameField.click();
        surnameField.clear();
        surnameField.sendKeys(surname);
        return this;
    }

    public OrderAScooter clickAndInputAdress(String address) { //клик по полю "Адрес" и ввод текста
        WebElement addressField = driver.findElement(INPUT_FIELD_ADRESS);
        addressField.click();
        addressField.clear();
        addressField.sendKeys(address);
        return this;
    }
    public OrderAScooter clickAndSelectMetroStation(int metro) { //выбираем станцию метро
        WebElement metroStationField = driver.findElement(INPUT_FIELD_DDL_METRO_STATION);
        metroStationField.click();
        metroStationField.clear();
        String locator = String.format("//div[@class = 'select-search__select']/ul/li[%d]", metro);
        WebElement ddlMetroStation = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ddlMetroStation);
        ddlMetroStation.click();
        return this;
    }

    public OrderAScooter clickAndInputPhone(String phone) { //клик по полю "Телефон" и ввод текста
        WebElement phoneField = driver.findElement(INPUT_FIELD_PHONE);
        phoneField.click();
        phoneField.clear();
        phoneField.sendKeys(phone);
        return this;
    }
    public OrderAScooter customerDataForm(String buttonLocation, String name, String surname, String address, int metro, String phone) {
        // Выполнение последовательности действий на экране
        clickCookie();
        clickOrderButton(buttonLocation);
        clickAndInputName(name);
        clickAndInputSurname(surname);
        clickAndInputAdress(address);
        clickAndSelectMetroStation(metro);
        clickAndInputPhone(phone);
        clickButtonFurther();
        return this;
    }

    public OrderAScooter clickButtonFurther() { //клик по кнопку "Далее"
        driver.findElement(BUTTON_FURTHER).click();
        return this;
    }

    public OrderAScooter clickInputFieldWhenToBringTheScooter(int daysToAdd) { //выбираем дату в календаре

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
        return this;
    }

    public OrderAScooter clickDdlTheRentalPeriod(String option) { //выбираем срок аренды
        WebElement rentalPeriod = driver.findElement(THE_RENTAL_PERIOD);
        rentalPeriod.click();
        // Выбор нужного значения в выпадающем списке
        WebElement optionElement = driver.findElement(By.xpath("//div[@class='Dropdown-menu']//div[contains(text(), '" + option + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
        return this;
    }

    public OrderAScooter selectCheckboxes(boolean checkboxBlack, boolean checkboxGrey) { //находим чекбоксы и выбираем их

        if (checkboxBlack) {
            WebElement checkboxBlackColor = driver.findElement(CHECKBOX_BLACK);
            checkboxBlackColor.click();
        }
        if (checkboxGrey) {
            WebElement checkboxGreyColor = driver.findElement(CHECKBOX_GREY);
            checkboxGreyColor.click();
        }
        return this;
    }

    public OrderAScooter setComment(String commentText) { // Находим поле "Комментарий" и кликаем по нему
        WebElement commentField = driver.findElement(INPUT_FIELD_COMMENT);
        commentField.clear();
        commentField.sendKeys(commentText);
        return this;
    }
    public OrderAScooter clickButtonOrder() { //клик по кнопке "Заказать" для оформления заказа
        WebElement buttonOrder = driver.findElement(BUTTON_FOR_ORDER);
        buttonOrder.click();
        return this;
    }
    public OrderAScooter clickButtonYes() { //клик по кнопке "Да" во всплывающем окне оформления заказа
        WebElement buttonOrderYes = driver.findElement(BUTTON_ORDER_YES);
        buttonOrderYes.click();
        return this;
    }
    public boolean checkOrderConfirmationWindow() {
        // Проверяем наличие всплывающего окна
        return driver.findElement(THE_ORDER_HAS_BEEN_PLACED).isDisplayed();
    }
    public OrderAScooter orderDetails(int daysToAdd, String option, boolean checkboxBlack, boolean checkboxGrey, String commentText) {
        clickInputFieldWhenToBringTheScooter(daysToAdd);
        clickDdlTheRentalPeriod(option);
        selectCheckboxes(checkboxBlack, checkboxGrey);
        setComment(commentText);
        clickButtonOrder();
        clickButtonYes();
        return this;
    }

}
