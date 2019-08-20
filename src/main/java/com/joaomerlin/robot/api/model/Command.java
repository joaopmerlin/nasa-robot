package com.joaomerlin.robot.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Command {

    L("LEFT"),
    R("RIGHT"),
    M("MARCH");

    private String label;
}
