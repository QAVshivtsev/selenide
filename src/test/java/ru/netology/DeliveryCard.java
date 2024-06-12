package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.TAB;
import static ru.netology.Date.getDate;


class DeliveryCard {
    @Test
    void shouldDeliveryFormWorks() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("input[placeholder=Город]").setValue("Нижний Новгород");
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        String expectedDate = getDate(4);
        $x("//input[@placeholder='Дата встречи']").setValue(expectedDate).sendKeys(TAB);
        $("input[name=name]").setValue("Вшивцев Владислав");
        $("input[name=phone]").setValue("+79875358135");
        $("label[data-test-id=agreement]").click();
        $x("//span[contains(text(), 'Забронировать')]").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + expectedDate));
    }
}
