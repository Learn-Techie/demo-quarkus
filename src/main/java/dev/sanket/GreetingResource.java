package dev.sanket;

import dev.sanket.records.Employee;
import dev.sanket.records.Employee;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/employee")
    public Employee employeeDetails() {
        return new Employee(1L, "Sanket Shirke");
    }

}
