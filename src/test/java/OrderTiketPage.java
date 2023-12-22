import com.codeborne.selenide.SelenideElement;
import ru.testit.annotations.*;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OrderTiketPage {

    private final SelenideElement searchTicketButton = $x("//div[contains(@class, 'dp-1glhebn-root-textVisible') and text() = 'Поиск билета']");
    private final SelenideElement cityFrom = $("[placeholder='Откуда'][autocomplete='off']");
    private final SelenideElement cityIn = $("[placeholder='Куда'][autocomplete='off']");
    private final SelenideElement departureDateThere = $("[placeholder='Туда']");
    private final SelenideElement departureDateReturn = $("[placeholder='Обратно']");
    private final SelenideElement searchButton = $("[type='submit']");
    private final SelenideElement dataErorThere = $("[data-errored='true'] [placeholder='Туда']");

    private boolean searchTicketButtonOnDisplay(){
        return searchTicketButton.shouldBe(visible).isDisplayed();
    }

    private boolean cityFromOnDisplay(){
        return cityFrom.shouldBe(visible).isDisplayed();
    }

    private void cityFromInput(String city){
        cityFrom.setValue(city).pressEnter();
    }

    private boolean cityInOnDisplay(){
        return cityIn.shouldBe(visible).isDisplayed();
    }

    private void cityInInput(String city){
        cityIn.setValue(city).pressEnter();
    }

    private boolean departureDateThereOnDisplay(){
        return departureDateThere.shouldBe(visible).isDisplayed();
    }

    private boolean departureDateReturnOnDisplay(){
        return departureDateReturn.shouldBe(visible).isDisplayed();
    }

    private boolean dataErorThereOnDisplay(){
        return dataErorThere.shouldBe(visible).isDisplayed();
    }

    @Step
    @Title(" убедиться, что блок с поиском билета действительно отображается (есть поле Откуда, Куда, Дата вылета Туда, Дата вылета Обратно)")
    public void searchTiketIsOpen() {
        Assertions.assertTrue(this.searchTicketButtonOnDisplay());
        Assertions.assertTrue(this.cityFromOnDisplay());
        Assertions.assertTrue(this.cityInOnDisplay());
        Assertions.assertTrue(this.departureDateThereOnDisplay());
        Assertions.assertTrue(this.departureDateReturnOnDisplay());
    }
    @Step
    @Title("Ввести критерии поиска и нажать ентер")
    public void enterSearchCriteria() {
        cityFromInput("Москва");
        cityInInput("Санкт-Петербург");
    }
    @Step
    @Title("Нажать кнопку «Поиск»")
    public void clickButtonSearch() {
        searchButton.click();
    }
    @Step
    @Title("Убедиться, что около поля «Туда» появилась красная обводка")
    public void checkFieldThere() {
        Assertions.assertTrue(dataErorThereOnDisplay());
    }
}
