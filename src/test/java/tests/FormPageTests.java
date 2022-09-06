package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static tests.TestData.*;


public class FormPageTests extends TestBase {

    @DisplayName("Проверка формы на сайте demoqa.com")
    @Test
    void successfulTest() {
        regitrsationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender("Other")
                .setUserNumber(userNumber)
                .setDateOfBirth("30", "May", "2000")
                .setSubjectsInput("Maths")
                .setHobbies("Sports")
                .setUploadPicture()
                .setCurrentAddress(userAdress)
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit()
                .checkFormOpen("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", "Other")
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "30 May,2000")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", userAdress)
                .checkResult("State and City", "NCR" + " " + "Delhi");

    }
    @DisplayName("Parameterized Test With Value Source")
    @ParameterizedTest(name = "При вводе номера телефона {0} в форме отображается номер  {0}")
    @ValueSource(strings = {
            "9284561212",
            "9880831415",
            "9172345678"
    })
    public void parameterizedTestWithValueSource(String valueSource) {
        regitrsationFormPage
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender("Other")
                .setUserNumber(valueSource)
                .setSubmit();
        regitrsationFormPage
                .checkFormOpen("Thanks for submitting the form")
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", "Other")
                .checkResult("Mobile", valueSource);
    }

    @DisplayName("Parameterized Test With CSV Source")
    @ParameterizedTest(name = "При вводе имени {0}, фамилии {1}, пола {2} и телефона {3} в форме должно отображатсья " +
            "имя {0}, фамилия {1}, пол {2} и телефон {3}")
    @CsvSource(value = {
            "Alex, Smith, Other, 9284561212",
            "Lis, Trass, Other, 9880831415",
            "Alex, Arest, Other, 9172345678"
    })
    public void parameterizedTestWithCSVSource(String firstName, String lastName, String gender, String phone) {
        regitrsationFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phone)
                .setSubmit();
        regitrsationFormPage
                .checkFormOpen("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone);
    }
}