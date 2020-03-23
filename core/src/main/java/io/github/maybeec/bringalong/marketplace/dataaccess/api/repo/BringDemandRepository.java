package io.github.maybeec.bringalong.marketplace.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Calendar;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

import io.github.maybeec.bringalong.marketplace.dataaccess.api.BringDemandEntity;
import io.github.maybeec.bringalong.marketplace.logic.api.to.BringDemandSearchCriteriaTo;

/**
 * {@link DefaultRepository} for {@link BringDemandEntity}
 */
public interface BringDemandRepository extends DefaultRepository<BringDemandEntity> {

  /**
   * @param criteria the {@link BringDemandSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link BringDemandEntity} objects that matched the search. If no pageable is set,
   *         it will return a unique page with all the objects that matched the search.
   */
  default Page<BringDemandEntity> findByCriteria(BringDemandSearchCriteriaTo criteria) {

    BringDemandEntity alias = newDslAlias();
    JPAQuery<BringDemandEntity> query = newDslQuery(alias);

    String item = criteria.getItem();
    if (item != null && !item.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getItem()), item, criteria.getItemOption());
    }
    String dropHint = criteria.getDropHint();
    if (dropHint != null && !dropHint.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getDropHint()), dropHint, criteria.getDropHintOption());
    }
    Calendar deadline = criteria.getDeadline();
    if (deadline != null) {
      query.where($(alias.getDeadline()).eq(deadline));
    }
    Integer estimatedAmount = criteria.getEstimatedAmount();
    if (estimatedAmount != null) {
      query.where($(alias.getEstimatedAmount()).eq(estimatedAmount));
    }
    String currency = criteria.getCurrency();
    if (currency != null) {
      query.where($(alias.getCurrency()).eq(currency));
    }
    Long acceptedByUser = criteria.getAcceptedByUser();
    if (acceptedByUser != null) {
      query.where($(alias.getAcceptedByUser()).eq(acceptedByUser));
    }
    Long userId = criteria.getUserId();
    if (userId != null) {
      query.where($(alias.getUserId()).eq(userId));
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
  public default void addOrderBy(JPAQuery<BringDemandEntity> query, BringDemandEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "item":
            if (next.isAscending()) {
              query.orderBy($(alias.getItem()).asc());
            } else {
              query.orderBy($(alias.getItem()).desc());
            }
            break;
          case "dropHint":
            if (next.isAscending()) {
              query.orderBy($(alias.getDropHint()).asc());
            } else {
              query.orderBy($(alias.getDropHint()).desc());
            }
            break;
          case "deadline":
            if (next.isAscending()) {
              query.orderBy($(alias.getDeadline()).asc());
            } else {
              query.orderBy($(alias.getDeadline()).desc());
            }
            break;
          case "estimatedAmount":
            if (next.isAscending()) {
              query.orderBy($(alias.getEstimatedAmount()).asc());
            } else {
              query.orderBy($(alias.getEstimatedAmount()).desc());
            }
            break;
          case "acceptedByUser":
            if (next.isAscending()) {
              query.orderBy($(alias.getAcceptedByUser()).asc());
            } else {
              query.orderBy($(alias.getAcceptedByUser()).desc());
            }
            break;
          case "userId":
            if (next.isAscending()) {
              query.orderBy($(alias.getUserId()).asc());
            } else {
              query.orderBy($(alias.getUserId()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
