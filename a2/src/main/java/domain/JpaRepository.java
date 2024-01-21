package domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface JpaRepository extends PanacheRepository<Persons> {
    // Custom queries or methods can be defined here
}
