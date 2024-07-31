
import data.Logopass;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import org.apache.logging.log4j.LogManager;

public class Authorization {

  private static Logger logger = LogManager.getLogger(Authorization.class);

  @BeforeEach
  void setup() {
    open("https://yandex.kz/");
  }

  @CsvSource(value = {"AbsD,12345", "AbsD,dr44r"})
  @ParameterizedTest(name = "Авторизация с неверным паролем {1}")
  void AuthorizationWithInvalidPassword(String login, String pass) {
    logger.error(login + " что то сделано не так");
    $("button.simple-popup__close ").click();
    $("a.home-link2.headline__personal-enter.home-link2_color_black").click();
    $("#passp-field-login").setValue(login).pressEnter();
    $("#passp-field-passwd").setValue(pass).pressEnter();
    $("div.Description.Description_size_m").shouldHave(
        text("Яндекс обнаружил угрозу взлома. Рекомендуем восстановить доступ и усилить защиту"));
  }

  @CsvSource(value = {"AbsD,12345", "AbsD,dr44r"})
  @ParameterizedTest(name = "Проверка кнопки  не помню пароль")
  void CheckingTheRestorePasswordButton(String login) {
    logger.error(login + "что то сделано не так");
    $("a.home-link2.headline__personal-enter.home-link2_color_black").click();
    $("#passp-field-login").setValue(login).pressEnter();
    $("a.Link.Link_pseudo").click();
    $("h1.passp-title").shouldHave
        (text("Введите символы с картинки"));
  }

  @ValueSource(strings = {"12345"})
  @ParameterizedTest(name = "Авторизация с неверным паролем {0}")
  void AuthorizationWithInvalidPassword_1(String pass) {
    logger.error(pass + " что то сделано не так");
    $("button.simple-popup__close ").click();
    $("a.home-link2.headline__personal-enter.home-link2_color_black").click();
    $("#passp-field-login").setValue("AbsD").pressEnter();
    $("#passp-field-passwd").setValue(pass).pressEnter();
    $("div.Description.Description_size_m").shouldHave
        (text("Яндекс обнаружил угрозу взлома. Рекомендуем восстановить доступ и усилить защиту"));
  }

  @CsvFileSource(resources = "/test_data/CheckingTheRestorePasswordButton_1.csv")
  @ParameterizedTest(name = "Проверка кнопки  не помню пароль")
  void CheckingTheRestorePasswordButton_1(String login) {
    logger.error(login + "что то сделано не так");
    $("a.home-link2.headline__personal-enter.home-link2_color_black").click();
    $("#passp-field-login").setValue(login).pressEnter();
    $("a.Link.Link_pseudo").click();
    $("h1.passp-title").shouldHave(text("Введите символы с картинки"));
  }

  @EnumSource(Logopass.class)
  @ParameterizedTest(name = "Авторизация с неверным паролем")
  void AuthorizationWithInvalidPassword_2(Logopass logopass) {
    logger.info(Logopass.pass.description + " что то сделано не так");
    $("button.simple-popup__close ").click();
    $("a.home-link2.headline__personal-enter.home-link2_color_black").click();
    $("#passp-field-login").setValue(Logopass.logo.description).pressEnter();
    $("#passp-field-passwd").setValue(Logopass.pass.description).pressEnter();
    $("div.Description.Description_size_m").shouldHave(
        text("Яндекс обнаружил угрозу взлома. Рекомендуем восстановить доступ и усилить защиту"));
  }
}




