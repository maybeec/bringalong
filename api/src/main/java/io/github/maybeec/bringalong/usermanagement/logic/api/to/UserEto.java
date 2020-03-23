package io.github.maybeec.bringalong.usermanagement.logic.api.to;

import java.util.List;

import com.devonfw.module.basic.common.api.to.AbstractEto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.maybeec.bringalong.general.common.api.Address;
import io.github.maybeec.bringalong.general.logic.api.to.AddressEto;
import io.github.maybeec.bringalong.usermanagement.common.api.PaymentType;
import io.github.maybeec.bringalong.usermanagement.common.api.User;

/**
 * Entity transport object of User
 */
public class UserEto extends AbstractEto implements User {

  private static final long serialVersionUID = 1L;

  private String login;

  private String forname;

  private String surname;

  private List<PaymentType> possiblePaymentOptions;

  private String forename;

  @JsonDeserialize(as = AddressEto.class)
  private Address address;

  @Override
  public String getLogin() {

    return login;
  }

  @Override
  public void setLogin(String login) {

    this.login = login;
  }

  @Override
  public String getForename() {

    return forname;
  }

  @Override
  public void setForename(String forname) {

    this.forname = forname;
  }

  @Override
  public String getSurname() {

    return surname;
  }

  @Override
  public void setSurname(String surname) {

    this.surname = surname;
  }

  @Override
  public List<PaymentType> getPossiblePaymentOptions() {

    return possiblePaymentOptions;
  }

  @Override
  public void setPossiblePaymentOptions(List<PaymentType> possiblePaymentOptions) {

    this.possiblePaymentOptions = possiblePaymentOptions;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.login == null) ? 0 : this.login.hashCode());
    result = prime * result + ((this.forname == null) ? 0 : this.forname.hashCode());
    result = prime * result + ((this.surname == null) ? 0 : this.surname.hashCode());
    result = prime * result + ((this.possiblePaymentOptions == null) ? 0 : this.possiblePaymentOptions.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    UserEto other = (UserEto) obj;
    if (this.login == null) {
      if (other.login != null) {
        return false;
      }
    } else if (!this.login.equals(other.login)) {
      return false;
    }
    if (this.forname == null) {
      if (other.forname != null) {
        return false;
      }
    } else if (!this.forname.equals(other.forname)) {
      return false;
    }
    if (this.surname == null) {
      if (other.surname != null) {
        return false;
      }
    } else if (!this.surname.equals(other.surname)) {
      return false;
    }

    if (this.possiblePaymentOptions == null) {
      if (other.possiblePaymentOptions != null) {
        return false;
      }
    } else if (!this.possiblePaymentOptions.equals(other.possiblePaymentOptions)) {
      return false;
    }
    return true;
  }

  /**
   * @return addressId
   */
  public Address getAddress() {

    return address;
  }

  /**
   * @param address setter for address attribute
   */
  public void setAddress(Address address) {

    this.address = address;
  }

}
