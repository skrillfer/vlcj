package uk.co.caprica.vlcj.mrl;

/**
 * Implementation for a web-style URL.
 * <p>
 * This class provides a fluent API for initialising the MRL, e.g.
 * <pre>
 * String mrl = new WebMrl().type("http")
 *                          .host("www.myhost.com")
 *                          .port("8080")
 *                          .path("/media/example.mp4")
 *                          .value();
 * </pre>
 * This will generate <code>"http://www.myhost.com:8080/media/example.mp4"</code>.
 */
public class WebMrl implements Mrl {

  /**
   * 
   */
  private String type;
  
  /**
   * 
   */
  private String host;
  
  /**
   * 
   */
  private int port = -1;

  /**
   * 
   */
  private String path;

  /**
   * 
   */
  private String value;
  
  public WebMrl type(String type) {
    this.type = type;
    return this;
  }
  
  public WebMrl host(String host) {
    this.host = host;
    return this;
  }

  public WebMrl port(int port) {
    this.port = port;
    return this;
  }
  
  public WebMrl path(String path) {
    this.path = path;
    return this;
  }

  @Override
  public String value() {
    if(value == null) {
      value = constructValue();
    }
    return value;
  }

  private String constructValue() {
    StringBuilder sb = new StringBuilder(40);
    sb.append(type);
    sb.append("://");
    sb.append(host);
    if(port != -1) {
      sb.append(':');
      sb.append(port);
    }
    if(path != null) {
      sb.append(path);
    }
    return sb.toString();
  }
}
