package tecdoc.pages;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.headless;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Selenide;

public class BasePage {

  public BasePage(String url) {
//    browser = "chrome";
//    timeout = 10000;
//    holdBrowserOpen = true;
//    browserPosition = "30x30";
//    browserSize = "1500x500";
    headless = false;

    open(url);
  }
}