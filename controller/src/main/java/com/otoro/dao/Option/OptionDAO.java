package com.otoro.dao.Option;

import com.otoro.model.Option.Option;
import com.otoro.model.Player.Player;

import java.util.List;

public interface OptionDAO {

    Option insertOption(Option option);

    List<Option> selectAllOptions();
}
