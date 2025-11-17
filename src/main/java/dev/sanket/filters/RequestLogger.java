package dev.sanket.filters;

import org.jboss.logging.Logger;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Provider
public class RequestLogger implements ContainerRequestFilter {

    private static final Logger LOG = Logger.getLogger(RequestLogger.class);

    @Override
    public void filter(ContainerRequestContext context) throws IOException {

        byte[] bytes = context.getEntityStream().readAllBytes();
        String body = new String(bytes);

        LOG.info("➡️ REQUEST: " + body);

        // Restore body for JAX-RS to read
        context.setEntityStream(new ByteArrayInputStream(bytes));
    }
}
