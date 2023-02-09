package com.otoro.dao.Attribute;


import com.otoro.model.Attribute.Attribute;
import com.otoro.model.Option.Option;
import com.otoro.repositories.Attribute.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgresAttribute")
public class PostgresAttributeDataAccessService implements AttributeDAO{

    private AttributeRepository attributeRepository;

    @Autowired
    public PostgresAttributeDataAccessService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }


    @Override
    public Attribute insertAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @Override
    public List<Attribute> selectAllAttributes() {
        List<Attribute> attributes = new ArrayList<>();
        attributeRepository.findAll().forEach((attributes::add));
        return attributes;
    }
}
