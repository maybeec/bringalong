package io.github.maybeec.bringalong.usermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import io.github.maybeec.bringalong.usermanagement.logic.api.Usermanagement;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserCto;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserEto;
import io.github.maybeec.bringalong.usermanagement.service.api.rest.UsermanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Usermanagement}.
 */
@Named("UsermanagementRestService")
public class UsermanagementRestServiceImpl implements UsermanagementRestService {

  @Inject
  private Usermanagement usermanagement;

  @Override
  public UserEto getUser(long id) {

    return this.usermanagement.findUser(id);
  }

  @Override
  public UserEto saveUser(UserEto user) {

    return this.usermanagement.saveUser(user);
  }

  @Override
  public UserCto getUserCto(long id) {

    return this.usermanagement.findUserCto(id);
  }

}
