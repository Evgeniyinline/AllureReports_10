package allure.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends TestBase {
    
    private static final String REPOSITORY = "Evgeniyinline/AllureReports_10";

    @Test
    @DisplayName("Проверка Issue в собственном репозитории")
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

    @Test
    @DisplayName("Проверка Issue в собственном репозитории Lambda Steps")
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();

        });

        step("Переходим по ссылке репозиторя" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем отутствие Issues", () -> {
            $(Selectors.withText("")).should(Condition.exist);
        });
    }

    @Test
    @DisplayName("Проверка Issue в собственном репозитории Web Steps")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWith();

    }

}
