package Adapter;

import Entities.Agent;

import java.util.Map;

public class VGA_display {
    public void display(Map<String, Agent> agents) {
        System.out.println("Displaying agents VGA:");
        for (Agent agent : agents.values()) {
            agent.displayInfo();
        }
    }
}
