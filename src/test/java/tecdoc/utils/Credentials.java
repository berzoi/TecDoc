package tecdoc.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Credentials extends JavaFaker {

  public void writeCredentials(String email) throws IOException {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
    String time = dtf.format(LocalDateTime.now());
    String path = "src/test/java/credentials/tecdoc ".concat(time);
    File myObj = new File(path);
//    myObj.createNewFile();
    FileWriter myWriter = new FileWriter(path);
    myWriter.write(email);
    myWriter.close();
  }
}