package io.github.maybeec.bringalong.masterdata.logic.base.usecase;

import javax.inject.Inject;

import io.github.maybeec.bringalong.general.logic.base.AbstractUc;
import io.github.maybeec.bringalong.masterdata.dataaccess.api.repo.StoreRepository;

/**
 * Abstract use case for Stores, which provides access to the commonly necessary data access objects.
 */
public class AbstractStoreUc extends AbstractUc {

  /** @see #getStoreRepository() */
  @Inject
  private StoreRepository storeRepository;

  /**
   * Returns the field 'storeRepository'.
   * 
   * @return the {@link StoreRepository} instance.
   */
  public StoreRepository getStoreRepository() {

    return this.storeRepository;
  }

}
