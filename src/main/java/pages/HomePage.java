package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = ".display-3")
    WebElement banner;

    public String getBanner() {
        return banner.getText();
    }
}
