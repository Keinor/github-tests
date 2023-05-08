package com.nastyabelova.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

/**
 * Класс с лямбда шагами для проверки поиска Issue в репозитории Keinor/github-tests
 */
public class StepTest {

    private static final String REPOSITORY = "Keinor/github-tests";
    private static final int ISSUE_NUMBER = 2;

    @Test
    public void testGithubIssue() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            takeScreenshot();
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").pressEnter();
            takeScreenshot();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
            takeScreenshot();
        });
        step("Переходим в раздел Issues", () -> {
            $("#issues-tab").click();
            takeScreenshot();
        });
        step("Проверяем что есть Issue с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
            takeScreenshot();
        });
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
