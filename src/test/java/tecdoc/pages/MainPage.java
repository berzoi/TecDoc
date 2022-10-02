package tecdoc.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class MainPage {

  private final SelenideElement changeLanguageTrue = $("[data-redirect='true']");
  private final SelenideElement myAccountBtn = $("[title='My account'] [class='account--display']");
  private final SelenideElement registerBtn = $("[data-action='open']");
  private final SelenideElement signInBtn = $("[class*='signin-btn']");
}
