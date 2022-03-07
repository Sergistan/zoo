import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketClass extends BaseClass {
    private final SelenideElement dogsEats = $(new By.ByLinkText("РАЦИОН ДЛЯ СОБАК"));
    private final SelenideElement addToBasket = $(new By.ByLinkText("Добавить в корзину"));
    private final SelenideElement numbersProducts = $(By.xpath("//div[@class= 't706__carticon-counter js-carticon-counter']"));
    private final SelenideElement yourOrder = $(By.xpath("//div[text()='Ваш заказ:']"));

/*Выбираем корм и жмем на кнопку "Добавить в корзину" */
    public void addProduct (){
        click(dogsEats);
        checkText(addToBasket, "Добавить в корзину");
        click(addToBasket);
    }

    @Step("Нажимаем на кнопку добавить в корзину и проверяем, что окно заказа открылось")
    public void userCanAddProductIntoBasket() {
        addProduct();
        click(numbersProducts);
        checkVisible(yourOrder);
    }

    @Step("Нажимаем на кнопку добавить в корзину и проверяем, что на иконке корзины количество отображаемого товара равно 1")
    public void checkNumberOrdersOnIcon(String x) {
        addProduct();
        checkText(numbersProducts, x);
    }
}

