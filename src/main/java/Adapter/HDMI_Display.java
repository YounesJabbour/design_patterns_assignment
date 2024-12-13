package Adapter;
import Entities.Agent;

import java.util.Map;

public class HDMI_Display implements HDMI {
    @Override
    public void display(Map<String, Agent> agents) {
        System.out.println("Displaying agents:");
        for (Agent agent : agents.values()) {
            agent.displayInfo();
        }
    }
}
