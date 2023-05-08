package com.nastyabelova.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Класс шагов для проверки поиска Issue в репозитории Keinor/github-tests
 */
public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
        takeScreenshot();
    }

    @Step("Ищем репозиторий {name}")
    public void searchForRepository(String name) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(name);
        $(".header-search-input").submit();
        takeScreenshot();
    }

    @Step("Переходим в репозиторий {name}")
    public void goToRepository(String name) {
        $(By.linkText(name)).click();
        takeScreenshot();
    }

    @Step("Переходим в раздел Issues")
    public void goToIssues() {
        $("#issues-tab").click();
        takeScreenshot();
    }

    @Step("Проверяем наличие Issue с номером {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(Condition.exist);
        takeScreenshot();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
