package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegitrsationFormPage;

public class TestBase {
    RegitrsationFormPage regitrsationFormPage = new RegitrsationFormPage();
    TestData testData = new TestData();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1000x1000";
    }
}
