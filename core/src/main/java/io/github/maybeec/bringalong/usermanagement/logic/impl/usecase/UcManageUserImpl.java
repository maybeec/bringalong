package io.github.maybeec.bringalong.usermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import io.github.maybeec.bringalong.usermanagement.dataaccess.api.UserEntity;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserEto;
import io.github.maybeec.bringalong.usermanagement.logic.api.usecase.UcManageUser;
import io.github.maybeec.bringalong.usermanagement.logic.base.usecase.AbstractUserUc;

/**
 * Use case implementation for modifying and deleting Users
 */
@Named
@Validated
@Transactional
public class UcManageUserImpl extends AbstractUserUc implements UcManageUser {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageUserImpl.class);

  @Override
  public UserEto saveUser(UserEto user) {

    Objects.requireNonNull(user, "user");

    UserEntity userEntity = getBeanMapper().map(user, UserEntity.class);

    // initialize, validate userEntity here if necessary
    UserEntity resultEntity = getUserRepository().save(userEntity);
    LOG.debug("User with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, UserEto.class);
  }

}
