package com.joaomerlin.robot.api.service;

import com.joaomerlin.robot.api.model.Command;
import com.joaomerlin.robot.api.model.Position;
import com.joaomerlin.robot.api.exception.InvalidCommandException;

import java.util.List;

public interface CommandService {

    List<Command> getCommands(String command) throws InvalidCommandException;

    Position execute(Command command, Position position);

    void validateLimits(Position position, Integer x, Integer y);
}
