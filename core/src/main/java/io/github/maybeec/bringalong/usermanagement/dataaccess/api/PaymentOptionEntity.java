package io.github.maybeec.bringalong.usermanagement.dataaccess.api;

import io.github.maybeec.bringalong.general.dataaccess.api.ApplicationPersistenceEntity;
import io.github.maybeec.bringalong.usermanagement.common.api.PaymentOption;
import io.github.maybeec.bringalong.usermanagement.common.api.PaymentType;

public class PaymentOptionEntity extends ApplicationPersistenceEntity implements PaymentOption {

  private PaymentType type;

  private String reference;

  private static final long serialVersionUID = 1L;

  /**
   * @return type
   */
  @Override
  public PaymentType getType() {

    return this.type;
  }

  /**
   * @param type new value of {@link #gettype}.
   */
  public void setType(PaymentType type) {

    this.type = type;
  }

  /**
   * @return reference
   */
  @Override
  public String getReference() {

    return this.reference;
  }

  /**
   * @param reference new value of {@link #getreference}.
   */
  @Override
  public void setReference(String reference) {

    this.reference = reference;
  }

}
