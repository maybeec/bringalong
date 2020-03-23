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

  public String getForename();

  /**
   * @param forname setter for forename attribute
   */

  public void setForename(String forname);

  /**
   * @return surnameId
   */

  public String getSurname();

  /**
   * @param surname setter for surname attribute
   */

  public void setSurname(String surname);

  /**
   * @return possiblePaymentOptionsId
   */

  public List<PaymentType> getPossiblePaymentOptions();

  /**
   * @param possiblePaymentOptions setter for possiblePaymentOptions attribute
   */

  public void setPossiblePaymentOptions(List<PaymentType> possiblePaymentOptions);

}
