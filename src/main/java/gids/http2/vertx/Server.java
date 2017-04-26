package gids.http2.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpServer;

/**
 * @author Thomas Segismont
 */
public class Server {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    HttpServer httpServer = vertx.createHttpServer();

    HttpClient httpClient = vertx.createHttpClient();

    httpServer.requestHandler(clientRequest -> {

      httpClient.getNow(8080, "localhost", "/", backendResponse -> {

        if (backendResponse.statusCode() == 200) {

          backendResponse.bodyHandler(backendResponseBody -> {
            clientRequest.response().end(backendResponseBody);
          });

        }

        clientRequest.response().setStatusCode(500);

      });

    }).listen(8081);

    System.out.println("Ready");

  }

}
