package gids.http2.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

/**
 * @author Thomas Segismont
 */
public class Server {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    HttpServer httpServer = vertx.createHttpServer();

    httpServer.requestHandler(clientRequest -> {

      clientRequest.response().end("Hello from server\n");

    }).listen(8081);

    System.out.println("Ready");

  }

}
