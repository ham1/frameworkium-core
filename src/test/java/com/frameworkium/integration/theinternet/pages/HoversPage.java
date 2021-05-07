package com.frameworkium.integration.theinternet.pages;

import com.frameworkium.lite.htmlelements.annotations.Timeout;
import com.frameworkium.lite.ui.annotations.Invisible;
import com.frameworkium.lite.ui.annotations.Visible;
import com.frameworkium.lite.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoversPage extends BasePage<HoversPage> {

    @Visible
    @FindBy(css = "div.figure:nth-of-type(1)")
    private WebElement firstFigure;

    @Invisible
    @Timeout(0)
    @FindBy(css = "div.figure:nth-of-type(1) div.figcaption")
    private WebElement firstFigureCaption;

    public static HoversPage open() {
        return new HoversPage().get("https://the-internet.herokuapp.com/hovers");
    }

    public String getFirstFigureCaption() {

        // Move mouse over the first figure to make caption visible
        (new Actions(driver)).moveToElement(firstFigure).perform();

        // Return text from the now-visible caption
        return firstFigureCaption.getText();
    }

}
