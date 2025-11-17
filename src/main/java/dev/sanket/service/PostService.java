package dev.sanket.service;

import dev.sanket.client.JsonPlaceholderClient;
import dev.sanket.model.Post;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import java.util.List;

@ApplicationScoped
public class PostService {

    private static final Logger LOG = Logger.getLogger(PostService.class);

    @Inject
    @RestClient
    JsonPlaceholderClient client;

    public List<Post> getAllPosts() {
        LOG.debug("Getting all posts");
        return client.getPosts();
    }

    public Post getPostById(Long id) {
        LOG.debugf("Getting post with id: %d", id);
        return client.getPostById(id);
    }

    public Post createPost(Post post) {
        LOG.debugf("Creating post: %s", post);
        return client.createPost(post);
    }
}