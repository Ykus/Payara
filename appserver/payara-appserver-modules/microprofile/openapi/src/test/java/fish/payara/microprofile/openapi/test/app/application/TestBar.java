package fish.payara.microprofile.openapi.test.app.application;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

/**
 *
 * @author Zdeněk Soukup
 */
public class TestBar {

    @GET
    public Response barMethod() {
        return Response.ok().entity("bar").build();
    }
}
