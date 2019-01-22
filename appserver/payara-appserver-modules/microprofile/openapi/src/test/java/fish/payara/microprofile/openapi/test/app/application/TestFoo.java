package fish.payara.microprofile.openapi.test.app.application;

import fish.payara.microprofile.openapi.resource.rule.ApplicationProcessedDocumentSubResource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.responses.APIResponses;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Zdeněk Soukup
 */
@Path("foo")
public class TestFoo {

    public transient static OpenAPI document;

    @BeforeClass
    public static void createDocument() {
        try {
            document = new ApplicationProcessedDocumentSubResource();
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Failed to build document.");
        }
    }

    private ResourceContext rc;

    @GET
    public String getMethod() {
        return "get foo";
    }

    @Path("bar")
    public TestBar sub() {
        return rc.getResource(TestBar.class);
    }

    @Test
    public void subResourceTest() {
        APIResponses responses = document.getPaths().get("/testSubResource/foo").getGET().getResponses();

    }
}
