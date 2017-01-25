package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractStateReceiver;
import com.github.ysl3000.quantum.api.receiver.ReceiverNotValidException;
import com.github.ysl3000.quantum.api.receiver.ReceiverState;
import com.github.ysl3000.quantum.api.receiver.ValueNotChangedException;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TrafficLightStateReceiver extends AbstractStateReceiver {

    public static final ReceiverState ON = ReceiverState.getByDyeColor(DyeColor.GREEN);
    public static final ReceiverState OF = ReceiverState.getByDyeColor(DyeColor.RED);

    /**
     * only use to getValidMaterials
     */
    public TrafficLightStateReceiver() {
        super();
    }

    public TrafficLightStateReceiver(Location location) {
        this(location, 0);
    }

    public TrafficLightStateReceiver(Location location, Integer delay) {
        super(location, delay);
    }

    public TrafficLightStateReceiver(Map<String, Object> map) {
        super(map);
    }

    @Override
    public boolean isActive() {
        return getState() == ON;
    }

    @Override
    public void setActive(boolean powerOn) {
        try {
            super.setActive(powerOn);
        } catch (ReceiverNotValidException | ValueNotChangedException e) {
            return;
        }
        setState(powerOn ? ON : OF);
    }

    @Override
    public ReceiverState getState() {
        return api.getState(location.getBlock());
    }

    @Override
    public void setState(ReceiverState state) {
        api.setState(location.getBlock(), state);
    }

    @Override
    public List<Material> getValidMaterials() {
        return Arrays.asList(Material.WOOL, Material.WOOD);
    }

    @Override
    public Map<String, Object> serialize() {
        return super.serialize();
    }

}
