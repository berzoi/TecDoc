package tecdoc.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

  static Config readConfig() {
    return ConfigFactory.systemProperties().hasPath("testProfile")
        ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
        : ConfigFactory.load("application.conf");
  }

  String TECDOC_URL = readConfig().getString("userParams.tecdoc.urlSolutions");
}