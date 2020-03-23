package io.github.maybeec.bringalong.marketplace.logic.api.to;

import java.util.Calendar;
import java.util.Currency;

import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

import io.github.maybeec.bringalong.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link io.github.maybeec.bringalong.marketplace.common.api.BringDemand}s.
 */
public class BringDemandSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String item;

  private String dropHint;

  private Calendar deadline;

  private Integer estimatedAmount;

  private Currency currency;

  private Long acceptedByUser;

  private Long userId;

  private StringSearchConfigTo itemOption;

  private StringSearchConfigTo dropHintOption;

  /**
   * @return itemId
   */

  public String getItem() {

    return item;
  }

  /**
   * @param item setter for item attribute
   */

  public void setItem(String item) {

    this.item = item;
  }

  /**
   * @return dropHintId
   */

  public String getDropHint() {

    return dropHint;
  }

  /**
   * @param dropHint setter for dropHint attribute
   */

  public void setDropHint(String dropHint) {

    this.dropHint = dropHint;
  }

  /**
   * @return deadlineId
   */

  public Calendar getDeadline() {

    return deadline;
  }

  /**
   * @param deadline setter for deadline attribute
   */

  public void setDeadline(Calendar deadline) {

    this.deadline = deadline;
  }

  /**
   * @return estimatedAmountId
   */

  public Integer getEstimatedAmount() {

    return estimatedAmount;
  }

  /**
   * @param estimatedAmount setter for estimatedAmount attribute
   */

  public void setEstimatedAmount(Integer estimatedAmount) {

    this.estimatedAmount = estimatedAmount;
  }

  /**
   * @return currencyId
   */

  public Currency getCurrency() {

    return currency;
  }

  /**
   * @param currency setter for currency attribute
   */

  public void setCurrency(Currency currency) {

    this.currency = currency;
  }

  /**
   * @return acceptedByUserId
   */

  public Long getAcceptedByUser() {

    return acceptedByUser;
  }

  /**
   * @param acceptedByUser setter for acceptedByUser attribute
   */

  public void setAcceptedByUser(Long acceptedByUser) {

    this.acceptedByUser = acceptedByUser;
  }

  /**
   * @return userIdId
   */

  public Long getUserId() {

    return userId;
  }

  /**
   * @param userId setter for userId attribute
   */

  public void setUserId(Long userId) {

    this.userId = userId;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getItem() item}.
   */
  public StringSearchConfigTo getItemOption() {

    return this.itemOption;
  }

  /**
   * @param itemOption new value of {@link #getItemOption()}.
   */
  public void setItemOption(StringSearchConfigTo itemOption) {

    this.itemOption = itemOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getDropHint() dropHint}.
   */
  public StringSearchConfigTo getDropHintOption() {

    return this.dropHintOption;
  }

  /**
   * @param dropHintOption new value of {@link #getDropHintOption()}.
   */
  public void setDropHintOption(StringSearchConfigTo dropHintOption) {

    this.dropHintOption = dropHintOption;
  }

}
