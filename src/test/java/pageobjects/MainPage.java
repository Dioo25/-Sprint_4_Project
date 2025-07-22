package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By cookieButton = By.id("rcc-confirm-button");
    private final By orderTopButton = By.className("Button_Button__ra12g");
    private final By orderBottomButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");
    private final By faqSection = By.className("Home_FAQ__3uVm4");

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void acceptCookies() {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderBottomButton() {
        driver.findElement(orderBottomButton).click();
    }

    public void scrollToFaqSection() {
        WebElement section = driver.findElement(faqSection);
        section.getLocation();
    }

    public void clickQuestion(int index) {
        driver.findElement(By.id("accordion__heading-" + index)).click();
    }

    public String getAnswerText(int index) {
        return driver.findElement(By.id("accordion__panel-" + index)).getText();
    }
}