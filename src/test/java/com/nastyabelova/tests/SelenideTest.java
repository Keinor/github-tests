package com.nastyabelova.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Класс для проверки поиска Issue в репозитории Keinor/github-tests
 */
public class SelenideTest {

    private static final String REPOSITORY = "Keinor/github-tests";
    private static final int ISSUE_NUMBER = 2;

    @Test
    public void testGithubIssue() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").pressEnter();

        $(By.linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    }
}
