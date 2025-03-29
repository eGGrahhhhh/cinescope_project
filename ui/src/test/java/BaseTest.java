//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenide;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//abstract public class BaseTest {
//
//    public void setUp() {
//
//        Configuration.baseUrl = "https://cinescope.t-qa.ru";
//        Configuration.remote = "http://localhost:4444/wd/hub";
//        Configuration.reportsFolder = "target/surefire-reports";
//        Configuration.downloadsFolder = "target/downloads";
//
//        Map<String, Boolean> options = new HashMap<>();
//        options.put("enableVNC", true);
//        options.put("enableVideo", true);
//        options.put("enableLog", true);
//
//        ChromeOptions capabilities = new ChromeOptions();
//        capabilities.setBrowserVersion("128.0");
//        Configuration.browserCapabilities = capabilities;
//        Configuration.browserCapabilities.setCapability("selenoid:options", options);
//
//    }
//
//    @BeforeEach
//    public void init() {
//        setUp();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        Selenide.closeWebDriver();
//    }
//}
