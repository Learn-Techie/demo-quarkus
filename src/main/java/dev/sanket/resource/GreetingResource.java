package dev.sanket.resource;

import dev.sanket.model.Post;
import dev.sanket.records.Employee;
import dev.sanket.service.PostService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/api/v1")
public class GreetingResource {
    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @Inject
    PostService postService;



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

    @GET
    @Path("/posts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post getPostById(@PathParam("id") Long id) {
        LOG.infof("REST request to get post with id: %d", id);
        return postService.getPostById(id);
    }

    @GET
    @Path("/posts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAllPosts() {
        LOG.info("REST request to get all posts");
        return postService.getAllPosts();
    }

    @POST
    @Path("/create-post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Post createPost(Post post) {
        return postService.createPost(post);
    }



}
