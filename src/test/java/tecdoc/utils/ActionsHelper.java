package tecdoc.utils;

import static com.codeborne.selenide.Condition.text;

import com.codeborne.selenide.SelenideElement;
import tecdoc.pages.BasePage;

public class ActionsHelper {

  public static void clickElement(SelenideElement element) {
    element.scrollTo().click();
  }

  public static void getMessage(SelenideElement element, String message) {
    element.shouldHave(text(message));
  }

  public void navigateTo(String url) {
    new BasePage(url);
  }
}
