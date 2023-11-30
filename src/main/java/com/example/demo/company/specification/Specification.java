package com.example.demo.company.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.function.Predicate;

public interface Specification<T> {

    //用來定義查詢條件的規格(查詢的根對象、查詢的主體、建構查詢條件的建構器)
    Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder);

}
