package dev.sanket.filters;

import org.jboss.logging.Logger;

import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ResponseLogger implements ContainerResponseFilter {

    private static final Logger LOG = Logger.getLogger(ResponseLogger.class);

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {

        Object responseEntity = responseContext.getEntity();
        LOG.info("⬅️ RESPONSE: " + (responseEntity != null ? responseEntity.toString() : "null"));
    }
}
