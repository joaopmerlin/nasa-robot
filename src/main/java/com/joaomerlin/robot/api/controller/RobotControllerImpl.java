package com.joaomerlin.robot.api.controller;

import com.joaomerlin.robot.api.exception.InvalidCommandException;
import com.joaomerlin.robot.api.service.RobotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class RobotControllerImpl implements RobotController {

    private final RobotService service;

    @Override
    public ResponseEntity<?> march(String robot, String command) {
        try {
            return ResponseEntity.ok(service.executeCommand(robot, command));
        } catch (InvalidCommandException e) {
            log.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
