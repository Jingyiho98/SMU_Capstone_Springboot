package com.otoro.repositories.Option;

import com.otoro.model.Option.Option;
import com.otoro.model.Story.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OptionRepository extends CrudRepository<Option, UUID>{
}

