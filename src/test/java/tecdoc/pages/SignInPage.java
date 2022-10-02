package tecdoc.pages;

import static com.codeborne.selenide.Selenide.$;
import static tecdoc.utils.ActionsHelper.clickElement;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class SignInPage {

  private final SelenideElement email = $("[name='email']");
  private final SelenideElement password = $("[name='password']");
  private final SelenideElement loginBtn = $("[class*='register--login-btn']");

  public void performLogin(String email, String password){
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    getEmail().sendKeys(email);
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    getPassword().sendKeys(password);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    clickElement(loginBtn);
  }
}
