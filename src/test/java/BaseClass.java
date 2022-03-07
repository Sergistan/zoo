import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class BaseClass {

    protected void click(SelenideElement element) {
        element.click();
    }

    protected void checkText(SelenideElement element, String string) {
        element.shouldBe(text(string));
    }

    protected void checkVisible(SelenideElement element) {
        element.shouldBe(visible);
    }

    protected void scrollTo(SelenideElement element) {
        element.scrollTo();
    }

    protected void writeText(SelenideElement element, String string) {
        element.sendKeys(string);
    }
}
