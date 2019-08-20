package com.joaomerlin.robot.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardinalPoint {

    N("E", "W"),
    S("W", "E"),
    E("S", "N"),
    W("N", "S");

    private String right;
    private String left;
}
