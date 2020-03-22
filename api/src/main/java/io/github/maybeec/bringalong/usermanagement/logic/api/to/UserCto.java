package io.github.maybeec.bringalong.usermanagement.logic.api.to;

import java.util.List;

import com.devonfw.module.basic.common.api.to.AbstractCto;

import io.github.maybeec.bringalong.masterdata.logic.api.to.AddressEto;

/**
 * Composite transport object of User
 */
public class UserCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private UserEto user;

  private AddressEto address;

  private List<PaymentOptionEto> acceptedPaymentOptions;

  public UserEto getUser() {

    return user;
  }

  public void setUser(UserEto user) {

    this.user = user;
  }

  public AddressEto getAddress() {

    return address;
  }

  public void setAddress(AddressEto address) {

    this.address = address;
  }

  public List<PaymentOptionEto> getAcceptedPaymentOptions() {

    return acceptedPaymentOptions;
  }

  public void setAcceptedPaymentOptions(List<PaymentOptionEto> acceptedPaymentOptions) {

    this.acceptedPaymentOptions = acceptedPaymentOptions;
  }

}
