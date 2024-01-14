package io.github.louis.ui.component;

import com.microsoft.playwright.Page;

/**
 * @author louis
 */
public final class Header extends BaseComponent {

    public Header(final Page page) {
        super(page);
    }

    public void clickOnLogo() {
        page.click("a[href='/TranLam']");
    }
}
