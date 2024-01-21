package MicroProfileRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@Path("/tvseries")
@Produces(MediaType.APPLICATION_JSON)
public class TvResource {
    //http:localhost:8080.tvseries/name/episodes
    @RestClient
    TvProxy proxy;
 //   https://api.tvmaze.com/shows/82/episodes
    @RestClient
    EpisodeProxy Proxy1;
    private List<TvSeriesModel> l=new ArrayList();
    @Path("/name")
    @GET
    public Response Name(@QueryParam("title") String title){
        TvSeriesModel obj=  getName(title);
        l.add(obj);
        return Response.ok(l).build();
    }
    @Path("/name/episodes")
    @GET
    public Response Episodes(@QueryParam("title") String title){
      TvSeriesModel obj=  getName(title);
  List<EpisodeModel> Episodes=Proxy1.get(obj.getId());
    //  l.add(obj);
        return Response.ok(Episodes).build();
    }
   // @Fault Tolerance
   @Fallback(fallbackMethod = "check")
    public TvSeriesModel getName(String title){
       return  proxy.get(title);
    }
    private TvSeriesModel check(String title) {

         TvSeriesModel obj=new TvSeriesModel();
         obj.setId(1L);
         return obj;
    }


}
