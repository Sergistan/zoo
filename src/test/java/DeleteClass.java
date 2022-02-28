import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DeleteClass extends BaseClass {
    private final SelenideElement buttonMinus = $(By.xpath("//span[@class='t706__product-minus']"));
    private final SelenideElement buttonDelete = $(By.xpath("//div[@class='t706__product-del']"));
    private final SelenideElement mainPage = $(By.xpath("//a[text() ='Главная']"));

    public void checkReturnIntoMainPageBeforeButtonMinus() {
        click(buttonMinus);
        scrollTo(mainPage);
        checkText(mainPage, "Главная");
    }

    public void checkReturnIntoMainPageBeforeButtonDelete() {
        click(buttonDelete);
        scrollTo(mainPage);
        checkText(mainPage, "Главная");
    }
}