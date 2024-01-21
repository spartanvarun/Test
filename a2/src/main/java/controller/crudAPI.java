package controller;

import io.smallrye.common.constraint.NotNull;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import domain.Persons;
import org.jboss.logging.Logger;

//import io.vertx.axle.core.Context;
//import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;
//import org.slf4j.Logger;


@Path("/Persons")
@Produces(MediaType.APPLICATION_JSON)
public class crudAPI {
 @Inject
 ValidateAPI c;

 public static final Logger log=Logger.getLogger(crudAPI.class);

 //        logger.trace("This is a trace message.");
//        logger.debug("This is a debug message.");
//        logger.info("This is an info message.");
//        logger.warn("This is a warning message.");
//        logger.error("This is an error message.");


// @Inject
//    Logger logger;
// @Inject
//    InjectChecking s;
// @Inject
//    RepositoryJ x;


    @GET
  public Response getList(@HeaderParam("X-API-Key") String apiKey) {
        if (!c.isValidApiKey(apiKey)) {
            log.info("line 37 executed perfectly");
            throw new WebApplicationException("Unauthorized: Invalid API Key", 401);
        }
        List<Persons> l =Persons.findAll().list();
        return Response.ok(l).build();
    }


    @GET
    @Path("/id")
    public Response getById(@HeaderParam("X-API-Key") String apiKey, @QueryParam("id") long id) {

        if (!c.isValidApiKey(apiKey)) {
            throw new WebApplicationException("Unauthorized: Invalid API Key", 401);
        }

        Persons obj = Persons.findById(id);
        if (obj == null) {
            throw new WebApplicationException("Person with this id does not exist!", 404);
        }

        return Response.ok(obj).build();
    }



    @GET
    @Path("/firstName")
    public Response findByFirstName(@HeaderParam("X-API-Key") String apiKey,@QueryParam("firstName") String firstName) {
        if (!c.isValidApiKey(apiKey)) {
            throw new WebApplicationException("Unauthorized: Invalid API Key", 401);
        }
        //Persons.findy
        List<Persons> l = Persons.findByFirstName(firstName);
        return Response.ok(l).build();
    }


    @GET
    @Path("/age")
    public Response findByFirstName(@HeaderParam("X-API-Key") String apiKey,@QueryParam("age") int age) {
        if (!c.isValidApiKey(apiKey)) {
            throw new WebApplicationException("Unauthorized: Invalid API Key", 401);
        }

        List<Persons> l = Persons.findByAge(age);
        return Response.ok(l).build();
    }

    @POST
    @Transactional
    public Response save(@HeaderParam("X-API-Key") String apiKey, @NotNull Personmodel model) {

        if (!c.isValidApiKey(apiKey)) {
            throw new WebApplicationException("Unauthorized: Invalid API Key", 401);
        }

        Persons obj = new Persons(model.getFirstname(), model.getLastname(), model.getAge());
        obj.persist();
        return Response.ok(obj).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@HeaderParam("X-API-Key") String apiKey, @PathParam("id") long id, @NotNull Personmodel model) {

        if (!c.isValidApiKey(apiKey)) {
            throw new WebApplicationException("Unauthorized: Invalid API Key",401);
        }

        Persons obj = Persons.findById(id);
        if (obj == null) {
            throw new WebApplicationException("Person with this id does not exist!",404);
        }
        obj.setFirstname(model.getFirstname());
        obj.setLastname(model.getLastname());
        obj.setAge(model.getAge());
        obj.persist();
        return Response.ok(obj).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response Delete(@HeaderParam("X-API-Key") String apiKey, @PathParam("id") long id) {

        if (!c.isValidApiKey(apiKey)) {
            throw new WebApplicationException("Unauthorized: Invalid API Key",401);
        }
        Persons obj = Persons.findById(id);
        if (obj == null) {
            throw new WebApplicationException("Person with this id does not exist!",404);
        }

        obj.delete();
        return Response.ok("Deleted successfully!").build();
    }
}