package org.doogle;

public class LibraryMetadata implements Metadata {

  // Specify the groupId and artifactId of the library you're interested in
  public static String GROUP_ID = "org.doogle";
  public static String ARTIFACT_ID = "version-tracker";
  public static String LIBRARY_PROPERTIES_PATH = String.format(
      "META-INF/maven/%s/%s/pom.properties", GROUP_ID, ARTIFACT_ID);
  public static String LIBRARY_VERSION_ATTRIBUTE = "version";


  @Override
  public String getFileResourcePath() {
    return LIBRARY_PROPERTIES_PATH;
  }

  @Override
  public String getAttribute() {
    return LIBRARY_VERSION_ATTRIBUTE;
  }

  @Override
  public String getMessage() {
    return "Version of " + GROUP_ID + ":" + ARTIFACT_ID + " is:";
  }
}
