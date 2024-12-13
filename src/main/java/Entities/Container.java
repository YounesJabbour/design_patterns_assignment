package Entities;

import Adapter.HDMI;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Container instance;
    private final Map<String, Agent> agents = new HashMap<>();
    private HDMI display;

    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void addAgent(Agent agent) {
        agents.put(agent.getName(), agent);
    }

    public void removeAgent(String name) {
        agents.remove(name);
    }

    public Agent getAgent(String name) {
        return agents.get(name);
    }

    public void setDisplay(HDMI display) {
        this.display = display;
    }

    public void displayState() {
        if (display != null) {
            display.display(agents);
        } else {
            System.out.println("No display connected.");
        }
    }
}