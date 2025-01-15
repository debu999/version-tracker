package org.doogle;

public class ApplicationMetadata implements Metadata {

  public static String SPRING_BOOT_MANIFEST_PATH = "META-INF/MANIFEST.MF";
  public static String SPRING_BOOT_VERSION_ATTRIBUTE = "Implementation-Version";

  @Override
  public String getFileResourcePath() {
    return SPRING_BOOT_MANIFEST_PATH;
  }

  @Override
  public String getAttribute() {
    return SPRING_BOOT_VERSION_ATTRIBUTE;
  }

  @Override
  public String getMessage() {
    return "Version of Spring Boot Application is:";
  }

}
