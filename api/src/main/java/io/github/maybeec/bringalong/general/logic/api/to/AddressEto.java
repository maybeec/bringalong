package io.github.maybeec.bringalong.general.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractEto;

import io.github.maybeec.bringalong.general.common.api.Address;

/**
 * Entity transport object of Address
 */
public class AddressEto extends AbstractEto implements Address {

  private static final long serialVersionUID = 1L;

  private String streetAndNumber;

  private String plz;

  private String city;

  private String additionalHints;

  @Override
  public String getStreetAndNumber() {

    return streetAndNumber;
  }

  @Override
  public void setStreetAndNumber(String streetAndNumber) {

    this.streetAndNumber = streetAndNumber;
  }

  @Override
  public String getPlz() {

    return plz;
  }

  @Override
  public void setPlz(String plz) {

    this.plz = plz;
  }

  @Override
  public String getCity() {

    return city;
  }

  @Override
  public void setCity(String city) {

    this.city = city;
  }

  @Override
  public String getAdditionalInformation() {

    return additionalHints;
  }

  @Override
  public void setAdditionalInformation(String additionalHints) {

    this.additionalHints = additionalHints;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.streetAndNumber == null) ? 0 : this.streetAndNumber.hashCode());
    result = prime * result + ((this.plz == null) ? 0 : this.plz.hashCode());
    result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
    result = prime * result + ((this.additionalHints == null) ? 0 : this.additionalHints.hashCode());
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
    AddressEto other = (AddressEto) obj;
    if (this.streetAndNumber == null) {
      if (other.streetAndNumber != null) {
        return false;
      }
    } else if (!this.streetAndNumber.equals(other.streetAndNumber)) {
      return false;
    }
    if (this.plz == null) {
      if (other.plz != null) {
        return false;
      }
    } else if (!this.plz.equals(other.plz)) {
      return false;
    }
    if (this.city == null) {
      if (other.city != null) {
        return false;
      }
    } else if (!this.city.equals(other.city)) {
      return false;
    }
    if (this.additionalHints == null) {
      if (other.additionalHints != null) {
        return false;
      }
    } else if (!this.additionalHints.equals(other.additionalHints)) {
      return false;
    }
    return true;
  }
}
