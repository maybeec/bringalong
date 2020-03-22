package io.github.maybeec.bringalong.masterdata.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import io.github.maybeec.bringalong.masterdata.logic.api.Masterdata;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreEto;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreSearchCriteriaTo;
import io.github.maybeec.bringalong.masterdata.service.api.rest.MasterdataRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Masterdata}.
 */
@Named("MasterdataRestService")
public class MasterdataRestServiceImpl implements MasterdataRestService {

  @Inject
  private Masterdata masterdata;

  @Override
  public StoreEto getStore(long id) {

    return this.masterdata.findStore(id);
  }

  @Override
  public StoreEto saveStore(StoreEto store) {

    return this.masterdata.saveStore(store);
  }

  @Override
  public void deleteStore(long id) {

    this.masterdata.deleteStore(id);
  }

  @Override
  public Page<StoreEto> findStores(StoreSearchCriteriaTo searchCriteriaTo) {

    return this.masterdata.findStores(searchCriteriaTo);
  }
}