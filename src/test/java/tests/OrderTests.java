package tests;

import org.junit.Test;
import pageobjects.MainPage;
import pageobjects.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderTests extends BaseTest {

    @Test
    public void testOrderViaTopButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.acceptCookies();
        mainPage.clickOrderTopButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFirstStep("Иван", "Иванов", "Москва, ул. Ленина, д.1", "Черкизовская", "+79999999999");
        orderPage.fillSecondStep("22.07.2025", "black");

        assertTrue(orderPage.isOrderConfirmed());
    }

    @Test
    public void testOrderViaBottomButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.acceptCookies();
        mainPage.scrollToFaqSection();
        mainPage.clickOrderBottomButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFirstStep("Ольга", "Петрова", "Московская область, д.5", "Котельники", "+78888888888");
        orderPage.fillSecondStep("23.07.2025", "grey");

        assertTrue(orderPage.isOrderConfirmed());
    }
}