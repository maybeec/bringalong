package io.github.maybeec.bringalong.request.dataaccess.api;

import java.util.Calendar;
import java.util.Currency;

public class RequestEntity {

  private String item;

  private String dropHint;

  private Calendar deadline;

  private Integer estimatedAmount;

  private Currency currency;

  /**
   * @return item
   */
  public String getItem() {

    return this.item;
  }

  /**
   * @param item new value of {@link #getitem}.
   */
  public void setItem(String item) {

    this.item = item;
  }

  /**
   * @return dropHint
   */
  public String getDropHint() {

    return this.dropHint;
  }

  /**
   * @param dropHint new value of {@link #getdropHint}.
   */
  public void setDropHint(String dropHint) {

    this.dropHint = dropHint;
  }

  /**
   * @return deadline
   */
  public Calendar getDeadline() {

    return this.deadline;
  }

  /**
   * @param deadline new value of {@link #getdeadline}.
   */
  public void setDeadline(Calendar deadline) {

    this.deadline = deadline;
  }

  /**
   * @return estimatedAmount
   */
  public Integer getEstimatedAmount() {

    return this.estimatedAmount;
  }

  /**
   * @param estimatedAmount new value of {@link #getestimatedAmount}.
   */
  public void setEstimatedAmount(Integer estimatedAmount) {

    this.estimatedAmount = estimatedAmount;
  }

  /**
   * @return currency
   */
  public Currency getCurrency() {

    return this.currency;
  }

  /**
   * @param currency new value of {@link #getcurrency}.
   */
  public void setCurrency(Currency currency) {

    this.currency = currency;
  }

}
