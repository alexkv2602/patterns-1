package ru.netology.delivery.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.BACK_SPACE;

class DeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        var validUser = DataGenerator.Registration.generateUser("ru");
        var daysToAddForFirstMeeting = 3;
        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);
        String city = DataGenerator.CityGenerator.generateCity("ru");
        String name = DataGenerator.NameGenerator.generateName("ru");
        String phone = DataGenerator.PhoneGenerator.generatePhone("ru");

        Configuration.holdBrowserOpen = true;
        $("span[data-test-id = city]").click();
        $("input[placeholder=Город]").setValue(city);
        $("span[class=menu-item__control]").click();
        $x("//input[@placeholder='Дата встречи']").sendKeys(BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE);
        $x("//input[@placeholder='Дата встречи']").setValue(firstMeetingDate);
        $x("//td[@class='calendar__day calendar__day_state_current']").click();
        $("span[data-test-id=name]").click();
        $("input[name=name]").setValue(name);
        $("span[data-test-id=phone]").click();
        $("input[name=phone]").setValue(phone);
        $("label[data-test-id=agreement]").click();
        $x("//button[contains(@class, 'button_view_extra') and contains(@class, 'button_size_m') and contains(@class, 'button_theme_alfa-on-white') and span/span[text()='Запланировать']]").click();
        $(withText("Успешно!")).should(appear, Duration.ofSeconds(11));
        $x("//div[contains(text(), 'Успешно!')]");
        refresh();
        $("span[data-test-id = city]").click();
        $("input[placeholder=Город]").setValue(city);
        $("span[class=menu-item__control]").click();
        $x("//input[@placeholder='Дата встречи']").sendKeys(BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE);
        $x("//input[@placeholder='Дата встречи']").setValue(secondMeetingDate);
        $x("//td[@class='calendar__day calendar__day_state_current']").click();
        $("span[data-test-id=name]").click();
        $("input[name=name]").setValue(name);
        $("span[data-test-id=phone]").click();
        $("input[name=phone]").setValue(phone);
        $("label[data-test-id=agreement]").click();
        $x("//button[contains(@class, 'button_view_extra') and contains(@class, 'button_size_m') and contains(@class, 'button_theme_alfa-on-white') and span/span[text()='Запланировать']]").click();
        $x("//*[contains(text(), 'У вас уже запланирована встреча на другую дату. Перепланировать?!");
        $x("//span[contains(text(), 'Перепланировать')]").click();
        $x("//div[contains(text(), 'Успешно!')]");





        // TODO: добавить логику теста в рамках которого будет выполнено планирование и перепланирование встречи.
        // Для заполнения полей формы можно использовать пользователя validUser и строки с датами в переменных
        // firstMeetingDate и secondMeetingDate. Можно также вызывать методы generateCity(locale),
        // generateName(locale), generatePhone(locale) для генерации и получения в тесте соответственно города,
        // имени и номера телефона без создания пользователя в методе generateUser(String locale) в датагенераторе
    }
}
