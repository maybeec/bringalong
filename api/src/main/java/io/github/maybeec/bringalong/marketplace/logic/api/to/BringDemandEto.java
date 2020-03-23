package io.github.maybeec.bringalong.marketplace.logic.api.to;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

import com.devonfw.module.basic.common.api.to.AbstractEto;

import io.github.maybeec.bringalong.marketplace.common.api.BringDemand;

/**
 * Entity transport object of BringDemand
 */
public class BringDemandEto extends AbstractEto implements BringDemand {

  private static final long serialVersionUID = 1L;

  private String item;

  private String dropHint;

  private Calendar deadline;

  private Integer estimatedAmount;

  private String currency;

  private Long acceptedByUser;

  private Long userId;

  @Override
  @NotNull
  public String getItem() {

    return item;
  }

  @Override
  public void setItem(String item) {

    this.item = item;
  }

  @Override
  public String getDropHint() {

    return dropHint;
  }

  @Override
  public void setDropHint(String dropHint) {

    this.dropHint = dropHint;
  }

  @Override
  public Calendar getDeadline() {

    return deadline;
  }

  @Override
  public void setDeadline(Calendar deadline) {

    this.deadline = deadline;
  }

  @Override
  public Integer getEstimatedAmount() {

    return estimatedAmount;
  }

  @Override
  public void setEstimatedAmount(Integer estimatedAmount) {

    this.estimatedAmount = estimatedAmount;
  }

  @Override
  @NotNull
  public String getCurrency() {

    return currency;
  }

  @Override
  public void setCurrency(String currency) {

    this.currency = currency;
  }

  @Override
  public Long getAcceptedByUser() {

    return acceptedByUser;
  }

  @Override
  public void setAcceptedByUser(Long acceptedByUser) {

    this.acceptedByUser = acceptedByUser;
  }

  @Override
  @NotNull
  public Long getUserId() {

    return userId;
  }

  @Override
  public void setUserId(Long userId) {

    this.userId = userId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.item == null) ? 0 : this.item.hashCode());
    result = prime * result + ((this.dropHint == null) ? 0 : this.dropHint.hashCode());
    result = prime * result + ((this.deadline == null) ? 0 : this.deadline.hashCode());
    result = prime * result + ((this.estimatedAmount == null) ? 0 : this.estimatedAmount.hashCode());
    result = prime * result + ((this.currency == null) ? 0 : this.currency.hashCode());
    result = prime * result + ((this.acceptedByUser == null) ? 0 : this.acceptedByUser.hashCode());
    result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
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
    BringDemandEto other = (BringDemandEto) obj;
    if (this.item == null) {
      if (other.item != null) {
        return false;
      }
    } else if (!this.item.equals(other.item)) {
      return false;
    }
    if (this.dropHint == null) {
      if (other.dropHint != null) {
        return false;
      }
    } else if (!this.dropHint.equals(other.dropHint)) {
      return false;
    }
    if (this.deadline == null) {
      if (other.deadline != null) {
        return false;
      }
    } else if (!this.deadline.equals(other.deadline)) {
      return false;
    }
    if (this.estimatedAmount == null) {
      if (other.estimatedAmount != null) {
        return false;
      }
    } else if (!this.estimatedAmount.equals(other.estimatedAmount)) {
      return false;
    }
    if (this.currency == null) {
      if (other.currency != null) {
        return false;
      }
    } else if (!this.currency.equals(other.currency)) {
      return false;
    }
    if (this.acceptedByUser == null) {
      if (other.acceptedByUser != null) {
        return false;
      }
    } else if (!this.acceptedByUser.equals(other.acceptedByUser)) {
      return false;
    }
    if (this.userId == null) {
      if (other.userId != null) {
        return false;
      }
    } else if (!this.userId.equals(other.userId)) {
      return false;
    }
    return true;
  }

}
