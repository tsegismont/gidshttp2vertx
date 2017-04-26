package gids.http2.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

/**
 * @author Thomas Segismont
 */
public class Backend {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    HttpServer httpServer = vertx.createHttpServer();

    httpServer.requestHandler(request -> {
      vertx.setTimer(500, tid -> {
        request.response().end("Hello from backend\n");
      });
    }).listen(8080);
  }

}
