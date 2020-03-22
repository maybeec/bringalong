package io.github.maybeec.bringalong.masterdata.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreEto;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreSearchCriteriaTo;

public interface UcFindStore {

  /**
   * Returns a Store by its id 'id'.
   *
   * @param id The id 'id' of the Store.
   * @return The {@link StoreEto} with id 'id'
   */
  StoreEto findStore(long id);

  /**
   * Returns a paginated list of Stores matching the search criteria.
   *
   * @param criteria the {@link StoreSearchCriteriaTo}.
   * @return the {@link List} of matching {@link StoreEto}s.
   */
  Page<StoreEto> findStores(StoreSearchCriteriaTo criteria);

}
