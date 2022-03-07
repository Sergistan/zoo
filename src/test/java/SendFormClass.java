import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SendFormClass extends BaseClass{
    private final SelenideElement inputName = $(new By.ByName("Name"));
    private final SelenideElement inputEmail = $(new By.ByName("Email"));
    private final SelenideElement inputPhone = $(new By.ByName("tildaspec-phone-part[]"));
    private final SelenideElement inputCity = $(new By.ByName("В какой город необходимо доставить корм"));
    private final SelenideElement inputPromo = $(new By.ByName("Введите промокод"));
    private final SelenideElement sendButton = $(By.xpath("//button[text()='Оформить заказ']"));
    private final SelenideElement successfulSend = $(By.xpath("//div[text()='Ваш заказ оформлен. " +
            "Менеджер свяжется с вами в течение 30 минут.']"));


    @Step("Заполняем данные для отправки формы")
    public void writeInfo(String name, String email, String phone, String city, String promo){
        writeText(inputName,name);
        writeText(inputEmail,email);
        writeText(inputPhone,phone);
        writeText(inputCity,city);
        writeText(inputPromo,promo);
    }
    @Step("Форма отправилась")
    public void sendForm(){
        click(sendButton);
        successfulSend.shouldBe(text("Ваш заказ оформлен. Менеджер свяжется с вами в течение 30 минут."));
    }
}
