package com.otoro.dao.Attribute;

import com.otoro.model.Attribute.Attribute;
import com.otoro.model.Option.Option;

import java.util.List;

public interface AttributeDAO {

    Attribute insertAttribute(Attribute attribute);

    List<Attribute> selectAllAttributes();
}
