package io.github.maybeec.bringalong.masterdata.common.api;

import io.github.maybeec.bringalong.general.common.api.ApplicationEntity;

public interface Store extends ApplicationEntity {

  /**
   * @return nameId
   */

  public String getName();

  /**
   * @param name setter for name attribute
   */

  public void setName(String name);

  /**
   * @return descriptionId
   */

  public String getDescription();

  /**
   * @param description setter for description attribute
   */

  public void setDescription(String description);

}
