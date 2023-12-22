import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.testit.annotations.*;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;

public class InfoPage {

    private final SelenideElement information = $("[href='/information']");
    private final SelenideElement informationFly = $("[href='/information#flight']");
    private final SelenideElement informationUseFul = $("[href='/information#useful']");
    private final SelenideElement informationCompany = $("[href='/information#company']");

    private void moveMouseInformation(){
        information.hover().shouldBe(Condition.visible,Duration.ofSeconds(10));
    }

    private boolean informationFlyOnDisplay(){
        informationFly.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return informationFly.isDisplayed();
    }

    private boolean informationUseFulOnDisplay(){
        informationUseFul.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return informationUseFul.isDisplayed();
    }

    private boolean informationCompanyOnDisplay(){
        informationCompany.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return informationCompany.isDisplayed();
    }

    @Step
    @Title("Навести мышку на пункт «Информация»")
    public void mouseOverOnInformation(){
        this.moveMouseInformation();
    }
    @Step
    @Title("Убедиться, что появилось всплывающее окно")
    public void informationMenuIsOpen(){
        Assertions.assertTrue(this.informationFlyOnDisplay());
        Assertions.assertTrue(this.informationUseFulOnDisplay());
        Assertions.assertTrue(this.informationCompanyOnDisplay());
    }
}
