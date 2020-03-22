package io.github.maybeec.bringalong.masterdata.logic.api.to;

import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

import io.github.maybeec.bringalong.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link io.github.maybeec.bringalong.masterdata.common.api.Store}s.
 */
public class StoreSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private String plz;

  private StringSearchConfigTo nameOption;

  private StringSearchConfigTo descriptionOption;

  /**
   * @return nameId
   */

  public String getName() {

    return name;
  }

  /**
   * @param name setter for name attribute
   */

  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return descriptionId
   */

  public String getDescription() {

    return description;
  }

  /**
   * @param description setter for description attribute
   */

  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return plz
   */
  public String getPlz() {

    return this.plz;
  }

  /**
   * @param plz new value of {@link #getplz}.
   */
  public void setPlz(String plz) {

    this.plz = plz;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getName() name}.
   */
  public StringSearchConfigTo getNameOption() {

    return this.nameOption;
  }

  /**
   * @param nameOption new value of {@link #getNameOption()}.
   */
  public void setNameOption(StringSearchConfigTo nameOption) {

    this.nameOption = nameOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getDescription() description}.
   */
  public StringSearchConfigTo getDescriptionOption() {

    return this.descriptionOption;
  }

  /**
   * @param descriptionOption new value of {@link #getDescriptionOption()}.
   */
  public void setDescriptionOption(StringSearchConfigTo descriptionOption) {

    this.descriptionOption = descriptionOption;
  }

}
