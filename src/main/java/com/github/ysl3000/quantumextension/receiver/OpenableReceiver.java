package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractReceiver;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;

import java.util.Collection;
import java.util.Map;

public class OpenableReceiver extends AbstractReceiver {

    /**
     * only use to getValidMaterials
     */
    public OpenableReceiver() {
        super();
    }

    public OpenableReceiver(Location location) {
        super(location);
    }

    public OpenableReceiver(Map<String, Object> map) {
        super(map);
    }

    public OpenableReceiver(Location location, Integer delay) {
        super(location, delay);
    }

    @Override
    public void calculateRealLocation() {
        this.location = api.getSourceBlock(location);
    }

    @Override
    public Collection<Material> getValidMaterials() {
        return Tag.DOORS.getValues();
    }

    @Override
    public boolean isActive() {

        BlockData blockData = location.getBlock().getBlockData();

        if (blockData instanceof org.bukkit.block.data.Openable) {
            return ((org.bukkit.block.data.Openable) blockData).isOpen();

        }

        return false;
    }


    @Override
    public void setActive(boolean powerOn) {

        if (!isValid()) return;

        setBlockData(location.getBlock(), Openable.class, openable -> {
            openable.setOpen(powerOn);
            location.getWorld().playEffect(location, Effect.DOOR_TOGGLE, 0, 10);
        });
    }


    @Override
    public int getBlockCurrent() {
        return isActive() ? 15 : 0;
    }
}
