package com.otoro.services;

import com.otoro.dao.Attribute.AttributeDAO;
import com.otoro.dao.Consequences.ConsequencesDAO;
import com.otoro.model.Attribute.Attribute;
import com.otoro.model.Consequences.Consequences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsequencesService {
    private final ConsequencesDAO consequencesDAO;

    @Autowired
    public ConsequencesService(@Qualifier("postgresConsequences") ConsequencesDAO consequencesDAO) {
        this.consequencesDAO = consequencesDAO;
    }

    public Consequences addConsequences(Consequences consequences){ return consequencesDAO.insertConsequence(consequences);}

    public List<Consequences> getAllConsequences(){return consequencesDAO.selectAllConsequences();}
}
