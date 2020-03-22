package io.github.maybeec.bringalong.masterdata.logic.api.to;

import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

import io.github.maybeec.bringalong.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link io.github.maybeec.bringalong.masterdata.common.api.Address}s.
 */
public class AddressSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String streetAndNumber;

  private String plz;

  private String city;

  private String additionalHints;

  private StringSearchConfigTo streetAndNumberOption;

  private StringSearchConfigTo plzOption;

  private StringSearchConfigTo cityOption;

  private StringSearchConfigTo additionalHintsOption;

  /**
   * @return streetAndNumberId
   */

  public String getStreetAndNumber() {

    return streetAndNumber;
  }

  /**
   * @param streetAndNumber setter for streetAndNumber attribute
   */

  public void setStreetAndNumber(String streetAndNumber) {

    this.streetAndNumber = streetAndNumber;
  }

  /**
   * @return plzId
   */

  public String getPlz() {

    return plz;
  }

  /**
   * @param plz setter for plz attribute
   */

  public void setPlz(String plz) {

    this.plz = plz;
  }

  /**
   * @return cityId
   */

  public String getCity() {

    return city;
  }

  /**
   * @param city setter for city attribute
   */

  public void setCity(String city) {

    this.city = city;
  }

  /**
   * @return additionalHintsId
   */

  public String getAdditionalHints() {

    return additionalHints;
  }

  /**
   * @param additionalHints setter for additionalHints attribute
   */

  public void setAdditionalHints(String additionalHints) {

    this.additionalHints = additionalHints;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getStreetAndNumber() streetAndNumber}.
   */
  public StringSearchConfigTo getStreetAndNumberOption() {

    return this.streetAndNumberOption;
  }

  /**
   * @param streetAndNumberOption new value of {@link #getStreetAndNumberOption()}.
   */
  public void setStreetAndNumberOption(StringSearchConfigTo streetAndNumberOption) {

    this.streetAndNumberOption = streetAndNumberOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getPlz() plz}.
   */
  public StringSearchConfigTo getPlzOption() {

    return this.plzOption;
  }

  /**
   * @param plzOption new value of {@link #getPlzOption()}.
   */
  public void setPlzOption(StringSearchConfigTo plzOption) {

    this.plzOption = plzOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getCity() city}.
   */
  public StringSearchConfigTo getCityOption() {

    return this.cityOption;
  }

  /**
   * @param cityOption new value of {@link #getCityOption()}.
   */
  public void setCityOption(StringSearchConfigTo cityOption) {

    this.cityOption = cityOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getAdditionalHints() additionalHints}.
   */
  public StringSearchConfigTo getAdditionalHintsOption() {

    return this.additionalHintsOption;
  }

  /**
   * @param additionalHintsOption new value of {@link #getAdditionalHintsOption()}.
   */
  public void setAdditionalHintsOption(StringSearchConfigTo additionalHintsOption) {

    this.additionalHintsOption = additionalHintsOption;
  }

}
