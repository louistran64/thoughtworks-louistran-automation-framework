package io.github.louis.ui.component;

import com.microsoft.playwright.Page;

/**
 * @author louis
 */
public abstract class BaseComponent {

    protected Page page;

    protected BaseComponent(final Page page) {
        this.page = page;
    }
}
