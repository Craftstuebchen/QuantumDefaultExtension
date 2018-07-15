package com.github.ysl3000.quantumextension.receiver;

import com.github.ysl3000.quantum.api.receiver.AbstractReceiver;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
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
        return isActive(location.getBlock(), Openable.class, Openable::isOpen);
    }


    @Override
    public void setActive(boolean powerOn) {
        setActive(location.getBlock(), Openable.class, openable -> openable.setOpen(powerOn));
    }


    @Override
    public int getBlockCurrent() {
        return isActive() ? 15 : 0;
    }
}
