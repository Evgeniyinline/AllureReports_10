package allure.tests;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {


    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Evgeniyinline")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {

    }

}
