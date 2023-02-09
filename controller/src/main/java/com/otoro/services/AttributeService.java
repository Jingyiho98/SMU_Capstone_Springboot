package com.otoro.services;


import com.otoro.dao.Attribute.AttributeDAO;
import com.otoro.dao.Option.OptionDAO;
import com.otoro.model.Attribute.Attribute;
import com.otoro.model.Option.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    private final AttributeDAO attributeDAO;

    @Autowired
    public AttributeService(@Qualifier("postgresAttribute") AttributeDAO attributeDAO) {
        this.attributeDAO = attributeDAO;
    }

    public Attribute addAttribute(Attribute attribute){ return attributeDAO.insertAttribute(attribute);}

    public List<Attribute> getAllAttributes(){return attributeDAO.selectAllAttributes();}
}
