package org.simpleservice;

import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.simpleservice.entity.SuggestedName;

/**
 *
 * @author Juneau
 */
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Path("suggestedNameService")
public class SuggestedNameService {

    @PersistenceContext(unitName = "SimpleService_1.0PU")
    private EntityManager em;

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") BigDecimal id) {
        SuggestedName suggestedName = em.createNamedQuery("SuggestedName.find", SuggestedName.class)
                .setParameter("id", id)
                .getSingleResult();

        return suggestedName != null
                ? Response.ok(suggestedName).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public Response findAll() {
        List<SuggestedName> suggestedNames = em.createNamedQuery("SuggestedName.findAll").getResultList();
        GenericEntity<List<SuggestedName>> list = new GenericEntity<List<SuggestedName>>(suggestedNames) {};
        return Response.ok(list).build();
    }

}
