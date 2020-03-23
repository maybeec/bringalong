package io.github.maybeec.bringalong.marketplace.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import io.github.maybeec.bringalong.marketplace.dataaccess.api.BringDemandEntity;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandEto;
import io.github.maybeec.bringalong.marketplace.logic.api.usecase.UcManageBringDemand;
import io.github.maybeec.bringalong.marketplace.logic.base.usecase.AbstractBringDemandUc;

/**
 * Use case implementation for modifying and deleting BringDemands
 */
@Named
@Validated
@Transactional
public class UcManageBringDemandImpl extends AbstractBringDemandUc implements UcManageBringDemand {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageBringDemandImpl.class);

  @Override
  public boolean deleteBringDemand(long bringDemandId) {

    BringDemandEntity bringDemand = getBringDemandRepository().find(bringDemandId);
    getBringDemandRepository().delete(bringDemand);
    LOG.debug("The bringDemand with id '{}' has been deleted.", bringDemandId);
    return true;
  }

  @Override
  public BringDemandEto saveBringDemand(BringDemandEto bringDemand) {

    Objects.requireNonNull(bringDemand, "bringDemand");

    BringDemandEntity bringDemandEntity = getBeanMapper().map(bringDemand, BringDemandEntity.class);

    // initialize, validate bringDemandEntity here if necessary
    BringDemandEntity resultEntity = getBringDemandRepository().save(bringDemandEntity);
    LOG.debug("BringDemand with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, BringDemandEto.class);
  }
}
