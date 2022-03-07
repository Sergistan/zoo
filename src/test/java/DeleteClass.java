import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DeleteClass extends BaseClass {
    private final SelenideElement buttonMinus = $(By.xpath("//span[@class='t706__product-minus']"));
    private final SelenideElement buttonDelete = $(By.xpath("//div[@class='t706__product-del']"));
    private final SelenideElement mainPage = $(By.xpath("//a[text() ='Главная']"));

    @Step ("Нажимаем на кнопку \"минус\" для удаления заказа из корзины")
    public void checkReturnIntoMainPageBeforeButtonMinus() {
        click(buttonMinus);
        scrollTo(mainPage);
        checkText(mainPage, "Главная");
    }
    @Step ("Нажимаем на кнопку \"крестик\" для удаления заказа из корзины")
    public void checkReturnIntoMainPageBeforeButtonDelete() {
        click(buttonDelete);
        scrollTo(mainPage);
        checkText(mainPage, "Главная");
    }
}