package io.github.maybeec.bringalong.common.builders;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import io.github.maybeec.bringalong.masterdata.dataaccess.api.StoreEntity;

/**
 * Test data builder for StoreEntity generated with cobigen.
 */
public class StoreEntityBuilder {

  private List<Consumer<StoreEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public StoreEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @return the populated StoreEntity.
   */
  public StoreEntity createNew() {

    StoreEntity storeentity = new StoreEntity();
    for (Consumer<StoreEntity> parameter : parameterToBeApplied) {
      parameter.accept(storeentity);
    }
    return storeentity;
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
   * @return the StoreEntity
   */
  public StoreEntity persist(EntityManager em) {

    StoreEntity storeentity = createNew();
    em.persist(storeentity);
    return storeentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of StoreEntity
   */
  public List<StoreEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<StoreEntity> storeentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      StoreEntity storeentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(storeentity);
      storeentityList.add(storeentity);
    }

    return storeentityList;
  }

}
