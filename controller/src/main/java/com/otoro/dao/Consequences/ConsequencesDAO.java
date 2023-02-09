package com.otoro.dao.Consequences;

import com.otoro.model.Attribute.Attribute;
import com.otoro.model.Consequences.Consequences;

import java.util.List;

public interface ConsequencesDAO {

    Consequences insertConsequence(Consequences consequence);

    List<Consequences> selectAllConsequences();
}
