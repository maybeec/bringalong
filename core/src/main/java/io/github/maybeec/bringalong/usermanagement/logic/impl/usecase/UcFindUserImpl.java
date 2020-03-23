package io.github.maybeec.bringalong.usermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import io.github.maybeec.bringalong.general.logic.api.to.AddressEto;
import io.github.maybeec.bringalong.usermanagement.dataaccess.api.UserEntity;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.PaymentOptionEto;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserCto;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserEto;
import io.github.maybeec.bringalong.usermanagement.logic.api.usecase.UcFindUser;
import io.github.maybeec.bringalong.usermanagement.logic.base.usecase.AbstractUserUc;

/**
 * Use case implementation for searching, filtering and getting Users
 */
@Named
@Validated
@Transactional
public class UcFindUserImpl extends AbstractUserUc implements UcFindUser {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindUserImpl.class);

  @Override
  public UserEto findUser(long id) {

    LOG.debug("Get User with id {} from database.", id);
    Optional<UserEntity> foundEntity = getUserRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), UserEto.class);
    else
      return null;
  }

  @Override
  public UserCto findUserCto(long id) {

    LOG.debug("Get UserCto with id {} from database.", id);
    UserEntity entity = getUserRepository().find(id);
    UserCto cto = new UserCto();
    cto.setUser(getBeanMapper().map(entity, UserEto.class));
    cto.setAddress(getBeanMapper().map(entity.getAddress(), AddressEto.class));
    cto.setAcceptedPaymentOptions(getBeanMapper().mapList(entity.getAcceptedPaymentOptions(), PaymentOptionEto.class));

    return cto;
  }

}
