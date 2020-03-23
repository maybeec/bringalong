package io.github.maybeec.bringalong.marketplace.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandEto;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandSearchCriteriaTo;

public interface UcFindBringDemand {

  /**
   * Returns a BringDemand by its id 'id'.
   *
   * @param id The id 'id' of the BringDemand.
   * @return The {@link BringDemandEto} with id 'id'
   */
  BringDemandEto findBringDemand(long id);

  /**
   * Returns a paginated list of BringDemands matching the search criteria.
   *
   * @param criteria the {@link BringDemandSearchCriteriaTo}.
   * @return the {@link List} of matching {@link BringDemandEto}s.
   */
  Page<BringDemandEto> findBringDemands(BringDemandSearchCriteriaTo criteria);

}
