package tecdoc.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class TecDocPage {


  private final SelenideElement tecdocBtn = $("[aria-label='TecDoc Catalogue']");

  private final SelenideElement tecdocDemoBtn = $(
      "[class='product--title'][title*='TecDoc Catalogue DEMO']");
  private final SelenideElement addToCart = $("[class='buy-btn--cart-add']");
  private final SelenideElement proceedBtn = $("[title='Proceed to checkout']");
  private final SelenideElement updatePaymentBtn = $("[class='btn is--small btn--change-payment']");
  private final SelenideElement paymentInAdvance = $(
      "[class='payment--method block method_last'] [class='method--input']");
  private final SelenideElement nextBtn = $(
      "[class='confirm--actions table--actions block'] [class*='btn']");
  private final SelenideElement policyBtn = $("[type='checkbox']");
  private final SelenideElement completePayment = $("[form='confirm--form']");
  private final SelenideElement thankMessage = $(
      "[class='panel--title teaser--title is--align-center']");
  private final SelenideElement myWebLicenses = $(
      "div[class='sidebar--categories-wrapper'] li:nth-child(6)");
  private final SelenideElement username = $("[class*='order--username'] [class='column--value']");
  private final SelenideElement password = $("[class*='order--password'] [class='column--value']");
  private final SelenideElement alertNoLicence = $("[class='alert--content']");
  private final SelenideElement exclamationTriangle = $(".fa.fa-exclamation-triangle");
  private final SelenideElement expiryDate = $(
      "[class='order--date panel--td column--date'] [class='column--value']");

  public SelenideElement getItemFromMyAccount(String locator) {
    return $x(
        "//div[@class='sidebar--categories-wrapper']//a[@class='navigation--link'][normalize-space()='"
            + locator + "']");
  }

  public SelenideElement getSignInOrRegisterItem(String locator) {
    return $x("//a[contains(text(),'" + locator + "')]");
  }
}