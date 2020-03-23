package io.github.maybeec.bringalong.general.common.api;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressEmbeddable implements Address {

  private String streetAndNumber;

  private String plz;

  private String city;

  private String additionalInformation;

  private Double lat;

  private Double lon;

  /**
   * @return plz
   */
  @Override
  @Column(nullable = false)
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
  @Column(nullable = false)
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
  @Column(nullable = false)
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
  public void setAdditionalInformation(String additionalInformation) {

    this.additionalInformation = additionalInformation;
  }

  /**
   * @return lat
   */
  @Column(nullable = false)
  public Double getLat() {

    return this.lat;
  }

  /**
   * @param lat new value of {@link #getLat}.
   */
  public void setLat(Double lat) {

    this.lat = lat;
  }

  /**
   * @return lon
   */
  @Column(nullable = false)
  public Double getLon() {

    return this.lon;
  }

  /**
   * @param lon new value of {@link #getLon}.
   */
  public void setLon(Double lon) {

    this.lon = lon;
  }

}
