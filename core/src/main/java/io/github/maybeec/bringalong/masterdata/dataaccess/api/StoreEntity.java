package io.github.maybeec.bringalong.masterdata.dataaccess.api;

import javax.persistence.Embedded;

import io.github.maybeec.bringalong.general.common.api.AddressEmbeddable;
import io.github.maybeec.bringalong.general.dataaccess.api.ApplicationPersistenceEntity;
import io.github.maybeec.bringalong.masterdata.common.api.Store;

public class StoreEntity extends ApplicationPersistenceEntity implements Store {

  private String name;

  private String description;

  private AddressEmbeddable address;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getName}.
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
   * @param description new value of {@link #getDescription}.
   */
  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return address
   */
  @Embedded
  public AddressEmbeddable getAddress() {

    return this.address;
  }

  /**
   * @param address new value of {@link #getAddress}.
   */
  public void setAddress(AddressEmbeddable address) {

    this.address = address;
  }

}
