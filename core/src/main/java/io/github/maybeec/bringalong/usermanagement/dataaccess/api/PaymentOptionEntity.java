package io.github.maybeec.bringalong.usermanagement.dataaccess.api;

import javax.persistence.Column;

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
  @Column(nullable = false)
  public PaymentType getType() {

    return this.type;
  }

  /**
   * @param type new value of {@link #getType}.
   */
  @Override
  public void setType(PaymentType type) {

    this.type = type;
  }

  /**
   * @return reference
   */
  @Override
  @Column(nullable = false)
  public String getReference() {

    return this.reference;
  }

  /**
   * @param reference new value of {@link #getReference}.
   */
  @Override
  public void setReference(String reference) {

    this.reference = reference;
  }

}
