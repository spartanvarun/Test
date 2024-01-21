package Reactive;

import controller.ValidateAPI;
import domain.Persons;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/reactive")
@Produces(MediaType.APPLICATION_JSON)
public class ReactiveMutiny {
    @Inject
    ValidateAPI c;
    @Path("/persons")
    @GET
    public Multi<Persons> getList(@HeaderParam("X-API-Key") String apiKey) {
        if (!c.isValidApiKey(apiKey)) {
            throw new WebApplicationException("Unauthorized: Invalid API Key", 401);
        }
        return Multi.createFrom().items(() -> Persons.findAll().stream());
    }


    @GET
    @Path("/persons/id")
    public Uni<Persons> getById(@HeaderParam("X-API-Key") String apiKey, @QueryParam("id") long id) {

        if (!c.isValidApiKey(apiKey)) {
            throw new WebApplicationException("Unauthorized: Invalid API Key", 401);
        }

        Persons obj = Persons.findById(id);
        if (obj == null) {
            throw new WebApplicationException("Person with this id does not exist!", 404);
        }
        return Uni.createFrom().item(obj);

    }
    @GET
    @Path("/sum")
    public Uni<Integer> sum(@QueryParam("a") int a, @QueryParam("b") int b) {
        // System.out.println("varun");
        return Uni.createFrom().item(() -> a + b);
        //  System.out.println("varun1");
    }


}