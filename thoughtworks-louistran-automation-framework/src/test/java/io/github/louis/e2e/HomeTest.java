package io.github.louis.e2e;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.github.louis.annotation.Smoke;
import io.github.louis.ui.page.HomePage;
import io.qameta.allure.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author louis
 */
@Feature("Login Test")
public class HomeTest extends BaseTest {

    private static final String PATH = "promoCode.csv";

    @BeforeEach
    public void createBrowserContextAndPageAndLoginPageInstances() {
        browserContext = browser.newContext();
        page = browserContext.newPage();

        homePage = createInstance(HomePage.class);
        homePage.open();
    }

    @Attachment(value = "Failed Test Case Screenshot", type = "image/png")
    protected byte[] captureScreenshotOnFailure() {
        return homePage.captureScreenshot();
    }

    @AfterEach
    public void closeBrowserContextSession() {
        browserContext.close();
    }

    @Smoke
    @Story("Basic Search flow")
    @Description(
            "TC01 - Customers is able to search for flights to Mars - Available Trip")
    @Test
    public void testValidTrip() {
        homePage.selectFlightDetails("July", "December (two years from now)");
        assertThat(homePage.getResultMessage()).hasText("Seats available!");
    }

    @Smoke
    @Story("Basic Search flow")
    @Description(
            "TC02 - Customers is not able to search for flights to Mars - Unavailable Trip")
    @Test
    public void testInvalidTrip() {
        homePage.selectFlightDetails("July", "July (two years from now)");
        assertThat(homePage.getResultMessage()).hasText("Sorry, there are no more seats available.");
    }

    @Smoke
    @Story("Promotional Codes")
    @Description(
            "TC03 - Customers is able to search for flights to Mars - Unavailable Trip")
    @Test
    public void testValidPromoCode() {
        String promoCode = "AF3-FJK-418";
        homePage.selectFlightDetails("July", "December (two years from now)");
        homePage.inputPromoCode(promoCode);
        assertThat(homePage.verifyPromoCode()).not().hasText("Sorry");
    }

    @Smoke
    @Story("Link to Home Page")
    @Description(
            "TC04 - Customers is able to go back to the flight search from anywhere on the site")
    @Test
    public void testLinkToHomePage() {
        homePage.clickOnLogo();
        assertThat(homePage.getWelcomeMessage()).hasText("Book a ticket to the red planet now!");
        homePage.selectFlightDetails("July", "December");
        homePage.getResultMessage();
        homePage.clickBackBtn();
        assertThat(homePage.getWelcomeMessage()).hasText("Book a ticket to the red planet now!");
    }

    @Smoke
    @Story("Invalid Return Dates")
    @Description(
            "TC06 -Potential customers is prevented from searching for invalid trips")
    @Test
    public void testInvalidReturnDate() {
        homePage.selectFlightDetails("July", "December");
        assertThat(homePage.getResultMessage()).hasText("Unfortunately, this schedule is not possible. Please try again.");
    }
}
