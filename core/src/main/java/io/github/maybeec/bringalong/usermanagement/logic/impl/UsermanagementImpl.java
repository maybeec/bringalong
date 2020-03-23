package io.github.maybeec.bringalong.usermanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.validation.annotation.Validated;

import io.github.maybeec.bringalong.general.logic.base.AbstractComponentFacade;
import io.github.maybeec.bringalong.usermanagement.logic.api.Usermanagement;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserCto;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserEto;
import io.github.maybeec.bringalong.usermanagement.logic.api.usecase.UcFindUser;
import io.github.maybeec.bringalong.usermanagement.logic.api.usecase.UcManageUser;

/**
 * Implementation of component interface of usermanagement
 */
@Named
@Validated
public class UsermanagementImpl extends AbstractComponentFacade implements Usermanagement {

  @Inject
  private UcFindUser ucFindUser;

  @Inject
  private UcManageUser ucManageUser;

  @Override
  public UserEto findUser(long id) {

    return this.ucFindUser.findUser(id);
  }

  @Override
  public UserEto saveUser(UserEto user) {

    return this.ucManageUser.saveUser(user);
  }

  @Override
  public UserCto findUserCto(long id) {

    return ucFindUser.findUserCto(id);
  }

}
