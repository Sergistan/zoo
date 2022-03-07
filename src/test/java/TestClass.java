import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тестирование сайта корма для домашних животных")
public class TestClass {
    BasketClass basketClass = new BasketClass();
    CountProductClass countProductClass = new CountProductClass();
    DeleteClass deleteClass = new DeleteClass();
    SendFormClass sendFormClass = new SendFormClass();


    @BeforeEach
    public void setUp() {
        open("https://statera-pet.ru/");
    }

    @Epic(value = "Тестирование страницы заказа")
    @Feature(value = "Тестирование поля количества товаров в корзине")
    @DisplayName("Тест №1")
    @Description ("Тест проверяет возможность пользователя добавить товар в корзину")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void ProductIntoBasket() {
        basketClass.userCanAddProductIntoBasket();
    }

    @Epic(value = "Тестирование страницы заказа")
    @Feature(value = "Тестирование поля количества товаров в корзине")
    @DisplayName("Тест №2")
    @Description ("Тест проверяет проверяет количество товара на иконке при разовом нажатии \"Добавить в корзину\"")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void CheckCountOrder() {
        basketClass.checkNumberOrdersOnIcon("1");
    }

    @Epic(value = "Тестирование страницы заказа")
    @Feature(value = "Тестирование поля количества товаров в корзине")
    @DisplayName("Тест №3")
    @Description ("Тест прогоняет граничные значания для количества заказов в поле заказов")
    @Severity(SeverityLevel.BLOCKER)
    @ParameterizedTest
    @ValueSource(ints = {-1,0,1,999,1000})
    public void countProductIsNull(int x) {
        basketClass.userCanAddProductIntoBasket();
        countProductClass.inputValue(x);
        countProductClass.checkCountProduct(x);
    }

    @Epic(value = "Тестирование страницы заказа")
    @Feature(value = "Тестирование поля количества товаров в корзине")
    @DisplayName("Тест №4")
    @Description ("Тест проверяет возможность пользователя удалять товар из корзины " +
            "с помощью кнопки /'минус/' ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void deleteProductFromBasketButtonMinus() {
        basketClass.userCanAddProductIntoBasket();
        deleteClass.checkReturnIntoMainPageBeforeButtonMinus();
    }

    @Epic(value = "Тестирование страницы заказа")
    @Feature(value = "Тестирование поля количества товаров в корзине")
    @DisplayName("Тест №5")
    @Description ("Тест проверяет возможность пользователя удалять товар из корзины " +
            "с помощью кнопки /'крестик/' ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void deleteProductFromBasketButtonDelete() {
        basketClass.userCanAddProductIntoBasket();
        deleteClass.checkReturnIntoMainPageBeforeButtonDelete();
    }


    @Epic(value = "Тестирование страницы заказа")
    @Feature(value = "Тестирование формы отправки заказа")
    @DisplayName("Тест №6")
    @Description ("Тест проверяет возможность отправки формы при вводе валидных значений")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void inputForm(){
        basketClass.userCanAddProductIntoBasket();
        sendFormClass.writeInfo("Паша Смирнов","qwery321@mail.com","9899999999",
                "Токио","321");
        sendFormClass.sendForm();
    }


    @AfterEach
    public void quit() {
        Selenide.closeWebDriver();
    }

}