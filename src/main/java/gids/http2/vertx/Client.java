package gids.http2.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpVersion;

/**
 * @author Thomas Segismont
 */
public class Client {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    HttpClientOptions options = new HttpClientOptions()
      .setProtocolVersion(HttpVersion.HTTP_2);
    HttpClient httpClient = vertx.createHttpClient(options);

    vertx.setPeriodic(1000, pid -> {
      httpClient.getNow(8081, "localhost", "/", response -> {
        response.bodyHandler(body -> {
          System.out.println("body = " + body);
        });
      });
    });

    System.out.println("Ready");
  }

}
