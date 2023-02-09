package com.otoro.dao.Option;

import com.otoro.model.Option.Option;
import com.otoro.model.Player.Player;
import com.otoro.repositories.Option.OptionRepository;
import com.otoro.repositories.Player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgresOption")
public class PostgresOptionDataAccessService implements OptionDAO{

    private OptionRepository optionRepository;

    @Autowired
    public PostgresOptionDataAccessService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public Option insertOption(Option option) {
       return optionRepository.save(option);
    }

    @Override
    public List<Option> selectAllOptions() {
        List<Option> options = new ArrayList<>();
        optionRepository.findAll().forEach((options::add));
        return options;
    }
}
