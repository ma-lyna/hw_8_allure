import org.junit.jupiter.api.Test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideCheck {
        @Test
        public void checkIssueSelenide() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com");

            $(".header-search-input").click();
            $(".header-search-input").sendKeys("ma-lyna/hw_7_parameterizedTests");
            $(".header-search-input").submit();

            $(linkText("ma-lyna/hw_7_parameterizedTests")).click();
            $("#issues-tab").click();
        }
}











