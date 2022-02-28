import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Epic("sdfgfdg")
public class TestClass {
    BasketClass basketClass = new BasketClass();
    CountProductClass countProductClass = new CountProductClass();
    DeleteClass deleteClass = new DeleteClass();
    SendFormClass sendFormClass = new SendFormClass();


    @BeforeEach
    public void setUp() {
        open("https://statera-pet.ru/");
    }

    @Test
    @Description ("12144")
    public void ProductIntoBasket() {
        basketClass.userCanAddProductIntoBasket();
    }

//    @DataProvider(name = "Data tests")
//    public Object[][] getData() {
//        Object[][] data = {{"-1"}, {"0"}, {"1"}, {"999"}, {"1000"}};
//        return data;
//    }
//
//    @Test(dataProvider = "Data tests")
//    public void countProductIsNull(String x) {
//        basketClass.userCanAddProductIntoBasket();
//        countProductClass.checkCountProduct(x);
//    }


    @Test
    public void deleteProductFromBasketButtonMinus() {
        basketClass.userCanAddProductIntoBasket();
        deleteClass.checkReturnIntoMainPageBeforeButtonMinus();
    }

    @Test
    public void deleteProductFromBasketButtonDelete() {
        basketClass.userCanAddProductIntoBasket();
        deleteClass.checkReturnIntoMainPageBeforeButtonDelete();
    }

    @Test
    public void inputForm(){
        basketClass.userCanAddProductIntoBasket();
        sendFormClass.sendForm();
    }


    @AfterEach
    public void quit() {
        Selenide.closeWebDriver();
    }

}