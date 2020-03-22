package io.github.maybeec.bringalong.usermanagement.dataaccess.api;

import java.util.List;

import javax.persistence.Transient;

import io.github.maybeec.bringalong.general.dataaccess.api.ApplicationPersistenceEntity;
import io.github.maybeec.bringalong.masterdata.dataaccess.api.AddressEntity;
import io.github.maybeec.bringalong.usermanagement.common.api.PaymentType;
import io.github.maybeec.bringalong.usermanagement.common.api.User;

public class UserEntity extends ApplicationPersistenceEntity implements User {

  private String login;

  private String forname;

  private String surname;

  private AddressEntity address;

  private List<PaymentOptionEntity> acceptedPaymentOptions;

  private List<PaymentType> possiblePaymentOptions;

  private static final long serialVersionUID = 1L;

  /**
   * @return login
   */
  public String getLogin() {

    return this.login;
  }

  /**
   * @param login new value of {@link #getlogin}.
   */
  public void setLogin(String login) {

    this.login = login;
  }

  /**
   * @return forname
   */
  public String getForname() {

    return this.forname;
  }

  /**
   * @param forname new value of {@link #getforname}.
   */
  public void setForname(String forname) {

    this.forname = forname;
  }

  /**
   * @return surname
   */
  public String getSurname() {

    return this.surname;
  }

  /**
   * @param surname new value of {@link #getsurname}.
   */
  public void setSurname(String surname) {

    this.surname = surname;
  }

  /**
   * @return address
   */
  public AddressEntity getAddress() {

    return this.address;
  }

  /**
   * @param address new value of {@link #getaddress}.
   */
  public void setAddress(AddressEntity address) {

    this.address = address;
  }

  /**
   * @return acceptedPaymentOptions
   */
  public List<PaymentOptionEntity> getAcceptedPaymentOptions() {

    return this.acceptedPaymentOptions;
  }

  /**
   * @param acceptedPaymentOptions new value of {@link #getacceptedPaymentOptions}.
   */
  public void setAcceptedPaymentOptions(List<PaymentOptionEntity> acceptedPaymentOptions) {

    this.acceptedPaymentOptions = acceptedPaymentOptions;
  }

  /**
   * @return possiblePaymentOptions
   */
  public List<PaymentType> getPossiblePaymentOptions() {

    return this.possiblePaymentOptions;
  }

  /**
   * @param possiblePaymentOptions new value of {@link #getpossiblePaymentOptions}.
   */
  public void setPossiblePaymentOptions(List<PaymentType> possiblePaymentOptions) {

    this.possiblePaymentOptions = possiblePaymentOptions;
  }

  @Override
  @Transient
  public Long getAddressId() {

    if (this.address == null) {
      return null;
    }
    return this.address.getId();
  }

  @Override
  public void setAddressId(Long addressId) {

    if (addressId == null) {
      this.address = null;
    } else {
      AddressEntity addressEntity = new AddressEntity();
      addressEntity.setId(addressId);
      this.address = addressEntity;
    }
  }

}
