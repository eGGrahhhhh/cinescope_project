import com.cinescope.api.ProjectConfig;
import com.cinescope.api.UserGenerator;
import com.cinescope.api.services.UserApiService;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.cinescope.api.payloads.UserPayload;

import static com.cinescope.api.conditions.Conditions.bodyField;
import static com.cinescope.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;


@Tag(value = "API_tests")
public class UsersTest {

    private final UserApiService userApiService = new UserApiService();

    @BeforeEach
    void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseApiUrl();
    }


    @Test
    @Description("Регистрация нового пользователя")
    public void testCanRegisterNewUser() {
        //given
        UserPayload user = UserGenerator.generateRandomUser();
        //expect
        userApiService.registerUser(user)
                .shouldHave(statusCode(201))
                .shouldHave(bodyField("id", not(isEmptyString())));
    }

    @Test
    @Description("Регистрация двух одиинаковых пользователей")
    public void testCanNotRegisterSameNewUser() {
        //given
        UserPayload user = UserGenerator.generateRandomUser();
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
        UserPayload user = UserGenerator.generateRandomUser();
        //expect
        userApiService.registerUser(user)
                .shouldHave(statusCode(201))
                .shouldHave(bodyField("id", not(isEmptyString())));

        userApiService.loginUser(user)
                .shouldHave(statusCode(201));
    }
}
