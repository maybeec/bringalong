package io.github.maybeec.bringalong.masterdata.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import io.github.maybeec.bringalong.masterdata.logic.api.Masterdata;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreEto;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Masterdata}.
 */
@Path("/masterdata/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MasterdataRestService {

  /**
   * Delegates to {@link Masterdata#findStore}.
   *
   * @param id the ID of the {@link StoreEto}
   * @return the {@link StoreEto}
   */
  @GET
  @Path("/store/{id}/")
  public StoreEto getStore(@PathParam("id") long id);

  /**
   * Delegates to {@link Masterdata#saveStore}.
   *
   * @param store the {@link StoreEto} to be saved
   * @return the recently created {@link StoreEto}
   */
  @POST
  @Path("/store/")
  public StoreEto saveStore(StoreEto store);

  /**
   * Delegates to {@link Masterdata#deleteStore}.
   *
   * @param id ID of the {@link StoreEto} to be deleted
   */
  @DELETE
  @Path("/store/{id}/")
  public void deleteStore(@PathParam("id") long id);

  /**
   * Delegates to {@link Masterdata#findStoreEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding stores.
   * @return the {@link Page list} of matching {@link StoreEto}s.
   */
  @Path("/store/search")
  @POST
  public Page<StoreEto> findStores(StoreSearchCriteriaTo searchCriteriaTo);

}