package io.github.maybeec.bringalong.marketplace.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import io.github.maybeec.bringalong.marketplace.logic.api.Marketplace;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandEto;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Marketplace}.
 */
@Path("/marketplace/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MarketplaceRestService {

  /**
   * Delegates to {@link Marketplace#findBringDemand}.
   *
   * @param id the ID of the {@link BringDemandEto}
   * @return the {@link BringDemandEto}
   */
  @GET
  @Path("/bringdemand/{id}/")
  public BringDemandEto getBringDemand(@PathParam("id") long id);

  /**
   * Delegates to {@link Marketplace#saveBringDemand}.
   *
   * @param bringdemand the {@link BringDemandEto} to be saved
   * @return the recently created {@link BringDemandEto}
   */
  @POST
  @Path("/bringdemand/")
  public BringDemandEto saveBringDemand(BringDemandEto bringdemand);

  /**
   * Delegates to {@link Marketplace#deleteBringDemand}.
   *
   * @param id ID of the {@link BringDemandEto} to be deleted
   */
  @DELETE
  @Path("/bringdemand/{id}/")
  public void deleteBringDemand(@PathParam("id") long id);

  /**
   * Delegates to {@link Marketplace#findBringDemandEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding bringdemands.
   * @return the {@link Page list} of matching {@link BringDemandEto}s.
   */
  @Path("/bringdemand/search")
  @POST
  public Page<BringDemandEto> findBringDemands(BringDemandSearchCriteriaTo searchCriteriaTo);

}