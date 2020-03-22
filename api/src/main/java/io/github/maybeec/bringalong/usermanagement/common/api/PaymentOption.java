package io.github.maybeec.bringalong.usermanagement.common.api;

import io.github.maybeec.bringalong.general.common.api.ApplicationEntity;

public interface PaymentOption extends ApplicationEntity {

  /**
   * @return typeId
   */

  public PaymentType getType();

  /**
   * @param type setter for type attribute
   */

  public void setType(PaymentType type);

  /**
   * @return referenceId
   */

  public String getReference();

  /**
   * @param reference setter for reference attribute
   */

  public void setReference(String reference);

}
