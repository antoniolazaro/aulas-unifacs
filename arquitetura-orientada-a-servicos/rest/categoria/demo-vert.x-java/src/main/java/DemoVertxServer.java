import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class DemoVertxServer extends AbstractVerticle {

	@Override
	public void start(Future<Void> future) {

		Router router = Router.router(vertx);
		router.route().handler(BodyHandler.create());
		
		router.get("/categoria").handler(this::get);
		router.get("/categoria/:id").handler(this::getById);
		router.post("/categoria").handler(BodyHandler.create()).handler(this::post);
		router.put("/categoria/:id").handler(BodyHandler.create()).handler(this::put);;
		router.delete("/categoria/:id").handler(this::delete);;
		

		vertx.createHttpServer().requestHandler(router::accept).listen(8080, "127.0.0.1", result -> {
			if (result.succeeded()) {
				future.complete();
			} else {
				future.fail(result.cause());
			}
		});
	}

	private void get(RoutingContext routingContext) {
		try {
			sendSuccess(Json.encodePrettily(CategoriaBD.bd.values()), routingContext.response());
		} catch (Exception ex) {
			sendError(ex.getMessage(), routingContext.response());
		}

	}
	
	private void getById(RoutingContext routingContext) {
		try {

			Categoria categoriaEncontrada = obterPorChave(routingContext);
			if (categoriaEncontrada != null) {
				sendSuccess(Json.encodePrettily(categoriaEncontrada), routingContext.response());
			} else {
				sendError(404,"Categoria não encontrada", routingContext.response());
			}
		} catch (Exception ex) {
			sendError(ex.getMessage(), routingContext.response());
		}
	}

	private Categoria obterPorChave(RoutingContext routingContext) {
		Categoria categoriaEncontrada = CategoriaBD.bd.get(Long.valueOf(routingContext.request().getParam("id")));
		return categoriaEncontrada;
	}
	

	private void post(RoutingContext routingContext) {
		try {
			Categoria category = Json.decodeValue(routingContext.getBodyAsString(),Categoria.class);
			CategoriaBD.bd.put(category.getId(),category);
			sendSuccess(Json.encodePrettily("Inserido com sucesso"), routingContext.response());
		} catch (Exception ex) {
			sendError(ex.getMessage(), routingContext.response());
		}

	}
	
	private void put(RoutingContext routingContext) {
		try {
			Categoria categoriaEncontrada = obterPorChave(routingContext);
			Categoria categoriaAtualizada = Json.decodeValue(routingContext.getBodyAsString(),Categoria.class);
			if (categoriaEncontrada != null) {
				CategoriaBD.bd.put(categoriaEncontrada.getId(),categoriaAtualizada);
				sendSuccess(Json.encodePrettily("Atualizado com sucesso"), routingContext.response());
			} else {
				sendError(404,"Categoria não encontrada", routingContext.response());
			}
			
		} catch (Exception ex) {
			sendError(ex.getMessage(), routingContext.response());
		}

	}

	private void delete(RoutingContext routingContext) {
		try {
			Categoria categoriaEncontrada = obterPorChave(routingContext);
			if (categoriaEncontrada != null) {
				CategoriaBD.bd.remove(categoriaEncontrada.getId());
				sendSuccess(Json.encodePrettily("Excluído com sucesso"), routingContext.response());
			} else {
				sendError(404,"Categoria não encontrada", routingContext.response());
			}
		} catch (Exception ex) {
			sendError(ex.getMessage(), routingContext.response());
		}

	}

	
	private void sendError(Integer statusCode,String errorMessage, HttpServerResponse response) {
		JsonObject jo = new JsonObject();
		jo.put("errorMessage", errorMessage);

		response.setStatusCode(statusCode).putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(jo));
	}

	private void sendError(String errorMessage, HttpServerResponse response) {
		JsonObject jo = new JsonObject();
		jo.put("errorMessage", errorMessage);

		response.setStatusCode(500).putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(jo));
	}

	private void sendSuccess(String responseBody, HttpServerResponse response) {
		response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8").end(responseBody);
	}

}
