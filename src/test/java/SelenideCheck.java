import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideCheck {
        @Test
        public void checkIssueSelenide() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com");

            $(".header-search-input").click();
            $(".header-search-input").sendKeys("junit-team/junit5");
            $(".header-search-input").submit();

            $(linkText("junit-team/junit5")).click();
            $("#issues-tab").click();
            $(withText("#3109")).should(Condition.exist);
        }
}











