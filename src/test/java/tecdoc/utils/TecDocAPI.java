package tecdoc.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TecDocAPI {


  @Test
  public void v2() throws IOException {
    URL url = new URL("https://solutions.tecalliance.net/register/saveRegister/sTarget/account/sTargetAction/index");

    // Create a HttpURLConnection object
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");

    // Set the request headers
    conn.setRequestProperty("Accept",
        "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
    conn.setRequestProperty("Accept-Language", "en,en-US;q=0.9,ru;q=0.8,ru-RU;q=0.7");
    conn.setRequestProperty("Cache-Control", "max-age=0");
    conn.setRequestProperty("Connection", "keep-alive");
    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    conn.setRequestProperty("Cookie",
        "session-1=43d0ddc2510d7f1de317b87d7720ce74513462ac6fbf37616f84ba305adbd034; __csrf_token-1=917u0QRPMRmXbFjHO3wuvHaEdNYnTu; session-2=04ebb244b5bd6d1805fe05c03ee8c13c6d43e855c4fd8fb61958307cda96a91d; shop=2; __csrf_token-2=l8g14AgbcbiiM2i0gY1wg7MPwmC5sy; cookieconsent_status=dismiss; x-ua-device=tablet");
    conn.setRequestProperty("Origin", "https://solutions.tecalliance.net");
    conn.setRequestProperty("Referer", "https://solutions.tecalliance.net/account/login/sTarget/account/sTargetAction/index");
    conn.setRequestProperty("Sec-Fetch-Dest", "document");
    conn.setRequestProperty("Sec-Fetch-Mode", "navigate");
    conn.setRequestProperty("Sec-Fetch-Site", "same-origin");
    conn.setRequestProperty("Sec-Fetch-User", "?1");
    conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
    conn.setRequestProperty("User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 OPR/99.0.0.0");
    conn.setRequestProperty("sec-ch-ua", "\"Opera\";v=\"99\", \"Chromium\";v=\"113\", \"Not-A.Brand\";v=\"24\"");
    conn.setRequestProperty("sec-ch-ua-mobile", "?0");
    conn.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");

    // Prepare the form data
//    String formData = "register%5Bpersonal%5D%5Bcustomer_type%5D=business&register%5Bpersonal%5D%5Bsalutation%5D=mr&register%5Bpersonal%5D%5Bfirstname%5D=Vasile&register%5Bpersonal%5D%5Blastname%5D=Vasiloi&register%5Bpersonal%5D%5Baccountmode%5D=0&register%5Bpersonal%5D%5Bemail%5D=berzoi0223.07%40gmail.com&register%5Bpersonal%5D%5BemailConfirmation%5D=berzoi0223.07%40gmail.com&register%5Bpersonal%5D%5Bpassword%5D=Public321%24&register%5Bpersonal%5D%5Bphone%5D=%2B37360118850&register%5Bpersonal%5D%5Battribute%5D%5Btext4%5D=500000001&register%5Bpersonal%5D%5Battribute%5D%5Btext5%5D=117660002&register%5Bbilling%5D%5Bcompany%5D=Iasi+and+Co&register%5Bbilling%5D%5Bdepartment%5D=&register%5Bbilling%5D%5BvatId%5D=&register%5Bbilling%5D%5Bstreet%5D=Traian+258&register%5Bbilling%5D%5Bzipcode%5D=2060&register%5Bbilling%5D%5Bcity%5D=Chisinau&register%5Bbilling%5D%5Bcountry%5D=193&Submit=&__csrf_token=l8g14AgbcbiiM2i0gY1wg7MPwmC5sy";
    // good one
//    String formData = "register[personal][customer_type]=business&register[personal][salutation]=mr&register[personal][firstname]=Nelu&register[personal][lastname]=Ionel&register[personal][accountmode]=0&register[personal][email]=berzoi0223.08@gmail.com&register[personal][emailConfirmation]=berzoi0223.08@gmail.com&register[personal][password]=Public321$&register[personal][phone]=+37360118850&register[personal][attribute][text4]=500000001&register[personal][attribute][text5]=117660002&register[billing][company]=Iasi and Co&register[billing][department]=&register[billing][vatId]=&register[billing][street]=Traian 258&register[billing][zipcode]=2060&register[billing][city]=Chisinau&register[billing][country]=193&Submit=&__csrf_token=l8g14AgbcbiiM2i0gY1wg7MPwmC5sy";
    String formData = "register[personal][customer_type]=business" +
        "&register[personal][salutation]=mr" +
        "&register[personal][firstname]=Nelu" +
        "&register[personal][lastname]=Ionel" +
        "&register[personal][accountmode]=0" +
        "&register[personal][email]=berzoi0223.08@gmail.com" +
        "&register[personal][emailConfirmation]=berzoi0223.08@gmail.com" +
        "&register[personal][password]=Public321$" +
        "&register[personal][phone]=+37360118850" +
        "&register[personal][attribute][text4]=500000001" +
        "&register[personal][attribute][text5]=117660002" +
        "&register[billing][company]=Iasi and Co" +
        "&register[billing][department]=" +
        "&register[billing][vatId]=" +
        "&register[billing][street]=Traian 258" +
        "&register[billing][zipcode]=2060" +
        "&register[billing][city]=Chisinau" +
        "&register[billing][country]=193" +
        "&Submit=" +
        "&__csrf_token=l8g14AgbcbiiM2i0gY1wg7MPwmC5sy";

    // URL encode the form data
//    String encodedFormData = URLEncoder.encode(formData, "UTF-8");

    // Write the form data to the request body
    try (OutputStream outputStream = conn.getOutputStream()) {
      byte[] formDataBytes = formData.getBytes("UTF-8");
      outputStream.write(formDataBytes, 0, formDataBytes.length);
    }

    // Get the response
    int responseCode = conn.getResponseCode();
    System.out.println("Response Code: " + responseCode);

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
      String line;
      StringBuilder response = new StringBuilder();
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      System.out.println("Response: " + response.toString());
    }

    // Close the connection
    conn.disconnect();
  }

  @Test
  public void v3() throws IOException {
    try {
      URL url = new URL("https://solutions.tecalliance.net/register/saveRegister/sTarget/account/sTargetAction/index");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");

      Map<String, String> headers = new HashMap<>();
      headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
      headers.put("Accept-Language", "en,en-US;q=0.9,ru;q=0.8,ru-RU;q=0.7");
      headers.put("Cache-Control", "max-age=0");
      headers.put("Connection", "keep-alive");
      headers.put("Content-Type", "application/x-www-form-urlencoded");
      headers.put("Cookie", "session-1=43d0ddc2510d7f1de317b87d7720ce74513462ac6fbf37616f84ba305adbd034; __csrf_token-1=917u0QRPMRmXbFjHO3wuvHaEdNYnTu; session-2=04ebb244b5bd6d1805fe05c03ee8c13c6d43e855c4fd8fb61958307cda96a91d; shop=2; __csrf_token-2=l8g14AgbcbiiM2i0gY1wg7MPwmC5sy; cookieconsent_status=dismiss; x-ua-device=tablet");
      headers.put("Origin", "https://solutions.tecalliance.net");
      headers.put("Referer", "https://solutions.tecalliance.net/account/login/sTarget/account/sTargetAction/index");
      headers.put("Sec-Fetch-Dest", "document");
      headers.put("Sec-Fetch-Mode", "navigate");
      headers.put("Sec-Fetch-Site", "same-origin");
      headers.put("Sec-Fetch-User", "?1");
      headers.put("Upgrade-Insecure-Requests", "1");
      headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 OPR/99.0.0.0");
      headers.put("sec-ch-ua", "\"Opera\";v=\"99\", \"Chromium\";v=\"113\", \"Not-A.Brand\";v=\"24\"");
      headers.put("sec-ch-ua-mobile", "?0");
      headers.put("sec-ch-ua-platform", "\"Windows\"");

      for (Map.Entry<String, String> entry : headers.entrySet()) {
        connection.setRequestProperty(entry.getKey(), entry.getValue());
      }

      String formData = "register[personal][customer_type]=business" +
          "&register[personal][salutation]=mr" +
          "&register[personal][firstname]=Costea" +
          "&register[personal][lastname]=Ionel" +
          "&register[personal][accountmode]=0" +
          "&register[personal][email]=mts_0628@gmail.com" +
          "&register[personal][emailConfirmation]=mts_0628@gmail.com" +
          "&register[personal][password]=Public321$" +
          "&register[personal][phone]=+37360118850" +
          "&register[personal][attribute][text4]=500000001" +
          "&register[personal][attribute][text5]=117660002" +
          "&register[billing][company]=Iasi and Co" +
          "&register[billing][department]=" +
          "&register[billing][vatId]=" +
          "&register[billing][street]=Traian 258" +
          "&register[billing][zipcode]=2060" +
          "&register[billing][city]=Chisinau" +
          "&register[billing][country]=193" +
          "&Submit=" +
          "&__csrf_token=l8g14AgbcbiiM2i0gY1wg7MPwmC5sy";
      connection.setDoOutput(true);
      OutputStream outputStream = connection.getOutputStream();
      outputStream.write(formData.getBytes());
      outputStream.flush();
      outputStream.close();

      int responseCode = connection.getResponseCode();

      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      StringBuilder response = new StringBuilder();

      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      reader.close();

      System.out.println("Response Code: " + responseCode);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

