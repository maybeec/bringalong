package io.github.maybeec.bringalong.marketplace.logic.api.usecase;

import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandEto;

/**
 * Interface of UcManageBringDemand to centralize documentation and signatures of methods.
 */
public interface UcManageBringDemand {

  /**
   * Deletes a bringDemand from the database by its id 'bringDemandId'.
   *
   * @param bringDemandId Id of the bringDemand to delete
   * @return boolean <code>true</code> if the bringDemand can be deleted, <code>false</code> otherwise
   */
  boolean deleteBringDemand(long bringDemandId);

  /**
   * Saves a bringDemand and store it in the database.
   *
   * @param bringDemand the {@link BringDemandEto} to create.
   * @return the new {@link BringDemandEto} that has been saved with ID and version.
   */
  BringDemandEto saveBringDemand(BringDemandEto bringDemand);

}
