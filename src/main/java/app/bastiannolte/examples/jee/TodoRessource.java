package app.bastiannolte.examples.jee;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoRessource {

    @Inject
    TodoService todoService;

    @GET
    public Response getAllTodos() {
        return Response.ok(todoService.liefereAlleTodos()).build();
    }

    @GET
    @Path("{uuid}")
    public Response getTodoByUuid(@PathParam("uuid") UUID uuid) {
        return Response.ok(todoService.liefereTodoMitUuid(uuid)).build();
    }

    @POST
    public Response postTodo(String text) {
        return Response.ok(todoService.erstelleTodo(text)).build();
    }
}

