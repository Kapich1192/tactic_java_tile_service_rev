package com.tactic.tactic_tile_service.models.devices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Device {
    private TypeDevice type;
    private HashMap<String,String> position;
    private HashMap<String,String> identification;
    private HashMap<String,String> settings;
    private ArrayList<Device> detected;

    public Device() {}

    public Device(TypeDevice type, HashMap<String, String> position, HashMap<String, String> identification, HashMap<String, String> settings, ArrayList<Device> detected) {
        this.type = type;
        this.position = position;
        this.identification = identification;
        this.settings = settings;
        this.detected = detected;
    }

    public TypeDevice getType() {
        return type;
    }

    public void setType(TypeDevice type) {
        this.type = type;
    }

    public HashMap<String, String> getPosition() {
        return position;
    }

    public void setPosition(HashMap<String, String> position) {
        this.position = position;
    }

    public HashMap<String, String> getIdentification() {
        return identification;
    }

    public void setIdentification(HashMap<String, String> identification) {
        this.identification = identification;
    }

    public HashMap<String, String> getSettings() {
        return settings;
    }

    public void setSettings(HashMap<String, String> settings) {
        this.settings = settings;
    }

    public ArrayList<Device> getDetected() {
        return detected;
    }

    public void setDetected(ArrayList<Device> detected) {
        this.detected = detected;
    }

    @Override
    public String toString() {
        return "Device{" +
                "type=" + type +
                ", position=" + position +
                ", identification=" + identification +
                ", settings=" + settings +
                ", detected=" + detected +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return type == device.type && Objects.equals(position, device.position) && Objects.equals(identification, device.identification) && Objects.equals(settings, device.settings) && Objects.equals(detected, device.detected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, position, identification, settings, detected);
    }
}
