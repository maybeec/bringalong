package io.github.maybeec.bringalong.masterdata.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

import io.github.maybeec.bringalong.masterdata.dataaccess.api.StoreEntity;
import io.github.maybeec.bringalong.masterdata.logic.api.to.StoreSearchCriteriaTo;

/**
 * {@link DefaultRepository} for {@link StoreEntity}
 */
public interface StoreRepository extends DefaultRepository<StoreEntity> {

  /**
   * @param criteria the {@link StoreSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link StoreEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<StoreEntity> findByCriteria(StoreSearchCriteriaTo criteria) {

    StoreEntity alias = newDslAlias();
    JPAQuery<StoreEntity> query = newDslQuery(alias);

    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
    }
    String description = criteria.getDescription();
    if (description != null && !description.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getDescription()), description, criteria.getDescriptionOption());
    }
    String plz = criteria.getPlz();
    if (plz != null) {
      query.where($(alias.getAddress().getPlz()).eq(plz));
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  /**
   * Add sorting to the given query on the given alias
   * 
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<StoreEntity> query, StoreEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "name":
            if (next.isAscending()) {
              query.orderBy($(alias.getName()).asc());
            } else {
              query.orderBy($(alias.getName()).desc());
            }
            break;
          case "description":
            if (next.isAscending()) {
              query.orderBy($(alias.getDescription()).asc());
            } else {
              query.orderBy($(alias.getDescription()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}