package io.github.maybeec.bringalong.usermanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import io.github.maybeec.bringalong.general.logic.base.AbstractComponentFacade;
import io.github.maybeec.bringalong.usermanagement.logic.api.Usermanagement;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserCto;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserEto;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserSearchCriteriaTo;
import io.github.maybeec.bringalong.usermanagement.logic.api.usecase.UcFindUser;
import io.github.maybeec.bringalong.usermanagement.logic.api.usecase.UcManageUser;

/**
 * Implementation of component interface of usermanagement
 */
@Named
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
  public Page<UserEto> findUsers(UserSearchCriteriaTo criteria) {

    return this.ucFindUser.findUsers(criteria);
  }

  @Override
  public UserEto saveUser(UserEto user) {

    return this.ucManageUser.saveUser(user);
  }

  @Override
  public boolean deleteUser(long id) {

    return this.ucManageUser.deleteUser(id);
  }

  @Override
  public UserCto findUserCto(long id) {

    return ucFindUser.findUserCto(id);
  }

  @Override
  public Page<UserCto> findUserCtos(UserSearchCriteriaTo criteria) {

    return ucFindUser.findUserCtos(criteria);
  }

}
