package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entity.Student;

@Path("/json")
public class RESTEasyJSONResource {
	@GET
	@Path("/{name}")
	@Produces("application/json")
	public Student produceJSON( @PathParam("name") String name ) {
		Student st = new Student(name, "Marco",19,12);
		return st;
	}
}
