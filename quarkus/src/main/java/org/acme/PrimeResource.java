package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-quarkus")
public class PrimeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{input}")
    public Payload primes(@PathParam("input") Long input) {
        return Payload.generate(input);
    }
}