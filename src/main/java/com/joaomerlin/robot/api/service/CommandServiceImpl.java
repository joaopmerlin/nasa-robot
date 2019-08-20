package com.joaomerlin.robot.api.service;

import com.joaomerlin.robot.api.model.CardinalPoint;
import com.joaomerlin.robot.api.model.Command;
import com.joaomerlin.robot.api.model.Position;
import com.joaomerlin.robot.api.exception.InvalidCommandException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandServiceImpl implements CommandService {

    @Override
    public List<Command> getCommands(String command) throws InvalidCommandException {
        List<Command> commands = new ArrayList<>();

        for (char c : command.toCharArray()) {
            try {
                commands.add(Command.valueOf(String.valueOf(c)));
            } catch (IllegalArgumentException e) {
                throw new InvalidCommandException("Invalid command " + c);
            }
        }

        return commands;
    }

    @Override
    public Position execute(Command command, Position position) {
        switch (command) {
            case M:
                switch (position.getPoint()) {
                    case N:
                        position.setY(position.getY() + 1);
                        break;
                    case E:
                        position.setX(position.getX() + 1);
                        break;
                    case S:
                        position.setY(position.getY() - 1);
                        break;
                    case W:
                        position.setX(position.getX() - 1);
                        break;
                }
                break;
            case L:
                position.setPoint(CardinalPoint.valueOf(position.getPoint().getLeft()));
                break;
            case R:
                position.setPoint(CardinalPoint.valueOf(position.getPoint().getRight()));
                break;
        }
        return position;
    }

    @Override
    public void validateLimits(Position position, Integer x, Integer y) {
        if (position.getX() > x || position.getY() > y || position.getX() < 0 || position.getY() < 0) {
            throw new InvalidCommandException("Invalid position");
        }
    }
}
