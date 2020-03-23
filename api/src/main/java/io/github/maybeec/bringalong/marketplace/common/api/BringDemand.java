package io.github.maybeec.bringalong.marketplace.common.api;

import java.util.Calendar;
import java.util.Currency;

import io.github.maybeec.bringalong.general.common.api.ApplicationEntity;

public interface BringDemand extends ApplicationEntity {

  /**
   * @return itemId
   */

  public String getItem();

  /**
   * @param item setter for item attribute
   */

  public void setItem(String item);

  /**
   * @return dropHintId
   */

  public String getDropHint();

  /**
   * @param dropHint setter for dropHint attribute
   */

  public void setDropHint(String dropHint);

  /**
   * @return deadlineId
   */

  public Calendar getDeadline();

  /**
   * @param deadline setter for deadline attribute
   */

  public void setDeadline(Calendar deadline);

  /**
   * @return estimatedAmountId
   */

  public Integer getEstimatedAmount();

  /**
   * @param estimatedAmount setter for estimatedAmount attribute
   */

  public void setEstimatedAmount(Integer estimatedAmount);

  /**
   * @return currencyId
   */

  public Currency getCurrency();

  /**
   * @param currency setter for currency attribute
   */

  public void setCurrency(Currency currency);

  /**
   * @return acceptedByUserId
   */

  public Long getAcceptedByUser();

  /**
   * @param acceptedByUser setter for acceptedByUser attribute
   */

  public void setAcceptedByUser(Long acceptedByUser);

  /**
   * @return userIdId
   */

  public Long getUserId();

  /**
   * @param userId setter for userId attribute
   */

  public void setUserId(Long userId);

}
