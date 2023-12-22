import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.testit.annotations.*;
import org.junit.jupiter.api.Assertions;
import ru.testit.annotations.Title;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement logo = $x("//img[contains(@src, 'logo-rus-white')]");


    private String titleText(){
        return title();
    }

    private boolean logoOnDisplay(){
        logo.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return logo.isDisplayed();
    }

    @Step
    @Title("Убедиться, что сайт открылся")
    public void siteIsOpen(String titleExpected){
        Assertions.assertEquals(this.titleText(), titleExpected);
        Assertions.assertTrue(this.logoOnDisplay());
    }
}
