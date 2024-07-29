
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Authorization {

    private static Logger logger = LoggerFactory.getLogger(Authorization.class);


    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/chromedriver.exe")).getFile());
        open("https://yandex.kz/");
    }

    @CsvSource(value = {
            "AbsD,12345",
            "AbsD,dr44r"
    })
    @ParameterizedTest(name = "Авторизация с неверным паролем {1}")
    void AuthorizationWithInvalidPassword(String login, String pass) {
        logger.error(login +"что то сделано не так");
        $("button.simple-popup__close ").click();
        $("a.home-link2.headline__personal-enter.home-link2_color_black").click();
        $("#passp-field-login").setValue(login).pressEnter();
        $("#passp-field-passwd").setValue(pass).pressEnter();
        $("div.Description.Description_size_m").shouldHave(text("Яндекс обнаружил угрозу взлома. Рекомендуем восстановить доступ и усилить защиту"));
    }

    @CsvSource(value = {
            "AbsD,12345",
            "AbsD,dr44r"
    })
    @ParameterizedTest(name = "Проверка кнопки  не помню пароль")
    void CheckingTheRestorePasswordButton(String login) {
        $("a.home-link2.headline__personal-enter.home-link2_color_black").click();
        $("#passp-field-login").setValue(login).pressEnter();
        $("a.Link.Link_pseudo").click();
        $("h1.passp-title").shouldHave(text("Введите символы с картинки"));

    }
}







//    @Disabled
//    @Test
//    @DisplayName("Предложение установить браузер")
//    void SuggestionToInstallBrowser() {
//        $("#distOverlayTitle").shouldHave(text("Установить Яндекс Браузер?"));
//    }
//    @Disabled
//    @Test
//    @DisplayName("Запуск голосового помощника Алиса")
//    void TurnOnAliceVoiceAssistant() {
//        $("button.simple-popup__close ").click();
//        $("button.alice-fab");
//    }
//}


