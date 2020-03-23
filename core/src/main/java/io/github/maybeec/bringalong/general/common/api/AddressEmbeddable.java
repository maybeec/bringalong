package io.github.maybeec.bringalong.general.common.api;

import javax.persistence.Embeddable;

import io.github.maybeec.bringalong.masterdata.common.api.Address;

@Embeddable
public class AddressEmbeddable implements Address {

  private String streetAndNumber;

  private String plz;

  private String city;

  private String additionalInformation;

  private Long lat;

  private Long lon;

  /**
   * @return plz
   */
  @Override
  public String getPlz() {

    return this.plz;
  }

  /**
   * @param plz new value of {@link #getPlz}.
   */
  @Override
  public void setPlz(String plz) {

    this.plz = plz;
  }

  /**
   * @return streetAndNumber
   */
  @Override
  public String getStreetAndNumber() {

    return this.streetAndNumber;
  }

  /**
   * @param streetAndNumber new value of {@link #getStreetAndNumber}.
   */
  @Override
  public void setStreetAndNumber(String streetAndNumber) {

    this.streetAndNumber = streetAndNumber;
  }

  /**
   * @return city
   */
  @Override
  public String getCity() {

    return this.city;
  }

  /**
   * @param city new value of {@link #getCity}.
   */
  @Override
  public void setCity(String city) {

    this.city = city;
  }

  /**
   * @return additionalHints
   */
  @Override
  public String getAdditionalInformation() {

    return this.additionalInformation;
  }

  /**
   * @param additionalInformation new value of {@link #getAdditionalInformation}.
   */
  @Override
  public void setAdditionalHints(String additionalInformation) {

    this.additionalInformation = additionalInformation;
  }

  /**
   * @return lat
   */
  public Long getLat() {

    return this.lat;
  }

  /**
   * @param lat new value of {@link #getLat}.
   */
  public void setLat(Long lat) {

    this.lat = lat;
  }

  /**
   * @return lon
   */
  public Long getLon() {

    return this.lon;
  }

  /**
   * @param lon new value of {@link #getLon}.
   */
  public void setLon(Long lon) {

    this.lon = lon;
  }

}
