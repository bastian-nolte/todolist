package app.bastiannolte.examples.jee;

import lombok.Getter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoRessource {

  @GET
    public Response sayHello() {
      return Response.ok("Hello").build();
  }
}
