package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractReceiver;
import com.github.ysl3000.quantum.api.receiver.ReceiverNotValidException;
import com.github.ysl3000.quantum.api.receiver.ValueNotChangedException;
import com.github.ysl3000.quantum.api.util.ValidMaterials;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.material.Lever;

import java.util.List;
import java.util.Map;

public class LeverReceiver extends AbstractReceiver {
    /**
     * only use to getValidMaterials
     */
    public LeverReceiver() {
        super();
    }

    public LeverReceiver(Location location) {
        this(location, 0);
    }

    public LeverReceiver(Location location, Integer delay) {
        super(location, delay);
    }

    public LeverReceiver(Map<String, Object> map) {
        super(map);
    }

    @Override
    public List<Material> getValidMaterials() {
        return ValidMaterials.LEVER;
    }

    @Override
    public boolean isActive() {
        return ((Lever) location.getBlock().getState().getData()).isPowered();
    }

    @Override
    public void setActive(boolean powerOn) {
        try {
            super.setActive(powerOn);
        } catch (ReceiverNotValidException | ValueNotChangedException e) {
            return;
        }
        BlockState state = location.getBlock().getState();
        Lever lever = (Lever) state.getData();
        lever.setPowered(powerOn);
        state.setData(lever);
        state.update();
    }

    @Override
    public int getBlockCurrent() {
        return isActive()?15:0;
    }
}
