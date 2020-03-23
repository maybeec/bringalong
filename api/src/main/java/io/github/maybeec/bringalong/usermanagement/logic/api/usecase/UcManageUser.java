package io.github.maybeec.bringalong.usermanagement.logic.api.usecase;

import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserEto;

/**
 * Interface of UcManageUser to centralize documentation and signatures of methods.
 */
public interface UcManageUser {

  /**
   * Saves a user and store it in the database.
   *
   * @param user the {@link UserEto} to create.
   * @return the new {@link UserEto} that has been saved with ID and version.
   */
  UserEto saveUser(UserEto user);

}
