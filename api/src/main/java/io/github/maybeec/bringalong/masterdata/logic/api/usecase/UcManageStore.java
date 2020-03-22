package io.github.maybeec.bringalong.masterdata.logic.api.usecase;

import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreEto;

/**
 * Interface of UcManageStore to centralize documentation and signatures of methods.
 */
public interface UcManageStore {

  /**
   * Deletes a store from the database by its id 'storeId'.
   *
   * @param storeId Id of the store to delete
   * @return boolean <code>true</code> if the store can be deleted, <code>false</code> otherwise
   */
  boolean deleteStore(long storeId);

  /**
   * Saves a store and store it in the database.
   *
   * @param store the {@link StoreEto} to create.
   * @return the new {@link StoreEto} that has been saved with ID and version.
   */
  StoreEto saveStore(StoreEto store);

}
