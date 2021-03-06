package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractKeepAliveReceiver;
import com.github.ysl3000.quantum.api.receiver.ReceiverNotValidException;
import com.github.ysl3000.quantum.api.receiver.ValueNotChangedException;
import com.github.ysl3000.quantum.api.util.ValidMaterials;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;


public class RedstoneLampReceiver extends AbstractKeepAliveReceiver {


    /**
     * only use to getValidMaterials
     */
    public RedstoneLampReceiver() {
        super();
    }

    public RedstoneLampReceiver(Location location) {
        super(location);
    }

    public RedstoneLampReceiver(Location location, Integer delay) {
        super(location, delay);
    }

    public RedstoneLampReceiver(Map<String, Object> map) {
        super(map);
    }

    @Override
    public List<Material> getValidMaterials() {
        return ValidMaterials.LAMP;
    }

    @Override
    public boolean isActive() {
        return this.location.getBlock().getType() == Material.REDSTONE_LAMP_ON;
    }

    @Override
    public void setActive(boolean powerOn) {
        try {
            super.setActive(powerOn);
        } catch (ValueNotChangedException | ReceiverNotValidException e) {
            return;
        }

        if (powerOn) {
            api.setStatic(location.getWorld(), true);
            location.getBlock().setType(Material.REDSTONE_LAMP_ON);
            api.setStatic(location.getWorld(), false);
        } else {
            this.getLocation().getBlock().setType(Material.REDSTONE_LAMP_OFF);
        }
    }


    @Override
    public boolean isValid() {
        return this.location.getBlock().getType() == Material.REDSTONE_LAMP_ON || this.location.getBlock().getType() == Material.REDSTONE_LAMP_OFF;
    }

    @Override
    public int getBlockCurrent() {
        return isActive()?15:0;
    }
}
