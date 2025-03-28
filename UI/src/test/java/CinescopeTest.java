import jdk.jfr.Description;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(MyAllureSetup.class)
public class CinescopeTest {

    MainPage mainPage = new MainPage();
    MoviePage moviePage = new MoviePage();
    PaymentPage paymentPage = new PaymentPage();

    @Description("Вход в аккаунт и покупка билетов")
    @CsvSource({
            "ivan333@gmail.com, Qq12345678, Тайна Коко, 1",
            "ivan333@gmail.com, Qq12345678, Темный рыцарь, 2"
    })
    @ParameterizedTest
    public void loginAndBuyTicketTest(String mail, String password, String titleOfMovie, String amountOfTicket) {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginAs(mail, password);
        mainPage.openMovie(titleOfMovie);
        moviePage.addToBucket();
        paymentPage.inputCardData(amountOfTicket);
        paymentPage.sendCardData();
    }

    @Description("Регистрация нового пользователя")
    @CsvSource({
            "Qwe Rty Uio, wrewrwer@gmail.com, Qq12345678, ТQq12345678"
    })
    @ParameterizedTest
    public void registerTest(String name, String mail, String password, String rePassword) {
        RegisterPage registerPage = RegisterPage.open();
        registerPage.registerAs(name, mail, password, rePassword);
    }
    @Description("Вход в аккаунт")
    @CsvSource({
            "ivan333@gmail.com, Qq12345678"
    })
    @ParameterizedTest
    public void loginTest(String mail, String password) {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginAs(mail, password);
    }
}
