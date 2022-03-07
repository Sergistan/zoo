import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CountProductClass extends BaseClass {

    private final SelenideElement inputCount = $(By.xpath("//span[@class='t706__product-quantity']"));

    @Step ("Пользователь вводит количество товара: \"{x}\"")
    @Attachment(value = "Возвращаемое значение в поле")
    public String inputValue(int x) {
        actions().click(inputCount).keyDown(Keys.LEFT_CONTROL).sendKeys("a").keyUp(Keys.LEFT_CONTROL).
                sendKeys(Keys.BACK_SPACE).sendKeys(String.valueOf(x)).sendKeys(Keys.TAB).build().perform();
        String number = inputCount.getText();
        if (x < 1) {
            Assert.assertEquals("1",number);
            return number;
        } else if (x <= 999) {
            Assert.assertTrue(number.contains(String.valueOf(x)));
            return number;
        } else {
            Assert.assertEquals("999",number);
            return number;
        }
    }
}

