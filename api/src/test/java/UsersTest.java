import com.cinescope.api.services.UserApiService;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cinescope.api.payloads.UserPayload;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Locale;

import static com.cinescope.api.conditions.Conditions.bodyField;
import static com.cinescope.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class UsersTest {

    private final UserApiService userApiService = new UserApiService();
    private static final Logger log = LoggerFactory.getLogger(UsersTest.class);
    private final Faker faker = new Faker(new Locale("us"));

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "https://auth.dev-cinescope.t-qa.ru";
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .savePageSource(true)
                        .screenshots(true));
        WebDriverRunner.addListener(new WebDriverListener() {
            @Override
            public void beforeAnyCall(Object target, Method method, Object[] args) {
                log.info("...{}{}{}", target, method, args);
            }

            @Override
            public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
                log.info("...{}{}{}{}",target, method, args, result);
            }
        });
    }


    @Test
    @Description("Регистрация нового пользователя")
    public void testCanRegisterNewUser() {
        //given
        UserPayload user = new UserPayload()
                .fullName(faker.name().fullName())
                .password("12345678Aa")
                .passwordRepeat("12345678Aa")
                .email(faker.internet().emailAddress());
        //expect
        userApiService.registerUser(user)
                .shouldHave(statusCode(201))
                .shouldHave(bodyField("id", not(isEmptyString())));
    }

    @Test
    @Description("Регистрация двух одиинаковых пользователей")
    public void testCanNotRegisterSameNewUser() {
        //given
        UserPayload user = new UserPayload()
                .fullName(faker.name().fullName())
                .password("12345678Aa")
                .passwordRepeat("12345678Aa")
                .email(faker.internet().emailAddress());
        //expect
        userApiService.registerUser(user)
                .shouldHave(statusCode(201))
                .shouldHave(bodyField("id", not(isEmptyString())));

        userApiService.registerUser(user)
                .shouldHave(statusCode(409));
    }

    @Test
    @Description("Регистрация нового пользователя и вход в аккаунт")
    public void testCanLoginNewUser() {
        //given
        UserPayload user = new UserPayload()
                .fullName(faker.name().fullName())
                .password("12345678Aa")
                .passwordRepeat("12345678Aa")
                .email(faker.internet().emailAddress());
        //expect
        userApiService.registerUser(user)
                .shouldHave(statusCode(201))
                .shouldHave(bodyField("id", not(isEmptyString())));

        userApiService.loginUser(user)
                .shouldHave(statusCode(201));
    }
}
