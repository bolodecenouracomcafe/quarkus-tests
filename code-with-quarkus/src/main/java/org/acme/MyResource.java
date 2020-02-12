package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/transaction-test")
public class MyResource {

    @Inject
    MyService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        service.transactionTest();
        return Response.status(Response.Status.OK).build();
    }
}