package tecdoc.steps;

import static com.codeborne.selenide.Selenide.open;
import static tecdoc.pages.TecdocConstants.ORDER_COMPLETE;
import static tecdoc.pages.TecdocConstants.WELCOME_MESSAGE;
import static tecdoc.utils.ActionsHelper.clickElement;
import static tecdoc.utils.ActionsHelper.getMessage;
import static tecdoc.utils.ConfigProvider.TECDOC_URL;
import static tecdoc.utils.DataEnum.USER_EMAIL;
import static tecdoc.utils.ScenarioContext.getScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import tecdoc.ActionsTecdoc;
import tecdoc.pages.MainPage;
import tecdoc.pages.RegisterPage;
import tecdoc.pages.TecDocPage;
import tecdoc.utils.ActionsHelper;

public class MyStepdefs {

  ActionsHelper actionsHelper = new ActionsHelper();
  ActionsTecdoc actionsTecdoc = new ActionsTecdoc();

  TecDocPage tecDocPage = new TecDocPage();

  MainPage mainPage = new MainPage();

  RegisterPage registerPage = new RegisterPage();

  @Given("Page is opened")
  public void loginPageIsOpened() {
    open("https://solutions.tecalliance.net");
//    actionsHelper.navigateTo(TECDOC_URL);

  }
/*
Daca trebuie fara headers
  @And("User enters Credentials to LogIn")
  public void userEntersCredentialsToLogIn(Map<String, String> keyValueMap) {
    keyValueMap.forEach((username, password) -> actionsTecdoc.signIn(username, password));
  }

 */

  @And("User enters Credentials to LogIn")
  public void userEntersCredentialsToLogIn(DataTable userTable) {
    var user = userTable.asMaps();
    var userName = user.get(0).get("Username");
    var passWord = user.get(0).get("Password");
    actionsTecdoc.signIn(userName, passWord);
    getScenarioContext().saveData(USER_EMAIL, userName);
  }


  @Then("User is retrieving the TecDoc licence")
  public void userIsRetrievingTheTecDocLicence() {
    actionsTecdoc.retrieveLicenceTecDoc();
  }

  @And("User clicks on the {string} tab")
  public void userClicksOnTheMyWebLicensesTab(String locator) {
    clickElement(tecDocPage.getItemFromMyAccount(locator));
  }

  @When("User clicks on the {string} button")
  public void userClicksOnTheSignInButton(String locator) {
    clickElement(mainPage.getChangeLanguageTrue());
    clickElement(mainPage.getMyAccountBtn());
    clickElement(tecDocPage.getSignInOrRegisterItem(locator));
  }

  @And("Freeze")
  public void freeze() {
    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Then("User populates mandatory fields having the country set to")
  public void userPopulatesMandatoryFields(DataTable userTable) throws IOException {
    var user = userTable.asMaps();
    var country = user.get(0).get("Country");
    actionsTecdoc.registerTecDoc(country);
    clickElement(registerPage.getContinueBtn());
  }

  @And("User checks the registration is successful")
  public void userChecksTheRegistrationIsSuccessful() {
    getMessage(registerPage.getWelcomeMessage(), WELCOME_MESSAGE);
    System.out.println("Email registration is done");
  }

  @And("User is ordering the TecDoc")
  public void userIsOrderingTheTecDoc() {
    actionsTecdoc.orderTecDoc();
  }

  @And("User checks ordering is successful")
  public void userChecksOrderingIsSuccessful() {
    getMessage(tecDocPage.getThankMessage(), ORDER_COMPLETE);
    System.out.println("TecDoc is ordered");
  }

  @Then("User checks if the email is registered")
  public void userChecksIfTheEmailIsRegistered() {
    actionsTecdoc.emailRegistration();
  }
}