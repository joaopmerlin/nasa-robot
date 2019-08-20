package com.joaomerlin.robot.api.service;

import com.joaomerlin.robot.api.model.Command;
import com.joaomerlin.robot.api.model.Position;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RobotServiceImpl implements RobotService {

    private final CommandService commandService;

    @Override
    public Position executeCommand(String robot, String command) {
        List<Command> commands = commandService.getCommands(command);

        Position currentPosition = new Position();
        for (Command c : commands) {
            currentPosition = commandService.execute(c, currentPosition);
            commandService.validateLimits(currentPosition, 5, 5);
        }

        return currentPosition;
    }

}
