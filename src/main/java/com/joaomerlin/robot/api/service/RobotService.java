package com.joaomerlin.robot.api.service;

import com.joaomerlin.robot.api.model.Position;

public interface RobotService {

    Position executeCommand(String robot, String command);

}
