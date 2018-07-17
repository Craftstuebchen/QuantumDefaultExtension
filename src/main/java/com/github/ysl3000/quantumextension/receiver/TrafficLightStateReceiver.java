package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractStateReceiver;
import com.github.ysl3000.quantum.api.receiver.ReceiverNotValidException;
import com.github.ysl3000.quantum.api.receiver.ReceiverState;
import com.github.ysl3000.quantum.api.receiver.ValueNotChangedException;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.BlockState;

import java.util.Collection;
import java.util.Map;

public class TrafficLightStateReceiver extends AbstractStateReceiver {


    private static final ReceiverState ON = ReceiverState.getByWool(Material.GREEN_WOOL);
    private static final ReceiverState OFF = ReceiverState.getByWool(Material.RED_WOOL);

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
        setState(location.getBlock(), BlockState.class, blockState -> blockState.setType(powerOn ? ON.wool : OFF.wool));
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
    public Collection<Material> getValidMaterials() {
        return Tag.WOOL.getValues();
    }

    @Override
    public Map<String, Object> serialize() {
        return super.serialize();
    }

}
