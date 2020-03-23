package io.github.maybeec.bringalong.marketplace.dataaccess.api;

import java.util.Calendar;
import java.util.Currency;

import io.github.maybeec.bringalong.general.dataaccess.api.ApplicationPersistenceEntity;
import io.github.maybeec.bringalong.marketplace.common.api.BringDemand;

public class BringDemandEntity extends ApplicationPersistenceEntity implements BringDemand {

  private String item;

  private String dropHint;

  private Calendar deadline;

  private Integer estimatedAmount;

  private Currency currency;

  private Long acceptedByUser;

  private Long userId;

  private static final long serialVersionUID = 1L;

  /**
   * @return item
   */
  @Override
  public String getItem() {

    return this.item;
  }

  /**
   * @param item new value of {@link #getItem}.
   */
  @Override
  public void setItem(String item) {

    this.item = item;
  }

  /**
   * @return dropHint
   */
  @Override
  public String getDropHint() {

    return this.dropHint;
  }

  /**
   * @param dropHint new value of {@link #getDropHint}.
   */
  @Override
  public void setDropHint(String dropHint) {

    this.dropHint = dropHint;
  }

  /**
   * @return deadline
   */
  @Override
  public Calendar getDeadline() {

    return this.deadline;
  }

  /**
   * @param deadline new value of {@link #getDeadline}.
   */
  @Override
  public void setDeadline(Calendar deadline) {

    this.deadline = deadline;
  }

  /**
   * @return estimatedAmount
   */
  @Override
  public Integer getEstimatedAmount() {

    return this.estimatedAmount;
  }

  /**
   * @param estimatedAmount new value of {@link #getEstimatedAmount}.
   */
  @Override
  public void setEstimatedAmount(Integer estimatedAmount) {

    this.estimatedAmount = estimatedAmount;
  }

  /**
   * @return currency
   */
  @Override
  public Currency getCurrency() {

    return this.currency;
  }

  /**
   * @param currency new value of {@link #getCurrency}.
   */
  @Override
  public void setCurrency(Currency currency) {

    this.currency = currency;
  }

  /**
   * @return acceptedByUser
   */
  @Override
  public Long getAcceptedByUser() {

    return this.acceptedByUser;
  }

  /**
   * @param acceptedByUser new value of {@link #getAcceptedByUser}.
   */
  @Override
  public void setAcceptedByUser(Long acceptedByUser) {

    this.acceptedByUser = acceptedByUser;
  }

  /**
   * @return userId
   */
  @Override
  public Long getUserId() {

    return this.userId;
  }

  /**
   * @param userId new value of {@link #getUserId}.
   */
  @Override
  public void setUserId(Long userId) {

    this.userId = userId;
  }

}
