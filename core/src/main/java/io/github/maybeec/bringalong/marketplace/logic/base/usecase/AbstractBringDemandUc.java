package io.github.maybeec.bringalong.marketplace.logic.base.usecase;

import javax.inject.Inject;

import io.github.maybeec.bringalong.general.logic.base.AbstractUc;
import io.github.maybeec.bringalong.marketplace.dataaccess.api.repo.BringDemandRepository;

/**
 * Abstract use case for BringDemands, which provides access to the commonly necessary data access objects.
 */
public class AbstractBringDemandUc extends AbstractUc {

  /** @see #getBringDemandRepository() */
  @Inject
  private BringDemandRepository bringDemandRepository;

  /**
   * Returns the field 'bringDemandRepository'.
   * 
   * @return the {@link BringDemandRepository} instance.
   */
  public BringDemandRepository getBringDemandRepository() {

    return this.bringDemandRepository;
  }

}
