package io.github.maybeec.bringalong.usermanagement.logic.api.usecase;

import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserCto;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserEto;

public interface UcFindUser {

  /**
   * Returns a composite User by its id 'id'.
   *
   * @param id The id 'id' of the User.
   * @return The {@link UserCto} with id 'id'
   */
  UserCto findUserCto(long id);

  /**
   * Returns a User by its id 'id'.
   *
   * @param id The id 'id' of the User.
   * @return The {@link UserEto} with id 'id'
   */
  UserEto findUser(long id);

}
