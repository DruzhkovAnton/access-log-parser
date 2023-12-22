import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.testit.annotations.*;



import static com.codeborne.selenide.Selenide.open;


@Description("testPobeda")
public class PobedaTest {
    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, capabilities);

        Configuration.browserCapabilities = capabilities;
        open("https://pobeda.aero/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("проверка блока Информация")
    @Description("проверка блока Информация")
    //@ExternalId("проверка блока Информация")
    public void testInformationMenu(){
        MainPage mainPage = new MainPage();
        InfoPage infoPage = new InfoPage();

        mainPage.siteIsOpen("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        infoPage.mouseOverOnInformation();
        infoPage.informationMenuIsOpen();
    }
    @Test
    @DisplayName ("Проверка блока поиска билетов")
    @Description("Проверка блока поиска билетов")
    //@ExternalId("Проверка блока поиска билетов")
    public void testInValidSearchTicket(){
        MainPage mainPage = new MainPage();
        OrderTiketPage orderTiket = new OrderTiketPage();

        mainPage.siteIsOpen("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        orderTiket.searchTiketIsOpen();
        orderTiket.enterSearchCriteria();
        orderTiket.clickButtonSearch();
        orderTiket.checkFieldThere();
    }

    @Test
    @DisplayName("Проверка блока Управление бронированием")
    @Description("Проверка блока Управление бронированием")
    //@ExternalId("Проверка блока Управление бронированием")
    public void testBookingManagement(){
        MainPage mainPage = new MainPage();
        BookingManagementPage bookingManagementPage = new BookingManagementPage();

        mainPage.siteIsOpen("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        bookingManagementPage.clickBookingManagementPage();
        bookingManagementPage.bookingManagementPageIsOpen();
        bookingManagementPage.inputData();
        bookingManagementPage.checkErrorOnDisplay();
    }

    @Test
    @DisplayName("Проверка блока Управление бронированием")
    @Description("Проверка блока Управление бронированием с ошибкой в проверке заголовка")
    //@ExternalId("Проверка блока Управление бронированием")
    public void testBookingManagementError(){
        MainPage mainPage = new MainPage();
        BookingManagementPage bookingManagementPage = new BookingManagementPage();

        mainPage.siteIsOpen("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками123");
        bookingManagementPage.clickBookingManagementPage();
        bookingManagementPage.bookingManagementPageIsOpen();
        bookingManagementPage.inputData();
        bookingManagementPage.checkErrorOnDisplay();
    }

}