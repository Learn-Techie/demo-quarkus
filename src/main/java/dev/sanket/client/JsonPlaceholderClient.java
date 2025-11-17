package dev.sanket.client;

import dev.sanket.model.Post;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/posts")
@RegisterRestClient(configKey = "jsonplaceholder-api")
public interface JsonPlaceholderClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Post> getPosts();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Post getPostById(@PathParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Post createPost(Post post);
}