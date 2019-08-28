import io.vertx.core.Vertx;

public class VertxRestApplication {

	public static void main(String[] args) {

		final DemoVertxServer _httpServerVerticle = new DemoVertxServer();
		final Vertx _vertx = Vertx.vertx();

		_vertx.deployVerticle(_httpServerVerticle);
		
		System.out.println("Servidor no ar com vert.x em: http://localhost:8080/categoria");
	}

}
