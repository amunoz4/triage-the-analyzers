package team.projectpulse.rubric;

import org.springframework.data.jpa.domain.Specification;

public final class RubricSpecs {
    private RubricSpecs() {
    }

    public static Specification<Rubric> containsRubricName(String providedRubricName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("rubricName")), "%" + providedRubricName.toLowerCase() + "%");
    }

    public static Specification<Rubric> belongsToCourse(Integer courseId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("course").get("id"), courseId);
    }

}
