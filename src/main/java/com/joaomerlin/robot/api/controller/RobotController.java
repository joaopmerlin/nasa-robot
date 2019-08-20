package com.joaomerlin.robot.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface RobotController {

    @PostMapping("{robot}/{command}")
    ResponseEntity<?> march(@PathVariable String robot, @PathVariable String command);

}
