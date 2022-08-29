package allure.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {


    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Evgeniyinline/AllureReports_10");
        $(".header-search-input").submit();

        $(linkText("Evgeniyinline/AllureReports_10")).click();

        $("#issues-tab").click();
        $(Selectors.withText("")).should(Condition.exist);
    }
}
