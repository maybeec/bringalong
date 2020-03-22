package io.github.maybeec.bringalong.masterdata.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import io.github.maybeec.bringalong.masterdata.dataaccess.api.StoreEntity;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreEto;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreSearchCriteriaTo;
import io.github.maybeec.bringalong.masterdata.logic.api.usecase.UcFindStore;
import io.github.maybeec.bringalong.masterdata.logic.base.usecase.AbstractStoreUc;

/**
 * Use case implementation for searching, filtering and getting Stores
 */
@Named
@Validated
@Transactional
public class UcFindStoreImpl extends AbstractStoreUc implements UcFindStore {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindStoreImpl.class);

  @Override
  public StoreEto findStore(long id) {

    LOG.debug("Get Store with id {} from database.", id);
    Optional<StoreEntity> foundEntity = getStoreRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), StoreEto.class);
    else
      return null;
  }

  @Override
  public Page<StoreEto> findStores(StoreSearchCriteriaTo criteria) {

    Page<StoreEntity> stores = getStoreRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(stores, StoreEto.class);
  }

}
