package io.github.maybeec.bringalong.usermanagement.common.api;

import java.util.List;

import io.github.maybeec.bringalong.general.common.api.ApplicationEntity;

public interface User extends ApplicationEntity {

  /**
   * @return loginId
   */

  public String getLogin();

  /**
   * @param login setter for login attribute
   */

  public void setLogin(String login);

  /**
   * @return fornameId
   */

  public String getForname();

  /**
   * @param forname setter for forname attribute
   */

  public void setForname(String forname);

  /**
   * @return surnameId
   */

  public String getSurname();

  /**
   * @param surname setter for surname attribute
   */

  public void setSurname(String surname);

  /**
   * getter for addressId attribute
   * 
   * @return addressId
   */

  public Long getAddressId();

  /**
   * @param address setter for address attribute
   */

  public void setAddressId(Long addressId);

  /**
   * @return possiblePaymentOptionsId
   */

  public List<PaymentType> getPossiblePaymentOptions();

  /**
   * @param possiblePaymentOptions setter for possiblePaymentOptions attribute
   */

  public void setPossiblePaymentOptions(List<PaymentType> possiblePaymentOptions);

}
