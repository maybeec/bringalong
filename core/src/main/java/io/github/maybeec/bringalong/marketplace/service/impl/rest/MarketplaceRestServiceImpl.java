package io.github.maybeec.bringalong.marketplace.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import io.github.maybeec.bringalong.marketplace.logic.api.Marketplace;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandEto;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandSearchCriteriaTo;
import io.github.maybeec.bringalong.marketplace.service.api.rest.MarketplaceRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Marketplace}.
 */
@Named("MarketplaceRestService")
public class MarketplaceRestServiceImpl implements MarketplaceRestService {

  @Inject
  private Marketplace marketplace;

  @Override
  public BringDemandEto getBringDemand(long id) {

    return this.marketplace.findBringDemand(id);
  }

  @Override
  public BringDemandEto saveBringDemand(BringDemandEto bringdemand) {

    return this.marketplace.saveBringDemand(bringdemand);
  }

  @Override
  public void deleteBringDemand(long id) {

    this.marketplace.deleteBringDemand(id);
  }

  @Override
  public Page<BringDemandEto> findBringDemands(BringDemandSearchCriteriaTo searchCriteriaTo) {

    return this.marketplace.findBringDemands(searchCriteriaTo);
  }
}