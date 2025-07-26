package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы шаг 1
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.className("select-search__input");
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    // Локаторы шаг 2
    private final By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.className("Dropdown-placeholder");
    private final By oneDayOption = By.xpath("//div[@class='Dropdown-menu']/div[text()='сутки']");
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By confirmOrderButton = By.xpath("//button[text()='Да']");
    private final By confirmationModal = By.xpath("//*[contains(text(),'Заказ оформлен')]");

    public void fillFirstStep(String name, String surname, String address, String metro, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroStationField).sendKeys(metro);
        driver.findElement(By.className("select-search__option")).click();
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();
    }

    public void fillSecondStep(String date, String color) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(rentalPeriodField).click();
        driver.findElement(oneDayOption).click();

        if (color.equalsIgnoreCase("black")) {
            driver.findElement(By.id("black")).click();
        } else {
            driver.findElement(By.id("grey")).click();
        }

        driver.findElement(orderButton).click();
        driver.findElement(confirmOrderButton).click();
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(confirmationModal).isDisplayed();
    }
}