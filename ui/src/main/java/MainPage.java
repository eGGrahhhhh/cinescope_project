import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public static MainPage open() {
        Selenide.open("/");
        return new MainPage();
    }

    private SelenideElement movieLocator;
    private final String moreInfoBtnLocator = "//h3[contains(text(),'%s')]/parent::*/parent::*//a[@data-qa-id='more_button']";

    /*void selectMovie(String movie) {
        movieLocator = $(withText(movie));
    }*/

    public void openMovie(String movie) {
        $x(String.format(moreInfoBtnLocator, movie)).click();
    }
}
