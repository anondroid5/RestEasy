package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/message")
public class SimpleMessageResource {
    public SimpleMessageResource() {
    }


    @GET
    @Produces("text/plain")
    public String get() {
        return "Hello ";
    }
    
    
    @GET
    @Path("/{name}")
    @Produces("text/plain")
    public String getMessage(@PathParam("name") String name) {
        return "Hello " + name;
    }
}