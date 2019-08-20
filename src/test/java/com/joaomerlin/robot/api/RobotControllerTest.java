package com.joaomerlin.robot.api;

import com.joaomerlin.robot.api.controller.RobotController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RobotControllerTest extends ApiApplicationTests {

    @Autowired
    private RobotController robotController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(robotController).build();
    }

    @Test
    public void testCommandOk() throws Exception {
        mockMvc.perform(post("/mars/MMRMMRMM")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x", is(2)))
                .andExpect(jsonPath("$.y", is(0)))
                .andExpect(jsonPath("$.point", is("S")));
    }

    @Test
    public void testCommandRepetition() throws Exception {
        mockMvc.perform(post("/mars/MML")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x", is(0)))
                .andExpect(jsonPath("$.y", is(2)))
                .andExpect(jsonPath("$.point", is("W")));

        mockMvc.perform(post("/mars/MML")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x", is(0)))
                .andExpect(jsonPath("$.y", is(2)))
                .andExpect(jsonPath("$.point", is("W")));
    }

    @Test
    public void testCommandInvalid() throws Exception {
        mockMvc.perform(post("/mars/AAA")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$", is("Invalid command A")));
    }

    @Test
    public void testCommandInvalidPosition() throws Exception {
        mockMvc.perform(post("/mars/MMMMMMMMMM")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$", is("Invalid position")));
    }

}
