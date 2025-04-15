import com.cinescope.api.*;
import com.cinescope.api.payloads.UserPayload;
import com.cinescope.api.services.UserApiService;
import com.cinescope.ui.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.cinescope.api.conditions.Conditions.statusCode;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MyAllureSetup.class)
public class CinescopeTest {

    private final UserApiService userApiService = new UserApiService();

    MainPage mainPage = new MainPage();
    MoviePage moviePage = new MoviePage();
    PaymentPage paymentPage = new PaymentPage();


    @Test
    @Description("Регистрация нового пользователя")
    public void registerNewUserWithValidCredentialsTest() {
        //given
        UserPayload user = UserGenerator.generateRandomUser();
        //expect
//        userApiService.registerUser(user)
//                .shouldHave(statusCode(201));

        RegisterPage.open().registerAs(user.fullName(), user.email(), user.password(), user.passwordRepeat());
    }


    @Description("Вход в аккаунт и покупка билетов")
    @CsvSource({
            "ivan333@gmail.com, Qq12345678, Тайна Коко, 1",
            "ivan333@gmail.com, Qq12345678, Москва слезам не верит, 2"
    })
    @ParameterizedTest
    public void loginAndBuyTicketWithValidCredentialsTest(String mail, String password, String titleOfMovie, String amountOfTicket) {
        LoginPage.open()
                .loginAs(mail, password);
        mainPage.openMovie(titleOfMovie);
        moviePage.addToBucket();
        paymentPage.inputCardData(amountOfTicket);
        paymentPage.sendCardData();
        assertThat(paymentPage.getSuccessMessage()).isEqualTo("Спасибо за покупку");
    }


    @Description("Вход в аккаунт")
    @CsvSource({
            "ivan333@gmail.com, Qq12345678"
    })
    @ParameterizedTest
    public void userCanLoginWithValidCredentialsTest(String mail, String password) {
        LoginPage.open()
                .loginAs(mail, password);
    }
}