package io.github.maybeec.bringalong.usermanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractEto;

import io.github.maybeec.bringalong.usermanagement.common.api.PaymentOption;
import io.github.maybeec.bringalong.usermanagement.common.api.PaymentType;

/**
 * Entity transport object of PaymentOption
 */
public class PaymentOptionEto extends AbstractEto implements PaymentOption {

  private static final long serialVersionUID = 1L;

  private PaymentType type;

  private String reference;

  @Override
  public PaymentType getType() {

    return type;
  }

  @Override
  public void setType(PaymentType type) {

    this.type = type;
  }

  @Override
  public String getReference() {

    return reference;
  }

  @Override
  public void setReference(String reference) {

    this.reference = reference;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
    result = prime * result + ((this.reference == null) ? 0 : this.reference.hashCode());
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
    PaymentOptionEto other = (PaymentOptionEto) obj;
    if (this.type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!this.type.equals(other.type)) {
      return false;
    }
    if (this.reference == null) {
      if (other.reference != null) {
        return false;
      }
    } else if (!this.reference.equals(other.reference)) {
      return false;
    }
    return true;
  }
}
