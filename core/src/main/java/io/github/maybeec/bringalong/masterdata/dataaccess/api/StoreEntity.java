package io.github.maybeec.bringalong.masterdata.dataaccess.api;

import javax.persistence.Transient;

import io.github.maybeec.bringalong.general.dataaccess.api.ApplicationPersistenceEntity;
import io.github.maybeec.bringalong.masterdata.common.api.Store;

public class StoreEntity extends ApplicationPersistenceEntity implements Store {

  private String name;

  private String description;

  private AddressEntity address;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return description
   */
  @Override
  public String getDescription() {

    return this.description;
  }

  /**
   * @param description new value of {@link #getdescription}.
   */
  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return address
   */
  public AddressEntity getAddress() {

    return this.address;
  }

  /**
   * @param address new value of {@link #getaddress}.
   */
  public void setAddress(AddressEntity address) {

    this.address = address;
  }

  @Override
  @Transient
  public Long getAddressId() {

    if (this.address == null) {
      return null;
    }
    return this.address.getId();
  }

  @Override
  public void setAddressId(Long addressId) {

    if (addressId == null) {
      this.address = null;
    } else {
      AddressEntity addressEntity = new AddressEntity();
      addressEntity.setId(addressId);
      this.address = addressEntity;
    }
  }

}
