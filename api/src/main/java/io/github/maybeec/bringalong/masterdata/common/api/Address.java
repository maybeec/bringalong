package io.github.maybeec.bringalong.masterdata.common.api;

import io.github.maybeec.bringalong.general.common.api.ApplicationEntity;

public interface Address extends ApplicationEntity {

  /**
   * @return plzId
   */
  public String getPlz();

  /**
   * @param plz setter for plz attribute
   */
  public void setPlz(String plz);

  /**
   * @return streetAndNumberId
   */
  public String getStreetAndNumber();

  /**
   * @param streetAndNumber setter for streetAndNumber attribute
   */
  public void setStreetAndNumber(String streetAndNumber);

  /**
   * @return cityId
   */
  public String getCity();

  /**
   * @param city setter for city attribute
   */
  public void setCity(String city);

  /**
   * @return additionalHintsId
   */
  public String getAdditionalHints();

  /**
   * @param additionalHints setter for additionalHints attribute
   */
  public void setAdditionalHints(String additionalHints);

}
