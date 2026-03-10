package skyjo.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/test-old")
public class Test {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "HELLO_12345";
    }
}
