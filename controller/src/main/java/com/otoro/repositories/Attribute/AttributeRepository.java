package com.otoro.repositories.Attribute;


import com.otoro.model.Attribute.Attribute;
import com.otoro.model.Story.Story;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends CrudRepository<Attribute, Long> {
}
