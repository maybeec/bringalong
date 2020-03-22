package io.github.maybeec.bringalong.masterdata.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import io.github.maybeec.bringalong.masterdata.dataaccess.api.StoreEntity;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreEto;
import io.github.maybeec.bringalong.masterdata.logic.api.usecase.UcManageStore;
import io.github.maybeec.bringalong.masterdata.logic.base.usecase.AbstractStoreUc;

/**
 * Use case implementation for modifying and deleting Stores
 */
@Named
@Validated
@Transactional
public class UcManageStoreImpl extends AbstractStoreUc implements UcManageStore {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageStoreImpl.class);

  @Override
  public boolean deleteStore(long storeId) {

    StoreEntity store = getStoreRepository().find(storeId);
    getStoreRepository().delete(store);
    LOG.debug("The store with id '{}' has been deleted.", storeId);
    return true;
  }

  @Override
  public StoreEto saveStore(StoreEto store) {

    Objects.requireNonNull(store, "store");

    StoreEntity storeEntity = getBeanMapper().map(store, StoreEntity.class);

    // initialize, validate storeEntity here if necessary
    StoreEntity resultEntity = getStoreRepository().save(storeEntity);
    LOG.debug("Store with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, StoreEto.class);
  }
}
