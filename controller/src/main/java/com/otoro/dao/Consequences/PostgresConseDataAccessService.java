package com.otoro.dao.Consequences;

import com.otoro.model.Attribute.Attribute;
import com.otoro.model.Consequences.Consequences;
import com.otoro.repositories.Attribute.AttributeRepository;
import com.otoro.repositories.Consequences.ConsequencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgresConsequences")
public class PostgresConseDataAccessService implements ConsequencesDAO {
    private ConsequencesRepository consequencesRepository;

    @Autowired
    public PostgresConseDataAccessService(ConsequencesRepository consequencesRepository) {
        this.consequencesRepository = consequencesRepository;
    }
    @Override
    public Consequences insertConsequence(Consequences consequence) {
        return consequencesRepository.save(consequence);
    }

    @Override
    public List<Consequences> selectAllConsequences() {
        List<Consequences> consequences = new ArrayList<>();
        consequencesRepository.findAll().forEach((consequences::add));
        return consequences;
    }
}
