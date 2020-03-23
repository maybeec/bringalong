package io.github.maybeec.bringalong.usermanagement.dataaccess.api;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

import io.github.maybeec.bringalong.general.common.api.AddressEmbeddable;
import io.github.maybeec.bringalong.general.dataaccess.api.ApplicationPersistenceEntity;
import io.github.maybeec.bringalong.usermanagement.common.api.PaymentType;
import io.github.maybeec.bringalong.usermanagement.common.api.User;

@Entity(name = "User")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class UserEntity extends ApplicationPersistenceEntity implements User {

  @NaturalId
  private String login;

  private String forename;

  private String surname;

  private AddressEmbeddable address;

  private List<PaymentOptionEntity> acceptedPaymentOptions;

  private List<PaymentType> possiblePaymentOptions;

  private static final long serialVersionUID = 1L;

  /**
   * @return login
   */
  @Override
  @Column(nullable = false, unique = true)
  public String getLogin() {

    return this.login;
  }

  /**
   * @param login new value of {@link #getLogin}.
   */
  @Override
  public void setLogin(String login) {

    this.login = login;
  }

  /**
   * @return forename
   */
  @Override
  @Column(nullable = false)
  public String getForename() {

    return this.forename;
  }

  /**
   * @param forename new value of {@link #getForename}.
   */
  @Override
  public void setForename(String forename) {

    this.forename = forename;
  }

  /**
   * @return surname
   */
  @Override
  @Column(nullable = false)
  public String getSurname() {

    return this.surname;
  }

  /**
   * @param surname new value of {@link #getSurname}.
   */
  @Override
  public void setSurname(String surname) {

    this.surname = surname;
  }

  /**
   * @return address
   */
  @Embedded
  public AddressEmbeddable getAddress() {

    return this.address;
  }

  /**
   * @param address new value of {@link #getAddress}.
   */
  public void setAddress(AddressEmbeddable address) {

    this.address = address;
  }

  /**
   * @return acceptedPaymentOptions
   */
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "user_id")
  public List<PaymentOptionEntity> getAcceptedPaymentOptions() {

    return this.acceptedPaymentOptions;
  }

  /**
   * @param acceptedPaymentOptions new value of {@link #getAcceptedPaymentOptions}.
   */
  public void setAcceptedPaymentOptions(List<PaymentOptionEntity> acceptedPaymentOptions) {

    this.acceptedPaymentOptions = acceptedPaymentOptions;
  }

  /**
   * @return possiblePaymentOptions
   */
  @Override
  @Column(nullable = false, columnDefinition = "varchar2")
  @Type(type = "json")
  public List<PaymentType> getPossiblePaymentOptions() {

    return this.possiblePaymentOptions;
  }

  /**
   * @param possiblePaymentOptions new value of {@link #getPossiblePaymentOptions}.
   */
  @Override
  public void setPossiblePaymentOptions(List<PaymentType> possiblePaymentOptions) {

    this.possiblePaymentOptions = possiblePaymentOptions;
  }

}
