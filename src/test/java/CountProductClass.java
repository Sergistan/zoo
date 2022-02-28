import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CountProductClass extends BaseClass {

    private final SelenideElement inputCount = $(By.xpath("//span[@class='t706__product-quantity']"));
    private final SelenideElement messageAboutDeleteProduct = $(By.xpath("//div[@class='t706__product-deleted']"));

    public void checkCountProduct(String x) {
        actions().click(inputCount).keyDown(Keys.LEFT_CONTROL).sendKeys("a").keyUp(Keys.LEFT_CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(x).build().perform();
        int a = Integer.parseInt(x);
        if (a < 1) {
            inputCount.shouldBe(text("1"));
        } else if ((a >= 1 && a <= 999)) {
            inputCount.shouldBe(text(x));
        } else {
            messageAboutDeleteProduct.shouldBe(text("Превышен лимит максимально допусимого количества товара"));
        }
    }

}
