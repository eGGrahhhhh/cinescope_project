import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class RegisterPage {

    public static RegisterPage open() {
        Selenide.open("/register");
        return new RegisterPage();
    }
/*
Не менее 8 символов
Не более 32 символов
Только латинские или кириллические буквы
Как минимум одна заглавная и одна строчная буква
Только арабские цифры
Как минимум одна цифра
Без пробелов
Другие допустимые символы:~ ! ? @ # $ % ^ & * _ - + ( ) [ ] {} > < / \ | " ' ., : ;
*/

    private final SelenideElement fullNameField = $(byName("fullName"));
    private final SelenideElement emailField = $(byName("email"));
    private final SelenideElement passwordField = $(byName("password"));
    private final SelenideElement rePasswordField = $(byName("passwordRepeat"));
    private final SelenideElement doRegisterField = $(byText("Зарегистрироваться"));

    public void sendFullName(String name) {
        fullNameField.setValue(name);
    }

    public void sendEmail(String email) {
        emailField.setValue(email);
    }

    public void sendPassword(String password) {
        passwordField.setValue(password);
    }

    public void sendRePassword(String rePassword) {
        rePasswordField.setValue(rePassword);
    }

    public void clickDoRegister() {
        doRegisterField.click();
    }

    public void registerAs(String name, String email, String password, String rePassword) {
        sendFullName(name);
        sendEmail(email);
        sendPassword(password);
        sendRePassword(rePassword);
        clickDoRegister();
    }
}
