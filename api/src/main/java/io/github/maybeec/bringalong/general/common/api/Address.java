package io.github.maybeec.bringalong.general.common.api;

public interface Address {

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
  public String getAdditionalInformation();

  /**
   * @param additionalHints setter for additionalHints attribute
   */
  public void setAdditionalInformation(String additionalHints);

}
