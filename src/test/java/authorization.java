import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;


public class authorization{

    @Disabled
    @Test
    @DisplayName("Авторизация с невалидным паролем")
        void AuthorizationWithAnInvalidPassword() {
        open("https://duckduckgo.com/");
        $("#searchbox_input").setValue("selenide").pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']").shouldBe(
                CollectionCondition.sizeGreaterThan(0));
    }



    @Disabled
    @Test
    @DisplayName("Наличие кнопки восстановления пароля")

    void ThePresenceOfAPasswordRecoveryButton() {
        System.out.println("Hello World");
    }
    @Disabled
    @Test
    @DisplayName("Запуск голосового помощника Алиса")

    void TurnOnAliceVoiceAssistant() {
        System.out.println("Hello World");
    }
}


