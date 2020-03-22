package io.github.maybeec.bringalong.masterdata.dataaccess.api;

import io.github.maybeec.bringalong.general.dataaccess.api.ApplicationPersistenceEntity;
import io.github.maybeec.bringalong.masterdata.common.api.Address;

public class AddressEntity extends ApplicationPersistenceEntity implements Address {

  private static final long serialVersionUID = 1L;

  private String streetAndNumber;

  private String plz;

  private String city;

  private String additionalHints;

  /**
   * @return plz
   */
  @Override
  public String getPlz() {

    return this.plz;
  }

  /**
   * @param plz new value of {@link #getplz}.
   */
  @Override
  public void setPlz(String plz) {

    this.plz = plz;
  }

  /**
   * @return streetAndNumber
   */
  public String getStreetAndNumber() {

    return this.streetAndNumber;
  }

  /**
   * @param streetAndNumber new value of {@link #getstreetAndNumber}.
   */
  public void setStreetAndNumber(String streetAndNumber) {

    this.streetAndNumber = streetAndNumber;
  }

  /**
   * @return city
   */
  public String getCity() {

    return this.city;
  }

  /**
   * @param city new value of {@link #getcity}.
   */
  public void setCity(String city) {

    this.city = city;
  }

  /**
   * @return additionalHints
   */
  public String getAdditionalHints() {

    return this.additionalHints;
  }

  /**
   * @param additionalHints new value of {@link #getadditionalHints}.
   */
  public void setAdditionalHints(String additionalHints) {

    this.additionalHints = additionalHints;
  }

}
