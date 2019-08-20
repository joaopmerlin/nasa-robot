package com.joaomerlin.robot.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Position implements Serializable {

    private Integer x;

    private Integer y;

    private CardinalPoint point;

    public Position() {
        this.x = 0;
        this.y = 0;
        this.point = CardinalPoint.N;
    }
}
