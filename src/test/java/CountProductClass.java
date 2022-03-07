import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CountProductClass extends BaseClass {

    private final SelenideElement inputCount = $(By.xpath("//span[@class='t706__product-quantity']"));

    @Step ("Пользователь вводит количество товара: \"{x}\"")
    public void inputValue(int x) {
        actions().click(inputCount).keyDown(Keys.LEFT_CONTROL).sendKeys("a").keyUp(Keys.LEFT_CONTROL).
                sendKeys(Keys.BACK_SPACE).sendKeys(String.valueOf(x)).sendKeys(Keys.TAB).build().perform();
    }

        @Step ("Возвращаемое значение в поле")
        public void checkCountProduct(int x) {
            String number = inputCount.getText();
            if (x < 1) {
                Assert.assertEquals("1",number);
            } else if (x <= 999) {
                Assert.assertTrue(number.contains(String.valueOf(x)));
            } else {
                Assert.assertEquals("999",number);
            }
            Allure.addAttachment("Значение", number);
        }
}

