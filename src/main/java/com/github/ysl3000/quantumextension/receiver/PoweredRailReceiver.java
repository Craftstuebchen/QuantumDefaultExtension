package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractKeepAliveReceiver;
import com.github.ysl3000.quantum.api.receiver.ReceiverNotValidException;
import com.github.ysl3000.quantum.api.receiver.ValueNotChangedException;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.material.PoweredRail;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class PoweredRailReceiver extends AbstractKeepAliveReceiver {
    /**
     * only use to getValidMaterials
     */
    public PoweredRailReceiver() {
        super();
    }

    public PoweredRailReceiver(Location location) {
        super(location);
    }

    public PoweredRailReceiver(Location location, Integer delay) {
        super(location, delay);
    }

    public PoweredRailReceiver(Map<String, Object> map) {
        super(map);
    }

    @Override
    public Collection<Material> getValidMaterials() {
        return Arrays.asList(Material.POWERED_RAIL, Material.ACTIVATOR_RAIL, Material.DETECTOR_RAIL);
    }

    @Override
    public boolean isActive() {
        return ((PoweredRail) location.getBlock().getState().getData()).isPowered();
    }

    @Override
    public void setActive(boolean powerOn) {
        try {
            super.setActive(powerOn);
        } catch (ReceiverNotValidException | ValueNotChangedException e) {
            return;
        }

        BlockState state = location.getBlock().getState();
        PoweredRail poweredRail = (PoweredRail) state.getData();
        poweredRail.setPowered(powerOn);
        state.setData(poweredRail);
        state.update();

    }

    @Override
    public boolean isValid() {
        return location.getBlock().getState().getData() instanceof PoweredRail;
    }

    @Override
    public int getBlockCurrent() {
        return isActive() ? 15 : 0;
    }
}
