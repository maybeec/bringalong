package io.github.maybeec.bringalong.marketplace.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import io.github.maybeec.bringalong.marketplace.dataaccess.api.BringDemandEntity;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandEto;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandSearchCriteriaTo;
import io.github.maybeec.bringalong.marketplace.logic.api.usecase.UcFindBringDemand;
import io.github.maybeec.bringalong.marketplace.logic.base.usecase.AbstractBringDemandUc;

/**
 * Use case implementation for searching, filtering and getting BringDemands
 */
@Named
@Validated
@Transactional
public class UcFindBringDemandImpl extends AbstractBringDemandUc implements UcFindBringDemand {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindBringDemandImpl.class);

  @Override
  public BringDemandEto findBringDemand(long id) {

    LOG.debug("Get BringDemand with id {} from database.", id);
    Optional<BringDemandEntity> foundEntity = getBringDemandRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), BringDemandEto.class);
    else
      return null;
  }

  @Override
  public Page<BringDemandEto> findBringDemands(BringDemandSearchCriteriaTo criteria) {

    Page<BringDemandEntity> bringdemands = getBringDemandRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(bringdemands, BringDemandEto.class);
  }

}
