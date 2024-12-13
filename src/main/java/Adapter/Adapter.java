package Adapter;

import Entities.Agent;

import java.util.Map;

public class Adapter implements  HDMI {
    private final VGA_display vga_display;

    public Adapter(VGA_display vga_display){
        this.vga_display = vga_display;
    }
    @Override
    public void display(Map<String, Agent> agents) {
        vga_display.display(agents);
    }
}
