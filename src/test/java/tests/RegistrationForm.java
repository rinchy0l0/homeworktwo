package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void successfulRegistrationTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Karina");
        $("#lastName").setValue("Riniskina");
        $("#userEmail").setValue("kriniskina@gmail.com");

        $("#genterWrapper").$(byText("Female")).click();

        $("#userNumber").setValue("7777777777");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1997");
        $("[aria-label='Choose Thursday, October 16th, 1997']").click();

        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("./img/1.jpg");

        $("#currentAddress").val("NN VV dom 7");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Karina Riniskina"), text("kriniskina@gmail.com"),
                text("Female"),
                text("7777777777"), text("16 October,1997"), text("Arts"),
                text("Sports"), text("1.jpg"), text("NN VV dom 7"), text("NCR Delhi"));

    }
}
