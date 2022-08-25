package allure.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1080x1080";
    }
}
