package com.nastyabelova.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

/**
 * Класс для проверки поиска Issue в репозитории Keinor/github-tests со шагами класса WebSteps и аннотациями Allure
 */
@Epic("github.com")
public class AnnotatedStepTest {

    private static final String REPOSITORY = "Keinor/github-tests";
    private static final int ISSUE_NUMBER = 2;
    WebSteps steps = new WebSteps();

    @Test
    @DisplayName("Тест для проверки поиска конкретной Issue")
    @Feature("Issues")
    @Story("Поиск по Issue")
    @Link(url = "https://github.com", name = "Главная страница")
    @Owner("belovanastya")
    @Severity(SeverityLevel.CRITICAL)
    public void searchIssueInRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.goToIssues();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
