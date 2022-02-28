import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketClass extends BaseClass {
    private final SelenideElement dogsEats = $(new By.ByLinkText("РАЦИОН ДЛЯ СОБАК"));
    private final SelenideElement addToBasket = $(new By.ByLinkText("Добавить в корзину"));
    private final SelenideElement numbersProducts = $(By.xpath("//div[@class= 't706__carticon-counter js-carticon-counter']"));
    private final SelenideElement yourOrder = $(By.xpath("//div[text()='Ваш заказ:']"));

    public void userCanAddProductIntoBasket() {
        click(dogsEats);
        checkText(addToBasket, "Добавить в корзину");
        click(addToBasket);
        checkText(numbersProducts, "1");
        click(numbersProducts);
        checkVisible(yourOrder);
    }
}

