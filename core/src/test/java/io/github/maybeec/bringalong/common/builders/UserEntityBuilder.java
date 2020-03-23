package io.github.maybeec.bringalong.common.builders;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import io.github.maybeec.bringalong.general.common.api.AddressEmbeddable;
import io.github.maybeec.bringalong.usermanagement.common.api.PaymentType;
import io.github.maybeec.bringalong.usermanagement.dataaccess.api.PaymentOptionEntity;
import io.github.maybeec.bringalong.usermanagement.dataaccess.api.UserEntity;

/**
 * Test data builder for UserEntity generated with cobigen.
 */
public class UserEntityBuilder {

  private List<Consumer<UserEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public UserEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param login the login to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder login(final String login) {

    this.parameterToBeApplied.add(target -> target.setLogin(login));

    return this;
  }

  /**
   * @param forname the forname to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder forname(final String forname) {

    this.parameterToBeApplied.add(target -> target.setForename(forname));

    return this;
  }

  /**
   * @param surname the surname to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder surname(final String surname) {

    this.parameterToBeApplied.add(target -> target.setSurname(surname));

    return this;
  }

  /**
   * @param address the address to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder address(final AddressEmbeddable address) {

    this.parameterToBeApplied.add(target -> target.setAddress(address));

    return this;
  }

  /**
   * @param acceptedPaymentOptions the acceptedPaymentOptions to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder acceptedPaymentOptions(final List<PaymentOptionEntity> acceptedPaymentOptions) {

    this.parameterToBeApplied.add(target -> target.setAcceptedPaymentOptions(acceptedPaymentOptions));

    return this;
  }

  /**
   * @param possiblePaymentOptions the possiblePaymentOptions to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder possiblePaymentOptions(final List<PaymentType> possiblePaymentOptions) {

    this.parameterToBeApplied.add(target -> target.setPossiblePaymentOptions(possiblePaymentOptions));

    return this;
  }

  /**
   * @return the populated UserEntity.
   */
  public UserEntity createNew() {

    UserEntity userentity = new UserEntity();
    for (Consumer<UserEntity> parameter : parameterToBeApplied) {
      parameter.accept(userentity);
    }
    return userentity;
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

    login("DefaultString");
    forename("DefaultString");
    surname("DefaultString");
    // TODO possiblePaymentOptions(...); //set Default java.util.List
  }

  /**
   * @param em the {@link EntityManager}
   * @return the UserEntity
   */
  public UserEntity persist(EntityManager em) {

    UserEntity userentity = createNew();
    em.persist(userentity);
    return userentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of UserEntity
   */
  public List<UserEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<UserEntity> userentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      UserEntity userentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(userentity);
      userentityList.add(userentity);
    }

    return userentityList;
  }

  /**
   * @param forename the forename to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder forename(final String forename) {

    this.parameterToBeApplied.add(target -> target.setForename(forename));

    return this;
  }

}
