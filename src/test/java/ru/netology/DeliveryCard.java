package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.TAB;
import static ru.netology.Date.getDate;


    class DeliveryCard {
        @Test
        void shouldDeliveryFormWorks() {
            Configuration.holdBrowserOpen = true;
            open("http://localhost:9999/");
            $("span[data-test-id = city]").click();
            $("input[placeholder=Город]").setValue("Нижний Новгород");
            $("span[class=menu-item__control]").click();
            $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
            String expectedDate = getDate(4);
            $x("//input[@placeholder='Дата встречи']").setValue(expectedDate).sendKeys(TAB);;
            $("span[data-test-id=name]").click();
            $("input[name=name]").setValue("Вшивцев Владислав");
            $("span[data-test-id=phone]").click();
            $("input[name=phone]").setValue("+79875358135");
            $("label[data-test-id=agreement]").click();
            $x("//span[contains(text(), 'Забронировать')]").click();
            $(withText("Успешно!")).should(appear, Duration.ofSeconds(11));
            $x("//div[contains(text(), 'Успешно!')]");
        }
    }
