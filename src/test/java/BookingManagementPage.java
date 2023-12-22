import com.codeborne.selenide.SelenideElement;
import ru.testit.annotations.*;
import org.junit.jupiter.api.Assertions;
import ru.testit.annotations.Title;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class BookingManagementPage {
    private final SelenideElement bookingManagementButton = $x("//div[contains(@class, 'dp-1glhebn-root-textVisible') and text() = 'Управление бронированием']");
    private final SelenideElement surnameClient = $("[placeholder='Фамилия клиента']");
    private final SelenideElement orderNumber = $("[placeholder='Номер заказа или билета']");
    private final SelenideElement searchButton = $x("//button[text()='Поиск']");
    private final SelenideElement errorMessage = $x("//div[text()='Некорректный номер']");


    private boolean errorMessageOnDisplay(){
        return errorMessage.shouldBe(visible).isDisplayed();
    }

    private boolean searchButtonOnDisplay(){
        return searchButton.shouldBe(visible).isDisplayed();
    }

    private boolean surnameClientOnDisplay(){
        return surnameClient.shouldBe(visible).isDisplayed();
    }

    private boolean orderNumberOnDisplay(){
        return orderNumber.shouldBe(visible).isDisplayed();
    }

    private void surnameClientInput(String surname){
        surnameClient.setValue(surname);
    }

    private void orderNumberInput(String order){
        orderNumber.setValue(order);
    }


    @Step
    @Title("кликнуть на пункт «Управление бронированием»")
    public void clickBookingManagementPage() {
        bookingManagementButton.click();
    }
    @Step
    @Title("Убедиться, что открылась необходимая страница")
    public void bookingManagementPageIsOpen() {
        Assertions.assertTrue(surnameClientOnDisplay());
        Assertions.assertTrue(orderNumberOnDisplay());
        Assertions.assertTrue(searchButtonOnDisplay());
    }
    @Step
    @Title("Ввести в поля ввода данные")
    public void inputData() {
        surnameClientInput("qwerty");
        orderNumberInput("XXXXXXXX");
        searchButton.click();
    }
    @Step
    @Title(" Убедиться, что в новой вкладке на экране отображается текст ошибки «Некорректный номер»")
    public void checkErrorOnDisplay() {
        Assertions.assertTrue(errorMessageOnDisplay());
    }
}
