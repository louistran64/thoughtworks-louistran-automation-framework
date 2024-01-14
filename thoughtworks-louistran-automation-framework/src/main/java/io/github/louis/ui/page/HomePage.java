package io.github.louis.ui.page;

import static io.github.louis.config.ConfigurationManager.config;

import com.microsoft.playwright.Locator;

import io.github.louis.factory.BasePageFactory;
import io.github.louis.ui.component.BackNavBtn;
import io.github.louis.ui.component.Header;
import io.qameta.allure.Step;

/**
 * @author louis
 */
public final class HomePage extends BasePage {

    private Header header;
    private BackNavBtn backNavBtn;


    @Override
    public void initComponents() {
        header = new Header(page);
        backNavBtn = new BackNavBtn(page);
    }

    @Step("Navigate to the home page")
    public HomePage open() {
        page.navigate(config().baseUrl());
        return this;
    }


    @Step("Select Depart & Return Value")
    public void selectFlightDetails(String departure, String returning){
        page.selectOption("#departing", departure);
        page.selectOption("#returning", returning);
    }

    @Step("Input Promotional Code")
    public void inputPromoCode(String promoCode){
        page.fill("#promotional_code", promoCode);

    }

    @Step("Generate Promotional Code")
    public Locator verifyPromoCode(){
        page.locator("input[type=submit]").click();
        return page.locator("p.promo_code");
    }

    @Step("Search & Get result message")
    public Locator getResultMessage() {
        page.locator("input[type=submit]").click();
        return page.locator("#content > p:nth-child(2)");
    }

    @Step("Get Welcome message in Modal")
    public Locator getWelcomeMessage() {
        return page.locator("#content > form > h3");
    }
    @Step("Click on 'MarsAir' Logo")
    public HomePage clickOnLogo() {
        header.clickOnLogo();
        return BasePageFactory.createInstance(page, HomePage.class);
    }

    @Step("Click 'Back' Button")
    public HomePage clickBackBtn() {
        backNavBtn.clickOnBackBtn();
        return BasePageFactory.createInstance(page, HomePage.class);
    }




}
