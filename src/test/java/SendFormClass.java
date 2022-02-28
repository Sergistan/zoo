import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SendFormClass extends BaseClass{
    private final SelenideElement inputName = $(new By.ByName("Name"));
    private final SelenideElement inputEmail = $(new By.ByName("Email"));
    private final SelenideElement inputPhone = $(new By.ByName("tildaspec-phone-part[]"));
    private final SelenideElement inputCity = $(new By.ByName("В какой город необходимо доставить корм"));
    private final SelenideElement inputPromo = $(new By.ByName("Введите промокод"));
    private final SelenideElement sendButton = $(By.xpath("//button[text()='Оформить заказ']"));

    public void sendForm(){
        writeText(inputName,"Катя Смирнова");
        writeText(inputEmail,"qwery@mail.com");
        writeText(inputPhone,"9999999999");
        writeText(inputCity,"Гамбург");
        writeText(inputPromo,"123");
        click(sendButton);
    }
}
