package io.github.maybeec.bringalong.common.builders;

import java.util.Calendar;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import io.github.maybeec.bringalong.marketplace.dataaccess.api.BringDemandEntity;

/**
 * Test data builder for BringDemandEntity generated with cobigen.
 */
public class BringDemandEntityBuilder {

  private List<Consumer<BringDemandEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public BringDemandEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param item the item to add.
   * @return the builder for fluent population of fields.
   */
  public BringDemandEntityBuilder item(final String item) {

    this.parameterToBeApplied.add(target -> target.setItem(item));

    return this;
  }

  /**
   * @param dropHint the dropHint to add.
   * @return the builder for fluent population of fields.
   */
  public BringDemandEntityBuilder dropHint(final String dropHint) {

    this.parameterToBeApplied.add(target -> target.setDropHint(dropHint));

    return this;
  }

  /**
   * @param deadline the deadline to add.
   * @return the builder for fluent population of fields.
   */
  public BringDemandEntityBuilder deadline(final Calendar deadline) {

    this.parameterToBeApplied.add(target -> target.setDeadline(deadline));

    return this;
  }

  /**
   * @param estimatedAmount the estimatedAmount to add.
   * @return the builder for fluent population of fields.
   */
  public BringDemandEntityBuilder estimatedAmount(final Integer estimatedAmount) {

    this.parameterToBeApplied.add(target -> target.setEstimatedAmount(estimatedAmount));

    return this;
  }

  /**
   * @param currency the currency to add.
   * @return the builder for fluent population of fields.
   */
  public BringDemandEntityBuilder currency(final Currency currency) {

    this.parameterToBeApplied.add(target -> target.setCurrency(currency));

    return this;
  }

  /**
   * @param acceptedByUser the acceptedByUser to add.
   * @return the builder for fluent population of fields.
   */
  public BringDemandEntityBuilder acceptedByUser(final Long acceptedByUser) {

    this.parameterToBeApplied.add(target -> target.setAcceptedByUser(acceptedByUser));

    return this;
  }

  /**
   * @param userId the userId to add.
   * @return the builder for fluent population of fields.
   */
  public BringDemandEntityBuilder userId(final Long userId) {

    this.parameterToBeApplied.add(target -> target.setUserId(userId));

    return this;
  }

  /**
   * @return the populated BringDemandEntity.
   */
  public BringDemandEntity createNew() {

    BringDemandEntity bringdemandentity = new BringDemandEntity();
    for (Consumer<BringDemandEntity> parameter : parameterToBeApplied) {
      parameter.accept(bringdemandentity);
    }
    return bringdemandentity;
  }

  /**
   * Might be enriched to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  /**
   * @param em the {@link EntityManager}
   * @return the BringDemandEntity
   */
  public BringDemandEntity persist(EntityManager em) {

    BringDemandEntity bringdemandentity = createNew();
    em.persist(bringdemandentity);
    return bringdemandentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of BringDemandEntity
   */
  public List<BringDemandEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<BringDemandEntity> bringdemandentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      BringDemandEntity bringdemandentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(bringdemandentity);
      bringdemandentityList.add(bringdemandentity);
    }

    return bringdemandentityList;
  }

}
