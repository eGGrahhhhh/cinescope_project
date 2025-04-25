import com.cinescope.api.ProjectConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class MyAllureSetup implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        Configuration.baseUrl = config.baseUiUrl();
        Configuration.remote = config.remote(); // "http://localhost:4444/wd/hub"; //
        RestAssured.baseURI = config.baseApiUrl();

        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", false);
        options.put("enableLog", true);

        ChromeOptions capabilities = new ChromeOptions();
        capabilities.setBrowserVersion("128.0");
        Configuration.browserCapabilities = capabilities;
        Configuration.browserCapabilities.setCapability("selenoid:options", options);

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .savePageSource(true)
                        .screenshots(true));
    }
}
