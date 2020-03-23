package io.github.maybeec.bringalong.usermanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.github.maybeec.bringalong.usermanagement.logic.api.Usermanagement;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserCto;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserEto;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Usermanagement}.
 */
@Path("/usermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UsermanagementRestService {

  /**
   * Delegates to {@link Usermanagement#findUserCto}.
   *
   * @param id the ID of the {@link UserCto}
   * @return the {@link UserCto}
   */
  @GET
  @Path("/user/cto/{id}/")
  public UserCto getUserCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Usermanagement#findUser}.
   *
   * @param id the ID of the {@link UserEto}
   * @return the {@link UserEto}
   */
  @GET
  @Path("/user/{id}/")
  public UserEto getUser(@PathParam("id") long id);

  /**
   * Delegates to {@link Usermanagement#saveUser}.
   *
   * @param user the {@link UserEto} to be saved
   * @return the recently created {@link UserEto}
   */
  @POST
  @Path("/user/")
  public UserEto saveUser(UserEto user);

}
