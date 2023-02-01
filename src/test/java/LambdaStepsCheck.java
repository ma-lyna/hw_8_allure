import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsCheck {
        private static final String REPOSITORY = "ma-lyna/hw_7_parameterizedTests";

        @Test
        public void checkIssueLambda() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            step("Open github", () -> {
                open("https://github.com");
            });
                step("Search for the repository " + REPOSITORY, () -> {
                    $(".header-search-input").click();
                    $(".header-search-input").sendKeys(REPOSITORY);
                    $(".header-search-input").submit();
                });
                step("Tap on the the repository " + REPOSITORY, () -> {
                    $(linkText(REPOSITORY)).click();
                });
                step("Open the 'Issues' tab", () -> {
                    $("#issues-tab").click();
                });
        }

    @Test
    public void checkIssueAnnotation() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotationStepsCheck steps = new AnnotationStepsCheck();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
    }
}











