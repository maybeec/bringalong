package io.github.maybeec.bringalong.masterdata.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractEto;

import io.github.maybeec.bringalong.masterdata.common.api.Store;

/**
 * Entity transport object of Store
 */
public class StoreEto extends AbstractEto implements Store {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private Long addressId;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getDescription() {

    return description;
  }

  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  @Override
  public Long getAddressId() {

    return addressId;
  }

  @Override
  public void setAddressId(Long addressId) {

    this.addressId = addressId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());

    result = prime * result + ((this.addressId == null) ? 0 : this.addressId.hashCode());
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
    StoreEto other = (StoreEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!this.description.equals(other.description)) {
      return false;
    }

    if (this.addressId == null) {
      if (other.addressId != null) {
        return false;
      }
    } else if (!this.addressId.equals(other.addressId)) {
      return false;
    }
    return true;
  }
}
