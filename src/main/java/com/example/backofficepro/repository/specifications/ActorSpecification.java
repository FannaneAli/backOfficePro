package com.example.backofficepro.repository.specifications;

import com.example.backofficepro.model.Actor;
import org.springframework.data.jpa.domain.Specification;

public class ActorSpecification {

    public static Specification<Actor> matches(String name) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "A%"));
    }
}
