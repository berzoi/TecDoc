package tecdoc.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class RegisterPage {

  private final SelenideElement salutation = $("[id='salutation']");
//  private final String salutationMr = "mr";
  private final SelenideElement firstname = $("[id='firstname']");
  private final SelenideElement lastname = $("[id='lastname']");
  private final SelenideElement email = $("[id='register_personal_email']");
  private final SelenideElement emailConfirmation = $("[id='register_personal_emailConfirmation']");
  private final SelenideElement password = $("[id='register_personal_password']");
  private final SelenideElement phone = $("[id='phone']");
  private final SelenideElement language = $("[id='text4']");
  private final SelenideElement business = $("[id='text5']");
  private final SelenideElement companyName = $("[placeholder='Company name*']");
  private final SelenideElement street = $("[id='street']");
  private final SelenideElement zipcode = $("[id='zipcode']");
  private final SelenideElement city = $("[id='city']");
  private final SelenideElement country = $("[id='country']");
  private final SelenideElement continueBtn = $("[class*='register--submit']");
  private final SelenideElement welcomeMessage = $("[class='panel--title']");
  private final ElementsCollection countries =  $$("[id='country']");
  public SelenideElement getCountryByName(String locator) {
    return $x("//option[contains(text(),'" + locator + "')]");
  }
}