package io.github.maybeec.bringalong.marketplace.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import io.github.maybeec.bringalong.general.logic.base.AbstractComponentFacade;
import io.github.maybeec.bringalong.marketplace.logic.api.Marketplace;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandEto;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandSearchCriteriaTo;
import io.github.maybeec.bringalong.marketplace.logic.api.usecase.UcFindBringDemand;
import io.github.maybeec.bringalong.marketplace.logic.api.usecase.UcManageBringDemand;

/**
 * Implementation of component interface of marketplace
 */
@Named
public class MarketplaceImpl extends AbstractComponentFacade implements Marketplace {

  @Inject
  private UcFindBringDemand ucFindBringDemand;

  @Inject
  private UcManageBringDemand ucManageBringDemand;

  @Override
  public BringDemandEto findBringDemand(long id) {

    return this.ucFindBringDemand.findBringDemand(id);
  }

  @Override
  public Page<BringDemandEto> findBringDemands(BringDemandSearchCriteriaTo criteria) {

    return this.ucFindBringDemand.findBringDemands(criteria);
  }

  @Override
  public BringDemandEto saveBringDemand(BringDemandEto bringdemand) {

    return this.ucManageBringDemand.saveBringDemand(bringdemand);
  }

  @Override
  public boolean deleteBringDemand(long id) {

    return this.ucManageBringDemand.deleteBringDemand(id);
  }
}
