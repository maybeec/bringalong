package io.github.maybeec.bringalong.usermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

import io.github.maybeec.bringalong.usermanagement.dataaccess.api.UserEntity;
import io.github.maybeec.bringalong.usermanagement.logic.api.to.UserSearchCriteriaTo;

/**
 * {@link DefaultRepository} for {@link UserEntity}
 */
public interface UserRepository extends DefaultRepository<UserEntity> {

  /**
   * @param criteria the {@link UserSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link UserEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<UserEntity> findByCriteria(UserSearchCriteriaTo criteria) {

    UserEntity alias = newDslAlias();
    JPAQuery<UserEntity> query = newDslQuery(alias);

    String login = criteria.getLogin();
    if (login != null && !login.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getLogin()), login, criteria.getLoginOption());
    }
    String forname = criteria.getForname();
    if (forname != null && !forname.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getForname()), forname, criteria.getFornameOption());
    }
    String surname = criteria.getSurname();
    if (surname != null && !surname.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getSurname()), surname, criteria.getSurnameOption());
    }
    Long address = criteria.getAddressId();
    if (address != null) {
      query.where($(alias.getAddress().getId()).eq(address));
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
  public default void addOrderBy(JPAQuery<UserEntity> query, UserEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "login":
            if (next.isAscending()) {
              query.orderBy($(alias.getLogin()).asc());
            } else {
              query.orderBy($(alias.getLogin()).desc());
            }
            break;
          case "forname":
            if (next.isAscending()) {
              query.orderBy($(alias.getForname()).asc());
            } else {
              query.orderBy($(alias.getForname()).desc());
            }
            break;
          case "surname":
            if (next.isAscending()) {
              query.orderBy($(alias.getSurname()).asc());
            } else {
              query.orderBy($(alias.getSurname()).desc());
            }
            break;
          case "address":
            if (next.isAscending()) {
              query.orderBy($(alias.getAddress().getId()).asc());
            } else {
              query.orderBy($(alias.getAddress().getId()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}