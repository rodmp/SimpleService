package org.simpleservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    public SuggestedName find(@PathParam("id") BigDecimal id) {
        SuggestedName suggestedName = null;
        try {
            suggestedName = em.createNamedQuery("SuggestedName.find", SuggestedName.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException ex){
            System.out.println("Error: "  + ex);
        }
        return suggestedName;
    }
   
    @GET
    public List<SuggestedName> findAll() {
        List<SuggestedName> suggestedNames = null;
        try {
            suggestedNames = em.createNamedQuery("SuggestedName.findAll").getResultList();
        } catch (NoResultException ex){
            System.out.println("Error: "  + ex);
        }
        return suggestedNames;
    }

}
