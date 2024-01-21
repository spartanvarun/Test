package MicroProfileRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
@Path("/singlesearch")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface TvProxy {
 //   https://api.tvmaze.com/shows/1/episodes
   // https://api.tvmaze.com/singlesearch/shows?q=game%20of%20throees
    @GET
    @Path("/shows")
    TvSeriesModel get(@QueryParam("q") String title);
}
