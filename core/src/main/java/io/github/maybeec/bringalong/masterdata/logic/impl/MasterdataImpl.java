package io.github.maybeec.bringalong.masterdata.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import io.github.maybeec.bringalong.general.logic.base.AbstractComponentFacade;
import io.github.maybeec.bringalong.masterdata.logic.api.Masterdata;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreEto;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreSearchCriteriaTo;
import io.github.maybeec.bringalong.masterdata.logic.api.usecase.UcFindStore;
import io.github.maybeec.bringalong.masterdata.logic.api.usecase.UcManageStore;

/**
 * Implementation of component interface of masterdata
 */
@Named
public class MasterdataImpl extends AbstractComponentFacade implements Masterdata {

  @Inject
  private UcFindStore ucFindStore;

  @Inject
  private UcManageStore ucManageStore;

  @Override
  public StoreEto findStore(long id) {

    return this.ucFindStore.findStore(id);
  }

  @Override
  public Page<StoreEto> findStores(StoreSearchCriteriaTo criteria) {

    return this.ucFindStore.findStores(criteria);
  }

  @Override
  public StoreEto saveStore(StoreEto store) {

    return this.ucManageStore.saveStore(store);
  }

  @Override
  public boolean deleteStore(long id) {

    return this.ucManageStore.deleteStore(id);
  }
}
