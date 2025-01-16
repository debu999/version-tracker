package io.github.debu999;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class VersionInfoProvider {

  private static final Metadata libraryMetadata = new LibraryMetadata();
  private static final Metadata applicationMetadata = new ApplicationMetadata();
  public static String UNKNOWN_VERSION = "UNKNOWN";

  public static Map<String, String> getVersion(Metadata metadata) throws IOException {
    // Get the ClassLoader
    ClassLoader classLoader = VersionInfoProvider.class.getClassLoader();
    String version = UNKNOWN_VERSION;
    try (InputStream input = classLoader.getResourceAsStream(metadata.getFileResourcePath())) {
      if (input != null) {
        Properties properties = new Properties();
        properties.load(input);
        System.out.println(properties);
        var ver = properties.getProperty(metadata.getAttribute());
        version = ver != null ? ver : version;
        System.out.println(metadata.getMessage() + version);
      } else {
        System.out.println("Could not locate " + metadata.getFileResourcePath() + " file");
      }
    }
    return Map.of("version", version);
  }

  public static Map<String, String> getLibraryVersion() throws IOException {
    return getVersion(libraryMetadata);
  }

  public static Map<String, String> getApplicationVersion() throws IOException {
    return getVersion(applicationMetadata);
  }

  public static void main(String[] args) throws IOException {
    System.out.println(getLibraryVersion());
    System.out.println(getApplicationVersion());
  }

  public static Properties getProperties(String path) throws IOException {
    // Get the ClassLoader
    ClassLoader classLoader = VersionInfoProvider.class.getClassLoader();
    try (InputStream input = classLoader.getResourceAsStream(path)) {
      if (input != null) {
        Properties properties = new Properties();
        properties.load(input);
        return properties;
      } else {
        return null;
      }
    }
  }
}