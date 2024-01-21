package MicroProfileRestClient;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/shows")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://api.tvmaze.com")
public interface EpisodeProxy {
 //https://api.tvmaze.com/shows/82/episodes
 // https://api.tvmaze.com/shows/1/episodes
 // https://api.tvmaze.com/shows/1/episodes
  @GET
  @Path("/{id}/episodes")
  List<EpisodeModel> get(@PathParam("id") Long id);

}
