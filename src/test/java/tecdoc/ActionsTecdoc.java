package tecdoc;

import static tecdoc.pages.TecdocConstants.ENGLISH;
import static tecdoc.pages.TecdocConstants.MR;
import static tecdoc.pages.TecdocConstants.PASSWORD;
import static tecdoc.pages.TecdocConstants.WORKSHOP;
import static tecdoc.utils.ActionsHelper.clickElement;
import static tecdoc.utils.DataEnum.USER_EMAIL;
import static tecdoc.utils.ScenarioContext.getScenarioContext;

import java.io.IOException;
import tecdoc.pages.MainPage;
import tecdoc.pages.RegisterPage;
import tecdoc.pages.SignInPage;
import tecdoc.pages.TecDocPage;
import tecdoc.utils.Credentials;
import tecdoc.utils.JavaFaker;

public class ActionsTecdoc extends JavaFaker {

  MainPage mainPage = new MainPage();
  RegisterPage registerPage = new RegisterPage();
  SignInPage signInPage = new SignInPage();

  TecDocPage tecDocPage = new TecDocPage();
  Credentials write = new Credentials();

  public void registerTecDoc(String country) throws IOException {
//    clickElement(mainPage.getChangeLanguageTrue());
//    clickElement(mainPage.getMyAccountBtn());
//    clickElement(mainPage.getRegisterBtn());
    registerPage.getSalutation().selectOptionByValue(MR);
    registerPage.getFirstname().sendKeys(firstName);
    registerPage.getLastname().sendKeys(lastName);
    registerPage.getEmail().sendKeys(email);
    registerPage.getEmailConfirmation().sendKeys(email);
    registerPage.getPassword().sendKeys(PASSWORD);
    registerPage.getPhone().sendKeys(cellPhone);
    registerPage.getLanguage().selectOptionByValue(ENGLISH);
    registerPage.getBusiness().selectOptionByValue(WORKSHOP);
    registerPage.getCompanyName().sendKeys(company);
    registerPage.getStreet().sendKeys(streetAddress);
    registerPage.getZipcode().sendKeys(zipCode);
    registerPage.getCity().sendKeys(cityName);
    clickElement(registerPage.getCountry());
    clickElement(registerPage.getCountryByName(country));
    write.writeCredentials(email);
  }

//  public void signIn(String email, String password) {
//    clickElement(mainPage.getChangeLanguageTrue());
//    clickElement(mainPage.getMyAccountBtn());
//    clickElement(mainPage.getSignInBtn());
//    signInPage.performLogin(email, password);
//  }

  public void signIn(String email, String password){
    signInPage.performLogin(email, password);
  }

  public void emailRegistration(){
    if (tecDocPage.getExclamationTriangle().exists()){
      System.out.println("TecDoc cannot be ordered yet");
    } else {
      System.out.println("TecDoc can be ordered");
    }
  }

  public void orderTecDoc() {
      clickElement(tecDocPage.getTecdocBtn());
      clickElement(tecDocPage.getTecdocDemoBtn());
      clickElement(tecDocPage.getAddToCart());
      clickElement(tecDocPage.getProceedBtn());
      clickElement(tecDocPage.getUpdatePaymentBtn());
      clickElement(tecDocPage.getPaymentInAdvance());
      clickElement(tecDocPage.getNextBtn());
      clickElement(tecDocPage.getPolicyBtn());
      clickElement(tecDocPage.getCompletePayment());
  }

  public void retrieveLicenceTecDoc() {
//    clickElement(tecDocPage.getMyWebLicenses());
//    if (tecDocPage.getAlertNoLicence().exists()) {
//      System.out.println("You have not yet purchased any licences");
//    } else {
//      System.out.println("Email       = " + email);
//      System.out.println("Username    = " + tecDocPage.getUsername().getText());
//      System.out.println("Password    = " + tecDocPage.getPassword().getText());
//      System.out.println("Expiry Date = " + tecDocPage.getExpiryDate().getText());
//    }

    if (tecDocPage.getAlertNoLicence().exists()) {
      System.out.println("You have not yet purchased any licences");
    } else {
      System.out.println("Email       = " + getScenarioContext().getData(USER_EMAIL));
      System.out.println("Username    = " + tecDocPage.getUsername().getText());
      System.out.println("Password    = " + tecDocPage.getPassword().getText());
      System.out.println("Expiry Date = " + tecDocPage.getExpiryDate().getText());
    }
  }
  public void getCountries() {
    clickElement(mainPage.getChangeLanguageTrue());
    clickElement(mainPage.getMyAccountBtn());
    clickElement(mainPage.getRegisterBtn());
    var texts = registerPage.getCountries().texts();
    System.out.println("texts = " + texts);
  }
}
