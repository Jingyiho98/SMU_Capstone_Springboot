package com.otoro.repositories.Consequences;

import com.otoro.model.Attribute.Attribute;
import com.otoro.model.Consequences.Consequences;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsequencesRepository extends CrudRepository<Consequences, Long> {
}
