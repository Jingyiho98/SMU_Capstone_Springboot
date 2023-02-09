package com.otoro.services;


import com.otoro.dao.Option.OptionDAO;
import com.otoro.dao.Story.StoryDAO;
import com.otoro.model.Option.Option;
import com.otoro.model.Story.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    private final OptionDAO optionDAO;

    @Autowired
    public OptionService(@Qualifier("postgresOption") OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    public Option addOption(Option option){ return optionDAO.insertOption(option);}

    public List<Option> getAllOptions(){return optionDAO.selectAllOptions();}
}
