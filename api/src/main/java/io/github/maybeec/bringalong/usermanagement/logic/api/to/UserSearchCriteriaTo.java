package io.github.maybeec.bringalong.usermanagement.logic.api.to;

import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

import io.github.maybeec.bringalong.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link io.github.maybeec.bringalong.usermanagement.common.api.User}s.
 */
public class UserSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String login;

  private String forname;

  private String surname;

  private Long addressId;

  private StringSearchConfigTo loginOption;

  private StringSearchConfigTo fornameOption;

  private StringSearchConfigTo surnameOption;

  /**
   * @return loginId
   */

  public String getLogin() {

    return login;
  }

  /**
   * @param login setter for login attribute
   */

  public void setLogin(String login) {

    this.login = login;
  }

  /**
   * @return fornameId
   */

  public String getForname() {

    return forname;
  }

  /**
   * @param forname setter for forname attribute
   */

  public void setForname(String forname) {

    this.forname = forname;
  }

  /**
   * @return surnameId
   */

  public String getSurname() {

    return surname;
  }

  /**
   * @param surname setter for surname attribute
   */

  public void setSurname(String surname) {

    this.surname = surname;
  }

  /**
   * getter for addressId attribute
   * 
   * @return addressId
   */

  public Long getAddressId() {

    return addressId;
  }

  /**
   * @param address setter for address attribute
   */

  public void setAddressId(Long addressId) {

    this.addressId = addressId;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getLogin() login}.
   */
  public StringSearchConfigTo getLoginOption() {

    return this.loginOption;
  }

  /**
   * @param loginOption new value of {@link #getLoginOption()}.
   */
  public void setLoginOption(StringSearchConfigTo loginOption) {

    this.loginOption = loginOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getForname() forname}.
   */
  public StringSearchConfigTo getFornameOption() {

    return this.fornameOption;
  }

  /**
   * @param fornameOption new value of {@link #getFornameOption()}.
   */
  public void setFornameOption(StringSearchConfigTo fornameOption) {

    this.fornameOption = fornameOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getSurname() surname}.
   */
  public StringSearchConfigTo getSurnameOption() {

    return this.surnameOption;
  }

  /**
   * @param surnameOption new value of {@link #getSurnameOption()}.
   */
  public void setSurnameOption(StringSearchConfigTo surnameOption) {

    this.surnameOption = surnameOption;
  }

}
