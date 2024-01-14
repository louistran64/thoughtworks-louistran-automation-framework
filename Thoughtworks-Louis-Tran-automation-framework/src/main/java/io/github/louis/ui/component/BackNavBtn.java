package io.github.louis.ui.component;

import com.microsoft.playwright.Page;

/**
 * @author louis
 */
public final class BackNavBtn extends BaseComponent {

    public BackNavBtn(final Page page) {
        super(page);
    }

    public void clickOnBackBtn() {
        page.click("a[href='javascript:window.history.go(-1)']");
    }
}
